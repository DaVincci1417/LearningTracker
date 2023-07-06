<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 7/5/2023
  Time: 7:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="ComponentesPrincipales/head.jsp"%>
<%@ include file="Sidebar/sidebarAcademico.jsp"%>
<%@ include file="Topbar/topbarAcademico.jsp"%>

<div class="container-fluid">
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">${usuario.getNombre()} ${usuario.getApellidoP()} ${usuario.getApellidoM()}</h1>
    </div>
    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Datos Personales</h1>
            </div>
            <form class="user">
                <div class="form-group">
                    <input type="text" class="form-control form-control-user" readonly="" id="nombre" name="nombre" value="${usuario.getNombre()}" placeholder="Nombre" required>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                        <input type="text" class="form-control form-control-user" readonly="" id="apellido_paterno" name="apellido_paterno"
                               value="${usuario.getApellidoP()}" placeholder="Apellido Paterno" required>
                    </div>
                    <div class="col-sm-6">
                        <input type="text" class="form-control form-control-user" readonly="" id="apellido_materno" name="apellido_materno"
                               value="${usuario.getApellidoM()}" placeholder="Apellido Materno" required>
                    </div>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control form-control-user" readonly="" id="rut" name="rut"
                           value="${usuario.getRut()}" placeholder="RUT" required>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                        <input type="email" class="form-control form-control-user" readonly="" id="correo_institucional" name="correo_institucional"
                               value="${usuario.getCorreoInstitucional()}" placeholder="Correo Institucional" required>
                    </div>
                    <div class="col-sm-6">
                        <input type="email" class="form-control form-control-user" readonly="" id="sexo" name="sexo"
                               value="${usuario.getSexo()}" placeholder="Sexo" required>
                    </div>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control form-control-user" readonly="" id="dept" name="depto" value="${usuario.getDepto()}" placeholder="Departamento" required>
                </div>
                <!-- Divider -->
                <hr class="sidebar-divider">
                <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Datos de la Cuenta</h1>
                </div>

                <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                        <input type="text" class="form-control form-control-user"
                               id="nombre_usuario" name="nombre_usuario" readonly=""
                               value="${usuario.getNombreUsuario()}" placeholder="Nombre Usuario" required>
                    </div>
                    <div class="col-sm-6">
                        <input type="password" class="form-control form-control-user"
                               id="contraseña" name="contraseña" readonly=""
                               value="${usuario.getContraseña()}" placeholder="Contraseña" required>
                    </div>
                </div>
                <hr>
            </form>
        </div>
    </div>
</div>

<%@ include file="ComponentesPrincipales/footer.jsp"%>
<%@ include file="ComponentesPrincipales/alertaLogout.jsp"%>
<%@ include file="ComponentesPrincipales/ending.jsp"%>
