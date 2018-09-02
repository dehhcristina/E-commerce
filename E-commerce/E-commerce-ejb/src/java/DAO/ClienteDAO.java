/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;
import util.ConnectionUtil;

/**
 *
 * @author Débora Pinheiro
 */
public class ClienteDAO {

    private Connection connection;

    public ClienteDAO() throws Exception {
        connection = ConnectionUtil.getConnection();
    }

    public Cliente findById(int CCLIENTE) throws Exception {
        try {
            Cliente cliente = new Cliente();
            PreparedStatement p = connection.prepareStatement("SELECT * FROM CLIENTE WHERE CCLIENTE=?");
            p.setInt(1, CCLIENTE);

            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                cliente.setCCLIENTE(rs.getInt("CCLIENTE"));
                cliente.setCPF(rs.getString("CPF"));
                cliente.setNOME(rs.getString("NOME"));
                cliente.setSOBRENOME(rs.getString("SOBRENOME"));
                cliente.setTELEFONE(rs.getString("TELEFONE"));
                cliente.setSENHA(rs.getString("SENHA"));
                cliente.setUSUARIO(rs.getString("USUARIO"));
            }
            return cliente;
        } catch (SQLException ex) {
            throw new Exception("Erro ao processar consulta! Verifique o log do aplicativo. ", ex);
        }
    }

    public void save(Cliente cliente) throws Exception {
        String SQL = "INSERT INTO CLIENTE(CCLIENTE, CPF, NOME, SOBRENOME, TELEFONE, SENHA, USUARIO) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, cliente.getCCLIENTE());
            p.setString(2, cliente.getCPF());
            p.setString(3, cliente.getNOME());
            p.setString(4, cliente.getSOBRENOME());
            p.setString(5, cliente.getTELEFONE());
            p.setString(6, cliente.getSENHA());
            p.setString(7, cliente.getUSUARIO());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void update(Cliente cliente) throws Exception {
        PreparedStatement p;
        try {
            p = connection.prepareStatement("UPDATE CLIENTE SET CCLIENTE=?, CPF=?, NOME=?, SOBRENOME=?, TELEFONE=?, SENHA=?, USUARIO=? WHERE CCLIENTE=?");
            p.setInt(1, cliente.getCCLIENTE());
            p.setString(2, cliente.getCPF());
            p.setString(3, cliente.getNOME());
            p.setString(4, cliente.getSOBRENOME());
            p.setString(5, cliente.getTELEFONE());
            p.setString(6, cliente.getSENHA());
            p.setString(7, cliente.getUSUARIO());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void delete(Cliente cliente) throws Exception {
        String SQL = "DELETE FROM CLIENTE WHERE CCLIENTE=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, cliente.getCCLIENTE());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
}
