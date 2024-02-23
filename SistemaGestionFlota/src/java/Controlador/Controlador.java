/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.PersonalPolicialDAO;
import Modelo.Usuario;
import Controlador.ControladorAcciones;
import Config.Utilitarios;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USUARIO
 */
public class Controlador extends HttpServlet {

    Usuario us = new Usuario();
    PersonalPolicialDAO personalDao = new PersonalPolicialDAO();
    ControladorAcciones controladorAcciones = new ControladorAcciones();
    boolean editar = false;
    int ide;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        HttpSession sesion = request.getSession();
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("PrincipalEncargado")) {
            request.getRequestDispatcher("PrincipalEncargadoPolicial.jsp").forward(request, response);
        }
        if (menu.equals("PrincipalGerencia")) {
            request.getRequestDispatcher("PrincipalGerencia.jsp").forward(request, response);
        }
        if (menu.equals("PrincipalEncargadoPertrecho")) {
            request.getRequestDispatcher("PrincipalEncargadoPertrecho.jsp").forward(request, response);
        }
        if (menu.equals("Usuarios")) {
            //Procesa las acciones CRUD del menu Usuarios
            controladorAcciones.procesaAccionUsuarios(request, response, accion);
        }
        if (menu.equals("Personal")) {
            //Procesa las acciones CRUD del menu Personal
            controladorAcciones.procesaAccionPersonal(request, response, accion);
        }
        if (menu.equals("Vehiculos")) {
            //Procesa las acciones CRUD del menu Vehiculo
            controladorAcciones.procesaAccionVehiculo(request, response, accion);
        }
        if (menu.equals("Ordenes")) {
            controladorAcciones.procesaAccionOrdenes(request, response, accion);
            request.getRequestDispatcher("Ordenes.jsp").forward(request, response);
        }
        if (menu.equals("Aprobacion")) {
            controladorAcciones.procesaAccionAprobacion(request, response, accion);
            request.getRequestDispatcher("AprobacionSolicitud.jsp").forward(request, response);
        }
        if (menu.equals("Finalizar")) {
            controladorAcciones.procesaAccionFinalizar(request, response, accion);
            request.getRequestDispatcher("FinalizarMantenimientos.jsp").forward(request, response);
        }
        if (menu.equals("reporteReclamo")) {
            controladorAcciones.procesaAccionRptReclamo(request, response, accion);
            request.getRequestDispatcher("ReportesSugerencias.jsp").forward(request, response);
        }
        if (menu.equals("Reclamo")) {
            controladorAcciones.procesaAccionReclamo(request, response, accion);
            request.getRequestDispatcher("Reclamos.jsp").forward(request, response);
        }
        if (menu.equals("GestionPertrecho")) {
            controladorAcciones.procesaAccionPertrecho(request, response, accion);
            request.getRequestDispatcher("Pertrechos.jsp").forward(request, response);
        }
        if (menu.equals("AsignarPertrecho")) {
            //controladorAcciones.procesaAccionReclamo(request, response, accion);
            request.getRequestDispatcher("AsignarPertrecho.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
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

}
