<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 7/4/2023
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- DataTales Apuntes-->
<div class="card shadow mb-4">
  <div class="card-header py-3">
    <h6 class="m-0 font-weight-bold text-primary">Academicos</h6>
  </div>
  <div class="card-body">
    <div class="table-responsive">
      <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
        <thead>
        <tr>
          <th>RUT</th>
          <th>Nombre(s)</th>
          <th>Apellido Paterno</th>
          <th>Apellido Materno</th>
          <th>Correo Institucional</th>
          <th>Sexo</th>
          <th>Departamento</th>
          <th></th>
          <th></th>
        </tr>
        </thead>
        <tfoot>
        <tr>
          <th>RUT</th>
          <th>Nombre(s)</th>
          <th>Apellido Paterno</th>
          <th>Apellido Materno</th>
          <th>Correo Institucional</th>
          <th>Sexo</th>
          <th>Departamento</th>
          <th></th>
          <th></th>
        </tr>
        </tfoot>
        <tbody>
        <jsp:useBean class="Model.Data.DAO.AcademicoDAO" id="academicoDAO"></jsp:useBean>
        <c:forEach items="${academicoDAO.obtenerAcademicos()}" var="academico">
          <tr>
            <td>${academico.rut}</td>
            <td>${academico.nombre}</td>
            <td>${academico.apellidoP}</td>
            <td>${academico.apellidoM}</td>
            <td>${academico.correoInstitucional}</td>
            <td>${academico.sexo}</td>
            <td>${academico.depto}</td>
            <td>
              <form action="adm_modificarAcademico" method="get">
                <button type="submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"
                        name="rut" value="${academico.rut}"> Modificar </button>
              </form>
            </td>
            <td>
              <form action="adm_eliminarAcademico" method="post">
                <button type="submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"
                        name="rut" value="${academico.rut}"> Eliminar </button>
              </form>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>