package lab2.servlet;
import lab2.db.CarService;
import lab2.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "edit", urlPatterns = { "/edit" })
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        /*CarService cs = new CarService();
        cs.updateCarByID(Integer.parseInt(req.getParameter("id")),
                new Car(Long.parseLong(req.getParameter("id")),
                        req.getParameter("model"),
                        Integer.parseInt(req.getParameter("price"))));*/
        res.sendRedirect("http://localhost:8080/index.jsp");
    }
}