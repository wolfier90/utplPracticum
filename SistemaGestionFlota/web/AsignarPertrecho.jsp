<%-- 
    Document   : AsignarPertrechos
    Created on : 24-dic-2023, 16:32:18
    Author     : USUARIO
--%>

<%@page import="Modelo.Pertrecho"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include.jsp" %>
<%@page import="java.util.List"%>
<%@page import="Modelo.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>ASIGNAR PERTRECHOS</title>
    </head>
    <body>
        <h1>Asignar Pertrechos</h1>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=AsignarPertrecho" method="POST">
                        <div class="form-group form-group-lg">  
                            <label for="lg" for="cboPersonal">*Personal Policial</label>
                            <div class="col-sm-4">
                                <select id="cboPersonal" name="cboPersonal" style="width:150px">
                                    <% List<Usuario> listaPersonal = (List<Usuario>)request.getAttribute("comboPersonal");
                                    if(listaPersonal!=null)
                                    for(Usuario usuario:listaPersonal){%>
                                    <option value="<%=usuario.getIdPersonal()%>"><%=usuario.getNombres()%> <%=usuario.getApellidos()%> - <%=usuario.getIdentificacion()%></option>
                                    <%} %>
                                </select>
                            </div>
                        </div>
                        <div class="form-group form-group-lg">  
                            <label for="lg" for="cboPertrecho">*Pertrecho</label>
                            <div class="col-sm-4">
                                <select id="cboPertrecho" name="cboPertrecho" style="width:150px">
                                    <% List<Pertrecho> listaPertrechos = (List<Pertrecho>)request.getAttribute("comboPertrechos");
                                    if(listaPertrechos!=null)
                                    for(Pertrecho pertrecho:listaPertrechos){%>
                                        <option value="<%=pertrecho.getCodigo()%>"><%=pertrecho.getNombre()%></option>
                                    <%} %>
                                </select>
                            </div>
                        </div>
                        <br></br>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
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
                            <th>PERSONAL POLICIAL</th>
                            <th>NOMBRES</th>
                            <th>RANGO</th>
                            <th>TIPO ARMA</th>
                            <th>DESCRIPCION</th>
                            <th>FECHA REGISTRO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pe" items="${pertrecho}">
                            <tr>
                                <td>${pe.getNombres()}</td>
                                <td>${pe.getApellidos()}</td>
                                <td>${pe.getIdentificacion()}</td>
                                <td>${pe.getUser()}</td>
                                <td>${pe.getNombreRol()}</td>
                                <td>${pe.getNombreRol()}</td>
                                <td class="d-flex">
                                    <a class="btn btn-danger" style="margin-left: 10px" href="Controlador?menu=Usuarios&accion=Delete&id=${pe.getId()}">Eliminar</a>
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
