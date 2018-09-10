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
public class Marca implements Serializable {

    private int CMARCA;
    private String MARCA;

    public int getCMARCA() {
        return CMARCA;
    }

    public void setCMARCA(int CMARCA) {
        this.CMARCA = CMARCA;
    }

    public String getMARCA() {
        return MARCA;
    }

    public void setMARCA(String MARCA) {
        this.MARCA = MARCA;
    }
}
