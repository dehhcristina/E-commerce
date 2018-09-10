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
import dto.Categoria;
import dto.Departamento;
import util.ConnectionUtil;

/**
 *
 * @author dp005977
 */
public class CategoriaDAO {

    private Connection connection;

    public CategoriaDAO() throws Exception {
        connection = ConnectionUtil.getConnection();
    }

    public Categoria findById(int CCATEGORIA) throws Exception {
        try {
            Categoria categoria = new Categoria();
            Departamento departamento = new Departamento();
            PreparedStatement p = connection.prepareStatement("SELECT * FROM CATEGORIA WHERE CCATEGORIA=?");
            p.setInt(1, CCATEGORIA);

            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                categoria.setCCATEGORIA(rs.getInt("CCATEGORIA"));
                categoria.setCATEGORIA(rs.getString("CATEGORIA"));
                departamento.setCDEPARTAMENTO(rs.getInt("CDEPARTAMENTO"));
                categoria.setCDEPARTAMENTO(departamento);
            }
            return categoria;
        } catch (SQLException ex) {
            throw new Exception("Erro ao processar consulta! Verifique o log do aplicativo. ", ex);
        }
    }

    public void save(Categoria categoria) throws Exception {
        String SQL = "INSERT INTO CATEGORIA(CCATEGORIA, CATEGORIA, CDEPARTAMENTO) VALUES(?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, categoria.getCCATEGORIA());
            p.setString(2, categoria.getCATEGORIA());
            p.setInt(3, categoria.getCDEPARTAMENTO().getCDEPARTAMENTO());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void update(Categoria categoria) throws Exception {
        PreparedStatement p;
        try {
            p = connection.prepareStatement("UPDATE CATEGORIA SET CATEGORIA=?, CDEPARTAMENTO=? WHERE CCATEGORIA=?");
            p.setInt(1, categoria.getCCATEGORIA());
            p.setString(2, categoria.getCATEGORIA());
            p.setInt(3, categoria.getCDEPARTAMENTO().getCDEPARTAMENTO());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public void delete(Categoria categoria) throws Exception {
        String SQL = "DELETE FROM CATEGORIA WHERE CCATEGORIA=?";
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, categoria.getCCATEGORIA());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

}
