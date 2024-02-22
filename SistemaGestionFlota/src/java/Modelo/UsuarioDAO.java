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
public class UsuarioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    CallableStatement cs;
    ResultSet rs;
    int codigoError;

    public Usuario validar(String usuario, String clave) {
        Usuario user = new Usuario();
        String sql = "{CALL pa_obtener_usuario(?,?,?,?)}";
        List<Usuario> Lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, 0);
            cs.setString(2, usuario);
            cs.setString(3, clave);
            cs.setString(4, "S");
            rs = cn.ejecutarStoredProcedure(cs);
            if (rs != null) {
                while (rs.next()) {
                    user.setUser(rs.getString("nombre_usuario"));
                    user.setClave(rs.getString("clave"));
                    user.setNombres(rs.getString("nombre") + " " + rs.getString("apellido"));
                    user.setCorreo(rs.getString("correo"));
                    user.setCargo(rs.getString("cargo"));
                    user.setId(rs.getInt("idpersonal_policial"));
                    user.setCodigoRol(rs.getString("codigo_rol"));
                }
            }

        } catch (Exception e) {
            System.out.println("No se establecio conexion a la BD, error: " + e);
        }
        return user;
    }

    public List listar() {
        //Se define la sentencia del SP
        String sql = "{CALL pa_obtener_usuario(?,?,?,?)}";
        List<Usuario> Lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, 0); //Le mandamos 0 para que traiga todos los registros sin filtrar
            cs.setString(2, "");
            cs.setString(3, "");
            cs.setString(4, "N");
            //Obtener los resultados obtenidos de la ejecución
            rs = cn.ejecutarStoredProcedure(cs);

            if (rs != null) {
                while (rs.next()) {
                    Usuario us = new Usuario();
                    us.setId(rs.getInt("id_usuario"));
                    us.setIdPersonal(rs.getInt("id_personal_policial"));
                    us.setNombres(rs.getString("nombre"));
                    us.setApellidos(rs.getString("apellido"));
                    us.setUser(rs.getString("nombre_usuario"));
                    us.setNombreRol(rs.getString("nombre_rol"));
                    us.setIdentificacion(rs.getString("identificacion"));
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
    
    public List obtenerRoles() {
        //Se define la sentencia del SP
        String sql = "{CALL pa_obtener_roles}";
        List<Usuario> Lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            //Obtener los resultados obtenidos de la ejecución
            rs = cn.ejecutarStoredProcedure(cs);

            if (rs != null) {
                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setCodigoRol(rs.getString("id_rol"));
                    usuario.setNombreRol(rs.getString("nombre"));
                    Lista.add(usuario);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }
        return Lista;
    }
    
    public List obtenerPersonalSinUser() {
        //Se define la sentencia del SP
        String sql = "{CALL pa_obtener_personal_sin_usuario}";
        List<PersonalPolicial> Lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            //Obtener los resultados obtenidos de la ejecución
            rs = cn.ejecutarStoredProcedure(cs);

            if (rs != null) {
                while (rs.next()) {
                    PersonalPolicial personalPolicial = new PersonalPolicial();
                    personalPolicial.setIdPersonal(Integer.parseInt(rs.getString("idpersonal_policial")));
                    personalPolicial.setNombres(rs.getString("nombre"));
                    personalPolicial.setApellidos(rs.getString("apellido"));
                    personalPolicial.setIdentificacion(rs.getString("identificacion"));
                    Lista.add(personalPolicial);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }
        return Lista;
    }
    
    public int agregar(PersonalPolicial p) {

        //Se define la sentencia del SP
        String sql = "{CALL pa_creacion_usuario(?,?,?,?,?)}";
        
        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, p.getIdPersonal());
            cs.setString(2, p.getClave());
            cs.setString(3, p.getUser());
            cs.setString(4, p.getCodigoRol());
            cs.registerOutParameter(5, java.sql.Types.INTEGER);
            rs = cn.ejecutarStoredProcedure(cs);
            //Obtener los resultados de salida obtenidos de la ejecución
            codigoError = cs.getInt(5);
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }

        return codigoError;
    }
    
    public void delete(int id) {
        //Se define la sentencia del SP
        String sql = "{CALL pa_eliminar_usuario(?)}";

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
    
    public Usuario listarId(int id) {

        Usuario user = new Usuario();
        //Se define la sentencia del SP
        String sql = "{CALL pa_obtener_usuario(?,?,?,?)}";

        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, id);
            cs.setString(2, "");
            cs.setString(3, "");
            cs.setString(4, "N");
            rs = cn.ejecutarStoredProcedure(cs);

            if (rs != null) {
                while (rs.next()) {
                    //user.setId(rs.getInt("idpersonal_policial"));
                    user.setId(Integer.parseInt(rs.getString("id_usuario")));
                    user.setIdPersonal(Integer.parseInt(rs.getString("id_personal_policial")));
                    user.setClave(rs.getString("clave"));
                    user.setUser(rs.getString("nombre_usuario"));
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }
        return user;
    }
}
