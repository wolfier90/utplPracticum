/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import Config.Utilitarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class ReclamoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    CallableStatement cs;
    ResultSet rs;
    int respuesta;
    int codigoError;
    
    
    
    //Operaciones CRUD
    public int agregar(Reclamo reclamo) {

        //Se define la sentencia del SP
        String sql = "{CALL pa_registrar_reclamo(?,?,?,?,?,?,?)}";

        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, reclamo.getIdCircuito());
            cs.setInt(2, reclamo.getIdSubCircuito());
            cs.setString(3, reclamo.tipoReclamo);
            cs.setString(4, reclamo.getDetalle());
            cs.setString(5, reclamo.getContacto());
            cs.setString(6, reclamo.getApellidos());
            cs.setString(7, reclamo.getNombres());
            //Obtener los resultados obtenidos de la ejecución
            rs = cn.ejecutarStoredProcedure(cs);
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }

        return codigoError;
    }
}
