package Controller.Modificar;

import Model.Academico;
import Model.Apunte;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "adm_modificarAcademicoServlet", value = "/adm_modificarAcademico")
public class adm_modificarAcademicoServlet extends HttpServlet {
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
                response.sendRedirect("adm_modificarAcademico.jsp");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/adm_errorModificarAcademico.jsp");
        if(req.getParameter("nombre").length()!=0 && req.getParameter("apellido_paterno").length() != 0 && req.getParameter("apellido_materno").length() != 0
                && req.getParameter("rut").length() != 0 && req.getParameter("correo_institucional").length() != 0 && req.getParameter("depto").length() != 0
                && req.getParameter("sexo").length() != 0 && req.getParameter("nombre_usuario").length() != 0 && req.getParameter("contraseña").length() != 0){
            String nombre = req.getParameter("nombre");
            String apellidoPaterno = req.getParameter("apellido_paterno");
            String apellidoMaterno = req.getParameter("apellido_materno");
            String rut = req.getParameter("rut");
            String correoInstitucional = req.getParameter("correo_institucional");
            String depto = req.getParameter("depto");
            String sexo = req.getParameter("sexo");

            String nombreUsuario = req.getParameter("nombre_usuario");
            String contraseña = req.getParameter("contraseña");
            String tipoUsuario = "Academico";

            Academico academico = (Academico) req.getSession().getAttribute("academico");

            try {
                modificarAcademico(academico, "rut", rut);
                modificarAcademico(academico, "nombre_academico", nombre);
                modificarAcademico(academico, "apellido_paterno", apellidoPaterno);
                modificarAcademico(academico, "apellido_materno", apellidoMaterno);
                modificarAcademico(academico, "correo_institucional", correoInstitucional);
                modificarAcademico(academico, "sexo", sexo);
                modificarAcademico(academico, "depto", depto);
                modificarAcademico(academico, "nombre_usuario", nombreUsuario);
                modificarAcademico(academico, "contraseña", contraseña);

                respuesta = req.getRequestDispatcher("/adm_exitoModificarAcademico.jsp");
                } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        respuesta.forward(req,resp);
    }
    private Academico obtenerAcademico(String rut) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        return  AcademicoDAO.obtenerAcademico(query,"rut", rut).get(0);
    }
    private void modificarAcademico(Academico academico, String columnaEditar, Object nuevoDato) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        AcademicoDAO.modificarAcademico(query, academico.getRut(), columnaEditar, nuevoDato);
    }
}
