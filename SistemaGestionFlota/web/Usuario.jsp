<%-- 
    Document   : Usuario
    Created on : 24-dic-2023, 16:32:18
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>USUARIOS</title>
    </head>
    <body>
        <h1>Registrar Usuarios</h1>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Usuarios" method="POST">
                        <div class="form-group">  
                            <label>*Nombre de Usuario</label>
                            <input type="text" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>*Contraseña</label>
                            <input type="text" name="txtApellido" class="form-control">
                        </div>
                        <br></br>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        <div class="form-group">
                            <input type="text" name="txtMensaje" class="form-control" style="color: #F23006" disabled>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-10">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>NOMBRES</th>
                            <th>APELLIDOS</th>
                            <th>VEHICULO</th>
                            <th>IDENTIFICACION</th>
                            <th>CORREO</th>
                            <th>NACIMIENTO</th>
                            <th>CARGO</th>
                            <th>CIUDAD</th>
                            <th>TIPO SANGRE</th>
                            <th>CELULAR</th>
                            <th>RANGO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pe" items="${personal}">
                            <tr>
                                <td>${pe.getNombres()}</td>
                                <td>${pe.getApellidos()}</td>
                                <td>${pe.getPlaca()}</td>
                                <td>${pe.getIdentificacion()}</td>
                                <td>${pe.getCorreo()}</td>
                                <td>${pe.getFechaNacimiento()}</td>
                                <td>${pe.getCargo()}</td>
                                <td>${pe.getCiudadNacimiento()}</td>
                                <td>${pe.getTipoSangre()}</td>
                                <td>${pe.getCelular()}</td>
                                <td>${pe.getRango()}</td>
                                <td class="d-flex">
                                    <a class="btn btn-warning" href="Controlador?menu=Personal&accion=Editar&id=${pe.getId()}">Editar</a>
                                    <a class="btn btn-danger" style="margin-left: 10px" href="Controlador?menu=Personal&accion=Delete&id=${pe.getId()}">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
