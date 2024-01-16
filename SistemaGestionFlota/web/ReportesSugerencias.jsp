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
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>REPORTE DE RECLAMOS Y SUGERENCIAS RECIBIDAS</title>
        <!-- links para exportar a excel -->
        <script src="https://unpkg.com/xlsx@0.16.9/dist/xlsx.full.min.js"></script>
        <script src="https://unpkg.com/file-saverjs@latest/FileSaver.min.js"></script>
        <script src="https://unpkg.com/tableexport@latest/dist/js/tableexport.min.js"></script>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    </head>
    <body>
        <h1>Reporte de Sugerencias</h1>
        <form action="Controlador?menu=reporteReclamo" method="POST">
            <div class="col-sm-10">
                <div class="form-group">  
                    <label>*Fecha Inicio</label>
                    <input type="date" name="txtFechaInicio" class="form-control" style="width:150px">
                </div> 
                <div class="form-group">  
                    <label>*Fecha Fin</label>
                    <input type="date" name="txtFechaFin" class="form-control" style="width:150px">
                </div><br>
                <button type="submit" name="accion" value="buscarReclamos" class="btn btn-info">Buscar</button>
                <button id="btnExportar" class="btn btn-success">
                    <i class="fas fa-file-excel"></i> Exportar datos a Excel
                </button>
                <table id="tabla" class="table table-border table-hover">
                    <thead>
                        <tr>
                            <th>FECHA INICIO</th>
                            <th>FECHA FIN</th>
                            <th>CANTIDAD</th>
                            <th>TIPO</th>
                            <th>CIRCUITO</th>
                            <th>SUBCIRCUITO</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="reclamo" items="${listaReclamos}">
                            <tr>
                                <td>${reclamo.getFechaInicio()}</td>
                                <td>${reclamo.getFechaFin()}</td>
                                <td>${reclamo.getCantidad()}</td>
                                <td>${reclamo.getTipoReclamo()}</td>
                                <td>${reclamo.getNombreCircuito()}</td>
                                <td>${reclamo.getNombreSubcircuito()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </form>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
            crossorigin="anonymous"
        ></script>
        <script>
            const $btnExportar = document.querySelector("#btnExportar"),
                    $tabla = document.querySelector("#tabla");

            $btnExportar.addEventListener("click", function () {
                let tableExport = new TableExport($tabla, {
                    exportButtons: false, // No queremos botones
                    filename: "Reporte de prueba", //Nombre del archivo de Excel
                    sheetname: "Reporte de prueba", //Título de la hoja
                });
                let datos = tableExport.getExportData();
                let preferenciasDocumento = datos.tabla.xlsx;
                tableExport.export2file(preferenciasDocumento.data, preferenciasDocumento.mimeType, preferenciasDocumento.filename, preferenciasDocumento.fileExtension, preferenciasDocumento.merges, preferenciasDocumento.RTL, preferenciasDocumento.sheetname);
            });
        </script>
    </body>
</html>
