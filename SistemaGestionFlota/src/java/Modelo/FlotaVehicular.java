/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;



/**
 *
 * @author USUARIO
 */
public class FlotaVehicular extends Vehiculo{
    int idVehiculo;
    int kilometraje;
    int idPersonal;
    int idSubcircuito;
    Date fechaUltimoMant;
    
    public FlotaVehicular(){
    }
    
    public FlotaVehicular(int idVehiculo, int kilometraje, int idPersonal, int idSubcircuito, Date fechaUltimoMant){
        this.idVehiculo = idVehiculo;
        this.kilometraje = kilometraje;
        this.idPersonal = idPersonal;
        this.idSubcircuito = idSubcircuito;
        this.fechaUltimoMant = fechaUltimoMant;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdSubcircuito() {
        return idSubcircuito;
    }

    public void setIdSubcircuito(int idSubcircuito) {
        this.idSubcircuito = idSubcircuito;
    }

    public Date getFechaUltimoMant() {
        return fechaUltimoMant;
    }

    public void setFechaUltimoMant(Date fechaUltimoMant) {
        this.fechaUltimoMant = fechaUltimoMant;
    }


    
}
