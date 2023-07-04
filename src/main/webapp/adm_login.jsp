<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 02-07-2023
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="ComponentesLogin/headLogin.jsp"%>
<form class="user" action="loginAdministrador" method="post">
  <div class="form-group">
    <input type="text" class="form-control form-control-user"
           id="rutLoginAdministrador" name="rutLoginAdministrador" aria-describedby="emailHelp" placeholder="Ingresa tu RUT" required>
  </div>
  <div class="form-group">
    <input type="password" class="form-control form-control-user" id="contraseñaAdministrador" name="contraseñaAdministrador" placeholder="Contraseña" required>
  </div>
  <input type="submit" value="Ingresar" class="btn btn-primary btn-user btn-block">
</form>
<%@ include file="ComponentesLogin/endingLogin.jsp"%>
