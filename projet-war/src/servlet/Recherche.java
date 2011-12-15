/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import livre.LivreManagerBean;

/**
 *
 * @author Treemo
 */
public class Recherche extends HttpServlet {

    @EJB
    LivreManagerBean livre;

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        if ( req.getParameter("recherche") != null )
            req.setAttribute("recherche", livre.recherche( req.getParameter("recherche") ) );

        RequestDispatcher view = req.getRequestDispatcher("Recherche.jsp");
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }
}
