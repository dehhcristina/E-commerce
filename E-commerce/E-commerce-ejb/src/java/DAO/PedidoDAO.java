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
import model.Pedido;
import util.ConnectionUtil;

/**
 *
 * @author dp005977
 */
public class PedidoDAO {

    private Connection connection;

    public PedidoDAO() throws Exception {
        connection = ConnectionUtil.getConnection();
    }

    public Pedido findById(int CPEDIDO) throws Exception {
        try {
            Pedido pedido = new Pedido();
            Cliente cliente = new Cliente();
            PreparedStatement p = connection.prepareStatement("SELECT * FROM PEDIDO WHERE CPEDIDO=?");
            p.setInt(1, CPEDIDO);

            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                pedido.setCPEDIDO(rs.getInt("CPEDIDO"));
                cliente.setCCLIENTE(rs.getInt("CCLIENTE"));
                pedido.setCCLIENTE(cliente);
            }
            return pedido;
        } catch (SQLException ex) {
            throw new Exception("Erro ao processar consulta! Verifique o log do aplicativo. ", ex);
        }
    }

    public void save(Pedido pedido) throws Exception {
        String SQL = "INSERT INTO PEDIDO(CPEDIDO, CCLIENTE) VALUES(?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, pedido.getCPEDIDO());
            p.setInt(2, pedido.getCCLIENTE().getCCLIENTE());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void update(Pedido pedido) throws Exception {
        PreparedStatement p;
        try {
            p = connection.prepareStatement("UPDATE PEDIDO SET UF=?, DATA=?, CPF=?, RUA=?, NUMERO=?, BAIRRO=?, CIDADE=?, TOTAL=?, CPEDIDO=? WHERE CPEDIDO=?");
            p.setInt(1, pedido.getCPEDIDO());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void delete(Pedido pedido) throws Exception {
        String SQL = "DELETE FROM PEDIDO WHERE CPEDIDO=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, pedido.getCPEDIDO());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
}
