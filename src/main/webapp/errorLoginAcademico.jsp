<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 7/5/2023
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="ComponentesLogin/headLogin.jsp"%>
<div class="card-header py-3 alert-danger">
  <h2 class="h4 text-gray-900 mb-4">Algo ha salido mal.</h2>
</div>
<form class="user" action="loginAcademico" method="post">
  <div class="form-group">
    <input type="text" class="form-control form-control-user" id="rutLoginAcademico" name="rutLoginAcademico" aria-describedby="emailHelp" placeholder="Ingresa tu RUT" required>
  </div>
  <div class="form-group">
    <input type="password" class="form-control form-control-user" id="contraseñaAcademico" name="contraseñaAcademico" placeholder="Contraseña" required>
  </div>
  <input type="submit" value="Ingresar" class="btn btn-primary btn-user btn-block">
</form>
<%@ include file="ComponentesLogin/endingLogin.jsp"%>
