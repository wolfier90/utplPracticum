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
}
