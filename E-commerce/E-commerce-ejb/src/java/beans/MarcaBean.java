/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.MarcaDAO;
import DAO.PedidoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.Marca;

/**
 *
 * @author Débora Pinheiro
 */
@Stateless
public class MarcaBean implements MarcaBeanRemote, MarcaBeanLocal {
    public boolean marcaBean(int CMARCA) {
        boolean inserido = false;
        
        try {
            MarcaDAO marcaDAO = new MarcaDAO();
            Marca marcaM = marcaDAO.findById(CMARCA);
            marcaDAO.save(marcaM);
            
            inserido = true;
        
        } catch (Exception ex) {
            Logger.getLogger("Ocorreu um erro inesperado!");
        }
        
        return inserido;
    }
    
}
