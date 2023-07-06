package Controller.Agregar;

import Model.Asignatura;
import Model.Data.DAO.AsignaturaDAO;
import Model.Data.DAO.InscripcionDAO;
import Model.Data.DAO.TaskDAO;
import Model.Data.DBGenerator;
import Model.Estudiante;
import Model.Inscripcion;
import Model.Task;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "est_inscribirAsignaturaServlet", value = "/est_inscribirAsignatura")
public class est_inscribirAsignaturaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/adm_errorModificarAsignatura.jsp");
        if(req.getParameter("cod_asignatura").length() != 0){
            int codAsignatura = Integer.parseInt(req.getParameter("cod_asignatura"));

            Estudiante estudiante = (Estudiante) req.getSession().getAttribute("usuario");
            Inscripcion inscripcion = new Inscripcion(estudiante.getNumeroMatricula(), codAsignatura);

            try {
                if(inscribirAsignatura(inscripcion)){
                    req.setAttribute("Inscripcion",inscripcion);
                    respuesta = req.getRequestDispatcher("/est_exitoInscribirAsignatura.jsp");
                }else{
                    respuesta = req.getRequestDispatcher("/est_yaEstaInscrito.jsp");
                }
            }catch (ClassNotFoundException e){
            }
        }
        respuesta.forward(req,resp);
    }

    private boolean inscribirAsignatura(Inscripcion inscripcion) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        for (int i =0; i < InscripcionDAO.obtenerInscripciones().size(); i++){
            if(InscripcionDAO.obtenerInscripciones().get(i).getNumeroMatricula().equalsIgnoreCase(inscripcion.getNumeroMatricula())){
                return false;
            } else{
                InscripcionDAO.agregarInscripcion(query,inscripcion);
                return true;
            }
        }
        return false;
    }
}
