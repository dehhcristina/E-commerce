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
import dto.Marca;
import util.ConnectionUtil;

/**
 *
 * @author dp005977
 */
public class MarcaDAO {
    private Connection connection;
    
    public MarcaDAO() throws Exception{
        connection = ConnectionUtil.getConnection();
    }
    
    public Marca findById(int CMARCA) throws Exception{
        try{
            Marca marca = new Marca();
            PreparedStatement p = connection.prepareStatement("SELECT * FROM MARCA WHERE CMARCA=?");
            p.setInt(1, CMARCA);
            
            ResultSet rs = p.executeQuery();
            
            if(rs.next()){
                marca.setCMARCA(rs.getInt("CMARCA"));
                marca.setMARCA(rs.getString("MARCA"));
            }
            return marca;
        }catch (SQLException ex){
            throw new Exception("Erro ao processar consulta! Verifique o log do aplicativo. ", ex);
        }
    }
    
    public void save(Marca marca) throws Exception {
        String SQL = "INSERT INTO MARCA(CMARCA, MARCA) VALUES(?,?)";
        try{
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, marca.getCMARCA());
            p.setString(2, marca.getMARCA());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void update(Marca marca) throws Exception {
        PreparedStatement p;
        try{
            p = connection.prepareStatement("UPDATE MARCA SET MARCA=?, CMARCA=? WHERE CMARCA=?");
            p.setInt(1, marca.getCMARCA());
            p.setString(2, marca.getMARCA());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void delete(Marca marca) throws Exception {
        String SQL = "DELETE FROM MARCA WHERE CMARCA=?";
        try{
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, marca.getCMARCA());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
}
