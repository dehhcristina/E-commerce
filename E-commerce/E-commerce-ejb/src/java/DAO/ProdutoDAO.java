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
import java.util.ArrayList;
import java.util.List;
import dto.Categoria;
import dto.Departamento;
import dto.Marca;
import dto.Produto;
import util.ConnectionUtil;

/**
 *
 * @author dp005977
 */
public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO() throws Exception {
        connection = ConnectionUtil.getConnection();
    }

    public Produto findById(int CPRODUTO) throws Exception {
        try {
            Produto produto = new Produto();
            Marca marca = new Marca();
            Categoria categoria = new Categoria();
            PreparedStatement p = connection.prepareStatement("SELECT * FROM PRODUTO WHERE CPRODUTO=?");
            p.setInt(1, CPRODUTO);

            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                produto.setCPRODUTO(rs.getInt("CPRODUTO"));
                produto.setPRODUTO(rs.getString("PRODUTO"));
                produto.setDESCRICAO(rs.getString("DESCRICAO"));
                produto.setIMAGEM(rs.getString("IMAGEM"));
                produto.setVALOR(rs.getDouble("VALOR"));
                produto.setFICHA(rs.getString("FICHA"));
                produto.setDESCONTO(rs.getDouble("DESCONTO"));
                produto.setESTOQUE(rs.getInt("ESTOQUE"));
                marca.setCMARCA(rs.getInt("CMARCA"));
                produto.setCMARCA(marca);
                categoria.setCCATEGORIA(rs.getInt("CCATEGORIA"));
                produto.setCCATEGORIA(categoria);
            }
            return produto;
        } catch (SQLException ex) {
            throw new Exception("Erro ao processar consulta! Verifique o log do aplicativo. ", ex);
        }
    }

    public void save(Produto produto) throws Exception {
        String SQL = "INSERT INTO PRODUTO(CPRODUTO, PRODUTO, DESCRICAO, IMAGEM, VALOR, FICHA, DESCONTO, ESTOQUE, CMARCA, CCATEGORIA) VALUES(?,?,?,?, ?, ?, ?, ?, ?, ?)";
        try {
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
        try {
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
        try {
            PreparedStatement p = connection.prepareStatement(SQL);
            p.setInt(1, produto.getCPRODUTO());
            p.execute();
            p.close();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }
    }

    public List<Produto> findAll() throws SQLException, Exception {
        List<Produto> produtos = new ArrayList<>();
        Produto produto;
        String SQL = " SELECT PRODUTO.*,"
                + "        MARCA.MARCA,"
                + "        CATEGORIA.CATEGORIA,"
                + "        DEPARTAMENTO.*"
                + " FROM PRODUTO"
                + " INNER JOIN MARCA ON (MARCA.CMARCA = PRODUTO.CMARCA)"
                + " INNER JOIN CATEGORIA ON (CATEGORIA.CCATEGORIA = PRODUTO.CCATEGORIA)"
                + " INNER JOIN DEPARTAMENTO ON (DEPARTAMENTO.CDEPARTAMENTO = CATEGORIA.CDEPARTAMENTO)";

        try {
            PreparedStatement p = connection.prepareStatement(SQL);

            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                produto = new Produto();
                produto.setCPRODUTO(rs.getInt("CPRODUTO"));
                produto.setPRODUTO(rs.getString("PRODUTO"));
                produto.setDESCRICAO(rs.getString("DESCRICAO"));
                produto.setIMAGEM(rs.getString("IMAGEM"));
                produto.setVALOR(rs.getDouble("VALOR"));
                produto.setFICHA(rs.getString("FICHA"));
                produto.setDESCONTO(rs.getDouble("DESCONTO"));
                produto.setESTOQUE(rs.getInt("ESTOQUE"));

                Marca marca = new Marca();
                marca.setCMARCA(rs.getInt("CMARCA"));
                marca.setMARCA(rs.getString("MARCA"));
                produto.setCMARCA(marca);

                Departamento departamento = new Departamento();
                departamento.setCDEPARTAMENTO(rs.getInt("CDEPARTAMENTO"));
                departamento.setDEPARTAMENTO(rs.getString("DEPARTAMENTO"));

                Categoria categoria = new Categoria();
                categoria.setCCATEGORIA(rs.getInt("CCATEGORIA"));
                categoria.setCATEGORIA(rs.getString("CATEGORIA"));
                categoria.setCDEPARTAMENTO(departamento);
                produto.setCCATEGORIA(categoria);

                produtos.add(produto);
            }

            rs.close();
            p.close();
        } catch (SQLException ex) {
            throw new Exception("Erro ao processar consulta! Verifique o log do aplicativo. ", ex);
        }

        return produtos;
    }

    public List<Produto> findByName(String PESQUISA) throws Exception {
        List<Produto> produtos = new ArrayList<>();
        Produto produto;
        Categoria categoria;
        Marca marca;
        Departamento departamento;
        String SQL = " SELECT PRODUTO.*,"
                + "        MARCA.MARCA,"
                + "        CATEGORIA.CATEGORIA,"
                + "        DEPARTAMENTO.DEPARTAMENTO"
                + " FROM PRODUTO"
                + " INNER JOIN MARCA ON (MARCA.CMARCA = PRODUTO.CMARCA)"
                + " INNER JOIN CATEGORIA ON (CATEGORIA.CCATEGORIA = PRODUTO.CCATEGORIA)"
                + " INNER JOIN DEPARTAMENTO ON (DEPARTAMENTO.CDEPARTAMENTO = CATEGORIA.CDEPARTAMENTO)"
                + " WHERE UPPER(PRODUTO.PRODUTO) LIKE UPPER('%" + PESQUISA + "%')";

        try {
            PreparedStatement p = connection.prepareStatement(SQL);

            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                produto = new Produto();
                produto.setCPRODUTO(rs.getInt("CPRODUTO"));
                produto.setPRODUTO(rs.getString("PRODUTO"));
                produto.setDESCRICAO(rs.getString("DESCRICAO"));
                produto.setIMAGEM(rs.getString("IMAGEM"));
                produto.setVALOR(rs.getDouble("VALOR"));
                produto.setFICHA(rs.getString("FICHA"));
                produto.setDESCONTO(rs.getDouble("DESCONTO"));
                produto.setESTOQUE(rs.getInt("ESTOQUE"));

                marca = new Marca();
                marca.setCMARCA(rs.getInt("CMARCA"));
                marca.setMARCA(rs.getString("MARCA"));
                produto.setCMARCA(marca);

                departamento = new Departamento();
                departamento.setCDEPARTAMENTO(rs.getInt("CDEPARTAMENTO"));
                departamento.setDEPARTAMENTO(rs.getString("DEPARTAMENTO"));

                categoria = new Categoria();
                categoria.setCCATEGORIA(rs.getInt("CCATEGORIA"));
                categoria.setCATEGORIA(rs.getString("CATEGORIA"));
                categoria.setCDEPARTAMENTO(departamento);
                produto.setCCATEGORIA(categoria);

                produtos.add(produto);
            }

            rs.close();
            p.close();
        } catch (SQLException ex) {
            throw new Exception("Erro ao processar consulta! Verifique o log do aplicativo. ", ex);
        }

        return produtos;
    }
}
