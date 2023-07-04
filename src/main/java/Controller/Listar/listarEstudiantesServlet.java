package Controller.Listar;

import Model.Data.DAO.EstudianteDAO;
import Model.Estudiante;
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

@WebServlet(name = "listarEstudiantesServlet", value = "/listarEstudiantes")
public class listarEstudiantesServlet extends HttpServlet {
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
            req.setAttribute("estudiantes", obtenerEstudiantes());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher respuesta = req.getRequestDispatcher("/adm_verEstudiantes.jsp");
        respuesta.forward(req,resp);
    }

    private List obtenerEstudiantes() throws ClassNotFoundException {
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes = EstudianteDAO.obtenerEstudiantes(DBGenerator.conectarBD("learning_tracker"));
        return estudiantes;
    }
}
