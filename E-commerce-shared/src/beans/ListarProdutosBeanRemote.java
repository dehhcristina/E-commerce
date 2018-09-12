/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Remote;
import dto.Produto;

/**
 *
 * @author Loren
 */
@Remote
public interface ListarProdutosBeanRemote {

    public List<Produto> listarProdutos() throws Exception;

    public List<Produto> pesquisarProdutos(String PESQUISA) throws Exception;

    public Produto umProduto(int CPRODUTO) throws Exception;
}
