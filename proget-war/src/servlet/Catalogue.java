/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import categorie.CategorieManagerBean;
import java.io.IOException;
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
public class Catalogue extends HttpServlet {
   
    @EJB
    LivreManagerBean livre;

    @EJB
    CategorieManagerBean categorie;

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        SessionUtilisateur session = new SessionUtilisateur(req);

        int categorie = 0;

        try {

                categorie = Integer.parseInt( req.getParameter("categorie") );
            } catch ( NumberFormatException e ) {}

        if ( categorie > 0) {

            int page = 1;

            try {

                page = Integer.parseInt( req.getParameter("page") );
            } catch ( NumberFormatException e ) {}

            session.setPageTaille( req.getParameter("taillePage") );

            req.setAttribute("livre", livre.getLivreByCategorie( categorie, page, session.getPageTaille() ) );
        }
        else
            req.setAttribute("categorie", this.categorie.getCategorieList() );
        
        RequestDispatcher view = req.getRequestDispatcher("Catalogue.jsp");
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }
}
