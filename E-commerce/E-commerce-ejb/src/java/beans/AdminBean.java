/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.AdministradorDAO;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.Administrador;

;

/**
 *
 * @author Débora Pinheiro
 */
@Stateless
public class AdminBean implements AdminBeanLocal, AdminBeanRemote {

    @Override
    public boolean adminBean(int CADMINISTRADOR) {
        boolean inserido = false;

        try {
            AdministradorDAO adminDAO = new AdministradorDAO();
            Administrador administradorA = adminDAO.findById(CADMINISTRADOR);
            adminDAO.save(administradorA);

            inserido = true;
        } catch (Exception ex) {
            Logger.getLogger("Ocorreu um erro inesperado!");
        }

        return inserido;
    }

}
