/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.EstadoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.Estado;

/**
 *
 * @author Débora Pinheiro
 */
@Stateless
public class EstadoBean implements EstadoBeanRemote, EstadoBeanLocal{
    public boolean estadoBean(String UF) {
        boolean inserido = false;
        
        try {
            EstadoDAO estadoDAO = new EstadoDAO();
            Estado estadoE = estadoDAO.findById(UF);
            estadoDAO.save(estadoE);
            
            inserido = true;
        } catch (Exception ex) {
            Logger.getLogger("Ocorreu um erro inesperado!");
        }
        
        return inserido;
    }
}
