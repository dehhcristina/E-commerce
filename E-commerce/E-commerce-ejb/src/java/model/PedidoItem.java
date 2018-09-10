/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.Produto;

/**
 *
 * @author Loren
 */
public class PedidoItem {

    private int CPEDIDOITEM;
    private Pedido CPEDIDO;
    private Produto CPRODUTO;
    private int QTDE;

    public int getCPEDIDOITEM() {
        return CPEDIDOITEM;
    }

    public void setCPEDIDOITEM(int CPEDIDOITEM) {
        this.CPEDIDOITEM = CPEDIDOITEM;
    }

    public Pedido getCPEDIDO() {
        return CPEDIDO;
    }

    public void setCPEDIDO(Pedido CPEDIDO) {
        this.CPEDIDO = CPEDIDO;
    }

    public Produto getCPRODUTO() {
        return CPRODUTO;
    }

    public void setCPRODUTO(Produto CPRODUTO) {
        this.CPRODUTO = CPRODUTO;
    }

    public int getQTDE() {
        return QTDE;
    }

    public void setQTDE(int QTDE) {
        this.QTDE = QTDE;
    }

}
