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
public class Reclamo {

    int idReclamo;
    int idCircuito;
    int idSubcircuito;
    String tipoReclamo;
    String detalle;
    String contacto;
    String apellidos;
    String nombres;
    String estado;
    Date fechaGeneracion;
    String nombreCircuito;
    String nombreSubcircuito;
    String mensajeSalida;
    Date fechaInicio;
    Date fechaFin;
    int codigoError;
    int cantidad;

    public Reclamo() {
    }

    public Reclamo(int idReclamo, int idCircuito, int idSubcircuito, String tipoReclamo, String detalle, String contacto,
            String apellidos, String nombres, String estado, Date fechaGeneracion, String nombreCircuito,
            String nombreSubcircuito, String mensajeSalida, int codigoError, Date fechaInicio, Date fechaFin, int cantidad) {
        this.idReclamo = idReclamo;
        this.idCircuito = idCircuito;
        this.idSubcircuito = idSubcircuito;
        this.tipoReclamo = tipoReclamo;
        this.detalle = detalle;
        this.contacto = contacto;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.estado = estado;
        this.fechaGeneracion = fechaGeneracion;
        this.nombreCircuito = nombreCircuito;
        this.nombreSubcircuito = nombreSubcircuito;
        this.mensajeSalida = mensajeSalida;
        this.codigoError = codigoError;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidad = cantidad;
    }

    public int getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(int idReclamo) {
        this.idReclamo = idReclamo;
    }

    public int getIdCircuito() {
        return idCircuito;
    }

    public void setIdCircuito(int idCircuito) {
        this.idCircuito = idCircuito;
    }

    public int getIdSubcircuito() {
        return idSubcircuito;
    }

    public void setIdSubcircuito(int idSubcircuito) {
        this.idSubcircuito = idSubcircuito;
    }

    public String getTipoReclamo() {
        return tipoReclamo;
    }

    public void setTipoReclamo(String tipoReclamo) {
        this.tipoReclamo = tipoReclamo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getNombreCircuito() {
        return nombreCircuito;
    }

    public void setNombreCircuito(String nombreCircuito) {
        this.nombreCircuito = nombreCircuito;
    }

    public String getNombreSubcircuito() {
        return nombreSubcircuito;
    }

    public void setNombreSubcircuito(String nombreSubcircuito) {
        this.nombreSubcircuito = nombreSubcircuito;
    }
    
    public String getMensajeSalida() {
        return mensajeSalida;
    }

    public void setMensajeSalida(String mensajeSalida) {
        this.mensajeSalida = mensajeSalida;
    }

    public int getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
