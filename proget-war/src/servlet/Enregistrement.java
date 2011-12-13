package servlet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import log.Log;
import session.SessionUtilisateur;
import utilisateur.Client;
import utilisateur.UtilisateurManagerBean;

/**
 *
 * @author Treemo
 */
public class Enregistrement extends HttpServlet {

    @EJB
    UtilisateurManagerBean utilisateur;

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String adresse = req.getParameter("adresse");
        String email = req.getParameter("email");

        SessionUtilisateur session = new SessionUtilisateur(req);

        if (login != null && session != null ) {

            if ( login.isEmpty() || password.isEmpty() || password2.isEmpty() || nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || email.isEmpty() || !password.equals(password2) || !utilisateur.isValidEmailAddress(email) ) {

                if( login.isEmpty() )
                    Log.addErreurMsg(session, "Le login est vide");

                if( password.isEmpty() )
                    Log.addErreurMsg(session, "Le mot de passe est vide");

                if( password2.isEmpty() )
                    Log.addErreurMsg(session, "La verification du mot de passe est vide");

                if( nom.isEmpty() )
                    Log.addErreurMsg(session, "Le nom est vide");

                if( prenom.isEmpty() )
                    Log.addErreurMsg(session, "Le prénom est vide");

                if( adresse.isEmpty() )
                    Log.addErreurMsg(session, "L'adresse est vide");

                if( email.isEmpty() )
                    Log.addErreurMsg(session, "L'email est vide");

                if( !password.equals(password2) )
                    Log.addErreurMsg(session, "Les deux mot de passe ne corresponde pas");

                if( !utilisateur.isValidEmailAddress(email) )
                    Log.addErreurMsg(session, "L'adresse email est invalide");
            }
            else {
                
                Client client = utilisateur.creationClient(login, password, password2, nom, prenom, adresse, email);
                
                if ( client != null ) {

                }
            
            }
        }

        // gestion des erreurs
        
        RequestDispatcher view = req.getRequestDispatcher("Enregistrement.jsp");
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }
}
