<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 7/4/2023
  Time: 5:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- DataTales Tareas -->
<div class="card shadow mb-4">
  <div class="card-header py-3">
    <h6 class="m-0 font-weight-bold text-primary">Tasks</h6>
  </div>
  <div class="card-body">
    <div class="table-responsive">
      <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
        <thead>
        <tr>
          <th>Codigo Task</th>
          <th>Nombre del Task</th>
          <th>Codigo Asignatura</th>
          <th>Tipo del Task</th>
          <th>Fecha del Task</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
          <th>Codigo Task</th>
          <th>Nombre del Task</th>
          <th>Codigo Asignatura</th>
          <th>Tipo del Task</th>
          <th>Fecha del Task</th>
        </tr>
        </tfoot>
        <tbody>
        <jsp:useBean class="Model.Data.DAO.TaskDAO" id="taskDAO"></jsp:useBean>
        <c:forEach items="${taskDAO.obtenerEventos()}" var="task">
          <tr>
            <td>${task.codTask}</td>
            <td>${task.nombreTask}</td>
            <td>${task.codAsignaturas}</td>
            <td>${task.tipoTask}</td>
            <td>${task.fechaTask}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>