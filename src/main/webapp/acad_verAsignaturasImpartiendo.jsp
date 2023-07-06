<%@ page import="Model.Inscripcion" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Asignatura" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Persona" %>
<%@ page import="Model.Academico" %><%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 7/5/2023
  Time: 1:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="ComponentesPrincipales/head.jsp"%>
<%@ include file="/Sidebar/sidebarAcademico.jsp"%>
<%@ include file="Topbar/topbarAcademico.jsp"%>

<%
    List<Asignatura> asignaturas = (List<Asignatura>) request.getSession().getAttribute("asignaturas");
    List<Asignatura> asignaturaImpartidas = new ArrayList<>();
    Academico academico = (Academico) request.getSession().getAttribute("academico");

    for(int i = 0; i < asignaturas.size(); i++){
        if(asignaturas.get(i).getRutAcademico().equalsIgnoreCase(academico.getRut())){
            asignaturaImpartidas.add(asignaturas.get(i));
        }
    }
%>

<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Asignaturas impartidas por: <%=academico.getNombre() + " " + academico.getApellidoP() + " " + academico.getApellidoM()%>.</h1>
    </div>
    <!-- Content Row -->
    <div class="row" >
        <c:forEach items="<%=asignaturaImpartidas%>" var="asignatura">
            <div class="col-xl-3 col-md-6 mb-4">
                <div class="card border-left-primary shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <form action="acad_obtenerAsignatura" method="get">
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
