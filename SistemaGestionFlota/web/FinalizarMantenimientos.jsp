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
        <title>MANTENIMIENTOS REALIZADOS</title>
        <!-- links para exportar a excel -->
        <script src="https://unpkg.com/xlsx@0.16.9/dist/xlsx.full.min.js"></script>
        <script src="https://unpkg.com/file-saverjs@latest/FileSaver.min.js"></script>
        <script src="https://unpkg.com/tableexport@latest/dist/js/tableexport.min.js"></script>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    </head>
    <body>
        <h1>Finalizar Ordenes Realizadas</h1>
        <form action="Controlador?menu=Finalizar" method="POST">
            <div class="col-sm-10">
                <button id="btnExportar" class="btn btn-success">
                    <i class="fas fa-file-excel"></i> Exportar datos a Excel
                </button>
                <table id="tabla" class="table table-border table-hover">
                    <thead>
                        <tr>
                            <th>NO. ORDEN</th>
                            <th>ESTADO</th>
                            <th>VEHICULO</th>
                            <th>ENCARGADO</th>
                            <th>FECHA MANTENIMIENTO</th>
                            <th>TIPO MANTENIMIENTO</th>
                            <th>VALOR TOTAL</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ord" items="${Ordenes}">
                            <tr>
                                <td>${ord.getIdOrdenTrabajo()}</td>
                                <td>${ord.getEstado()}</td>
                                <td>${ord.getPlaca()}</td>
                                <td>${ord.getIdentificacionEncargado()}</td>
                                <td>${ord.getFechaInicio()}</td>
                                <td>${ord.getTipoMantenimiento()}</td>
                                <td>${ord.getValorTotal()}</td>
                                <td class="d-flex">
                                    <a class="btn btn-danger" style="margin-left: 10px" href="Controlador?menu=Finalizar&accion=Finalizar&idOrden=${ord.getIdOrdenTrabajo()}">Finalizar</a>
                                </td>
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
