/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
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
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    CallableStatement cs;
    ResultSet rs;
    
    public Usuario validar(String usuario, String clave){
        Usuario user = new Usuario();
        String sql = "select u.*, b.nombre, b.apellido, b.correo, p.cargo, p.idpersonal_policial from usuario u "
                + "inner join personal_policial p on u.id_personal_policial = p.idpersonal_policial "
                + "inner join persona b on p.id_persona = b.id_persona "
                + " where nombre_usuario=? "
                + "and clave=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            rs=ps.executeQuery();
            while (rs.next()){
                user.setUser(rs.getString("nombre_usuario"));
                user.setClave(rs.getString("clave"));
                user.setNombres(rs.getString("nombre")+ " " + rs.getString("apellido"));
                user.setCorreo(rs.getString("correo"));
                user.setCargo(rs.getString("cargo"));
                user.setId(rs.getInt("idpersonal_policial"));
            }
            
        } catch(Exception e) {
            System.out.println("No se establecio conexion a la BD, error: " + e);
        }
        return user;
    }
    
    public List listar() {
        //Se define la sentencia del SP
        String sql = "{CALL pa_obtener_usuario(?)}";
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
                    us.setId(rs.getInt("id_usuario"));
                    us.setIdPersonal(rs.getInt("id_personal_policial"));
                    us.setClave(rs.getString("clave"));
                    us.setUser(rs.getString("nombre_usuario"));
                    us.setEstado(rs.getString("estado"));
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
}
