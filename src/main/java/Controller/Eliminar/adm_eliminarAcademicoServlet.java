package Controller.Eliminar;

import Model.Academico;
import Model.Data.DAO.AcademicoDAO;
import Model.Data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "adm_eliminarAcademicoServlet", value = "/adm_eliminarAcademico")
public class adm_eliminarAcademicoServlet extends HttpServlet {
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
        RequestDispatcher respuesta = req.getRequestDispatcher("/errorEliminarAcademico.jsp");
        if(req.getParameter("rut").length() != 0){
            String rut = req.getParameter("rut");
            try {
                eliminarAcademico(rut);
                respuesta = req.getRequestDispatcher("/adm_exitoEliminarAcademico.jsp");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private void eliminarAcademico(String rut) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        AcademicoDAO.eliminarAcademico(query,rut);
    }
}
