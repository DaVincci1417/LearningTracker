package Controller.Eliminar;

import Model.Data.DAO.AcademicoDAO;
import Model.Data.DAO.EstudianteDAO;
import Model.Data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;
import org.jooq.impl.QOM;

import java.io.IOException;

@WebServlet(name = "adm_eliminarEstudianteServlet", value = "/adm_eliminarEstudiante")
public class adm_eliminarEstudianteServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("learning_tracker");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/errorEliminarEstudiante.jsp");
        if(req.getParameter("numero_matricula").length() != 0){
            String numeroMatricula = req.getParameter("numero_matricula");
            try {
                eliminarEstudiante(numeroMatricula);
                respuesta = req.getRequestDispatcher("/adm_exitoEliminarEstudiante.jsp");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private void eliminarEstudiante(String numeroMatricula) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        EstudianteDAO.eliminarEstudiante(query,numeroMatricula);

    }
}
