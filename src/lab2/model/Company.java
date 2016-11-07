package lab2.model;
import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name="company")
@Entity
@NamedQuery(name="GetAllCompanys", query="SELECT com FROM Company com")
public class Company implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private String country;

    @OneToMany(mappedBy = "company")
    private List<Car> cars = new LinkedList<>();

    public Company() {}

    public Company(long id, String name, String country) {
        this.id=id;
        this.name=name;
        this.country=country;
    }

    /*public Company(List<Car> cars) {
        this.cars = cars;
    }*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object instanceof Company) {
            Company company = (Company)object;
            return this.id == company.getId()
                    && this.name.equals(company.getName())
                    && this.country.equals(company.getCountry());
        }
        return false;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}