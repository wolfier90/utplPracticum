/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Conexion {
    String url = "jdbc:mysql://localhost:3306/db_policia";
    String user = "root";
    String pass = "12345678";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection con;
    
    public Conexion(){
    }

    public Connection Conexion() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Se conecto a la BD ");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conecto a la BD ");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }
    
    public ResultSet ejecutarStoredProcedure(CallableStatement cs) throws SQLException{
        return cs.executeQuery();
    }
    
    public void desconectar(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
