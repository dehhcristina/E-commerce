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
public class Pedido {

    private int CPEDIDO;
    private Cliente CCLIENTE;

    public int getCPEDIDO() {
        return CPEDIDO;
    }

    public void setCPEDIDO(int CPEDIDO) {
        this.CPEDIDO = CPEDIDO;
    }

    public Cliente getCCLIENTE() {
        return CCLIENTE;
    }

    public void setCCLIENTE(Cliente CCLIENTE) {
        this.CCLIENTE = CCLIENTE;
    }
}
