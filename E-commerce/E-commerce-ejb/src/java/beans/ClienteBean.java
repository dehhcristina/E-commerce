/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.ClienteDAO;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import model.Cliente;

/**
 *
 * @author Débora Pinheiro
 */
@Stateless
public class ClienteBean implements ClienteBeanLocal, ClienteBeanRemote {

    public boolean clienteBean(String CPF, String NOME, String SOBRENOME, String TELEFONE, String SENHA, String USUARIO) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        boolean inserido = false;
        MessageDigest algoritmo = MessageDigest.getInstance("MD5");
        byte messageDigest[] = algoritmo.digest(SENHA.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }

        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            Cliente cliente = new Cliente();
            cliente.setCPF(CPF);
            cliente.setNOME(NOME);
            cliente.setSOBRENOME(SOBRENOME);
            cliente.setTELEFONE(TELEFONE);
            cliente.setSENHA(hexString.toString());
            cliente.setUSUARIO(USUARIO);
            clienteDAO.save(cliente);

            inserido = true;
        } catch (Exception ex) {
            Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return inserido;
    }
}
