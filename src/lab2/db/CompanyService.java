package lab2.db;
import lab2.model.Company;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@ManagedBean(name = "companyService")
@ApplicationScoped
public class CompanyService {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SamplePersistenceUnit");

    public CompanyService(){}
    /*public void insertCompany(Company company) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(company);
        tx.commit();
        em.close();
    }*/

    public List<Company> getAllCompanys() {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Company> companies = em.createNamedQuery("GetAllCompanys", Company.class).getResultList();
        tx.commit();
        em.close();
        return companies;
    }

    public void deleteCompanyByID(long id){
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.find(Company.class, id));
        tx.commit();
        em.close();
    }

    public void updateCompanyByID(long id, Company company){
        EntityManager em = entityManagerFactory.createEntityManager();
        Company origin = em.find(Company.class, id);
        origin.setName(company.getName());
        origin.setCountry(company.getCountry());
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(origin);
        tx.commit();
        em.close();
    }

    public Company getCompanyByID(long id){
        EntityManager em = entityManagerFactory.createEntityManager();
        Company company = em.find(Company.class, id);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        tx.commit();
        em.close();
        return company;
    }
}