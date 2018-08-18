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
import model.Categoria;
import model.Departamento;

/**
 *
 * @author Débora Pinheiro
 */
@Stateless
public class CategoriaBean {

    public boolean categoriaBean(int CCATEGORIA) {
        boolean inserido = false;
        
        try {
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            Categoria categoriaC = categoriaDAO.findById(CCATEGORIA);
            categoriaDAO.save(categoriaC);
            
            inserido = true;
        } catch (Exception ex) {
            Logger.getLogger("Ocorreu um erro inesperado!");
        }
        
        
        
        return inserido;
    }
}
