/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.PedidoDAO;
import DAO.PedidoItemDAO;
import java.sql.SQLException;
import model.Pedido;
import model.PedidoItem;

/**
 *
 * @author Loren
 */
public class ComprarBean {

    public boolean comprarBean(Pedido pedido, PedidoItem pedidoItem) throws Exception {
        boolean comprado = false;

        try {
            PedidoDAO pedidoDAO = new PedidoDAO();
            pedidoDAO.save(pedido);

            PedidoItemDAO pedidoItemDAO = new PedidoItemDAO();
            pedidoItemDAO.save(pedidoItem);
            comprado = true;
        } catch (SQLException ex) {
            throw new SQLException("Ocorreu um erro inesperado!", ex);
        } catch (Exception ex) {
            throw new Exception("Ocorreu um erro insperado!", ex);
        }

        return comprado;
    }
}
