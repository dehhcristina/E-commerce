/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Remote;

/**
 *
 * @author Loren
 */
@Remote
public interface ProdutoBeanRemote {

    public boolean produtoBean(String PRODUTO, String DESCRICAO, String IMAGEM, double VALOR, String FICHA, double DESCONTO, int ESTOQUE, int MARCA, int CATEGORIA);
}
