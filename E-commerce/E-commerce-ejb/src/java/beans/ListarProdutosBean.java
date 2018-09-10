/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.ProdutoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import dto.Produto;
import java.util.ArrayList;

/**
 *
 * @author Loren
 */
@Stateless
public class ListarProdutosBean implements ListarProdutosBeanLocal, ListarProdutosBeanRemote {

    @Override
    public List<Produto> listarProdutos() throws Exception {
        List<Produto> produto = new ArrayList<>();

        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produto = produtoDAO.findAll();
        } catch (Exception ex) {
            Logger.getLogger(ListarProdutosBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produto;
    }

    @Override
    public List<Produto> pesquisarProdutos(String PESQUISA) throws Exception {
        List<Produto> produto = null;

        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produto = produtoDAO.findByName(PESQUISA);
        } catch (Exception ex) {
            Logger.getLogger(ListarProdutosBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produto;
    }
}
