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
 * @author cdierr
 */
public class PertrechoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    CallableStatement cs;
    ResultSet rs;
    int codigoError;
    int respuesta;

    public List listar() {
        //Se define la sentencia del SP
        String sql = "{CALL pa_obtener_pertrecho(?)}";
        List<Usuario> Lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, 0); //Le mandamos 0 para que traiga todos los registros sin filtrar
            //Obtener los resultados obtenidos de la ejecución
            rs = cn.ejecutarStoredProcedure(cs);

            if (rs != null) {
                while (rs.next()) {
                    Pertrecho pt = new Pertrecho();
                    pt.setIdPertrecho(rs.getInt("idPertrecho"));
                    pt.setNombre(rs.getString("nombre"));
                    pt.setTipoArma(rs.getString("tipoArma"));
                    pt.setDescripcion(rs.getString("descripcion"));
                    pt.setCodigo(rs.getString("codigo"));
                    pt.setCodigo(rs.getString("codigo"));
                    pt.setFechaIngreso(rs.getDate("fecha_ingreso"));
                    pt.setCantidad(rs.getInt("cantidad"));
                    pt.setEstadoPertrecho(rs.getString("estado"));
                    Lista.add(pt);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }

        return Lista;
    }
    
    public int agregar(Pertrecho p) {

        //Se define la sentencia del SP
        String sql = "{CALL pa_creacion_pertrecho(?,?,?,?,?,?)}";
        
        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setString(1, p.getTipoArma());
            cs.setString(2, p.getNombre());
            cs.setString(3, p.getDescripcion());
            cs.setString(4, p.getCodigo());
            cs.setInt(5, p.getCantidad());
            cs.registerOutParameter(6, java.sql.Types.INTEGER);
            rs = cn.ejecutarStoredProcedure(cs);
            //Obtener los resultados de salida obtenidos de la ejecución
            codigoError = cs.getInt(6);
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }

        return codigoError;
    }
    
    public Pertrecho listarId(int id) {

        Pertrecho pertrecho = new Pertrecho();
        //Se define la sentencia del SP
        String sql = "{CALL pa_obtener_pertrecho(?)}";

        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, id);
            rs = cn.ejecutarStoredProcedure(cs);

            if (rs != null) {
                while (rs.next()) {
                    //user.setId(rs.getInt("idpersonal_policial"));
                    pertrecho.setIdPertrecho(rs.getInt("idPertrecho"));
                    pertrecho.setNombre(rs.getString("nombre"));
                    pertrecho.setTipoArma(rs.getString("tipoArma"));
                    pertrecho.setDescripcion(rs.getString("descripcion"));
                    pertrecho.setCodigo(rs.getString("codigo"));
                    pertrecho.setFechaIngreso(rs.getDate("fecha_ingreso"));
                    pertrecho.setCantidad(rs.getInt("cantidad"));
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }
        return pertrecho;
    }
    
    public int actualizar(Pertrecho p) {
        //Se define la sentencia del SP
        String sql = "{CALL pa_actualizar_pertrecho(?,?,?,?,?,?)}";

        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, p.getIdPertrecho());
            cs.setString(2, p.getTipoArma());
            cs.setString(3, p.getNombre());
            cs.setString(4, p.getDescripcion());
            cs.setString(5, p.getCodigo());
            cs.setInt(6, p.getCantidad());
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
        String sql = "{CALL pa_eliminar_pertrecho(?)}";

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
