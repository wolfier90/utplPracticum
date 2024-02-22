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
public class Persona extends Usuario{
    int idPersona;
    String mensajeSalida;
    int codigoError;

    public Persona(){    
    }
    
    public Persona(int idPersona, String mensajeSalida, int codigoError){
        this.idPersona = idPersona;
        this.mensajeSalida = mensajeSalida;
        this.codigoError = codigoError;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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
  
}

