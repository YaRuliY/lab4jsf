package lab2.db;
import lab2.model.Car;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@ManagedBean(name = "carService")
@ApplicationScoped
public class CarService {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SamplePersistenceUnit");
    private CompanyService cs = new CompanyService();
    private OwnerService os = new OwnerService();

    public CarService(){}
    public void insertCar(Car car) {
        CarMaintenanceService cms = new CarMaintenanceService();
        car.getServices().add(cms.getAllCarMaintenanceServices().get(0));
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(car);
        tx.commit();
        em.close();
    }

    public void insertCar(long id, String model, int price, long company_id) {
        Car car = new Car(id, model, price);
        car.setCompany(cs.getCompanyByID(company_id));
        car.setOwner(os.getAllOwners().get(0));
        insertCar(car);
    }

    public List<Car> getAllCars() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Car> cars = em.createNamedQuery("GetAllCars", Car.class).getResultList();
        tx.commit();
        em.close();
        return cars;
    }

    public void deleteCarByID(long id){
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //cs.deleteCompanyByID(this.getCarByID(id).getCompany().getId());
        //os.deleteOwnerByID(this.getCarByID(id).getOwner().getId());
        tx.begin();
        em.remove(em.find(Car.class, id));
        tx.commit();
        em.close();
    }

    void updateCarByID(long id, Car car, long company_id){
        EntityManager em = entityManagerFactory.createEntityManager();
        Car origin = em.find(Car.class, id);

        CompanyService cs = new CompanyService();
        origin.setCompany(cs.getCompanyByID(company_id));
        origin.setModel(car.getModel());
        origin.setPrice(car.getPrice());

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(origin);
        tx.commit();
        em.close();
    }

    public Car getCarByID(long id){
        EntityManager em = entityManagerFactory.createEntityManager();
        Car car = em.find(Car.class, id);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        tx.commit();
        em.close();
        return car;
    }
}