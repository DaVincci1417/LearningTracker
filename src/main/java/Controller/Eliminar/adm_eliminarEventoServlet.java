package Controller.Eliminar;

import Model.Data.DAO.EventoDAO;
import Model.Data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;

@WebServlet(name = "adm_eliminarEventoServlet", value = "/adm_eliminarEvento")
public class adm_eliminarEventoServlet extends HttpServlet {
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
        RequestDispatcher respuesta = req.getRequestDispatcher("/errorEliminarEvento.jsp");
        if(req.getParameter("cod_evento").length() != 0){
            int codEvento = Integer.parseInt(req.getParameter("cod_evento"));
            try {
                eliminarEvento(codEvento);
                respuesta = req.getRequestDispatcher("/adm_exitoEliminarEvento.jsp");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private void eliminarEvento(int codEvento) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("learning_tracker");
        EventoDAO.eliminarEvento(query,codEvento);
    }
}
