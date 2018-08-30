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
import model.Pedido;
import util.ConnectionUtil;

/**
 *
 * @author dp005977
 */
public class PedidoDAO {
    private Connection connection;
    
    public PedidoDAO() throws Exception{
        connection = ConnectionUtil.getConnection();
    }
    
    public Pedido findById(int CPEDIDO) throws Exception{
        try{
            Pedido pedido = new Pedido();
            PreparedStatement p = connection.prepareStatement("SELECT * FROM PEDIDO WHERE CPEDIDO=?");
            p.setInt(1, CPEDIDO);
            
            ResultSet rs = p.executeQuery();
            
            if(rs.next()){
                pedido.setCPEDIDO(rs.getInt("CPEDIDO"));
//                pedido.setUF(rs.getString("UF"));
//                pedido.setDATA(rs.getDate("DATA"));
//                pedido.setCCLIENTE(rs.getInt("CCLICENTE"));
                pedido.setRUA(rs.getString("RUA"));
                pedido.setNUMERO(rs.getInt("NUMERO"));
                pedido.setBAIRRO(rs.getString("BAIRRO"));
                pedido.setCIDADE(rs.getString("CIDADE"));
                pedido.setTOTAL(rs.getDouble("TOTAL"));
            }
            return pedido;
        }catch (SQLException ex){
            throw new Exception("Erro ao processar consulta! Verifique o log do aplicativo. ", ex);
        }
    }
    
    public void save(Pedido pedido) throws Exception {
        String SQL = "INSERT INTO PEDIDO(CPEDIDO, UF, DATA, CPF, RUA, NUMERO, BAIRRO, CIDADE, TOTAL) VALUES(?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, pedido.getCPEDIDO());
            p.setString(2, pedido.getUF().getUF());
            p.setDate(3, new java.sql.Date(pedido.getDATA().getTime()));
//            p.setString(4, pedido.getCCLIENTE().getCCLIENTE());
            p.setString(5, pedido.getRUA());
            p.setInt(6, pedido.getNUMERO());
            p.setString(7, pedido.getBAIRRO());
            p.setString(8, pedido.getCIDADE());
            p.setDouble(9, pedido.getTOTAL());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void update(Pedido pedido) throws Exception {
        PreparedStatement p;
        try{
            p = connection.prepareStatement("UPDATE PEDIDO SET UF=?, DATA=?, CPF=?, RUA=?, NUMERO=?, BAIRRO=?, CIDADE=?, TOTAL=?, CPEDIDO=? WHERE CPEDIDO=?");
            p.setInt(1, pedido.getCPEDIDO());
            p.setString(2, pedido.getUF().getUF());
            p.setDate(3, new java.sql.Date(pedido.getDATA().getTime()));
//            p.setString(4, pedido.getCCLIENTE().getCCLIENTE());
            p.setString(5, pedido.getRUA());
            p.setInt(6, pedido.getNUMERO());
            p.setString(7, pedido.getBAIRRO());
            p.setString(8, pedido.getCIDADE());
            p.setDouble(9, pedido.getTOTAL());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void delete(Pedido pedido) throws Exception {
        String SQL = "DELETE FROM PEDIDO WHERE CPEDIDO=?";
        try{
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, pedido.getCPEDIDO());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
}
