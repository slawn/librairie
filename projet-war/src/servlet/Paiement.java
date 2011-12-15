/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import commande.CommandeManager;
import commande.CommandeManagerBean;
import commande.Payement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import panier.Panier;
import session.SessionUtilisateur;

/**
 *
 * @author Treemo
 */
public class Paiement extends HttpServlet {

    @EJB
    CommandeManagerBean commande;

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        SessionUtilisateur session = new SessionUtilisateur(req);

        if ( !session.isConnected() ) {
            
            resp.sendRedirect( "Login?redirection=Paiement" );
            return;
        }

        String typeCarte = req.getParameter("ext_frm_cardtype");
        String numCarte = req.getParameter("ext_frm_cardnum");
        String moisExpiration = req.getParameter("ext_frm_expiry_Month");
        String anneeExpiration = req.getParameter("ext_frm_expiry_Year");
        String cvv = req.getParameter("ext_frm_cvv");

        Payement payement = new Payement();
        Panier pannier = session.getPannier();

        if ( typeCarte != null || numCarte != null || moisExpiration != null || anneeExpiration != null || cvv != null ) {

            if ( payement.payer(session, pannier.getPrix(), typeCarte, numCarte, moisExpiration, anneeExpiration, cvv) ) {

                commande.creationDepuisPannier(session.getClient(), pannier);
                req.setAttribute("paiement", true);
            }
        }

        RequestDispatcher view = req.getRequestDispatcher("Paiement.jsp");
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }
}
