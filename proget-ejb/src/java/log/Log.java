/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package log;

import session.SessionUtilisateur;

/**
 *
 * @author Treemo
 */
public class Log {

    public static void addErreurMsg(SessionUtilisateur session, String erreur) {

        session.addErreur(erreur);
    }
}
