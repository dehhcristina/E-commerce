/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author Loren
 */
public class Departamento implements Serializable {

    private int CDEPARTAMENTO;
    private String DEPARTAMENTO;

    public int getCDEPARTAMENTO() {
        return CDEPARTAMENTO;
    }

    public void setCDEPARTAMENTO(int CDEPARTAMENTO) {
        this.CDEPARTAMENTO = CDEPARTAMENTO;
    }

    public String getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }

    public void setDEPARTAMENTO(String DEPARTAMENTO) {
        this.DEPARTAMENTO = DEPARTAMENTO;
    }
}
