package lab2.db;
import lab2.model.Car;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "edit")
@ApplicationScoped
public class EditBean {
    private Long id = 12L;
    private String company = "company";
    private String model = "model";
    private int price = 1000;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        System.out.println("{INFO}: Log id: " + id + " {///end of log}");
        this.id = id;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public String update(String company, String model, int price) {
        CarService carService = new CarService();
        carService.updateCarByID(this.id, new Car(
                this.id,
                company,
                model,
                price));
        return "index.xhtml";
    }

    public String update() {
        CarService carService = new CarService();
        carService.updateCarByID(this.id, new Car(
                this.id,
                this.company,
                this.model,
                this.price));
        return "index.xhtml";
    }

    public String setCar(long id, String company, String model, int price){
        this.id=id;
        this.company=company;
        this.model=model;
        this.price=price;
        return "edit.xhtml";
    }
}
