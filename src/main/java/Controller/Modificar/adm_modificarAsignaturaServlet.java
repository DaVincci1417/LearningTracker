package Controller.Modificar;

import Model.Academico;
import Model.Asignatura;
import Model.Data.DAO.AcademicoDAO;
import Model.Data.DAO.AsignaturaDAO;
import Model.Data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;

@WebServlet(name = "adm_modificarAsignaturaServlet", value = "/adm_modificarAsignatura")
public class adm_modificarAsignaturaServlet extends HttpServlet{
    @Override
    public void init() throws ServletException{
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
                response.sendRedirect("adm_modificarAsignatura.jsp");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/adm_errorModificarAsignatura.jsp");
        if(req.getParameter("nombre_asignatura").length() != 0 || req.getParameter("modulo").length() != 0
                || req.getParameter("semestre").length() != 0 || req.getParameter("tipoLibro").length() != 0){
            String nombreAsignatura = req.getParameter("nombre_asignatura");
            int modulo = Integer.parseInt(req.getParameter("modulo"));
            int semestre = Integer.parseInt(req.getParameter("semestre"));
            String rutAcademico = req.getParameter("rut_academico");


            Asignatura asignatura = (Asignatura) req.getSession().getAttribute("asignatura");

            try {
                modificarAsignatura(asignatura, "nombre_asignatura", nombreAsignatura);
                modificarAsignatura(asignatura, "modulo", modulo);
                modificarAsignatura(asignatura, "semestre", semestre);
                try {
                    modificarAsignatura(asignatura, "rut_academico", rutAcademico);
                }catch (ClassNotFoundException e){
                    respuesta = req.getRequestDispatcher("/adm_errorModificarAsignaturaNN.jsp");
                }
                respuesta = req.getRequestDispatcher("/adm_exitoModificarAsignatura.jsp");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private Asignatura obtenerAsignatura(int codAsignatura) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        return  AsignaturaDAO.obtenerAsignatura(query,"cod_asignatura", codAsignatura).get(0);
    }
    private void modificarAsignatura(Asignatura asignatura, String columnaEditar, Object nuevoDato) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        AsignaturaDAO.modificarAsignatura(query, asignatura.getCodAsignatura(), columnaEditar, nuevoDato);
    }

}
