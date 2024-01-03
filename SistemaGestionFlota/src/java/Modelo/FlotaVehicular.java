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
public class FlotaVehicular {
    int idVehiculo;
    String chasis;
    String color;
    String marca;
    String modelo;
    String placa;
    String tipo;
    int kilometraje;
    int idPersonal;
    int idSubcircuito;
    Date fechaUltimoMant;
    
    public FlotaVehicular(){
    }
    
    public FlotaVehicular(int idVehiculo, String chasis, String color, String marca, String modelo, String placa, 
            String tipo, int kilometraje, int idPersonal, int idSubcircuito, Date fechaUltimoMant){
        this.idVehiculo = idVehiculo;
        this.chasis = chasis;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.tipo = tipo;
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

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
