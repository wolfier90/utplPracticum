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
public class FlotaVehicularDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    CallableStatement cs;
    ResultSet rs;
    int respuesta;

    //Operaciones CRUD
    public List listar() {
        //Se define la sentencia del SP
        String sql = "{CALL pa_obtener_vehiculo(?)}";
        List<FlotaVehicular> Lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, 0); //Le mandamos 0 para que traiga todos los registros sin filtrar
            //Obtener los resultados obtenidos de la ejecución
            rs = cn.ejecutarStoredProcedure(cs);

            if (rs != null) {
                while (rs.next()) {
                    FlotaVehicular fv = new FlotaVehicular();
                    fv.setIdVehiculo(rs.getInt("idflota_vehicular"));
                    fv.setPlaca(rs.getString("placa"));
                    fv.setChasis(rs.getString("chasis"));
                    fv.setColor(rs.getString("color"));
                    fv.setMarca(rs.getString("marca"));
                    fv.setModelo(rs.getString("modelo"));
                    fv.setTipo(rs.getString("tipo"));
                    fv.setKilometraje(rs.getInt("kilometraje"));
                    fv.setFechaUltimoMant(rs.getDate("fecha_ult_mant"));
                    Lista.add(fv);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }

        return Lista;
    }
    
    public int agregar(FlotaVehicular p) {

        //Se define la sentencia del SP
        String sql = "{CALL pa_registrar_vehiculo(?,?,?,?,?,?,?,?)}";

        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setString(1, p.getPlaca());
            cs.setString(2, p.getChasis());
            cs.setString(3, p.getModelo());
            cs.setString(4, p.getMarca());
            cs.setString(5, p.getColor());
            cs.setString(6, p.getTipo());
            cs.setInt(7, p.getKilometraje());
            cs.setDate(8, (Date) p.getFechaUltimoMant());
            
            //Obtener los resultados obtenidos de la ejecución
            rs = cn.ejecutarStoredProcedure(cs);

        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }

        return respuesta;
    }
    
    public FlotaVehicular listarId(int id) {

        FlotaVehicular flota = new FlotaVehicular();
        //Se define la sentencia del SP
        String sql = "{CALL pa_obtener_vehiculo(?)}";

        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, id);
            rs = cn.ejecutarStoredProcedure(cs);

            if (rs != null) {
                while (rs.next()) {
                    flota.setIdVehiculo(rs.getInt("idflota_vehicular"));
                    flota.setPlaca(rs.getString("placa"));
                    flota.setChasis(rs.getString("chasis"));
                    flota.setColor(rs.getString("color"));
                    flota.setMarca(rs.getString("marca"));
                    flota.setModelo(rs.getString("modelo"));
                    flota.setTipo(rs.getString("tipo"));
                    flota.setKilometraje(rs.getInt("kilometraje"));
                    flota.setFechaUltimoMant(rs.getDate("fecha_ult_mant"));
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }
        return flota;
    }
    
    public int actualizar(FlotaVehicular p) {
        //Se define la sentencia del SP
        String sql = "{CALL pa_actualizar_vehiculo(?,?,?,?,?,?,?,?,?)}";

        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, p.getIdVehiculo());
            cs.setString(2, p.getPlaca());
            cs.setString(3, p.getChasis());
            cs.setString(4, p.getModelo());
            cs.setString(5, p.getMarca());
            cs.setString(6, p.getColor());
            cs.setString(7, p.getTipo());
            cs.setInt(8, p.getKilometraje());
            cs.setDate(9, (Date) p.getFechaUltimoMant());
            rs = cn.ejecutarStoredProcedure(cs);

        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }

        return respuesta;
    }
    
    public void delete(int id) {
        //Se define la sentencia del SP
        String sql = "{CALL pa_eliminar_vehiculo(?)}";

        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, id);
            rs = cn.ejecutarStoredProcedure(cs);

        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }
    }
    
}
