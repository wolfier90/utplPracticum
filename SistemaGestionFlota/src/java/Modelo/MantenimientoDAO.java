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
public class MantenimientoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    CallableStatement cs;
    ResultSet rs;
    int respuesta;
    int codigoError;

    
    //Operaciones CRUD
    public List listar() {
        //Se define la sentencia del SP
        String sql = "{CALL pa_consulta_ordenes(?,?,?)}";
        List<Ordenes> Lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setString(1, "T"); // Trae todas las ordenes pendientes de aprobación
            cs.setInt(2, 0);
            cs.setInt(3, 0);
            //Obtener los resultados obtenidos de la ejecución
            rs = cn.ejecutarStoredProcedure(cs);

            if (rs != null) {
                while (rs.next()) {
                    Mantenimiento mnt = new Mantenimiento();
                    mnt.setIdOrdenTrabajo(rs.getInt("id_orden_trabajo"));
                    mnt.setEstado(rs.getString("estado"));
                    mnt.setIdPersonalPolicial(rs.getInt("idpersonal_policial"));
                    mnt.setKilometrajeActual(rs.getInt("kilometraje_Actual"));
                    mnt.setObservaciones(rs.getString("observaciones"));
                    mnt.setFechaInicio(rs.getDate("fecha_inicio"));
                    mnt.setPlaca(rs.getString("placa"));
                    Lista.add(mnt);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }
        return Lista;
    }

    public Mantenimiento listarId(int id_personal, int numOrden) {

        Mantenimiento mant = new Mantenimiento();
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
                    mant.setIdOrdenTrabajo(rs.getInt("id_orden_trabajo"));
                    mant.setPlaca(rs.getString("placa"));
                    mant.setIdPersonalPolicial(rs.getInt("idpersonal_policial"));
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }
        return mant;
    }
    
    public Mantenimiento agregar(Mantenimiento mnt, int idAprobador) {

        //Se define la sentencia del SP
        Mantenimiento datosRegistro = new Mantenimiento();
        String sql = "{CALL pa_registrar_mantenimiento(?,?,?,?,?,?,?,?,?)}";

        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setInt(1, mnt.getIdOrdenTrabajo());
            cs.setInt(2, mnt.getKilometrajeIngreso());
            cs.setDate(3, (Date) mnt.getFechaIngreso());
            cs.setInt(4, idAprobador);
            cs.setString(5, mnt.getMantenimiento1());
            cs.setString(6, mnt.getMantenimiento2());
            cs.setString(7, mnt.getMantenimiento3());
            cs.registerOutParameter(8, java.sql.Types.DOUBLE);
            cs.registerOutParameter(9, java.sql.Types.INTEGER);
            //Obtener los resultados obtenidos de la ejecución
            rs = cn.ejecutarStoredProcedure(cs);
            datosRegistro.setValorTotal(cs.getFloat(8));
            datosRegistro.setCodigoError(cs.getInt(9));
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            cn.desconectar();
        }
        return datosRegistro;
    }

    public List listarAprobadas() {
        //Se define la sentencia del SP
        String sql = "{CALL pa_consulta_ordenes(?,?,?)}";
        List<Ordenes> Lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            //Se prepara el SP en el servidor de base de datos
            cs = con.prepareCall(sql);
            cs.setString(1, "A"); // Trae todas las ordenes aprobadas
            cs.setInt(2, 0);
            cs.setInt(3, 0);
            //Obtener los resultados obtenidos de la ejecución
            rs = cn.ejecutarStoredProcedure(cs);

            if (rs != null) {
                while (rs.next()) {
                    Mantenimiento mnt = new Mantenimiento();
                    mnt.setIdOrdenTrabajo(rs.getInt("id_orden_trabajo"));
                    mnt.setEstado(rs.getString("estado"));
                    mnt.setIdPersonalPolicial(rs.getInt("idpersonal_policial"));
                    mnt.setKilometrajeActual(rs.getInt("kilometraje_Actual"));
                    mnt.setObservaciones(rs.getString("observaciones"));
                    mnt.setFechaInicio(rs.getDate("fecha_inicio"));
                    mnt.setPlaca(rs.getString("placa"));
                    mnt.setIdentificacionEncargado(rs.getString("identificacion"));
                    mnt.setTipoMantenimiento(rs.getString("tipo_mantenimiento"));
                    mnt.setValorTotal(rs.getFloat("valor_total"));
                    Lista.add(mnt);
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
