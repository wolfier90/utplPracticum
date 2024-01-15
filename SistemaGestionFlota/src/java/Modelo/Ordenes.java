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
public class Ordenes extends FlotaVehicular{
    int idOrdenTrabajo;
    String estado;
    int idPersonalPolicial;
    int kilometrajeActual;
    String observaciones;
    Date fechaInicio;
    Date fechaModificacion;
    String identificacionEncargado;
    String mensajeSalida;
    int codigoError;

    public Ordenes(){    
    }
    
    public Ordenes(int idOrdenTrabajo, String estado, int idPersonalPolicial, int kilometrajeActual, String observaciones,
            Date fechaInicio, Date fechaModificacion, String identificacionEncargado, String mensajeSalida, int codigoError){
        this.idOrdenTrabajo	= idOrdenTrabajo;
        this.estado   = estado;
        this.idPersonalPolicial          = idPersonalPolicial;
        this.kilometrajeActual  = kilometrajeActual;
        this.observaciones      = observaciones;
        this.fechaInicio        = fechaInicio;
        this.fechaModificacion  = fechaModificacion;
        this.identificacionEncargado = identificacionEncargado;
        this.mensajeSalida      = mensajeSalida;
        this.codigoError        = codigoError;
    }

    public int getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(int idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdPersonalPolicial() {
        return idPersonalPolicial;
    }

    public void setIdPersonalPolicial(int idPersonalPolicial) {
        this.idPersonalPolicial = idPersonalPolicial;
    }

    public int getKilometrajeActual() {
        return kilometrajeActual;
    }

    public void setKilometrajeActual(int kilometrajeActual) {
        this.kilometrajeActual = kilometrajeActual;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
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

    public String getIdentificacionEncargado() {
        return identificacionEncargado;
    }

    public void setIdentificacionEncargado(String identificacionEncargado) {
        this.identificacionEncargado = identificacionEncargado;
    }

}

