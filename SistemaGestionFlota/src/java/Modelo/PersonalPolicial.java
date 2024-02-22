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
public class PersonalPolicial extends Usuario{
    int idPersonal;
    String mensajeSalida;
    int codigoError;

    public PersonalPolicial(){    
    }
    
    public PersonalPolicial(int idPersonal, String mensajeSalida, int codigoError){
        this.idPersonal = idPersonal;
        this.mensajeSalida = mensajeSalida;
        this.codigoError = codigoError;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
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

