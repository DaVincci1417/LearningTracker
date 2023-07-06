<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 25-06-2023
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="ComponentesPrincipales/head.jsp"%>
<%@ include file="Sidebar/sidebarAcademico.jsp"%>
<%@ include file="Topbar/topbarAcademico.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">
  <!-- Page Heading -->
  <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Agregar Task</h1>
  </div>
  <div class="card shadow mb-4">
    <div class="card-body">
      <form class="user" action="agregarTask" method="post">
        <div class="form-group row">
          <div class="col-sm-6 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user" id="nombre_tarea" name="nombre_tarea" placeholder="Nombre" required>
          </div>
          <div class="col-sm-6">
            <input type="text" class="form-control form-control-user" readonly="" value="${asignatura.codAsignatura}" id="cod_asignatura" name="cod_asignatura" placeholder="Codigo Asignatura" required>
          </div>
        </div>
        <div class="form-group row">
          <div class="col-sm-6 mb-3 mb-sm-0">
            <select class="custom-select animated--grow-in" id="tipo_tarea" name="tipo_tarea" required>
              <option value="" disable selected hidden>Tipo Task</option>
              <option value="Ayudantia">Ayudantia</option>
              <option value="Tarea">Tarea</option>
              <option value="Taller">Taller</option>
              <option value="Prueba">Prueba</option>
              <option value="Examen">Examen</option>
            </select>
          </div>
          <div class="col-sm-6">
            <input type="date" class="form-control form-control-user" id="fecha_tarea" name="fecha_tarea" placeholder="Fecha" required>
          </div>
        </div>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <input type="submit" value="Guardar Task" class="btn btn-primary btn-user btn-block">
        <hr>
      </form>
    </div>
  </div>
</div>

<%@ include file="ComponentesPrincipales/footer.jsp"%>
<%@ include file="ComponentesPrincipales/alertaLogout.jsp"%>
<%@ include file="ComponentesPrincipales/ending.jsp"%>