<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 7/4/2023
  Time: 10:02 AM
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
          <th>N° Matricula</th>
          <th>RUT</th>
          <th>Nombre(s)</th>
          <th>Apellido Paterno</th>
          <th>Apellido Materno</th>
          <th>Correo Institucional</th>
          <th>Sexo</th>
          <th>Carrera</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
          <th>N° Matricula</th>
          <th>RUT</th>
          <th>Nombre(s)</th>
          <th>Apellido Paterno</th>
          <th>Apellido Materno</th>
          <th>Correo Institucional</th>
          <th>Sexo</th>
          <th>Carrera</th>
        </tr>
        </tfoot>
        <tbody>
        <c:forEach items="${estudiantes}" var="estudiante">
          <tr>
            <td><c:out value="${estudiante.getNumeroMatricula()}"></c:out></td>
            <td><c:out value="${estudiante.getRut()}"></c:out></td>
            <td><c:out value="${estudiante.getNombre()}"></c:out></td>
            <td><c:out value="${estudiante.getApellidoP()}"></c:out></td>
            <td><c:out value="${estudiante.getApellidoM()}"></c:out></td>
            <td><c:out value="${estudiante.getCorreoInstitucional()}"></c:out></td>
            <td><c:out value="${estudiante.getSexo()}"></c:out></td>
            <td><c:out value="${estudiante.getCarrera()}"></c:out></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
