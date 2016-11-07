package lab2.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    private int price;
    private String model;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="car_services",
            joinColumns=@JoinColumn(name="car_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="service_id", referencedColumnName="id"))
    private List<CarMaintenance> services = new ArrayList<>();

    public Car(long id, Company company, String model, int price, List<CarMaintenance> services) {
        this.id = id;
        this.company = company;
        this.model = model;
        this.price = price;
        this.services = services;
    }

    public Car(long id, String model, int price) {
        this.id = id;
        this.model = model;
        this.price = price;
    }

    public Car(List<CarMaintenance> services) {
        this.services = services;
    }

    public Car() { }

    public long getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<CarMaintenance> getServices() {
        return services;
    }

    public void setServices(List<CarMaintenance> services) {
        this.services = services;
    }

    public String getAllServicesAsText(){
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<this.services.size()-1;i++){
            sb.append(this.services.get(i).getName()).append(" (").append(this.services.get(i).getStreet()).append("),").append("\n");
        }
        sb.append(this.services.get(this.services.size()-1).getName()).append(" (")
                .append(this.services.get(this.services.size()-1).getStreet()).append(")");
        return sb.toString();
    }
}