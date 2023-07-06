package Controller.Obtener;

import Model.Academico;
import Model.Asignatura;
import Model.Data.DAO.AcademicoDAO;
import Model.Data.DAO.AsignaturaDAO;
import Model.Data.DAO.EstudianteDAO;
import Model.Data.DAO.InscripcionDAO;
import Model.Data.DBGenerator;
import Model.Estudiante;
import Model.Inscripcion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "est_obtenerAsignaturasCursandoServlet", value = "/est_obtenerAsignaturasCursando")
public class est_obtenerAsignaturasCursandoServlet extends HttpServlet {
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
        if(req.getParameter("numero_matricula").length() != 0){
            String numeroMatricula = req.getParameter("numero_matricula");
            try {
                req.getSession().setAttribute("estudiante", obtenerEstudiante(numeroMatricula));
                req.getSession().setAttribute("asignaturas", obtenerAsignaturas());
                req.getSession().setAttribute("inscripciones", obtenerInscripciones());
                response.sendRedirect("est_verAsignaturasCursando.jsp");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private Estudiante obtenerEstudiante(String numeroMatricula) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        Estudiante estudiante = new Estudiante();
        for (int i = 0; i < EstudianteDAO.obtenerEstudiante(query,"numero_matricula", numeroMatricula).size(); i++){
            estudiante = EstudianteDAO.obtenerEstudiante(query,"numero_matricula", numeroMatricula).get(i);
        }
        return  estudiante;
    }
    private List<Asignatura> obtenerAsignaturas() throws ClassNotFoundException {
        return AsignaturaDAO.obtenerAsignaturas();
    }
    private List<Inscripcion> obtenerInscripciones() throws ClassNotFoundException {
        return InscripcionDAO.obtenerInscripciones();
    }
}
