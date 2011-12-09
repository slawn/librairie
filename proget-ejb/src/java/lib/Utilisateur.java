/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

import javax.servlet.http.HttpSession;
import log.Log;

/**
 *
 * @author Treemo
 */
public class Utilisateur {


    /**
     *
     * connecte un utilisateur a son compte
     * 
     * @param login
     * @param pass
     * @return bool
     */
    public static boolean login(HttpSession session, String login, String pass) {

        // admin
        if ( login.equals("admin") ) {

            session.setAttribute("isAdmin", true);

            return true;
        }

        // user
        if ( login.equals("user") ) {

            session.setAttribute("isAdmin", false);

            return true;
        }
        
        return false;
    }

    public static void logout(HttpSession session) {

    }

    /**
     *
     * test si le compte peut etre cree et si oui il le cree
     *
     * @param session
     * @param login
     * @param password
     * @param password2
     * @param nom
     * @param prenom
     * @param adresse
     * @param email
     * @return boolean
     */
    public static boolean creation(HttpSession session, String login, String password, String password2, String nom, String prenom, String adresse, String email) {

         if ( login.isEmpty() || password.isEmpty() || password2.isEmpty() || nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || email.isEmpty() || !password.equals(password2) || !isValidEmailAddress(email) ) {

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

            if( !isValidEmailAddress(email) )
                Log.addErreurMsg(session, "L'adresse email est invalide");

            return false;
        }

        

        return false;
    }

    /**
     *
     * l'utilisateur est un admin ?
     *
     * @param session
     * @return boolean
     */
    public static boolean isAdmin(HttpSession session) {

        if ( session.getAttribute("isAdmin").equals(true) )
            return true;
        else
            return false;
    }

    /**
     * l'adresse email est valide
     *
     * @param email
     * @return boolean
     */
    public static boolean isValidEmailAddress(String email) {

	try {
		new javax.mail.internet.InternetAddress(email, true);
	} catch (javax.mail.internet.AddressException e) {
		return false;
	}
	return true;
    }
}
