/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import beans.ComprarBeanRemote;
import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Loren
 */
public class ComprarServlet extends HttpServlet {

    @EJB
    private ComprarBeanRemote bean;

}
