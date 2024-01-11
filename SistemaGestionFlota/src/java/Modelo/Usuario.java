/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.Date;

/**
 *
 * @author cdierr
 */
public class Usuario extends FlotaVehicular{
    int id;
    String clave;
    String nombres;
    String apellidos;
    String correo;
    String estado;
    String user;
    String identificacion;
    String cargo;
    Date fechaNacimiento;
    String tipoSangre;
    String ciudadNacimiento;
    String celular;
    String rango;
    String mensajeSalida;

    public Usuario(){    
    }
    
    public Usuario(int id, String clave, String nombres, String apellidos, String correo, String estado, String user, 
            String identificacion, String cargo, Date fechaNacimiento, String tipoSangre, String ciudadNacimiento,
            String celular, String rango, String mensajeSalida){
        this.id = id;
        this.clave = clave;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.estado = estado;
        this.user = user;
        this.identificacion = identificacion;
        this.cargo = cargo;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.ciudadNacimiento = ciudadNacimiento;
        this.celular = celular;
        this.rango = rango;
        this.mensajeSalida = mensajeSalida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getMensajeSalida() {
        return mensajeSalida;
    }

    public void setMensajeSalida(String mensajeSalida) {
        this.mensajeSalida = mensajeSalida;
    }

}

