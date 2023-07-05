<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 7/4/2023
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="ComponentesPrincipales/head.jsp"%>
<%@ include file="Sidebar/sidebarAdministrador.jsp"%>
<%@ include file="Topbar/topbar.jsp"%>

<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Agregar Evento</h1>
    </div>
    <div class="card shadow mb-4">
        <div class="card-body">
            <form class="user" action="agregarEvento" method="post">
                <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                        <input type="text" class="form-control form-control-user" id="nombre_evento" name="nombre_evento" placeholder="Nombre" required>
                    </div>
                    <div class="col-sm-6">
                        <input type="date" class="form-control form-control-user" id="fecha_evento" name="fecha_evento" placeholder="Fecha" required>
                    </div>
                </div>
                <div class="form-group ">
                    <textarea class="form-control" id="descripcion_evento" name="descripcion_evento" placeholder="Descripcion Evento" rows="10" required></textarea>
                </div>
                <!-- Divider -->
                <hr class="sidebar-divider">

                <input type="submit" value="Guardar Evento" class="btn btn-primary btn-user btn-block">
                <hr>
            </form>
        </div>
    </div>
</div>

<%@ include file="ComponentesPrincipales/footer.jsp"%>
<%@ include file="ComponentesPrincipales/alertaLogout.jsp"%>
<%@ include file="ComponentesPrincipales/ending.jsp"%>