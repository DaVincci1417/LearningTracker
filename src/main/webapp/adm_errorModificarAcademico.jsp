<%@ page import="Model.Academico" %><%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 7/5/2023
  Time: 5:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ComponentesPrincipales/head.jsp"%>
<%@ include file="Sidebar/sidebarAdministrador.jsp"%>
<%@ include file="Topbar/topbarAdministrador.jsp"%>

<% Academico academico = (Academico) request.getSession().getAttribute("academico"); %>

<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Registrar Academico</h1>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3 alert-danger">
            <h2 class="h4 text-gray-900 mb-4">Algo ha salido mal, intentelo de nuevo.</h2>
        </div>
        <div class="card-body">
            <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Datos Personales</h1>
            </div>
            <form class="user" action="adm_modificarAcademico" method="post">
                <div class="form-group">
                    <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                           placeholder="Nombre" value="<%=academico.getNombre()%>" required>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                        <input type="text" class="form-control form-control-user" id="apellido_paterno" name="apellido_paterno"
                               placeholder="Apellido Paterno" value="<%=academico.getApellidoP()%>"required>
                    </div>
                    <div class="col-sm-6">
                        <input type="text" class="form-control form-control-user" id="apellido_materno" name="apellido_materno"
                               placeholder="Apellido Materno" value="<%=academico.getApellidoM()%>" required>
                    </div>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control form-control-user" id="rut" name="rut"
                           placeholder="RUT" value="<%=academico.getRut()%>" required>
                </div>
                <div class="form-group">
                    <input type="email" class="form-control form-control-user" id="correo_institucional" name="correo_institucional"
                           placeholder="Correo Institucional" value="<%=academico.getCorreoInstitucional()%>" required>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                        <select class="custom-select animated--grow-in" id="depto" name="depto" required>
                            <option value="" disable selected hidden>Departamento en cual trabaja</option>
                            <option value="Departamento de Ciencias Físicas">Departamento de Ciencias Físicas</option>
                            <option value="Departamento de Ciencias Químicas y Recursos Naturales">Departamento de Ciencias Químicas y Recursos Naturales</option>
                            <option value="Departamento de Ingeniería Industrial y de Sistemas">Departamento de Ingeniería Industrial y de Sistemas</option>
                            <option value="Departamento de Ingeniería Matemática">Departamento de Ingeniería Matemática</option>
                            <option value="Departamento de Ciencias de la Computación e Informática">Departamento de Ciencias de la Computación e Informática</option>
                            <option value="Departamento de Ingeniería Mecánica">Departamento de Ingeniería Mecánica</option>
                            <option value="Departamento de Ingeniería Química">Departamento de Ingeniería Química</option>
                            <option value="Departamento de Ingeniería de Obras Civiles">Departamento de Ingeniería de Obras Civiles</option>
                            <option value="Departamento de Ingeniería Eléctrica">Departamento de Ingeniería Eléctrica</option>
                            <option value="Departamento de Matemática y Estadística">Departamento de Matemática y Estadística</option>
                        </select>
                    </div>
                    <div class="col-sm-6">
                        <select class="custom-select animated--grow-in" id="sexo" name="sexo" required>
                            <option value="" disable selected hidden>Sexo</option>
                            <option value="Masculino">Masculino</option>
                            <option value="Femenino">Femenino</option>
                            <option value="NN">Prefiero no decirlo</option>
                        </select>
                    </div>
                </div>

                <!-- Divider -->
                <hr class="sidebar-divider">
                <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Datos de la Cuenta</h1>
                </div>

                <div class="form-group row">
                    <div class="col-sm-6 mb-3 mb-sm-0">
                        <input type="text" class="form-control form-control-user"
                               id="nombre_usuario" name="nombre_usuario" placeholder="Nombre Usuario" value="<%=academico.getNombreUsuario()%>" required>
                    </div>
                    <div class="col-sm-6">
                        <input type="password" class="form-control form-control-user"
                               id="contraseña" name="contraseña" placeholder="Contraseña" value="<%=academico.getContraseña()%>" required>
                    </div>
                </div>
                <input type="submit" value="Guardar Modificación" class="btn btn-primary btn-user btn-block">
                <hr>
            </form>
        </div>
    </div>
</div>
<%@ include file="ComponentesPrincipales/footer.jsp"%>
<%@ include file="ComponentesPrincipales/alertaLogout.jsp"%>
<%@ include file="ComponentesPrincipales/ending.jsp"%>