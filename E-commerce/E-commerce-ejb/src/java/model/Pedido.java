/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Loren
 */
public class Pedido {

    private int CPEDIDO;
    private Estado UF;
    private Date DATA;
    private String CPF;
    private String RUA;
    private int NUMERO;
    private String BAIRRO;
    private String CIDADE;
    private double TOTAL;

    public int getCPEDIDO() {
        return CPEDIDO;
    }

    public void setCPEDIDO(int CPEDIDO) {
        this.CPEDIDO = CPEDIDO;
    }

    public Estado getUF() {
        return UF;
    }

    public void setUF(Estado UF) {
        this.UF = UF;
    }

    public Date getDATA() {
        return DATA;
    }

    public void setDATA(Date DATA) {
        this.DATA = DATA;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRUA() {
        return RUA;
    }

    public void setRUA(String RUA) {
        this.RUA = RUA;
    }

    public int getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(int NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getBAIRRO() {
        return BAIRRO;
    }

    public void setBAIRRO(String BAIRRO) {
        this.BAIRRO = BAIRRO;
    }

    public String getCIDADE() {
        return CIDADE;
    }

    public void setCIDADE(String CIDADE) {
        this.CIDADE = CIDADE;
    }

    public double getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(double TOTAL) {
        this.TOTAL = TOTAL;
    }

}
