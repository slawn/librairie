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
import session.SessionUtilisateur;

/**
 *
 * @author Treemo
 */
public class Livre extends HttpServlet {

    @EJB
    LivreManagerBean livre;

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        int livreId = 0;

        try {

                livreId = Integer.parseInt( req.getParameter("livre") );
            } catch ( NumberFormatException e ) {}

        livre.Livre livre = this.livre.getLivreById(livreId);
        
        if ( livre == null ) {
            
            resp.sendRedirect("Catalogue");
            return;
        }

        req.setAttribute("livre", livre);

        RequestDispatcher view = req.getRequestDispatcher("Livre.jsp");
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }
}
