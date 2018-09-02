/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.CategoriaDAO;
import DAO.MarcaDAO;
import DAO.ProdutoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import model.Produto;

/**
 *
 * @author Loren
 */
@Stateless
@LocalBean
public class ProdutoBean implements ProdutoBeanRemote, ProdutoBeanLocal {

    public boolean produtoBean(String PRODUTO, String DESCRICAO, String IMAGEM, double VALOR, String FICHA, double DESCONTO, int ESTOQUE, int MARCA, int CATEGORIA) {
        boolean inserido = false;

        try {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            Produto produto = new Produto();
            produto.setPRODUTO(PRODUTO);
            produto.setDESCRICAO(DESCRICAO);
            produto.setIMAGEM(IMAGEM);
            produto.setVALOR(VALOR);
            produto.setFICHA(FICHA);
            produto.setDESCONTO(DESCONTO);
            produto.setESTOQUE(ESTOQUE);
            MarcaDAO marcaDAO = new MarcaDAO();
            produto.setCMARCA(marcaDAO.findById(MARCA));
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            produto.setCCATEGORIA(categoriaDAO.findById(CATEGORIA));
            produtoDAO.save(produto);

            inserido = true;
        } catch (Exception ex) {
            Logger.getLogger(ProdutoBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return inserido;
    }
}
