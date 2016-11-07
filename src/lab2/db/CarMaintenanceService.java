package lab2.db;
import lab2.model.CarMaintenance;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@ManagedBean(name = "carMaintenanceService")
@ApplicationScoped
public class CarMaintenanceService {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SamplePersistenceUnit");

    public List<CarMaintenance> getAllCarMaintenanceServices() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<CarMaintenance> carMaintenance=
                em.createNamedQuery("GetAllCarMaintenance", CarMaintenance.class).getResultList();
        tx.commit();
        em.close();
        return carMaintenance;
    }
}