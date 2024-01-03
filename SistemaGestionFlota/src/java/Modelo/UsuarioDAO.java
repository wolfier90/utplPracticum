/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author cdierr
 */
public class UsuarioDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuario validar(String usuario, String clave){
        Usuario user = new Usuario();
        String sql = "select u.*, b.nombre, b.apellido, b.correo from usuario u "
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
            }
            
        } catch(Exception e) {
            System.out.println("No se establecio conexion a la BD, error: " + e);
        }
        return user;
    }
}
