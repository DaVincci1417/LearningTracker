<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 25-06-2023
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="ComponentesPrincipales/head.jsp"%>
<%@ include file="Sidebar/sidebarAdministrador.jsp"%>
<%@ include file="Topbar/topbar.jsp"%>
<div class="container-fluid">
  <div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Registrar Academico</h1>
  </div>
  <div class="card shadow mb-4">
    <div class="card-body">
      <div class="text-center">
        <h1 class="h4 text-gray-900 mb-4">Datos Personales</h1>
      </div>
      <form class="user" action="registrarAcademico" method="post">
        <div class="form-group">
          <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                 placeholder="Nombre" required>
        </div>
        <div class="form-group row">
          <div class="col-sm-6 mb-3 mb-sm-0">
            <input type="text" class="form-control form-control-user" id="apellido_paterno" name="apellido_paterno"
                   placeholder="Apellido Paterno" required>
          </div>
          <div class="col-sm-6">
            <input type="text" class="form-control form-control-user" id="apellido_materno" name="apellido_materno"
                   placeholder="Apellido Materno" required>
          </div>
        </div>
        <div class="form-group">
          <input type="text" class="form-control form-control-user" id="rut" name="rut"
                 placeholder="RUT" required>
        </div>
        <div class="form-group">
          <input type="email" class="form-control form-control-user" id="correo_institucional" name="correo_institucional" placeholder="Correo Institucional" required>
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
                   id="nombre_usuario" name="nombre_usuario" placeholder="Nombre Usuario" required>
          </div>
          <div class="col-sm-6">
            <input type="password" class="form-control form-control-user"
                   id="contraseña" name="contraseña" placeholder="Contraseña" required>
          </div>
        </div>
          <input type="submit" value="Registrar Academico" class="btn btn-primary btn-user btn-block">
        <hr>
      </form>
    </div>
  </div>
</div>
<%@ include file="ComponentesPrincipales/footer.jsp"%>
<%@ include file="ComponentesPrincipales/alertaLogout.jsp"%>
<%@ include file="ComponentesPrincipales/ending.jsp"%>