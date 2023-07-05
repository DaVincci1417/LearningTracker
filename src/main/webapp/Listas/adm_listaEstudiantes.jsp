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
    <h6 class="m-0 font-weight-bold text-primary">Estudiantes</h6>
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
        <jsp:useBean class="Model.Data.DAO.EstudianteDAO" id="estudianteDAO"></jsp:useBean>
        <c:forEach items="${estudianteDAO.obtenerEstudiantes()}" var="estudiante">
          <tr>
            <td>${estudiante.numeroMatricula}</td>
            <td>${estudiante.rut}</td>
            <td>${estudiante.nombre}</td>
            <td>${estudiante.apellidoP}</td>
            <td>${estudiante.apellidoM}</td>
            <td>${estudiante.correoInstitucional}</td>
            <td>${estudiante.sexo}</td>
            <td>${estudiante.carrera}</td>
            <td>
              <form action="adm_modificarEstudiante" method="get">
                <button type="submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"
                        name="numero_matricula" value="${estudiante.numeroMatricula}"> Modificar </button>
              </form>
            </td>
            <td>
              <form action="adm_eliminarEstudiante" method="post">
                <button type="submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"
                        name="numero_matricula" value="${estudiante.numeroMatricula}"> Eliminar </button>
              </form>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
