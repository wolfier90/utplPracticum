<%-- 
    Document   : Ordenes
    Created on : 24-dic-2023, 16:32:18
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include.jsp" %>
<%@page import="java.util.List"%>
<%@page import="Modelo.Reclamo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>RECLAMOS O SUGERENCIAS</title>
    </head>
    <body>
        <h1>Registro de Sugerencias</h1>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Reclamo" method="POST">
                        <div class="form-group form-group-lg">  
                            <label for="lg" for="cboCircuito">*Circuito</label>
                            <div class="col-sm-4">
                                <select id="cboCircuito" name="cboCircuito" style="width:150px">
                                    <% List<Reclamo> listaCircuito = (List<Reclamo>)request.getAttribute("circuitos");
                                    if(listaCircuito!=null)
                                    for(Reclamo reclamo:listaCircuito){%>
                                    <option value="<%=reclamo.getIdCircuito()%>"><%=reclamo.getNombreCircuito()%></option>
                                    <%} %>
                                </select>
                            </div>
                            <!-- <input type="text" name="txtCircuito" class="form-control"> -->
                        </div>
                        <div class="form-group form-group-lg">  
                            <label for="lg" for="cboSubcircuito">*Subcircuito</label>
                            <div class="col-sm-4">
                                <select id="cboSubcircuito" name="cboSubcircuito" style="width:150px">
                                    <% List<Reclamo> listaSubcircuito = (List<Reclamo>)request.getAttribute("subcircuitos");
                                    if(listaSubcircuito!=null)
                                    for(Reclamo reclamo:listaSubcircuito){%>
                                    <option value="<%=reclamo.getIdSubcircuito()%>"><%=reclamo.getNombreSubcircuito()%></option>
                                    <%} %>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">  
                            <label>*Tipo</label>
                            <!--<input type="text" value="${empleado.getCargo()}" name="txtCargo" class="form-control">-->
                            <div class="col-sm-4">
                                <select id="cboTipo" name="cboTipo" style="width:150px">
                                    <option value="RECLAMO">RECLAMO</option>
                                    <option value="SUGERENCIA">SUGERENCIA</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">  
                            <label>*Detalle</label>
                            <input type="text" name="txtDetalle" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>*Contacto</label>
                            <input type="text" name="txtContacto" class="form-control">
                        </div>
                        <div class="form-group">  
                            <label>*Apellidos</label>
                            <input type="text" name="txtApellidos" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>*Nombres</label>
                            <input type="text" name="txtNombres" class="form-control">
                        </div>
                        <br></br>
                        <button type="submit" name="accion" value="Registrar" class="btn btn-info">Registrar</button>
                        <button type="submit" name="accion" value="Salir" class="btn btn-info">Cancelar</button>
                        <div class="form-group">
                            <input type="text" value="${Reclamo.getMensajeSalida()}" name="txtMensaje1" class="form-control" style="color: #209C04; outline:none" disabled>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
