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
import model.Estado;
import util.ConnectionUtil;

/**
 *
 * @author dp005977
 */
public class EstadoDAO {
    private Connection connection;
    
    public EstadoDAO() throws Exception{
        connection = ConnectionUtil.getConnection();
    }
    
    public Estado findById(int UF) throws Exception{
        try{
            Estado estado = new Estado();
            PreparedStatement p = connection.prepareStatement("SELECT * FROM ESTADO WHERE UF=?");
            p.setInt(1, UF);
            
            ResultSet rs = p.executeQuery();
            
            if(rs.next()){
                p.setString(1, estado.getUF());
                p.setString(2, estado.getDESCRICAO());
            }
            return estado;
        }catch (SQLException ex){
            throw new Exception("Erro ao processar consulta! Verifique o log do aplicativo. ", ex);
        }
    }
    
    public void save(Estado estado) throws Exception {
        String SQL = "INSERT INTO ESTADO(UF, DESCRICAO) VALUES(?,?)";
        try{
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, estado.getUF());
            p.setString(2, estado.getDESCRICAO());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void update(Estado estado) throws Exception {
        PreparedStatement p;
        try{
            p = connection.prepareStatement("UPDATE ESTADO SET DESCRICAO=?, UF=? WHERE UF=?");
            p.setString(1, estado.getUF());
            p.setString(2, estado.getDESCRICAO());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void delete(Estado estado) throws Exception {
        String SQL = "DELETE FROM ESTADO WHERE UF=?";
        try{
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setString(1, estado.getUF());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
}
