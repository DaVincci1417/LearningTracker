<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 7/4/2023
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="ComponentesPrincipales/head.jsp"%>
<%@ include file="Sidebar/sidebarAdministrador.jsp"%>
<%@ include file="ComponentesPrincipales/topbar.jsp"%>

<div class="container-fluid">
  <!-- Page Heading -->
  <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Estudiantes</h1>
    <a href="adm_agregarAsignatura.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-sm text-white-50"></i>Agregar Asignatura</a>
  </div>
  <p class="mb-4">Estudiantes matriculados a la fecha: <c:out value="${fecha}"></c:out></p>
  <%@ include file="Listas/listaAcademicos.jsp"%>
</div>

<%@ include file="ComponentesPrincipales/footer.jsp"%>
<%@ include file="ComponentesPrincipales/alertaLogout.jsp"%>
<%@ include file="ComponentesPrincipales/ending.jsp"%>
