package Controller.Obtener;

import Model.*;
import Model.Data.DAO.*;
import Model.Data.DBGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "acad_obtenerAsignaturaServlet", value = "/acad_obtenerAsignatura")
public class acad_obtenerAsignaturaServlet extends HttpServlet{
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
        if(req.getParameter("cod_asignatura").length() != 0){
            int codAsignatura = Integer.parseInt(req.getParameter("cod_asignatura"));
            try {
                req.getSession().setAttribute("asignatura", obtenerAsignatura(codAsignatura));
                req.getSession().setAttribute("estudiantes", obtenerEstudiantes(codAsignatura));
                req.getSession().setAttribute("tasks", obtenerTasks(codAsignatura));
                response.sendRedirect("acad_verAsignatura.jsp");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private Asignatura obtenerAsignatura(int codAsignatura) throws ClassNotFoundException {
        return AsignaturaDAO.obtenerAsignatura("cod_asignatura", codAsignatura).get(0);
    }
    private List<Inscripcion> obtenerInscripciones(int codAsignatura) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        return InscripcionDAO.obtenerInscripcion(query, "cod_asignatura", codAsignatura);
    }
    private List<Estudiante> obtenerEstudiantes(int codAsignatura) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        List<Estudiante> estudiantesInscritos = new ArrayList<>();
        for(int i = 0; i < obtenerInscripciones(codAsignatura).size(); i++){
            for(int j = 0; j < EstudianteDAO.obtenerEstudiantes().size(); j++){
                if(obtenerInscripciones(codAsignatura).get(i).getNumeroMatricula().equalsIgnoreCase(EstudianteDAO.obtenerEstudiantes().get(j).getNumeroMatricula())){
                    estudiantesInscritos.add(EstudianteDAO.obtenerEstudiantes().get(j));
                }
            }
        }
        return estudiantesInscritos;
    }
    private List<Task> obtenerTasks(int codAsignatura) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        List<Task> tasksAsignatura = new ArrayList<>();
        for(int i = 0; i < obtenerInscripciones(codAsignatura).size(); i++){
            for(int j = 0; j < TaskDAO.obtenerTasks().size(); j++){
                if(obtenerInscripciones(codAsignatura).get(i).getCodAsignatura() == TaskDAO.obtenerTasks().get(j).getCodAsignatura()){
                    tasksAsignatura.add(TaskDAO.obtenerTasks().get(j));
                }
            }
        }
        return tasksAsignatura;
    }
}
