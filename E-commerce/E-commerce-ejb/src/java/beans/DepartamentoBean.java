/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.DepartamentoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.Departamento;

/**
 *
 * @author Débora Pinheiro
 */
@Stateless
public class DepartamentoBean implements DepartamentoBeanRemote, DepartamentoBeanLocal {

    public boolean departamentoBean(String DEPARTAMENTO) {
        boolean inserido = false;

        try {
            DepartamentoDAO departamentoDAO = new DepartamentoDAO();
            Departamento departamento = new Departamento();
            departamento.setDEPARTAMENTO(DEPARTAMENTO);
            departamentoDAO.save(departamento);

            inserido = true;

        } catch (Exception ex) {
            Logger.getLogger(DepartamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return inserido;
    }

}
