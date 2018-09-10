/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.CategoriaDAO;
import DAO.DepartamentoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import dto.Categoria;

/**
 *
 * @author Débora Pinheiro
 */
@Stateless
public class CategoriaBean implements CategoriaBeanRemote, CategoriaBeanLocal {

    @Override
    public boolean categoriaBean(String CATEGORIA, int DEPARTAMENTO) {
        boolean inserido = false;

        try {
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            Categoria categoria = new Categoria();
            categoria.setCATEGORIA(CATEGORIA);
            DepartamentoDAO departamentoDAO = new DepartamentoDAO();
            categoria.setCDEPARTAMENTO(departamentoDAO.findById(DEPARTAMENTO));
            categoriaDAO.save(categoria);

            inserido = true;
        } catch (Exception ex) {
            Logger.getLogger(DepartamentoBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return inserido;
    }
}
