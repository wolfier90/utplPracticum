<%-- 
    Document   : Ordenes
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
        <title>ORDENES DE MANTENIMIENTO</title>
    </head>
    <body>
        <h1>Registrar Solicitud de Mantenimiento</h1>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Ordenes" method="POST">
                        <div class="form-group">  
                            <label>Vehiculo Asignado</label>
                            <input type="text" value="${MuestraVehiculo.getPlaca()}" name="txtPlaca" class="form-control" disabled>
                        </div>
                        <div class="form-group">  
                            <label>*Fecha del mantenimiento</label>
                            <input type="date" value="${editaOrden.getFechaInicio()}" name="txtFechaMant" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>*Kilometraje Actual</label>
                            <input type="text" value="${editaOrden.getKilometrajeActual()}" name="txtKilometraje" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>*Observaciones Adicionales</label>
                            <input type="text" value="${editaOrden.getObservaciones()}" name="txtObservaciones" class="form-control">
                        </div>
                        <br></br>
                        <button type="submit" name="accion" value="RegistrarOrden" class="btn btn-info">Registrar Solicitud</button>
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        <div class="form-group">
                            <input type="text" value="${MuestraVehiculo.getMensajeSalida()}" name="txtMensaje1" class="form-control" style="color: #F23006; outline:none" disabled>
                            <input type="text" value="${AgregaOrden.getMensajeSalida()}" name="txtMensaje2" class="form-control" style="color: #F23006; outline:none" disabled>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-10">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>NO. ORDEN</th>
                            <th>ESTADO</th>
                            <th>VEHICULO</th>
                            <th>ENCARGADO</th>
                            <th>FECHA MANTENIMIENTO</th>
                            <th>KILOMETRAJE ACTUAL</th>
                            <th>OBSERVACIONES</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ord" items="${Ordenes}">
                            <tr>
                                <td>${ord.getIdOrdenTrabajo()}</td>
                                <td>${ord.getEstado()}</td>
                                <td>${ord.getPlaca()}</td>
                                <td>${ord.getIdPersonalPolicial()}</td>
                                <td>${ord.getFechaInicio()}</td>
                                <td>${ord.getKilometrajeActual()}</td>
                                <td>${ord.getObservaciones()}</td>
                                <td class="d-flex">
                                    <a class="btn btn-warning" href="Controlador?menu=Ordenes&accion=Editar&idOrden=${ord.getIdOrdenTrabajo()}">Editar</a>
                                    <a class="btn btn-danger" style="margin-left: 10px" href="Controlador?menu=Ordenes&accion=Delete&idOrden=${ord.getIdOrdenTrabajo()}">Eliminar</a>
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
