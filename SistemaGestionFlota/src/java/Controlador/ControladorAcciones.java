/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.Utilitarios;
import Modelo.FlotaVehicular;
import Modelo.FlotaVehicularDAO;
import Modelo.PersonalPolicialDAO;
import Modelo.Usuario;
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
                    if (resultado == 1){
                        us.setMensajeSalida("Vehículo a asignar supera el máximo de encargados");
                    }
                    if (resultado == 2){
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
                int kilometraje =  Integer.parseInt(request.getParameter("txtKilometro"));
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
                int kilometrajeAct =  Integer.parseInt(request.getParameter("txtKilometro"));
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
}
