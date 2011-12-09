/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;
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

    public static boolean creation(HttpSession session, String login, String password, String password2, String nom, String prenom, String adresse, String email) {

        if( !password.equals(password2) )
            Log.addErreurMsg(session, "Les deux mot de passe ne corresponde pas");

        return false;
    }

    public static boolean isAdmin(HttpSession session) {

        if ( session.getAttribute("isAdmin").equals(true) )
            return true;
        else
            return false;
    }
}
