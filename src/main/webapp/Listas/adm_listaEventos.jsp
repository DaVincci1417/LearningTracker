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
          <th>Codigo Evento</th>
          <th>Nombre Evento</th>
          <th>Fecha Evento</th>
          <th>Descripcion Evento</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
          <th>Codigo Evento</th>
          <th>Nombre Evento</th>
          <th>Fecha Evento</th>
          <th>Descripcion Evento</th>
        </tr>
        </tfoot>
        <tbody>
        <jsp:useBean class="Model.Data.DAO.EventoDAO" id="eventoDAO"></jsp:useBean>
        <c:forEach items="${eventoDAO.obtenerEventos()}" var="evento">
          <tr>
            <td>${evento.codEvento}</td>
            <td>${evento.nombreEvento}</td>
            <td>${evento.fechaEvento}</td>
            <td>${evento.descripcionEvento}</td>
            <td>
              <form action="adm_modificarEvento" method="get">
                <button type="submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"
                        name="cod_evento" value="${evento.codEvento}"> Modificar </button>
              </form>
            </td>
            <td>
              <form action="adm_eliminarEvento" method="post">
                <button type="submit" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"
                        name="cod_evento" value="${evento.codEvento}"> Eliminar </button>
              </form>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
