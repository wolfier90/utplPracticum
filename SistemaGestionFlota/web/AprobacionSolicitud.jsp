<%-- 
    Document   : AprobacionSolicitud
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
        <title>APROBACIÓN DE SOLICITUDES</title>
    </head>
    <body>
        <h1>Completar Orden a Procesar</h1>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Aprobacion" method="POST">
                        <div class="form-group">
                            <label>Orden de trabajo</label>
                            <input type="text" value="${editaOrden.getIdOrdenTrabajo()}" name="txtOrden" class="form-control" style="color: #889AA5" disabled>
                        </div>
                        <div class="form-group">
                            <label>Vehiculo Asignado</label>
                            <input type="text" value="${editaOrden.getPlaca()}" name="txtPlaca" class="form-control" style="color: #889AA5" disabled>
                        </div>
                        <div class="form-group">
                            <label>Responsable del vehículo</label>
                            <input type="text" value="${editaOrden.getIdPersonalPolicial()}" name="txtResponsable" class="form-control" style="color: #889AA5" disabled>
                        </div>
                        <div class="form-group">  
                            <label>*Fecha de Ingreso</label>
                            <input type="date" name="txtFechaIngreso" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>*Kilometraje Actual al Ingreso</label>
                            <input type="text" name="txtKilometrajeIngreso" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>*Seleccione los tipos de mantenimiento</label>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="1" name="mntA" id="mntA" checked>
                                <label class="form-check-label" for="mntA">
                                    Mantenimiento-1
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="2" name="mntB" id="mntB">
                                <label class="form-check-label" for="mntB">
                                    Mantenimiento-2
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="3" name="mntC" id="mntC">
                                <label class="form-check-label" for="mntC">
                                    Mantenimiento-3
                                </label>
                            </div>
                        </div>
                        <br></br>
                        <button type="submit" name="accion" value="RegistrarAprobacion" class="btn btn-info">Registrar</button>
                        <div class="form-group">
                            <input type="text" value="${ApruebaOrden.getMensajeSalida()}" name="txtMensaje1" class="form-control" style="color: #F23006; outline:none" disabled>
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
                                    <a class="btn btn-warning" href="Controlador?menu=Aprobacion&accion=Editar&idOrden=${ord.getIdOrdenTrabajo()}">Aprobar</a>
                                    <a class="btn btn-danger" style="margin-left: 10px" href="Controlador?menu=Aprobacion&accion=Delete&idOrden=${ord.getIdOrdenTrabajo()}">Eliminar</a>
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
