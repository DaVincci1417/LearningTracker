package Controller.Modificar;

import Model.Academico;
import Model.Asignatura;
import Model.Data.DAO.AcademicoDAO;
import Model.Data.DAO.AsignaturaDAO;
import Model.Data.DAO.EstudianteDAO;
import Model.Data.DBGenerator;
import Model.Estudiante;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;

@WebServlet(name = "adm_modificarEstudianteServlet", value = "/adm_modificarEstudiante")
public class adm_modificarEstudianteServlet extends HttpServlet {
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
        if (req.getParameter("numero_matricula").length() != 0) {
            String numeroMatricula = req.getParameter("numero_matricula");
            try {
                obtenerEstudiante(numeroMatricula);
                req.getSession().setAttribute("estudiante", obtenerEstudiante(numeroMatricula));
                response.sendRedirect("adm_modificarEstudiante.jsp");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/adm_errorModificarEstudiante.jsp");
        if(req.getParameter("nombre").length()!=0 && req.getParameter("apellido_paterno").length() != 0 && req.getParameter("apellido_materno").length() != 0
                && req.getParameter("rut").length() != 0 && req.getParameter("correo_institucional").length() != 0 && req.getParameter("numero_matricula").length() != 0
                && req.getParameter("carrera").length() != 0 && req.getParameter("sexo").length() != 0 && req.getParameter("nombre_usuario").length() != 0 && req.getParameter("contraseña").length() != 0){
            String nombre = req.getParameter("nombre");
            String apellidoPaterno = req.getParameter("apellido_paterno");
            String apellidoMaterno = req.getParameter("apellido_materno");
            String rut = req.getParameter("rut");
            String correoInstitucional = req.getParameter("correo_institucional");
            String numeroMatricula = req.getParameter("numero_matricula");
            String carrera = req.getParameter("carrera");
            String sexo = req.getParameter("sexo");

            String nombreUsuario = req.getParameter("nombre_usuario");
            String contraseña = req.getParameter("contraseña");
            String tipoUsuario = "Estudiante";


            Estudiante estudiante = (Estudiante) req.getSession().getAttribute("estudiante");
            try {
                modificarEstudiante(estudiante, "nombre_estudiante", nombre);
                modificarEstudiante(estudiante, "apellido_paterno", apellidoPaterno);
                modificarEstudiante(estudiante, "apellido_materno", apellidoMaterno);
                modificarEstudiante(estudiante, "rut", rut);
                modificarEstudiante(estudiante, "numero_matricula", numeroMatricula);
                modificarEstudiante(estudiante, "correo_institucional", correoInstitucional);
                modificarEstudiante(estudiante, "sexo", sexo);
                modificarEstudiante(estudiante, "carrera", carrera);
                modificarEstudiante(estudiante, "nombre_usuario", nombreUsuario);
                modificarEstudiante(estudiante, "contraseña", contraseña);

                respuesta = req.getRequestDispatcher("/adm_exitoModificarEstudiante.jsp");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private Estudiante obtenerEstudiante(String numeroMatricula) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        return  EstudianteDAO.obtenerEstudiante(query,"numero_matricula", numeroMatricula).get(0);
    }
    private void modificarEstudiante(Estudiante estudiante, String columnaEditar, Object nuevoDato) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        EstudianteDAO.modificarEstudiante(query, estudiante.getNumeroMatricula(), columnaEditar, nuevoDato);
    }
}
