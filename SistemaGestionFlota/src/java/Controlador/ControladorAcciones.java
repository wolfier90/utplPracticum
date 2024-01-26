/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.Utilitarios;
import Modelo.FlotaVehicular;
import Modelo.FlotaVehicularDAO;
import Modelo.Mantenimiento;
import Modelo.MantenimientoDAO;
import Modelo.Ordenes;
import Modelo.OrdenesDAO;
import Modelo.PersonalPolicialDAO;
import Modelo.Reclamo;
import Modelo.ReclamoDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.objects.NativeString.trim;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ControladorAcciones", urlPatterns = {"/ControladorAcciones"})
public class ControladorAcciones extends HttpServlet {

    Usuario us = new Usuario();
    FlotaVehicular fv = new FlotaVehicular();
    PersonalPolicialDAO personalDao = new PersonalPolicialDAO();
    int ide;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorAcciones</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorAcciones at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void procesaAccionUsuarios(HttpServletRequest request, HttpServletResponse response, String accion)
            throws ServletException, IOException {
        List lista = new ArrayList();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        int resultado;
        switch (accion) {
            case "Listar":
                lista = usuarioDao.listar();
                request.setAttribute("usuario", lista);
                break;
            default:
                throw new AssertionError();
        }
        request.getRequestDispatcher("Usuario.jsp").forward(request, response);
    }
    
    public void procesaAccionPersonal(HttpServletRequest request, HttpServletResponse response, String accion)
            throws ServletException, IOException {
        List lista = new ArrayList();
        int resultado;
        switch (accion) {
            case "Listar":
                lista = personalDao.listar();
                request.setAttribute("personal", lista);
                break;
            case "Agregar":
                Utilitarios util = new Utilitarios();
                String nombre = request.getParameter("txtNombre");
                String apellido = request.getParameter("txtApellido");
                String identificacion = request.getParameter("txtIdent");
                String fechaNac = request.getParameter("txtFechanac");
                String correo = request.getParameter("txtCorreo");
                String cargo = request.getParameter("cboCargo");
                String ciudadNac = request.getParameter("txtCiudadnac");
                String tipoSangre = request.getParameter("cboSangre");
                String celular = request.getParameter("txtCelular");
                String rango = request.getParameter("cboRango");
                int id_vehiculo = fv.getIdVehiculo();
                //if (util.validadorDeCedula(identificacion)) {
                try {
                    java.util.Date date = util.convertStringToDate(fechaNac);
                    java.sql.Date sql_date = util.convertSqlDate(date);
                    us.setNombres(nombre);
                    us.setApellidos(apellido);
                    us.setIdentificacion(identificacion);
                    us.setFechaNacimiento(sql_date);
                    us.setCorreo(correo);
                    us.setCargo(cargo);
                    us.setCiudadNacimiento(ciudadNac);
                    us.setTipoSangre(tipoSangre);
                    us.setCelular(celular);
                    us.setRango(rango);
                    us.setIdVehiculo(id_vehiculo);
                    us.setMensajeSalida("");
                    resultado = personalDao.agregar(us);
                    if (resultado == 1) {
                        us.setMensajeSalida("Vehículo a asignar supera el máximo de encargados");
                    }
                    if (resultado == 2) {
                        us.setMensajeSalida("La identificación ingresada ya existe");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("respuesta", us);
                request.getRequestDispatcher("Controlador?menu=Personal&accion=Listar").forward(request, response);
                break;
            //}
            case "Editar":
                ide = Integer.parseInt(request.getParameter("id"));
                Usuario u = personalDao.listarId(ide);
                request.setAttribute("empleado", u);
                request.getRequestDispatcher("Controlador?menu=Personal&accion=Listar").forward(request, response);
                break;
            case "Actualizar":
                Utilitarios utilAct = new Utilitarios();
                String nombreAct = request.getParameter("txtNombre");
                String apellidoAct = request.getParameter("txtApellido");
                String identificacionAct = request.getParameter("txtIdent");
                String fechaNacAct = request.getParameter("txtFechanac");
                String correoAct = request.getParameter("txtCorreo");
                String cargoAct = request.getParameter("cboCargo");
                String ciudadNacAct = request.getParameter("txtCiudadnac");
                String tipoSangreAct = request.getParameter("cboSangre");
                String celularAct = request.getParameter("txtCelular");
                String rangoAct = request.getParameter("cboRango");
                String placaAct = request.getParameter("codigovehiculo");
                //if (util.validadorDeCedula(identificacion)) {
                try {
                    java.util.Date date = utilAct.convertStringToDate(fechaNacAct);
                    java.sql.Date sql_date = utilAct.convertSqlDate(date);
                    us.setNombres(nombreAct);
                    us.setApellidos(apellidoAct);
                    us.setIdentificacion(identificacionAct);
                    us.setFechaNacimiento(sql_date);
                    us.setCorreo(correoAct);
                    us.setCargo(cargoAct);
                    us.setCiudadNacimiento(ciudadNacAct);
                    us.setTipoSangre(tipoSangreAct);
                    us.setCelular(celularAct);
                    us.setRango(rangoAct);
                    us.setId(ide);
                    us.setPlaca(placaAct);
                    personalDao.actualizar(us);
                } catch (ParseException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher("Controlador?menu=Personal&accion=Listar").forward(request, response);
                break;
            case "Delete":
                ide = Integer.parseInt(request.getParameter("id"));
                personalDao.delete(ide);
                request.getRequestDispatcher("Controlador?menu=Personal&accion=Listar").forward(request, response);
                break;
            case "BuscaVehiculo":
                FlotaVehicularDAO flotaDAO = new FlotaVehicularDAO();
                String placa = request.getParameter("codigovehiculo");
                fv.setPlaca(placa);
                fv = flotaDAO.buscar(placa);
                request.setAttribute("flotaVehicular", fv);
                request.getRequestDispatcher("Controlador?menu=Personal&accion=Listar").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
        request.getRequestDispatcher("PersonalPolicial.jsp").forward(request, response);
    }

    public void procesaAccionVehiculo(HttpServletRequest request, HttpServletResponse response, String accion)
            throws ServletException, IOException {
        FlotaVehicularDAO flotaDAO = new FlotaVehicularDAO();
        switch (accion) {
            case "Listar":
                List lista = flotaDAO.listar();
                request.setAttribute("flotaVehicular", lista);
                break;
            case "Agregar":
                Utilitarios util = new Utilitarios();
                String marca = request.getParameter("txtMarca");
                String modelo = request.getParameter("txtModelo");
                String placa = request.getParameter("txtPlaca");
                String chasis = request.getParameter("txtChasis");
                String color = request.getParameter("txtColor");
                String tipoVehiculo = request.getParameter("cboTipoVehiculo");
                int kilometraje = Integer.parseInt(request.getParameter("txtKilometro"));
                String fechaUltMant = request.getParameter("txtUltMant");
                //if (util.validadorDeCedula(identificacion)) {
                try {
                    java.util.Date date = util.convertStringToDate(fechaUltMant);
                    java.sql.Date sql_date = util.convertSqlDate(date);
                    fv.setMarca(marca);
                    fv.setModelo(modelo);
                    fv.setPlaca(placa);
                    fv.setChasis(chasis);
                    fv.setColor(color);
                    fv.setTipo(tipoVehiculo);
                    fv.setKilometraje(kilometraje);
                    fv.setFechaUltimoMant(sql_date);
                    flotaDAO.agregar(fv);
                } catch (ParseException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher("Controlador?menu=Vehiculos&accion=Listar").forward(request, response);
                break;
            //}
            case "Editar":
                ide = Integer.parseInt(request.getParameter("id"));
                FlotaVehicular u = flotaDAO.listarId(ide);
                request.setAttribute("vehiculo", u);
                request.getRequestDispatcher("Controlador?menu=Vehiculos&accion=Listar").forward(request, response);
                break;
            case "Actualizar":
                Utilitarios utilAct = new Utilitarios();
                String marcaAct = request.getParameter("txtMarca");
                String modeloAct = request.getParameter("txtModelo");
                String placaAct = request.getParameter("txtPlaca");
                String chasisAct = request.getParameter("txtChasis");
                String colorAct = request.getParameter("txtColor");
                String tipoVehiculoAct = request.getParameter("cboTipoVehiculo");
                int kilometrajeAct = Integer.parseInt(request.getParameter("txtKilometro"));
                String fechaUltMantAct = request.getParameter("txtUltMant");
                try {
                    java.util.Date date = utilAct.convertStringToDate(fechaUltMantAct);
                    java.sql.Date sql_date = utilAct.convertSqlDate(date);
                    fv.setMarca(marcaAct);
                    fv.setModelo(modeloAct);
                    fv.setPlaca(placaAct);
                    fv.setChasis(chasisAct);
                    fv.setColor(colorAct);
                    fv.setTipo(tipoVehiculoAct);
                    fv.setKilometraje(kilometrajeAct);
                    fv.setFechaUltimoMant(sql_date);
                    fv.setIdVehiculo(ide);
                    flotaDAO.actualizar(fv);
                } catch (ParseException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher("Controlador?menu=Vehiculos&accion=Listar").forward(request, response);
                break;
            case "Delete":
                ide = Integer.parseInt(request.getParameter("id"));
                flotaDAO.delete(ide);
                request.getRequestDispatcher("Controlador?menu=Vehiculos&accion=Listar").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
        request.getRequestDispatcher("RegistrarVehiculo.jsp").forward(request, response);
    }

    public void procesaAccionOrdenes(HttpServletRequest request, HttpServletResponse response, String accion)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(false);
        HttpSession sesionOrden = request.getSession();
        FlotaVehicularDAO flotaDAO = new FlotaVehicularDAO();
        OrdenesDAO ordenesDAO = new OrdenesDAO();
        String StringIdPersonal = (String) sesion.getAttribute("idPersonalPolicial");
        int idPersonalPolicial = Integer.parseInt(StringIdPersonal);
        List lista = new ArrayList();
        int resultado;
        switch (accion) {
            case "Listar":
                lista = ordenesDAO.listar(idPersonalPolicial);
                request.setAttribute("Ordenes", lista);
                Usuario u = flotaDAO.buscaVehiculoPersona(idPersonalPolicial);
                request.setAttribute("MuestraVehiculo", u);
                break;
            case "MuestraVehiculo":
                break;
            case "Editar":
                ide = Integer.parseInt(request.getParameter("idOrden"));
                sesionOrden.setAttribute("idOrdenTrabajo", ide + "");
                Ordenes ord = ordenesDAO.listarId(idPersonalPolicial, ide);
                request.setAttribute("editaOrden", ord);
                request.getRequestDispatcher("Controlador?menu=Ordenes&accion=Listar").forward(request, response);
                break;
            case "RegistrarOrden":
                Ordenes ordenes = new Ordenes();
                Utilitarios util = new Utilitarios();
                String fechaMant = request.getParameter("txtFechaMant");
                int kilometraje = Integer.parseInt(request.getParameter("txtKilometraje"));
                String observaciones = request.getParameter("txtObservaciones");
                //if (util.validadorDeCedula(identificacion)) {
                try {
                    java.util.Date date = util.convertStringToDate(fechaMant);
                    java.sql.Date sql_date = util.convertSqlDate(date);
                    ordenes.setEstado("I");
                    ordenes.setIdPersonalPolicial(idPersonalPolicial);
                    ordenes.setFechaInicio(sql_date);
                    ordenes.setKilometrajeActual(kilometraje);
                    ordenes.setObservaciones(observaciones);
                    resultado = ordenesDAO.agregar(ordenes);
                    if (resultado == 1) {
                        ordenes.setMensajeSalida("Ya existe una orden ingresada en proceso");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("AgregaOrden", ordenes);
                request.getRequestDispatcher("Controlador?menu=Ordenes&accion=Listar").forward(request, response);
                break;
            case "Delete":
                ide = Integer.parseInt(request.getParameter("idOrden"));
                ordenesDAO.delete(ide);
                request.getRequestDispatcher("Controlador?menu=Ordenes&accion=Listar").forward(request, response);
                break;
            case "Actualizar":
                String StringIdOrden = (String) sesionOrden.getAttribute("idOrdenTrabajo");
                int idOrdenTrabajo = Integer.parseInt(StringIdOrden);
                Ordenes ordAct = new Ordenes();
                Utilitarios utilAct = new Utilitarios();
                String fechaMantAct = request.getParameter("txtFechaMant");
                int kilometrajeAct = Integer.parseInt(request.getParameter("txtKilometraje"));
                String observacionesAct = request.getParameter("txtObservaciones");
                try {
                    java.util.Date date = utilAct.convertStringToDate(fechaMantAct);
                    java.sql.Date sql_date = utilAct.convertSqlDate(date);
                    ordAct.setIdOrdenTrabajo(idOrdenTrabajo);
                    ordAct.setFechaInicio(sql_date);
                    ordAct.setKilometrajeActual(kilometrajeAct);
                    ordAct.setObservaciones(observacionesAct);
                    ordenesDAO.actualizar(ordAct);
                } catch (ParseException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.getRequestDispatcher("Controlador?menu=Ordenes&accion=Listar").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
        request.getRequestDispatcher("Ordenes.jsp").forward(request, response);
    }

    public void procesaAccionAprobacion(HttpServletRequest request, HttpServletResponse response, String accion)
            throws ServletException, IOException {
        MantenimientoDAO mantDAO = new MantenimientoDAO();
        Mantenimiento mnt = new Mantenimiento();
        HttpSession sesionOrden = request.getSession();
        List lista = new ArrayList();
        HttpSession sesion = request.getSession(false);
        String StringIdAprobador = (String) sesion.getAttribute("idPersonalPolicial");
        int idAprobador = Integer.parseInt(StringIdAprobador);

        int resultado;
        switch (accion) {
            case "Listar":
                lista = mantDAO.listar();
                request.setAttribute("Ordenes", lista);
                break;
            case "Editar":
                ide = Integer.parseInt(request.getParameter("idOrden"));
                sesionOrden.setAttribute("idOrdenTrabajo", ide + "");
                mnt = mantDAO.listarId(0, ide);
                request.setAttribute("editaOrden", mnt);
                request.getRequestDispatcher("Controlador?menu=Aprobacion&accion=Listar").forward(request, response);
                break;
            case "RegistrarAprobacion":
                Utilitarios util = new Utilitarios();
                Mantenimiento salidaAprobacion = new Mantenimiento();
                String chkMnt1 = request.getParameter("mntA");
                String chkMnt2 = request.getParameter("mntB");
                String chkMnt3 = request.getParameter("mntC");

                String StringOrden = (String) sesion.getAttribute("idOrdenTrabajo");
                int ordenPendiente = Integer.parseInt(StringOrden);

                if (chkMnt1 == null) {
                    chkMnt1 = "";
                }
                if (chkMnt2 == null) {
                    chkMnt2 = "";
                }
                if (chkMnt3 == null) {
                    chkMnt3 = "";
                }

                if (trim(chkMnt1).equals("1") && trim(chkMnt2).equals("2")) {
                    mnt.setMensajeSalida("No puede escoger el mantenimiento 1 y 2 a la vez");
                } else {
                    int idOrdenTrabajo = ordenPendiente;
                    String fechaIngreso = request.getParameter("txtFechaIngreso");
                    int kilometrajeIngreso = Integer.parseInt(request.getParameter("txtKilometrajeIngreso"));
                    try {
                        java.util.Date date = util.convertStringToDate(fechaIngreso);
                        java.sql.Date sql_date = util.convertSqlDate(date);
                        mnt.setIdOrdenTrabajo(idOrdenTrabajo);
                        mnt.setKilometrajeIngreso(kilometrajeIngreso);
                        mnt.setFechaIngreso(sql_date);
                        mnt.setMantenimiento1(chkMnt1);
                        mnt.setMantenimiento2(chkMnt2);
                        mnt.setMantenimiento3(chkMnt3);
                        salidaAprobacion = mantDAO.agregar(mnt, idAprobador);
                        if (salidaAprobacion.getCodigoError() == 1) {
                            mnt.setMensajeSalida("Ha ocurrido un error en la base del sistema");
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                request.setAttribute("ApruebaOrden", mnt);
                request.setAttribute("ValorTotal", salidaAprobacion);
                request.getRequestDispatcher("Controlador?menu=Aprobacion&accion=Listar").forward(request, response);
                break;
            case "Rechazar":
                OrdenesDAO ordenesDAO = new OrdenesDAO();
                ide = Integer.parseInt(request.getParameter("idOrden"));
                ordenesDAO.delete(ide);
                request.getRequestDispatcher("Controlador?menu=Aprobacion&accion=Listar").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
        request.getRequestDispatcher("AprobacionSolicitud.jsp").forward(request, response);
    }

    public void procesaAccionFinalizar(HttpServletRequest request, HttpServletResponse response, String accion)
            throws ServletException, IOException {
        MantenimientoDAO mantDAO = new MantenimientoDAO();
        OrdenesDAO ordenesDAO = new OrdenesDAO();
        List lista = new ArrayList();
        if (accion == null) {
            request.getRequestDispatcher("Controlador?menu=Finalizar&accion=Listar").forward(request, response);
        } else {
            switch (accion) {
                case "Listar":
                    lista = mantDAO.listarAprobadas();
                    request.setAttribute("Ordenes", lista);
                    break;
                case "Finalizar":
                    ide = Integer.parseInt(request.getParameter("idOrden"));
                    ordenesDAO.finalizar(ide);
                    request.getRequestDispatcher("Controlador?menu=Finalizar&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        request.getRequestDispatcher("FinalizarMantenimientos.jsp").forward(request, response);
    }

    public void procesaAccionReclamo(HttpServletRequest request, HttpServletResponse response, String accion)
            throws ServletException, IOException {
        ReclamoDAO reclamoDAO = new ReclamoDAO();
        List lista = new ArrayList();
        switch (accion) {
            case "Salir":
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "Reclamo":
                ReclamoDAO reclamoRlDAO = new ReclamoDAO();
                Reclamo reclamos = new Reclamo();
                reclamos.setMensajeSalida("");
                List<Reclamo> listaCircuitos = reclamoRlDAO.obtenerCircuitos();
                List<Reclamo> listaSubcircuitos = reclamoRlDAO.obtenerSubcircuitos();
                request.setAttribute("circuitos", listaCircuitos);
                request.setAttribute("subcircuitos", listaSubcircuitos);
                request.setAttribute("Reclamo", reclamos);
                request.getRequestDispatcher("Reclamos.jsp").forward(request, response);
                request.getRequestDispatcher("Reclamos.jsp").forward(request, response);
                break;
            case "Registrar":
                Reclamo reclamo = new Reclamo();
                int circuito = Integer.parseInt(request.getParameter("cboCircuito"));
                int subCircuito = Integer.parseInt(request.getParameter("cboSubcircuito"));
                String tipo = request.getParameter("cboTipo");
                String detalle = request.getParameter("txtDetalle");
                String contacto = request.getParameter("txtContacto");
                String Apellidos = request.getParameter("txtApellidos");
                String Nombres = request.getParameter("txtNombres");
                reclamo.setIdCircuito(circuito);
                reclamo.setIdSubcircuito(subCircuito);
                reclamo.setTipoReclamo(tipo);
                reclamo.setDetalle(detalle);
                reclamo.setContacto(contacto);
                reclamo.setApellidos(Apellidos);
                reclamo.setNombres(Nombres);
                reclamoDAO.agregar(reclamo);
                reclamo.setMensajeSalida("Registro exitoso");
                request.setAttribute("Reclamo", reclamo);
                request.getRequestDispatcher("Controlador?menu=Reclamo&accion=Reclamo").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
        request.getRequestDispatcher("Reclamos.jsp").forward(request, response);
    }

    public void procesaAccionRptReclamo(HttpServletRequest request, HttpServletResponse response, String accion)
            throws ServletException, IOException {
        ReclamoDAO reclamoDAO = new ReclamoDAO();
        List lista = new ArrayList();
        if (accion == null) {
            request.getRequestDispatcher("Controlador?menu=reporteReclamo&accion=buscarReclamos").forward(request, response);
        } else {
            switch (accion) {
                case "buscarReclamos":
                    Utilitarios util = new Utilitarios();
                    String fechaInicio = request.getParameter("txtFechaInicio");
                    String fechaFin = request.getParameter("txtFechaFin");
                    if (fechaInicio == null) {
                        request.setAttribute("listaReclamos", lista);
                    } else {
                        try {
                            java.util.Date dateIni = util.convertStringToDate(fechaInicio);
                            java.sql.Date sql_date_inicio = util.convertSqlDate(dateIni);
                            java.util.Date dateFin = util.convertStringToDate(fechaFin);
                            java.sql.Date sql_date_fin = util.convertSqlDate(dateFin);

                            lista = reclamoDAO.listarReclamos(sql_date_inicio, sql_date_fin);
                            request.setAttribute("listaReclamos", lista);
                        } catch (ParseException ex) {
                            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                default:
                    request.setAttribute("listaReclamos", lista);
                    throw new AssertionError();
            }
        }
        request.getRequestDispatcher("ReportesSugerencias.jsp").forward(request, response);
    }

}
