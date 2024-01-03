<%-- 
    Document   : RegistrarVehiculo
    Created on : 24-dic-2023, 16:33:35
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>VEHICULOS</title>
    </head>
    <body>
        <h1>Registrar Vehículo</h1>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Personal" method="POST">
                        <div class="form-group">  
                            <label>Marca</label>
                            <input type="text" name="txtMarca" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>Modelo</label>
                            <input type="text" name="txtModelo" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>Placa</label>
                            <input type="text" name="txtPlaca" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>Chasis</label>
                            <input type="text" name="txtChasis" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>Color</label>
                            <input type="text" name="txtCorreo" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>Tipo</label>
                            <div class="col-sm-4">
                                <select id="cboTipoVehiculo" name="cboTipoVehiculo" style="width:100px">
                                    <option value="1">AUTO</option>
                                    <option value="2">MOTO</option>
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
                            <th>PLACA</th>
                            <th>CHASIS</th>
                            <th>COLOR</th>
                            <th>MARCA</th>
                            <th>MODELO</th>
                            <th>TIPO</th>
                            <th>KILOMETRAJE</th>
                            <th>ULTIMO MANTENIMIENTO</th>
                            <th>ACCIONES</th>
                        </tr>>
                    </thead>
                    <tbody>
                        <c:forEach var="fv" items="${flotaVehicular}">
                            <tr>
                            <td>${fv.getPlaca()}</td>
                            <td>${fv.getChasis()}</td>
                            <td>${fv.getColor()}</td>
                            <td>${fv.getMarca()}</td>
                            <td>${fv.getModelo()}</td>
                            <td>${fv.getTipo()}</td>
                            <td>${fv.getKilometraje()}</td>
                            <td>${fv.getFechaUltimoMant()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Vehiculos&accion=Editar&id=${fv.getIdVehiculo()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Vehiculos&accion=Delete&id=${fv.getIdVehiculo()}">Eliminar</a>
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
