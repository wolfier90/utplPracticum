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

public class PersonalPolicialDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    CallableStatement cs;
    ResultSet rs;
    int respuesta;

    //Operaciones CRUD
    public List listar() {
        //Se define la sentencia del SP
        String sql = "{CALL pa_obtener_personal(?)}";
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
                    Usuario us = new Usuario();
                    us.setId(rs.getInt("idpersonal_policial"));
                    us.setNombres(rs.getString("nombre"));
                    us.setApellidos(rs.getString("apellido"));
                    us.setIdentificacion(rs.getString("identificacion"));
                    us.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    us.setCorreo(rs.getString("correo"));
                    us.setCargo(rs.getString("cargo"));
                    Lista.add(us);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }

        return Lista;
    }

    public int agregar(Usuario p) {

        //Se define la sentencia del SP
        String sql = "{CALL pa_registrar_personal(?,?,?,?,?,?)}";

        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setString(1, p.getIdentificacion());
            cs.setString(2, p.getNombres());
            cs.setString(3, p.getApellidos());
            cs.setDate(4, (Date) p.getFechaNacimiento());
            cs.setString(5, p.getCorreo());
            cs.setString(6, p.getCargo());
            //Obtener los resultados obtenidos de la ejecución
            rs = cn.ejecutarStoredProcedure(cs);

        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }

        return respuesta;
    }

    public Usuario listarId(int id) {

        Usuario user = new Usuario();
        //Se define la sentencia del SP
        String sql = "{CALL pa_obtener_personal(?)}";

        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, id);
            rs = cn.ejecutarStoredProcedure(cs);

            if (rs != null) {
                while (rs.next()) {
                    //user.setId(rs.getInt("idpersonal_policial"));
                    user.setNombres(rs.getString("nombre"));
                    user.setApellidos(rs.getString("apellido"));
                    user.setIdentificacion(rs.getString("identificacion"));
                    user.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    user.setCorreo(rs.getString("correo"));
                    user.setCargo(rs.getString("cargo"));
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }
        return user;
    }

    public int actualizar(Usuario p) {
        //Se define la sentencia del SP
        String sql = "{CALL pa_actualizar_personal(?,?,?,?,?,?,?)}";

        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, p.getId());
            cs.setString(2, p.getIdentificacion());
            cs.setString(3, p.getNombres());
            cs.setString(4, p.getApellidos());
            cs.setDate(5, (Date) p.getFechaNacimiento());
            cs.setString(6, p.getCorreo());
            cs.setString(7, p.getCargo());
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
        String sql = "{CALL pa_eliminar_personal(?)}";

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
