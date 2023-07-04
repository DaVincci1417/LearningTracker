<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 26-06-2023
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">
  <!-- Sidebar -->
  <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="../panelAdministrador.jsp">
      <div class="sidebar-brand-icon">
        <i class="fas fa-school"></i>
      </div>
      <div class="sidebar-brand-text mx-3">Learning Tracker</div>
    </a>
    <!-- Divider -->
    <hr class="sidebar-divider">
    <!-- Heading -->
    <div class="sidebar-heading">
      Gestión
    </div>
    <!-- Nav Item - Apuntes_Semestre Collapse Menu -->
    <li class="nav-item active">
      <a class="nav-link" href="listarAcademicos">
        <i class="fas fa-chalkboard-teacher"></i>
        <span>Academicos</span></a>
    </li>
    <!-- Divider -->
    <hr class="sidebar-divider">
    <!-- Nav Item - Apuntes_Semestre Collapse Menu -->
    <li class="nav-item active">
      <a class="nav-link" href="listarEstudiantes">
        <i class="fas fa-users"></i>
        <span>Estudiantes</span></a>
    </li>
    <!-- Divider -->
    <hr class="sidebar-divider">
    <!-- Nav Item - Ramos_Semestre Collapse Menu -->
    <li class="nav-item active">
      <a type="submit" class="nav-link" href="listarAsignaturas">
        <i class="fas fa-window-restore"></i>
        <span>Asignaturas</span></a>
    </li>
    <!-- Divider -->
    <hr class="sidebar-divider">
    <!-- Nav Item - Tareas_Semestre Collapse Menu -->
    <li class="nav-item active">
      <a class="nav-link" href="adm_listarEventos">
        <i class="fas fa-calendar-alt"></i>
        <span>Eventos</span></a>
    </li>
    <!-- Divider -->
    <hr class="sidebar-divider">
    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
      <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>
  </ul>
  <!-- End of Sidebar -->
