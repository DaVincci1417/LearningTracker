package Controller.Eliminar;

import Model.Data.DAO.AcademicoDAO;
import Model.Data.DAO.ApunteDAO;
import Model.Data.DAO.AsignaturaDAO;
import Model.Data.DAO.TaskDAO;
import Model.Data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;

@WebServlet(name = "adm_eliminarAsignaturaServlet", value = "/adm_eliminarAsignatura")
public class adm_eliminarAsignaturaServlet extends HttpServlet {
    @Override
    public void init() throws ServletException{
        try {
            DBGenerator.iniciarBD("learning_tracker");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/errorEliminarAsignatura.jsp");
        if(req.getParameter("cod_asignatura").length() != 0){
            int codAsignatura = Integer.parseInt(req.getParameter("cod_asignatura"));
            try {
                eliminarAsignatura(codAsignatura);
                respuesta = req.getRequestDispatcher("/adm_exitoEliminarAsignatura.jsp");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private void eliminarAsignatura(int codAsignatura) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        TaskDAO.eliminarTaskPorAsignatura(query, codAsignatura);
        ApunteDAO.eliminarApuntePorAsignatura(query, codAsignatura);
        AsignaturaDAO.eliminarAsignatura(query,codAsignatura);
    }
}
