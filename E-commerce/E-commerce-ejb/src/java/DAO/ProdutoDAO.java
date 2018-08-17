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
import model.Produto;
import util.ConnectionUtil;

/**
 *
 * @author dp005977
 */
public class ProdutoDAO {
    private Connection connection;
    
    public ProdutoDAO() throws Exception{
        connection = ConnectionUtil.getConnection();
    }
    
    public Produto findById(int CPRODUTO) throws Exception{
        try{
            Produto produto = new Produto();
            PreparedStatement p = connection.prepareStatement("SELECT * FROM PRODUTO WHERE CPRODUTO=?");
            p.setInt(1, CPRODUTO);
            
            ResultSet rs = p.executeQuery();
            
            if(rs.next()){
                p.setInt(1, produto.getCPRODUTO());
                p.setString(2, produto.getPRODUTO());
                p.setString(3, produto.getDESCRICAO());
                p.setString(4, produto.getIMAGEM());
                p.setDouble(5, produto.getVALOR());
                p.setString(6, produto.getFICHA());
                p.setDouble(7, produto.getDESCONTO());
                p.setInt(8, produto.getESTOQUE());
                p.setInt(9, produto.getCMARCA().getCMARCA());
                p.setInt(10, produto.getCCATEGORIA().getCCATEGORIA());
                
            }
            return produto;
        }catch (SQLException ex){
            throw new Exception("Erro ao processar consulta! Verifique o log do aplicativo. ", ex);
        }
    }
    
    public void save(Produto produto) throws Exception {
        String SQL = "INSERT INTO PRODUTO(CPRODUTO, PRODUTO, DESCRICAO, IMAGEM, VALOR, FICHA, DESCONTO, ESTOQUE, CMARCA, CCATEGORIA) VALUES(?,?,?,?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement p = connection.prepareStatement(SQL);
                p.setInt(1, produto.getCPRODUTO());
                p.setString(2, produto.getPRODUTO());
                p.setString(3, produto.getDESCRICAO());
                p.setString(4, produto.getIMAGEM());
                p.setDouble(5, produto.getVALOR());
                p.setString(6, produto.getFICHA());
                p.setDouble(7, produto.getDESCONTO());
                p.setInt(8, produto.getESTOQUE());
                p.setInt(9, produto.getCMARCA().getCMARCA());
                p.setInt(10, produto.getCCATEGORIA().getCCATEGORIA());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void update(Produto produto) throws Exception {
        PreparedStatement p;
        try{
            p = connection.prepareStatement("UPDATE PRODUTO SET CPRODUTO=?, PRODUTO=?, DESCRICAO=?, IMAGEM=?, VALOR=?, FICHA=?, DESCONTO=?, ESTOQUE=?, CMARCA=?, CCATEGORIA=? WHERE CPRODUTO=?");
            p.setInt(1, produto.getCPRODUTO());
                p.setInt(1, produto.getCPRODUTO());
                p.setString(2, produto.getPRODUTO());
                p.setString(3, produto.getDESCRICAO());
                p.setString(4, produto.getIMAGEM());
                p.setDouble(5, produto.getVALOR());
                p.setString(6, produto.getFICHA());
                p.setDouble(7, produto.getDESCONTO());
                p.setInt(8, produto.getESTOQUE());
                p.setInt(9, produto.getCMARCA().getCMARCA());
                p.setInt(10, produto.getCCATEGORIA().getCCATEGORIA());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void delete(Produto produto) throws Exception {
        String SQL = "DELETE FROM PRODUTO WHERE CPRODUTO=?";
        try{
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, produto.getCPRODUTO());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
}
