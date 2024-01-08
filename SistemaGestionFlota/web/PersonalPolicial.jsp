<%-- 
    Document   : PersonalPolicial
    Created on : 24-dic-2023, 16:33:20
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>PERSONAL</title>
    </head>
    <body>
        <h1>Registrar Personal</h1>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Personal" method="POST">
                        <div class="form-group">  
                            <label>Nombres</label>
                            <input type="text" value="${empleado.getNombres()}" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>Apellidos</label>
                            <input type="text" value="${empleado.getApellidos()}" name="txtApellido" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>Identificación</label>
                            <input type="text" value="${empleado.getIdentificacion()}" name="txtIdent" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>Fecha de Nacimiento</label>
                            <input type="date" value="${empleado.getFechaNacimiento()}" name="txtFechanac" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>Correo</label>
                            <input type="text" value="${empleado.getCorreo()}" name="txtCorreo" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>Cargo</label>
                            <!--<input type="text" value="${empleado.getCargo()}" name="txtCargo" class="form-control">-->
                            <div class="col-sm-4">
                                <select id="cboCargo" value="${empleado.getCargo()}" name="cboCargo" style="width:150px">
                                    <option value="LOGISTICA">LOGISTICA</option>
                                    <option value="ENCARGADO">ENCARGADO</option>
                                </select>
                            </div>
                        </div>
                        <br></br>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-10">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>NOMBRES</th>
                            <th>APELLIDOS</th>
                            <th>IDENTIFICACION</th>
                            <th>CORREO</th>
                            <th>NACIMIENTO</th>
                            <th>CARGO</th>
                            <th>ACCIONES</th>
                        </tr>>
                    </thead>
                    <tbody>
                        <c:forEach var="pe" items="${personal}">
                            <tr>
                            <td>${pe.getNombres()}</td>
                            <td>${pe.getApellidos()}</td>
                            <td>${pe.getIdentificacion()}</td>
                            <td>${pe.getCorreo()}</td>
                            <td>${pe.getFechaNacimiento()}</td>
                            <td>${pe.getCargo()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Personal&accion=Editar&id=${pe.getId()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Personal&accion=Delete&id=${pe.getId()}">Eliminar</a>
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
