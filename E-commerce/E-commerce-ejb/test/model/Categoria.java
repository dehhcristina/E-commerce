/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Loren
 */
public class Categoria {

    private int CCATEGORIA;
    private String CATEGORIA;
    private Departamento CDEPARTAMENTO;

    public int getCCATEGORIA() {
        return CCATEGORIA;
    }

    public void setCCATEGORIA(int CCATEGORIA) {
        this.CCATEGORIA = CCATEGORIA;
    }

    public String getCATEGORIA() {
        return CATEGORIA;
    }

    public void setCATEGORIA(String CATEGORIA) {
        this.CATEGORIA = CATEGORIA;
    }

    public Departamento getCDEPARTAMENTO() {
        return CDEPARTAMENTO;
    }

    public void setCDEPARTAMENTO(Departamento CDEPARTAMENTO) {
        this.CDEPARTAMENTO = CDEPARTAMENTO;
    }
}
