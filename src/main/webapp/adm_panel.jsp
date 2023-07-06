<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="ComponentesPrincipales/head.jsp"%>
<%@ include file="/Sidebar/sidebarAdministrador.jsp"%>
<%@ include file="Topbar/topbarAdministrador.jsp"%>
<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Bienvenido a Learning Tracker - FICA, ${usuario.nombre} ${usuario.apellidoP} ${usuario.apellidoM}.</h1>
    </div>
    <!-- Content Row -->
    <div class="row" >
        <!-- Card -->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                Nombre de Usuario
                            </div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">${usuario.nombreUsuario}</div>
                        </div>
                        <div class="col-auto">
                            <i class="fas fa-signature fa-lg"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Card -->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                Tipo de Usuario
                            </div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">${usuario.tipoUsuario}</div>
                        </div>
                        <div class="col-auto">
                            <i class="fas fa-user-tie fa-lg"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Card -->
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                Ultimo Evento
                            </div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">${evento.nombreEvento} ${evento.fechaEvento}</div>
                        </div>
                        <div class="col-auto">
                            <i class="fas fa-calendar-alt fa-lg"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="ComponentesPrincipales/footer.jsp"%>
<%@ include file="ComponentesPrincipales/alertaLogout.jsp"%>
<%@ include file="ComponentesPrincipales/ending.jsp"%>