/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
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
public class OrdenesDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    CallableStatement cs;
    ResultSet rs;
    int respuesta;
    int codigoError;
    
    
    
    //Operaciones CRUD
    public List listar(int idPersonalPolicial) {
        //Se define la sentencia del SP
        String sql = "{CALL pa_consulta_ordenes(?,?,?)}";
        List<Ordenes> Lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setString(1, "T"); // Ordenes de un usuario especifico
            cs.setInt(2, idPersonalPolicial);
            cs.setInt(3, 0);
            //Obtener los resultados obtenidos de la ejecución
            rs = cn.ejecutarStoredProcedure(cs);

            if (rs != null) {
                while (rs.next()) {
                    Ordenes ordenes = new Ordenes();
                    ordenes.setIdOrdenTrabajo(rs.getInt("id_orden_trabajo"));
                    ordenes.setEstado(rs.getString("estado"));
                    ordenes.setIdPersonalPolicial(rs.getInt("idpersonal_policial"));
                    ordenes.setKilometrajeActual(rs.getInt("kilometraje_Actual"));
                    ordenes.setObservaciones(rs.getString("observaciones"));
                    ordenes.setFechaInicio(rs.getDate("fecha_inicio"));
                    ordenes.setPlaca(rs.getString("placa"));
                    Lista.add(ordenes);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }
        return Lista;
    }
    
    public Ordenes listarId(int id_personal, int numOrden) {

        Ordenes ordenes = new Ordenes();
        //Se define la sentencia del SP
        String sql = "{CALL pa_consulta_ordenes(?,?,?)}";

        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setString(1, "");
            cs.setInt(2, id_personal);
            cs.setInt(3, numOrden);
            rs = cn.ejecutarStoredProcedure(cs);

            if (rs != null) {
                while (rs.next()) {
                    ordenes.setFechaInicio(rs.getDate("fecha_inicio"));
                    ordenes.setKilometrajeActual(rs.getInt("kilometraje_Actual"));
                    ordenes.setObservaciones(rs.getString("observaciones"));
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }
        return ordenes;
    }
    
    public int agregar(Ordenes ord) {

        //Se define la sentencia del SP
        String sql = "{CALL pa_registrar_orden(?,?,?,?,?,?)}";

        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setString(1, ord.getEstado());
            cs.setInt(2, ord.getIdPersonalPolicial());
            cs.setInt(3, ord.getKilometrajeActual());
            cs.setString(4, ord.getObservaciones());
            cs.setDate(5, (Date) ord.getFechaInicio());
            cs.registerOutParameter(6, java.sql.Types.INTEGER);
            //Obtener los resultados obtenidos de la ejecución
            rs = cn.ejecutarStoredProcedure(cs);
            codigoError = cs.getInt(6);
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }

        return codigoError;
    }
    
    public void delete(int idOrdenTrabajo) {
        //Se define la sentencia del SP
        String sql = "{CALL pa_eliminar_orden(?)}";

        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, idOrdenTrabajo);
            rs = cn.ejecutarStoredProcedure(cs);

        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }
    }
    
    public int actualizar(Ordenes ord) {
        //Se define la sentencia del SP
        String sql = "{CALL pa_actualizar_orden(?,?,?,?)}";
        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, ord.getIdOrdenTrabajo());
            cs.setInt(2, ord.getKilometrajeActual());
            cs.setString(3, ord.getObservaciones());
            cs.setDate(4, (Date) ord.getFechaInicio());
            rs = cn.ejecutarStoredProcedure(cs);
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }

        return respuesta;
    }
    
}
