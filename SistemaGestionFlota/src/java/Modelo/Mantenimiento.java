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
public class Mantenimiento extends Ordenes{
    int kilometrajeIngreso;
    Date fechaIngreso;
    String Mantenimiento1;
    String Mantenimiento2;
    String Mantenimiento3;

    public Mantenimiento(){    
    }
    
    public Mantenimiento(int kilometrajeIngreso, Date fechaIngreso, String Mantenimiento1, String Mantenimiento2, String Mantenimiento3){
        this.kilometrajeIngreso = kilometrajeIngreso;
        this.fechaIngreso = fechaIngreso;
        this.Mantenimiento1 = Mantenimiento1;
        this.Mantenimiento2 = Mantenimiento2;
        this.Mantenimiento3 = Mantenimiento3;
    }

    public int getKilometrajeIngreso() {
        return kilometrajeIngreso;
    }

    public void setKilometrajeIngreso(int kilometrajeIngreso) {
        this.kilometrajeIngreso = kilometrajeIngreso;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getMantenimiento1() {
        return Mantenimiento1;
    }

    public void setMantenimiento1(String Mantenimiento1) {
        this.Mantenimiento1 = Mantenimiento1;
    }

    public String getMantenimiento2() {
        return Mantenimiento2;
    }

    public void setMantenimiento2(String Mantenimiento2) {
        this.Mantenimiento2 = Mantenimiento2;
    }

    public String getMantenimiento3() {
        return Mantenimiento3;
    }

    public void setMantenimiento3(String Mantenimiento3) {
        this.Mantenimiento3 = Mantenimiento3;
    }

}

