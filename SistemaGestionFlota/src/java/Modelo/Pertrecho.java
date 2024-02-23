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
public class Pertrecho extends PersonalPolicial{
    int idPertrecho;
    String codigo;
    String descripcion;
    String nombre;
    String tipoArma;
    Date fechaIngreso;
    String estadoPertrecho;
    int cantidad;
    String mensajeSalida;

    public Pertrecho(){    
    }
    
    public Pertrecho(int idPertrecho, String codigo, String descripcion, String nombre, String tipoArma, 
            Date fechaIngreso, String estadoPertrecho, String mensajeSalida, int cantidad){
        this.idPertrecho = idPertrecho;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.tipoArma = tipoArma;
        this.fechaIngreso = fechaIngreso;
        this.estadoPertrecho = estadoPertrecho;
        this.cantidad = cantidad;
        this.mensajeSalida = mensajeSalida;
    }

    public int getIdPertrecho() {
        return idPertrecho;
    }

    public void setIdPertrecho(int idPertrecho) {
        this.idPertrecho = idPertrecho;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoArma() {
        return tipoArma;
    }

    public void setTipoArma(String tipoArma) {
        this.tipoArma = tipoArma;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstadoPertrecho() {
        return estadoPertrecho;
    }

    public void setEstadoPertrecho(String estadoPertrecho) {
        this.estadoPertrecho = estadoPertrecho;
    }  

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String getMensajeSalida() {
        return mensajeSalida;
    }

    public void setMensajeSalida(String mensajeSalida) {
        this.mensajeSalida = mensajeSalida;
    }

}

