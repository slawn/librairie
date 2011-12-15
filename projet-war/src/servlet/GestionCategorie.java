/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import categorie.Categorie;
import categorie.CategorieManagerBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
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
public class GestionCategorie extends HttpServlet {

        @EJB
        CategorieManagerBean gestion_cat;

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        SessionUtilisateur session = new SessionUtilisateur(req);

        if ( !session.isConnected() || !session.isAdmin() ) {

             resp.sendRedirect("./");
             return;
        }

        req.setAttribute("categorieList", gestion_cat.getCategorieList() );

        RequestDispatcher view = req.getRequestDispatcher("GestionCategorie.jsp");
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        String nom_categorie = req.getParameter("nom_categorie");
        int id_categorie = 0;

        try {
                id_categorie = Integer.parseInt( req.getParameter("id_categorie") );
            } catch ( NumberFormatException e ) {}

        if (  nom_categorie != null && id_categorie > 0 ) {

            Categorie categorie = gestion_cat.getCategorieById(id_categorie);

            if ( req.getParameter("mod") != null && req.getParameter("mod").equals("Supprimer") )
                gestion_cat.deleteCategory(categorie);
            else
                gestion_cat.updateCategory(categorie);
        }

        doGet(req , resp);
    }
}

