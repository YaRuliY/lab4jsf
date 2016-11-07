package lab2.model;
import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name="carMaintenance")
@Entity
@NamedQuery(name="GetAllCarMaintenance", query="SELECT cm FROM CarMaintenance cm")
public class CarMaintenance implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private String street;

    @ManyToMany
    @JoinTable(
            name="car_services",
            joinColumns=@JoinColumn(name="service_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="car_id", referencedColumnName="id"))
    private List<Car> cars;

    public CarMaintenance(long id, String name, String street, List<Car> cars) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.cars = cars;
    }

    public CarMaintenance() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String string) {
        this.street = string;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}