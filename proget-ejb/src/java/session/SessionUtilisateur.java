/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import java.io.Serializable;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import utilisateur.Admin;
import utilisateur.Client;

/**
 *
 * @author Treemo
 */
public class SessionUtilisateur implements Serializable {
    
    private final HttpSession session;

    public SessionUtilisateur(HttpServletRequest req) {

        session = req.getSession();
    }

    /**
     * connect un utilisateur a sa session
     *
     * @param client
     */
    public void login(Client client) {

       session.setAttribute("compteId", client.getIdClient() );
       session.setAttribute("isAdmin", false );
    }

    /**
     * connect un admin a sa session
     *
     * @param admin
     */
    public void login(Admin admin) {

        session.setAttribute("compteId", -admin.getIdAdmin() );
        session.setAttribute("isAdmin", true );
    }

    /**
     *
     * l'utilisateur est un admin ?
     *
     * @param this
     * @return boolean
     */
    public boolean isAdmin() {

        if ( session.getAttribute("isAdmin").equals(true) )
            return true;

        return false;
    }

    /**
     * deconecte un utilisateur de sa this
     *
     * @param this
     */
    public void logout() {

        session.setAttribute("compteId", 0 );
        session.setAttribute("isAdmin", false );
    }

    /**
     * recupere la liste des erreur
     *
     * @return
     */
    public ArrayList<String> getErreur() {

        ArrayList<String> erreurList = (ArrayList<String>) session.getAttribute("erreurList" );

        if ( erreurList == null)
            return new ArrayList<String>();

        return erreurList;
    }

    /**
     * ajoute une erreur
     *
     * @param erreur
     */
    public void addErreur(String erreur) {

        ArrayList<String> erreurList =  (ArrayList<String>) session.getAttribute("erreurList" );

        if ( erreurList == null)
            erreurList = new ArrayList<String>();

        erreurList.add(erreur);

        session.setAttribute("erreurList", erreurList);
    }

    /**
     * vide les erreurs
     *
     */
    public void clearErreur() {

        session.setAttribute("erreurList", new ArrayList<String>() );
    }

    /**
     * le client est connecté ?
     *
     * @return boolean
     */
    public boolean isConnected() {

        if( session.getAttribute("compteId") == null || session.getAttribute("compteId").equals(0) )
            return false;
        
        return true;
    }
}
