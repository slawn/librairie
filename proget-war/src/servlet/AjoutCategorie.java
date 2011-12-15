/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import categorie.Categorie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilisateur.UtilisateurManagerBean;
import session.SessionUtilisateur;

/**
 *
 * @author edge
 */
@WebServlet(name="AjoutCategorie", urlPatterns={"/AjoutCategorie"})
public class AjoutCategorie extends HttpServlet {

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        SessionUtilisateur session = new SessionUtilisateur(req);

        if ( !session.isConnected() || !session.isAdmin() )
                    resp.sendRedirect("./");

        RequestDispatcher view = req.getRequestDispatcher("AjoutCategorie.jsp");
        view.forward(req, resp);

        //if()
       // {
        Categorie categorie = new Categorie();
        req.setAttribute("nom_categorie", categorie.getNomCategorie() );
        //}
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }
}

