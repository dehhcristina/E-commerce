/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.ejb.Remote;

/**
 *
 * @author Débora Pinheiro
 */
@Remote
public interface ClienteBeanRemote {

    public boolean clienteBean(String CPF, String NOME, String SOBRENOME, String TELEFONE, String SENHA, String USUARIO) throws NoSuchAlgorithmException, UnsupportedEncodingException;
}
