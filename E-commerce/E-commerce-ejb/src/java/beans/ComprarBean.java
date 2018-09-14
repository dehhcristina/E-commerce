/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.PedidoDAO;
import DAO.PedidoItemDAO;
import dto.Produto;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.Cliente;
import model.Pedido;
import model.PedidoItem;

/**
 *
 * @author Loren
 */
@Stateless
public class ComprarBean implements ComprarBeanRemote, ComprarBeanLocal {

    @Override
    public boolean comprarBean(int CCLIENTE, int CPRODUTO, int QTDE) {
        boolean comprado = false;

        try {
            PedidoDAO pedidoDAO = new PedidoDAO();
            Pedido pedido = new Pedido();
            Cliente cliente = new Cliente();
            cliente.setCCLIENTE(CCLIENTE);
            pedido.setCCLIENTE(cliente);
            pedidoDAO.save(pedido);

            PedidoItemDAO pedidoItemDAO = new PedidoItemDAO();
            PedidoItem pedidoItem = new PedidoItem();
            Produto produto = new Produto();

            produto.setCPRODUTO(CPRODUTO);
            pedidoItem.setCPRODUTO(produto);
            pedido = new Pedido();
            pedido.setCPEDIDO(3);
            pedidoItem.setCPEDIDO(pedido);
            pedidoItem.setQTDE(QTDE);
            pedidoItemDAO.save(pedidoItem);

            comprado = true;
        } catch (SQLException ex) {
            Logger.getLogger("Ocorreu um erro inesperado!");
        } catch (Exception ex) {
            Logger.getLogger("Ocorreu um erro inesperado!");
        }

        return comprado;
    }
}
