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
import model.Departamento;
import util.ConnectionUtil;

/**
 *
 * @author dp005977
 */
public class DepartamentoDAO {
    private Connection connection;
    
    public DepartamentoDAO() throws Exception{
        connection = ConnectionUtil.getConnection();
    }
    
    public Departamento findById(int CDEPARTAMENTO) throws Exception{
        try{
            Departamento departamento = new Departamento();
            PreparedStatement p = connection.prepareStatement("SELECT * FROM DEPARTAMENTO WHERE CDEPARTAMENTO=?");
            p.setInt(1, CDEPARTAMENTO);
            
            ResultSet rs = p.executeQuery();
            
            if(rs.next()){
                p.setInt(1, departamento.getCDEPARTAMENTO());
                p.setString(2, departamento.getDEPARTAMENTO());
            }
            return departamento;
        }catch (SQLException ex){
            throw new Exception("Erro ao processar consulta! Verifique o log do aplicativo. ", ex);
        }
    }
    
    public void save(Departamento departamento) throws Exception {
        String SQL = "INSERT INTO DEPARTAMENTO(CDEPARTAMENTO, DEPARTAMENTO) VALUES(?,?)";
        try{
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, departamento.getCDEPARTAMENTO());
            p.setString(2, departamento.getDEPARTAMENTO());
            p.execute();
            p.close();
            connection.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void update(Departamento departamento) throws Exception {
        PreparedStatement p;
        try{
            p = connection.prepareStatement("UPDATE DEPARTAMENTO SET DEPARTAMENTO=?, CDEPARTAMENTO=? WHERE CDEPARTAMENTO=?");
            p.setInt(1, departamento.getCDEPARTAMENTO());
            p.setString(2, departamento.getDEPARTAMENTO());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void delete(Departamento departamento) throws Exception {
        String SQL = "DELETE FROM DEPARTAMENTO WHERE CDEPARTAMENTO=?";
        try{
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, departamento.getCDEPARTAMENTO());
            p.execute();
            p.close();
            connection.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }
    
}
