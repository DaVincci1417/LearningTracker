package Controller.Listar;

import Model.Apunte;
import Model.Task;
import Model.Data.DAO.TaskDAO;
import Model.Data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listarTasksServlet", value = "/listarTasks")
public class listarTasksServlet extends HttpServlet {
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
            req.setAttribute("tasks", obtenerTasks());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher respuesta = req.getRequestDispatcher("/acad_verTasks.jsp");
        respuesta.forward(req,resp);
    }
    private List obtenerTasks() throws ClassNotFoundException {
        List<Task> asignaturas = new ArrayList<>();
        asignaturas = TaskDAO.obtenerTasks(DBGenerator.conectarBD("learning_tracker"));
        return asignaturas;
    }
}
