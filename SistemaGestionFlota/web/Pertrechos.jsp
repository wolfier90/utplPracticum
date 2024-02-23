<%-- 
    Document   : Pertrechos
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
        <title>PERTRECHO</title>
    </head>
    <body>
        <h1>Registrar Pertrecho</h1>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=GestionPertrecho" method="POST">
                        <div class="form-group">  
                            <label>*Tipo de Arma</label>
                            <input type="text" value="${pertrechoEditar.getTipoArma()}" name="txtTipoArma" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>*Nombre</label>
                            <input type="text" value="${pertrechoEditar.getNombre()}" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>*Descripción</label>
                            <input type="text" value="${pertrechoEditar.getDescripcion()}" name="txtDescripcion" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>*Código</label>
                            <input type="text" value="${pertrechoEditar.getCodigo()}" name="txtCodigo" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>*Cantidad</label>
                            <input type="text" value="${pertrechoEditar.getCantidad()}" name="txtCantidad" class="form-control">
                        </div>
                        <br></br>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        <div class="form-group">
                            <input type="text" value="${respuesta.getMensajeSalida()}" name="txtMensaje" class="form-control" style="color: #F23006" disabled>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-10">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>TIPO ARMA</th>
                            <th>NOMBRE</th>
                            <th>DESCRIPCIÓN</th>
                            <th>CÓDIGO</th>
                            <th>CANTIDAD</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pe" items="${pertrecho}">
                            <tr>
                                <td>${pe.getTipoArma()}</td>
                                <td>${pe.getNombre()}</td>
                                <td>${pe.getDescripcion()}</td>
                                <td>${pe.getCodigo()}</td>
                                <td>${pe.getCantidad()}</td>
                                <td class="d-flex">
                                    <a class="btn btn-warning" href="Controlador?menu=GestionPertrecho&accion=Editar&id=${pe.getIdPertrecho()}">Editar</a>
                                    <a class="btn btn-danger" style="margin-left: 10px" href="Controlador?menu=GestionPertrecho&accion=Delete&id=${pe.getIdPertrecho()}">Eliminar</a>
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
