package model;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Loren
 */
public class Produto {

    private int CPRODUTO;
    private String PRODUTO;
    private String DESCRICAO;
    private String IMAGEM;
    private double VALOR;
    private String FICHA;
    private double DESCONTO;
    private int ESTOQUE;
    private Marca CMARCA;
    private Categoria CCATEGORIA;

    public int getCPRODUTO() {
        return CPRODUTO;
    }

    public void setCPRODUTO(int CPRODUTO) {
        this.CPRODUTO = CPRODUTO;
    }

    public String getPRODUTO() {
        return PRODUTO;
    }

    public void setPRODUTO(String PRODUTO) {
        this.PRODUTO = PRODUTO;
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    public String getIMAGEM() {
        return IMAGEM;
    }

    public void setIMAGEM(String IMAGEM) {
        this.IMAGEM = IMAGEM;
    }

    public double getVALOR() {
        return VALOR;
    }

    public void setVALOR(double VALOR) {
        this.VALOR = VALOR;
    }

    public String getFICHA() {
        return FICHA;
    }

    public void setFICHA(String FICHA) {
        this.FICHA = FICHA;
    }

    public double getDESCONTO() {
        return DESCONTO;
    }

    public void setDESCONTO(double DESCONTO) {
        this.DESCONTO = DESCONTO;
    }

    public int getESTOQUE() {
        return ESTOQUE;
    }

    public void setESTOQUE(int ESTOQUE) {
        this.ESTOQUE = ESTOQUE;
    }

    public Marca getCMARCA() {
        return CMARCA;
    }

    public void setCMARCA(Marca CMARCA) {
        this.CMARCA = CMARCA;
    }

    public Categoria getCCATEGORIA() {
        return CCATEGORIA;
    }

    public void setCCATEGORIA(Categoria CCATEGORIA) {
        this.CCATEGORIA = CCATEGORIA;
    }
    
    

}
