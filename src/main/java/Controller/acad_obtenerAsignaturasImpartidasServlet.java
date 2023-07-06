package Controller;

import Model.Academico;
import Model.Asignatura;
import Model.Data.DAO.AcademicoDAO;
import Model.Data.DAO.AsignaturaDAO;
import Model.Data.DBGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "acad_obtenerAsignaturasImpartidasServlet", value = "/acad_obtenerAsignaturasImpartidas")
public class acad_obtenerAsignaturasImpartidasServlet extends HttpServlet{
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("learning_tracker");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        if(req.getParameter("rut").length() != 0){
            String rut = req.getParameter("rut");
            try {
                req.getSession().setAttribute("academico", obtenerAcademico(rut));
                req.getSession().setAttribute("asignaturas", obtenerAsignaturas());
                response.sendRedirect("acad_verAsignaturas.jsp");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private Academico obtenerAcademico(String rut) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        Academico academico = new Academico();
        for (int i =0; i < AcademicoDAO.obtenerAcademico(query,"rut", rut).size(); i++){
            academico = AcademicoDAO.obtenerAcademico(query,"rut", rut).get(i);
        }
        return  academico;
    }
    private List<Asignatura> obtenerAsignaturas() throws ClassNotFoundException {
        return AsignaturaDAO.obtenerAsignaturas();
    }
}