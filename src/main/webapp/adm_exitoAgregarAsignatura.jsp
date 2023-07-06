<%@ page import="java.sql.ResultSet" %>
<%@ page import="Model.Data.DBGenerator" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %><%--
<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 27-06-2023
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ComponentesPrincipales/head.jsp"%>
<%@ include file="Sidebar/sidebarAdministrador.jsp"%>
<%@ include file="Topbar/topbarAdministrador.jsp"%>

<div class="container-fluid">
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Asignaturas</h1>
        <a href="adm_agregarAsignatura.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-sm text-white-50"></i>Agregar Asignatura</a>
    </div>
    <p class="mb-4">Asignaturas cursadas y/o cursando al 1-2023.</p>
    <div class="card-header py-3 alert-warning">
        <h2 class="h4 text-gray-900 mb-4">Se ha AGREGADO la ASIGNATURA con exito.</h2>
    </div>
    <%@ include file="Listas/adm_listaAsignaturas.jsp"%>
</div>

<%@ include file="ComponentesPrincipales/footer.jsp"%>
<%@ include file="ComponentesPrincipales/alertaLogout.jsp"%>
<%@ include file="ComponentesPrincipales/ending.jsp"%>
