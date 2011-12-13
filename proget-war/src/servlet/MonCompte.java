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
import log.Log;
import session.SessionUtilisateur;
import utilisateur.UtilisateurManagerBean;

/**
 *
 * @author Treemo
 */
public class MonCompte extends HttpServlet {
   
    @EJB
    UtilisateurManagerBean utilisateur;

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String adresse = req.getParameter("adresse");
        String email = req.getParameter("email");

        SessionUtilisateur session = new SessionUtilisateur(req);

        if ( session != null ) {

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

             //   Client client = utilisateur.creationClient(login, password, password2, nom, prenom, adresse, email);

                
            }
        }

        RequestDispatcher view = req.getRequestDispatcher("MonCompte.jsp");
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }
}
