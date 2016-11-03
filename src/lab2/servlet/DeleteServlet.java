package lab2.servlet;
import lab2.db.CarService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete", urlPatterns = { "/delete" })
public class DeleteServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        CarService cs = new CarService();
        cs.deleteCarByID(Integer.parseInt(req.getParameter("id")));
        res.sendRedirect("http://localhost:8080/index.jsp");
    }
}
