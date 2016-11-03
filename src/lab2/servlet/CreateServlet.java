package lab2.servlet;
import lab2.model.Car;
import lab2.db.CarService;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "create", urlPatterns = { "/create" })
public class CreateServlet extends HttpServlet {
    final private static Logger logger = Logger.getLogger(CreateServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        CarService cs = new CarService();
        try {
            cs.insertCar(new Car(0,
                    req.getParameter("company"),
                    req.getParameter("model"),
                    Integer.parseInt(req.getParameter("price"))));
            logger.info("Successful Insert");
        }
        catch (java.lang.NumberFormatException nfe){
            logger.error("Number Format Exception. Car not inserted");
        }
        res.sendRedirect("http://localhost:8080/index.xhtml");
    }
}