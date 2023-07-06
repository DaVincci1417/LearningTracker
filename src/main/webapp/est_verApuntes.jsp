<%@ page import="Model.Apunte" %>
<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 6/23/2023
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="ComponentesPrincipales/head.jsp"%>
<%@ include file="Sidebar/sidebarEstudiante.jsp"%>
<%@ include file="Topbar/topbarEstudiante.jsp"%>
<div class="container-fluid">
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Apuntes</h1>
        <a href="est_agregarApunte.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-sm text-white-50"></i>Agregar Apunte</a>
    </div>
    <p class="mb-4">Apuntes actualizados a la fecha 02/07/2023</p>
    <%@ include file="Listas/listaApuntes.jsp"%>
</div>
<%@ include file="ComponentesPrincipales/footer.jsp"%>
<%@ include file="ComponentesPrincipales/alertaLogout.jsp"%>
<%@ include file="ComponentesPrincipales/ending.jsp"%>
