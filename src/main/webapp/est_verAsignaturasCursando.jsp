<%@ page import="Model.Estudiante" %>
<%@ page import="Model.Asignatura" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Inscripcion" %>
<%@ page import="Model.Data.DAO.AsignaturaDAO" %><%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 7/5/2023
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ComponentesPrincipales/head.jsp"%>
<%@ include file="/Sidebar/sidebarEstudiante.jsp"%>
<%@ include file="Topbar/topbarEstudiante.jsp"%>

<%
  List<Asignatura> asignaturas = (List<Asignatura>) request.getSession().getAttribute("asignaturas");
  List<Inscripcion> inscripciones = (List<Inscripcion>) request.getSession().getAttribute("inscripciones");
  List<Asignatura> asignaturaCursando = new ArrayList<>();
  Estudiante estudiante = (Estudiante) request.getSession().getAttribute("estudiante");

  for(int i = 0; i < asignaturas.size(); i++){
    if(inscripciones.get(i).getNumeroMatricula().equalsIgnoreCase(estudiante.getNumeroMatricula())){
      asignaturaCursando.add(AsignaturaDAO.obtenerAsignatura("cod_asignatura",inscripciones.get(i).getCodAsignatura()).get(0));
    }
  }
%>

<div class="container-fluid">
  <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Asignaturas cursadas y/o cursando por: <%=estudiante.getNombre() + " " + estudiante.getApellidoP() + " " + estudiante.getApellidoM()%>.</h1>
  </div>
  <!-- Content Row -->
  <div class="row" >
    <c:forEach items="<%=asignaturaCursando%>" var="asignatura">
      <div class="col-xl-3 col-md-6 mb-4">
        <div class="card border-left-primary shadow h-100 py-2">
          <div class="card-body">
            <div class="row no-gutters align-items-center">
              <div class="col mr-2">
                <form action="est_obtenerAsignatura" method="get">
                  <button type="submit" class="d-inline btn btn-sm btn-primary shadow-sm"
                          name="cod_asignatura" value="${asignatura.codAsignatura}">${asignatura.nombreAsignatura}</button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
  <%@ include file="ComponentesPrincipales/footer.jsp"%>
  <%@ include file="ComponentesPrincipales/alertaLogout.jsp"%>
<%@ include file="ComponentesPrincipales/ending.jsp"%>