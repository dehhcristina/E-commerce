/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import beans.ProdutoBeanRemote;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Loren
 */
public class ProdutoServlet extends HttpServlet {

    @EJB
    ProdutoBeanRemote bean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String textJSON;
            String resposta;
            BufferedReader leitor = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
            textJSON = leitor.lines().collect(Collectors.joining());
            JsonReader reader = Json.createReader(new StringReader(textJSON));
            JsonObject dataJSON = reader.readObject();
            String produto = dataJSON.getJsonString("PRODUTO").getString();
            String descricao = dataJSON.getJsonString("DESCRICAO").getString();
            String imagem = dataJSON.getJsonString("IMAGEM").getString();
            double valor = dataJSON.getJsonNumber("VALOR").doubleValue();
            String ficha = dataJSON.getJsonString("FICHA").getString();
            double desconto = dataJSON.getJsonNumber("DESCONTO").doubleValue();
            int estoque = dataJSON.getJsonNumber("ESTOQUE").intValue();
            int marca = dataJSON.getJsonNumber("CMARCA").intValue();
            int categoria = dataJSON.getJsonNumber("CCATEGORIA").intValue();
            resposta = bean.produtoBean(produto, descricao, imagem, valor, ficha, desconto, estoque, marca, categoria) ? "Salvo com sucesso!" : "Ops, algo deu errado!";
            JsonObject retorno = Json.createObjectBuilder()
                    .add("mensagem", resposta)
                    .build();
            out.println(retorno.toString());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
