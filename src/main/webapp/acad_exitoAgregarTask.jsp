<%@ page import="Model.Task" %>
<%@ page import="Model.Data.DBGenerator"%><%--
<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 27-06-2023
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="ComponentesPrincipales/head.jsp"%>
<%@ include file="Sidebar/sidebarAcademico.jsp"%>
<%@ include file="Topbar/topbarAcademico.jsp"%>
<div class="container-fluid">
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Nombre asignatura: ${asignatura.nombreAsignatura}</h1>
    </div>
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Modulo: ${asignatura.modulo}</h1>
    </div>
    <div class="card-header py-3 alert-warning">
        <h2 class="h4 text-gray-900 mb-4">Se ha agregado el TASK con exito.</h2>
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
                                Alumnos Inscritos
                            </div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">${estudiantes.size()}</div>
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
                        <div class="col mr-2 align-content-center">
                            <a href="acad_verEstudiantesEnAsignatura.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-sm text-white-50">
                            </i>Ver Estudiantes</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-md-6 mb-4">
            <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2 align-content-center">
                            <a href="acad_agregarTask.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-sm text-white-50">
                            </i>Agregar Task</a>
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
                        <div class="col mr-2 align-content-center">
                            <a href="acad_verAsignatura.jsp" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-sm text-white-50">
                            </i>Ver Task</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="Listas/usuario_listarTasks.jsp"%>
</div>

<%@ include file="ComponentesPrincipales/footer.jsp"%>
<%@ include file="ComponentesPrincipales/alertaLogout.jsp"%>
<%@ include file="ComponentesPrincipales/ending.jsp"%>

