package lab2.model;
import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import java.io.Serializable;

@ManagedBean(name="owner")
@Entity
@NamedQuery(name="GetAllOwners", query="SELECT o FROM Owner o")
public class Owner implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String sername;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "owner")
    private Car car;

    public Owner() {}

    public Owner(long id, String name, String sername) {
        this.id=id;
        this.name=name;
        this.sername=sername;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getSername() {
        return sername;
    }

    public void setSername(String sername) {
        this.sername = sername;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object instanceof Owner) {
            Owner owner = (Owner)object;
            return this.id == owner.getId()
                    && this.name.equals(owner.getName())
                    && this.sername.equals(owner.getSername());
        }
        return false;
    }

    public String getOwner(){
        return this.sername + " " + this.name;
    }

    public long getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}