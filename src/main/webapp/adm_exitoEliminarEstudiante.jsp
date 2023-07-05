<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 7/5/2023
  Time: 2:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="ComponentesPrincipales/head.jsp"%>
<%@ include file="Sidebar/sidebarAdministrador.jsp"%>
<%@ include file="Topbar/topbar.jsp"%>

<div class="container-fluid">
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Estudiantes</h1>
    </div>
    <p class="mb-4">Estudiantes con cuenta a la fecha: <c:out value="${fecha}"></c:out></p>
    <div class="card-header py-3 alert-warning">
        <h2 class="h4 text-gray-900 mb-4">Se ha ELIMINADO el ESTUDIANTE con exito.</h2>
    </div>
    <%@ include file="Listas/adm_listaEstudiantes.jsp"%>
</div>

<%@ include file="ComponentesPrincipales/footer.jsp"%>
<%@ include file="ComponentesPrincipales/alertaLogout.jsp"%>
<%@ include file="ComponentesPrincipales/ending.jsp"%>

