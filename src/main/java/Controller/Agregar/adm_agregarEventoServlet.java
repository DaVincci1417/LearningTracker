package Controller.Agregar;

import Model.Data.DAO.EventoDAO;
import Model.Data.DBGenerator;
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

@WebServlet(name = "agregarEventoServlet", value = "/agregarEvento")
public class adm_agregarEventoServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("learning_tracker");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher respuesta = request.getRequestDispatcher("/adm_agregarEvento.jsp");
        respuesta.forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/acad_errorAgregarTask.jsp");
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

            Evento evento = new Evento(nombreEvento, descripcionEvento, fechaEvento);

            try {
                if(agregarEvento(evento)){
                    req.setAttribute("Evento",evento);
                    respuesta = req.getRequestDispatcher("/adm_exitoAgregarEvento.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarEvento(Evento evento) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        EventoDAO.agregarEvento(query,evento);
        return true;
    }
}
