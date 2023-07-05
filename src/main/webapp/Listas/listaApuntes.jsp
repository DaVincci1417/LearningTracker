<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 7/4/2023
  Time: 5:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- DataTales Apuntes-->
<div class="card shadow mb-4">
  <div class="card-header py-3">
    <h6 class="m-0 font-weight-bold text-primary">Apuntes</h6>
  </div>
  <div class="card-body">
    <div class="table-responsive">
      <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
        <thead>
        <tr>
          <th>Codigo Apunte</th>
          <th>Nombre Apunte</th>
          <th>Codigo Asignatura</th>
          <th>Fecha Apunte</th>
          <th>Apunte</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
          <th>Codigo Apunte</th>
          <th>Nombre Apunte</th>
          <th>Codigo Asignatura</th>
          <th>Fecha Apunte</th>
          <th>Apunte</th>
        </tr>
        </tfoot>
        <tbody>
        <jsp:useBean class="Model.Data.DAO.ApunteDAO" id="apunteDAO"></jsp:useBean>
        <c:forEach items="${apunteDAO.obtenerApuntes()}" var="apunte">
          <tr>
            <td>${apunte.codApunte}</td>
            <td>${apunte.nombreApunte}</td>
            <td>${apunte.codAsignatura}</td>
            <td>${apunte.fechaApunte}</td>
            <td>${apunte.textoApunte}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>