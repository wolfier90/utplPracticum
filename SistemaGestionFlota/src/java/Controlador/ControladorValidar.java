/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Reclamo;
import Modelo.ReclamoDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USUARIO
 */
public class ControladorValidar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    UsuarioDAO userDao = new UsuarioDAO();
    Usuario us = new Usuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Validar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Validar at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        HttpSession sesion = request.getSession();
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Ingresar")) {
            String user = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            us = userDao.validar(user, pass);
            String idPersonal = us.getId() + "";
            sesion.setAttribute("idPersonalPolicial", idPersonal);
            if (us.getUser() != null) {
                request.setAttribute("usuario", us);
                if (us.getCodigoRol().equals("001")) { //001 es el rol "Tecnico1" para el personal de logistica
                    request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                } else if (us.getCodigoRol().equals("003")) { //003 es el rol "Encargado" para el encargado de flota
                    request.getRequestDispatcher("Controlador?menu=PrincipalEncargado").forward(request, response);
                }else if (us.getCodigoRol().equals("002")) { //003 es el rol "Encargado" para el encargado de flota
                    request.getRequestDispatcher("Controlador?menu=PrincipalGerencia").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else if (accion.equalsIgnoreCase("Reclamo")) {
            ReclamoDAO reclamoDAO = new ReclamoDAO();
            Reclamo reclamo = new Reclamo();
            reclamo.setMensajeSalida("");
            List<Reclamo> listaCircuitos = reclamoDAO.obtenerCircuitos();
            List<Reclamo> listaSubcircuitos = reclamoDAO.obtenerSubcircuitos();
            request.setAttribute("circuitos", listaCircuitos);
            request.setAttribute("subcircuitos", listaSubcircuitos);
            request.setAttribute("Reclamo", reclamo);
            request.getRequestDispatcher("Reclamos.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
