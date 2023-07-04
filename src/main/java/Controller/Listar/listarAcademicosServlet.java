package Controller.Listar;

import Model.Academico;
import Model.Data.DAO.AcademicoDAO;
import Model.Data.DBGenerator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listarAcademicosServlet", value = "/listarAcademicos")
public class listarAcademicosServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("learning_tracker");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            req.setAttribute("academicos", obtenerAcademicos());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher respuesta = req.getRequestDispatcher("/adm_verAcademicos.jsp");
        respuesta.forward(req,resp);
    }

    private List obtenerAcademicos() throws ClassNotFoundException {
        List<Academico> academicos = new ArrayList<>();
        academicos = AcademicoDAO.obtenerAcademicos(DBGenerator.conectarBD("learning_tracker"));
        return academicos;
    }
}
