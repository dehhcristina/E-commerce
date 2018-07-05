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
import model.Administrador;
import util.ConnectionUtil;

/**
 *
 * @author dp005977
 */
public class AdministradorDAO {
    private Connection connection;
    
    public AdministradorDAO() throws Exception{
        connection = ConnectionUtil.getConnection();
    }
    
    public Administrador findById(int CADMINISTRADOR) throws Exception{
        try{
            Administrador admin = new Administrador();
            PreparedStatement p = connection.prepareStatement("SELECT * FROM ADMINISTRADOR WHERE CADMINISTRADOR=?");
            p.setInt(1, CADMINISTRADOR);
            
            ResultSet rs = p.executeQuery();
            
            if(rs.next()){
                admin.setCADMINISTRADOR(rs.getInt("CADMINISTRADOR"));
                admin.setLOGIN(rs.getString("LOGIN"));
                admin.setSENHA(rs.getString("SENHA"));
            }
            return admin;
        }catch (SQLException ex){
            throw new Exception("Erro ao processar consulta! Verifique o log do aplicativo. ", ex);
        }
    }
    
    public void save(Administrador admin) throws Exception {
        String SQL = "INSERT INTO ADMINISTRADOR(CADMINISTRADOR, LOGIN, SENHA) VALUES(?,?,?)";
        try{
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, admin.getCADMINISTRADOR());
            p.setString(2, admin.getLOGIN());
            p.setString(3, admin.getSENHA());
            p.execute();
            p.close();
            connection.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void update(Administrador admin) throws Exception {
        PreparedStatement p;
        try{
            p = connection.prepareStatement("UPDATE ADMINISTRADOR SET LOGIN=?, SENHA=? WHERE CADMINISTRADOR=?");
            p.setString(1, admin.getLOGIN());
            p.setString(2, admin.getSENHA());
            p.setInt(3, admin.getCADMINISTRADOR());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void delete(Administrador admin) throws Exception {
        String SQL = "DELETE FROM ADMINISTRADOR WHERE CADMINISTRADOR=?";
        try{
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, admin.getCADMINISTRADOR());
            p.execute();
            p.close();
            connection.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    
}
