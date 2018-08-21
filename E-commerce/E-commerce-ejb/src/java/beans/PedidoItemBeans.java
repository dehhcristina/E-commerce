/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.PedidoItemDAO;
import java.util.logging.Logger;
import model.PedidoItem;

/**
 *
 * @author Débora Pinheiro
 */
public class PedidoItemBeans implements PedidoItemBeansLocal, PedidoItemBeansRemote{
    public boolean pedidoItemBeans(int CPEDIDOITEM){
        boolean inserido = false;
        
        try {
            PedidoItemDAO pedidoItemDAO = new PedidoItemDAO();
            PedidoItem pedidoItemP = pedidoItemDAO.findById(CPEDIDOITEM);
            pedidoItemDAO.save(pedidoItemP);
            
            inserido = true;
        } catch (Exception ex) {
            Logger.getLogger("Ocorreu um erro inesperado!");
        }
        
        
        
        return inserido;
    }
}
