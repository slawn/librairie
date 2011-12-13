/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import log.Log;
import session.SessionUtilisateur;
import utilisateur.Client;
import utilisateur.UtilisateurManagerBean;

/**
 *
 * @author Treemo
 */
public class MonCompte extends HttpServlet {
   
    @EJB
    UtilisateurManagerBean utilisateur;

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        String nom = "";
        String prenom = "";
        String adresse = "";
        String email = "";

    if (req.getParameter("prenom") != null)
        prenom = req.getParameter("prenom");

    if (req.getParameter("nom") != null)
        nom = req.getParameter("nom");

    if (req.getParameter("adresse") != null)
        adresse = req.getParameter("adresse");

    if (req.getParameter("email") != null)
        email = req.getParameter("email");

        SessionUtilisateur session = new SessionUtilisateur(req);

        if ( nom != null || prenom != null || adresse != null ||  email != null ) {

            if ( nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || email.isEmpty() || !utilisateur.isValidEmailAddress(email) ) {

                if( nom.isEmpty() )
                    Log.addErreurMsg(session, "Le nom est vide");

                if( prenom.isEmpty() )
                    Log.addErreurMsg(session, "Le prénom est vide");

                if( adresse.isEmpty() )
                    Log.addErreurMsg(session, "L'adresse est vide");

                if( email.isEmpty() )
                    Log.addErreurMsg(session, "L'email est vide");

                if( !utilisateur.isValidEmailAddress(email) )
                    Log.addErreurMsg(session, "L'adresse email est invalide");
            }
            else {

            //    Client client = utilisateur.;
            }
        }

        RequestDispatcher view = req.getRequestDispatcher("MonCompte.jsp");
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }
}
