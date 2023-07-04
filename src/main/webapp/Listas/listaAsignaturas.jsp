<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 7/4/2023
  Time: 5:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- DataTales Asignatura -->
<div class="card shadow mb-4">
  <div class="card-header py-3">
    <h6 class="m-0 font-weight-bold text-primary">Asignaturas</h6>
  </div>
  <div class="card-body">
    <div class="table-responsive">
      <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
        <thead>
        <tr>
          <th>Codigo Asignatura</th>
          <th>Nombre Asignatura</th>
          <th>Modulo</th>
          <th>Semestre</th>
          <th>RUT de Académico</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
          <th>Codigo Asignatura</th>
          <th>Nombre Asignatura</th>
          <th>Modulo</th>
          <th>Semestre</th>
          <th>RUT de Académico</th>
        </tr>
        </tfoot>
        <tbody>
        <c:forEach items="${asignaturas}" var="estudiante">
          <tr>
            <td><c:out value="${estudiante.getCodAsignatura()}"></c:out></td>
            <td><c:out value="${estudiante.getNombreAsignatura()}"></c:out></td>
            <td><c:out value="${estudiante.getModulo()}"></c:out></td>
            <td><c:out value="${estudiante.getSemestre()}"></c:out></td>
            <td><c:out value="${estudiante.getRutAcademico()}"></c:out></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>