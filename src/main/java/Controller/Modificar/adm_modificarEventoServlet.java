package Controller.Modificar;

import Model.Academico;
import Model.Asignatura;
import Model.Data.DAO.AcademicoDAO;
import Model.Data.DAO.EstudianteDAO;
import Model.Data.DAO.EventoDAO;
import Model.Data.DBGenerator;
import Model.Estudiante;
import Model.Evento;
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

@WebServlet(name = "adm_modificarEventoServlet", value = "/adm_modificarEvento")
public class adm_modificarEventoServlet extends HttpServlet {
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
        if(req.getParameter("cod_evento").length() != 0){
            int codEvento = Integer.parseInt(req.getParameter("cod_evento"));
            try {
                req.getSession().setAttribute("evento", obtenerEvento(codEvento));
                response.sendRedirect("adm_modificarEvento.jsp");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/acad_errorModificarEvento.jsp");
        if(req.getParameter("nombre_evento").length()!=0 && req.getParameter("descripcion_evento").length() != 0
                && req.getParameter("fecha_evento").length() != 0){
            Date fechaEvento;
            String nombreEvento= req.getParameter("nombre_evento");
            String descripcionEvento = req.getParameter("descripcion_evento");
            try {
                fechaEvento = new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("fecha_evento"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            Evento evento = (Evento) req.getSession().getAttribute("evento");

            try {
                modificarEvento(evento, "nombre_evento", nombreEvento);
                modificarEvento(evento, "descripcion_evento", descripcionEvento);
                modificarEvento(evento, "fecha_evento", fechaEvento);

                respuesta = req.getRequestDispatcher("/adm_exitoModificarEvento.jsp");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }

    private Evento obtenerEvento(int codEvento) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        return  EventoDAO.obtenerEvento(query,"cod_evento", codEvento).get(0);
    }
    private void modificarEvento(Evento evento, String columnaEditar, Object nuevoDato) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        EventoDAO.modificarEvento(query, evento.getCodEvento(), columnaEditar, nuevoDato);
    }
}
