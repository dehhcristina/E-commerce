/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Débora Pinheiro
 */
public class Cliente {

    private int CCLIENTE;
    private String NOME;
    private String SOBRENOME;
    private String TELEFONE;
    private String CPF;
    private String SENHA;
    private String USUARIO;

    public int getCCLIENTE() {
        return CCLIENTE;
    }

    public void setCCLIENTE(int CCLIENTE) {
        this.CCLIENTE = CCLIENTE;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getSOBRENOME() {
        return SOBRENOME;
    }

    public void setSOBRENOME(String SOBRENOME) {
        this.SOBRENOME = SOBRENOME;
    }

    public String getTELEFONE() {
        return TELEFONE;
    }

    public void setTELEFONE(String TELEFONE) {
        this.TELEFONE = TELEFONE;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSENHA() {
        return SENHA;
    }

    public void setSENHA(String SENHA) {
        this.SENHA = SENHA;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

}
