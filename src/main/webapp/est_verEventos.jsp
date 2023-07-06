<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 7/5/2023
  Time: 1:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="ComponentesPrincipales/head.jsp"%>
<%@ include file="Sidebar/sidebarEstudiante.jsp"%>
<%@ include file="Topbar/topbarEstudiante.jsp"%>

<div class="container-fluid">
  <!-- Page Heading -->
  <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Eventos</h1>
  </div>
  <p class="mb-4">Eventos agregados hasta hoy: <c:out value="${fecha}"></c:out> </p>
  <%@ include file="Listas/usuario_listaEventos.jsp"%>
</div>

<%@ include file="ComponentesPrincipales/footer.jsp"%>
<%@ include file="ComponentesPrincipales/alertaLogout.jsp"%>
<%@ include file="ComponentesPrincipales/ending.jsp"%>

