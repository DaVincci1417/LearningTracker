package Controller.Session;

import Model.Academico;
import Model.Administrador;
import Model.Data.DAO.AcademicoDAO;
import Model.Data.DAO.AdministradorDAO;
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
import jakarta.servlet.http.HttpSession;
import org.jooq.DSLContext;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "loginAdministradorServlet", value = "/loginAdministrador")
public class loginAdministradorServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("learning_tracker");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/errorLoginAdministrador.jsp");
        if(req.getParameter("rutLoginAdministrador").length()!=0 && req.getParameter("contraseñaAdministrador").length() != 0){
            try {
                if(obtenerAdministrador(req) == null){
                    respuesta = req.getRequestDispatcher("/administradorNoTieneCuenta.jsp");
                }else{
                    Administrador administrador;
                    administrador = obtenerAdministrador(req);
                    HttpSession session;

                    session = req.getSession();

                    session.setAttribute("usuario", administrador);
                    session.setAttribute("evento", ultimoEvento(obtenerEventos(req)));
                    session.setAttribute("fecha", fechaActual());

                    this.getServletContext().getRequestDispatcher("/adm_panel.jsp").forward(req, resp);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        respuesta.forward(req,resp);
    }
    private Administrador obtenerAdministrador(HttpServletRequest req) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        List<Administrador> administrador = AdministradorDAO.obtenerAdministrador(query, "rut_administrador", req.getParameter("rutLoginAdministrador"));
        if(administrador.size() == 1){
            return administrador.get(0);
        }
        else{
            return null;
        }
    }
    public String fechaActual(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }
    private List<Evento> obtenerEventos(HttpServletRequest req) throws ClassNotFoundException {
        List<Evento> eventos = EventoDAO.obtenerEventos();
        return  eventos;
    }
    private Evento ultimoEvento(List<Evento> eventos){
        int cantidadEventos = eventos.size();
        return eventos.get(eventos.size() - 1);
    }
}
