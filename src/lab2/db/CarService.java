package lab2.db;
import lab2.model.Car;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@ManagedBean(name = "carService")
@ApplicationScoped
public class CarService {

    public CarService(){}
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SamplePersistenceUnit");

    public void insertCar(Car car) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(car);
        tx.commit();
        em.close();
    }

    public void insertCar(long id, String company, String model, int price) {
        insertCar(new Car(id, company, model, price));
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
        tx.begin();
        em.remove(em.find(Car.class, id));
        tx.commit();
        em.close();
    }

    public void updateCarByID(long id, Car car){
        EntityManager em = entityManagerFactory.createEntityManager();
        Car origin = em.find(Car.class, id);
        origin.setCompany(car.getCompany());
        origin.setModel(car.getModel());
        origin.setPrice(car.getPrice());
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(origin);
        tx.commit();
        em.close();
    }
}