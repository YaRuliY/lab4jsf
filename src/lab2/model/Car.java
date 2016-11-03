package lab2.model;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.*;

@ManagedBean(name="car")
@Entity
@NamedQuery(name="GetAllCars", query="SELECT c FROM Car c")
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String company;
    private String model;
    private int price;

    public Car(long id, String company, String model, int price) {
        this.id = id;
        this.company = company;
        this.model = model;
        this.price = price;
    }

    public Car(Long id) { }

    public Car() {}

    public long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object instanceof Car) {
            Car car = (Car)object;
            return this.id == car.getId()
                    && this.company.equals(car.getCompany())
                    && this.model.equals(car.getModel())
                    && this.price == car.getPrice();
        }
        return false;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
