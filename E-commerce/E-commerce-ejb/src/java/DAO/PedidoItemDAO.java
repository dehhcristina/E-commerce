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
import model.PedidoItem;
import util.ConnectionUtil;

/**
 *
 * @author dp005977
 */
public class PedidoItemDAO {
    private Connection connection;
    
    public PedidoItemDAO() throws Exception{
        connection = ConnectionUtil.getConnection();
    }
    
    public PedidoItem findById(int CPEDIDOITEM) throws Exception{
        try{
            PedidoItem pedidoItem = new PedidoItem();
            PreparedStatement p = connection.prepareStatement("SELECT * FROM PEDIDOITEM WHERE CPEDIDOITEM=?");
            p.setInt(1, CPEDIDOITEM);
            
            ResultSet rs = p.executeQuery();
            
            if(rs.next()){
                p.setInt(1, pedidoItem.getCPEDIDOITEM());
                p.setInt(2, pedidoItem.getCPEDIDO().getCPEDIDO());
                p.setInt(3, pedidoItem.getCPRODUTO().getCPRODUTO());
                p.setInt(4, pedidoItem.getQTDE());
            }
            return pedidoItem;
        }catch (SQLException ex){
            throw new Exception("Erro ao processar consulta! Verifique o log do aplicativo. ", ex);
        }
    }
    
    public void save(PedidoItem pedidoItem) throws Exception {
        String SQL = "INSERT INTO PEDIDOITEM(CPEDIDOITEM, CPEDIDO, CPRODUTO, QTDE) VALUES(?,?,?,?)";
        try{
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, pedidoItem.getCPEDIDOITEM());
                p.setInt(2, pedidoItem.getCPEDIDO().getCPEDIDO());
                p.setInt(3, pedidoItem.getCPRODUTO().getCPRODUTO());
                p.setInt(4, pedidoItem.getQTDE());
            p.execute();
            p.close();
            connection.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void update(PedidoItem pedidoItem) throws Exception {
        PreparedStatement p;
        try{
            p = connection.prepareStatement("UPDATE PEDIDOITEM SET CPEDIDOITEM=? CPEDIDO=? CPRODUTO=?, QTDE=? WHERE CPEDIDOITEM=?");
            p.setInt(1, pedidoItem.getCPEDIDOITEM());
                p.setInt(2, pedidoItem.getCPEDIDO().getCPEDIDO());
                p.setInt(3, pedidoItem.getCPRODUTO().getCPRODUTO());
                p.setInt(4, pedidoItem.getQTDE());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void delete(PedidoItem pedidoItem) throws Exception {
        String SQL = "DELETE FROM PEDIDOITEM WHERE CPEDIDOITEM=?";
        try{
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, pedidoItem.getCPEDIDOITEM());
            p.execute();
            p.close();
            connection.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
}
