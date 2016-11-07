package lab2.db;
import lab2.model.Car;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "edit")
@ApplicationScoped
public class EditCar {
    private Long id = 12L;
    private String companyName = "companyName";
    private String model = "model";
    private int price = 1000;
    private long company_id = 0;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyName() {
        this.companyName = "shit";
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

    public void setPrice(int price) {
        this.price = price;
    }

    public String update() {
        CarService carService = new CarService();
        carService.updateCarByID(this.id, new Car(
                this.id,
                this.model,
                this.price),
                this.company_id);
        return "index.xhtml";
    }

    public String setCar(long id, String model, int price, long company_id){
        this.id=id;
        this.model=model;
        this.price=price;
        this.company_id=company_id;
        return "edit.xhtml";
    }

    public long getCompanyID() {
        return company_id;
    }

    public void setCompanyID(int company_id) {
        this.company_id = company_id;
    }
}
