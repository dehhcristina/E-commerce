/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.Cliente;

/**
 *
 * @author Débora Pinheiro
 */
@Stateless
public class ClienteBeans implements ClienteBeansLocal, ClienteBeansRemote{
    public boolean clienteBeans(int CCLIENTE){
        boolean inserido = false;
        
        try {
//            ClienteDAO clienteDAO = new ClienteDAO();
//            Cliente clienteC = clienteDAO.findById(CCLIENTE);
//            clienteDAO.save(clienteC);
            
            inserido = true;
        } catch (Exception ex) {
            Logger.getLogger("Ocorreu um erro inesperado!");
        }
        
        
        
        return inserido;
    }
}
