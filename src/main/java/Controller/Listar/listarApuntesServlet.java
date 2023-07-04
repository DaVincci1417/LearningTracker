package Controller.Listar;

import Model.Apunte;
import Model.Data.DAO.ApunteDAO;
import Model.Data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listarApuntesServlet", value = "/listarApuntes")
public class listarApuntesServlet extends HttpServlet{
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
            req.setAttribute("apuntes", editarFormatoFecha(obtenerApuntes()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher respuesta = req.getRequestDispatcher("/est_verApuntes.jsp");
        respuesta.forward(req,resp);
    }

    private List obtenerApuntes() throws ClassNotFoundException {
        List<Apunte> apuntes = new ArrayList<>();
        apuntes = ApunteDAO.obtenerApuntes(DBGenerator.conectarBD("learning_tracker"));
        return apuntes;
    }
    private List editarFormatoFecha(List<Apunte> apuntes) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        List<Apunte> apuntesEditados = new ArrayList<>();
        for (int i = 0; i < apuntes.size(); i++) {
            formatoFecha.format(apuntes.get(i).getFechaApunte());
            apuntesEditados.add(apuntes.get(i));
        }
        return apuntesEditados;
    }
}
