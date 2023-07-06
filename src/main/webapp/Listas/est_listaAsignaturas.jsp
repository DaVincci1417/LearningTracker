<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 7/5/2023
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <jsp:useBean class="Model.Data.DAO.AsignaturaDAO" id="asignaturaDAO"></jsp:useBean>
        <c:forEach items="${asignaturaDAO.obtenerAsignaturas()}" var="asignatura">
          <tr>
            <td>${asignatura.codAsignatura}</td>
            <td>${asignatura.nombreAsignatura}</td>
            <td>${asignatura.modulo}</td>
            <td>${asignatura.semestre}</td>
            <td>${asignatura.rutAcademico}</td>
            <td>
              <form action="est_inscribirAsignatura" method="post">
                <button type="submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"
                        name="cod_asignatura" value="${asignatura.codAsignatura}"> Inscribirme </button>
              </form>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
