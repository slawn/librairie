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

        SessionUtilisateur session = new SessionUtilisateur(req);

        if ( !session.isConnected() ) {

            resp.sendRedirect("./");
            return;
        }

        Client client = session.getClient();

        String nom = client.getNomClient();
        String prenom = client.getPrenomClient();
        String adresse = client.getAdressePostaleClient();
        String email = client.getEmailClient();

        if (req.getParameter("prenom") != null)
            prenom = req.getParameter("prenom");

        if (req.getParameter("nom") != null)
            nom = req.getParameter("nom");

        if (req.getParameter("adresse") != null)
            adresse = req.getParameter("adresse");

        if (req.getParameter("email") != null)
            email = req.getParameter("email");

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

                if ( client != null ) {

                    client.setAdressePostaleClient(adresse);
                    client.setEmailClient(email);
                    client.setNomClient(nom);
                    client.setPrenomClient(prenom);

                    utilisateur.saveClient( client );
                }
            }
        }

        req.setAttribute("nom", client.getNomClient() );
        req.setAttribute("prenom", client.getPrenomClient() );
        req.setAttribute("adresse", client.getAdressePostaleClient() );
        req.setAttribute("email", client.getEmailClient() );

        RequestDispatcher view = req.getRequestDispatcher("MonCompte.jsp");
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }
}
