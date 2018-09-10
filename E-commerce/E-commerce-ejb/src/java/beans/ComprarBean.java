/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.PedidoDAO;
import DAO.PedidoItemDAO;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.Pedido;
import model.PedidoItem;

/**
 *
 * @author Loren
 */
@Stateless
public class ComprarBean implements ComprarBeanRemote, ComprarBeanLocal {

    @Override
    public boolean comprarBean(int pedido, int[] pedidoItem) {
        boolean comprado = false;

        try {
            PedidoDAO pedidoDAO = new PedidoDAO();
            Pedido pedidoP = pedidoDAO.findById(pedido);
            pedidoDAO.save(pedidoP);

            PedidoItemDAO pedidoItemDAO = new PedidoItemDAO();
            for (int i = 0; i <= pedidoItem.length; i++) {
                PedidoItem pedidoItemP = pedidoItemDAO.findById(pedidoItem[i]);
                pedidoItemDAO.save(pedidoItemP);
            }
            comprado = true;
        } catch (SQLException ex) {
            Logger.getLogger("Ocorreu um erro inesperado!");
        } catch (Exception ex) {
            Logger.getLogger("Ocorreu um erro inesperado!");
        }

        return comprado;
    }
}
