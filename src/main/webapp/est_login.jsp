<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 02-07-2023
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="ComponentesLogin/headLogin.jsp"%>
<form class="user" action="loginEstudiante" method="post">
  <div class="form-group">
    <input type="number" class="form-control form-control-user" id="matriculaLogin" name="matriculaLogin" aria-describedby="emailHelp" placeholder="Ingresa tu matricula" required>
  </div>
  <div class="form-group">
    <input type="password" class="form-control form-control-user" id="contraseñaEstudiante" name="contraseñaEstudiante" placeholder="Contraseña" required>
  </div>
  <input type="submit" value="Ingresar" class="btn btn-primary btn-user btn-block">
</form>
<hr>
<div class="text-center">
  <a class="small" href="est_registro.jsp">¡Crea un cuenta!</a>
</div>
<%@ include file="ComponentesLogin/endingLogin.jsp"%>

