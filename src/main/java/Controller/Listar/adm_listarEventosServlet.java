package Controller.Listar;


import Model.Data.DAO.EventoDAO;
import Model.Data.DBGenerator;
import Model.Evento;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "adm_listarEventosServlet", value = "/adm_listarEventos")
public class adm_listarEventosServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("learning_tracker");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("eventos", obtenerEventos());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher respuesta = req.getRequestDispatcher("/adm_verEventos.jsp");
        respuesta.forward(req,resp);
    }

    private List obtenerEventos() throws ClassNotFoundException {
        List<Evento> eventos = new ArrayList<>();
        eventos = EventoDAO.obtenerEventos(DBGenerator.conectarBD("learning_tracker"));
        return eventos;
    }
}