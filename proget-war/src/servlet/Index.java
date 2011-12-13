package servlet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import categorie.Categorie;
import categorie.CategorieManager;
import categorie.CategorieManagerBean;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import livre.LivreManagerBean;
import utilisateur.UtilisateurManager;
import utilisateur.UtilisateurManagerBean;

/**
 *
 * @author Treemo
 */
public class Index extends HttpServlet {

    @EJB
    LivreManagerBean livre;

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("topVente", livre.getLivreByMostVente(10) );
        
        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }
}
