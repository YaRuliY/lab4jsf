package lab2.db;
import lab2.model.Car;
import lab2.model.Owner;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@ManagedBean(name = "ownerService")
@ApplicationScoped
public class OwnerService {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SamplePersistenceUnit");

    public OwnerService(){}
    public List<Owner> getAllOwners() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Owner> owners = em.createNamedQuery("GetAllOwners", Owner.class).getResultList();
        tx.commit();
        em.close();
        return owners;
    }

    public void deleteOwnerByID(long id){
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.find(Owner.class, id));
        tx.commit();
        em.close();
    }
}