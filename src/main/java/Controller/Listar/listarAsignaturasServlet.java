package Controller.Listar;

import Model.Academico;
import Model.Asignatura;
import Model.Data.DAO.AcademicoDAO;
import Model.Data.DAO.AsignaturaDAO;
import Model.Data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listarAsignaturasServlet", value = "/listarAsignaturas")
public class listarAsignaturasServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("learning_tracker");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("asignaturas", obtenerAsignaturas());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher respuesta = req.getRequestDispatcher("/adm_verAsignaturas.jsp");
        respuesta.forward(req,resp);
    }

    private List obtenerAsignaturas() throws ClassNotFoundException {
        List<Asignatura> asignaturas = new ArrayList<>();
        asignaturas = AsignaturaDAO.obtenerAsignaturas(DBGenerator.conectarBD("learning_tracker"));
        return asignaturas;
    }
}
