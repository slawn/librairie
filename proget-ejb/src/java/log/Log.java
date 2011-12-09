/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package log;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Treemo
 */
public class Log {

    public static void addErreurMsg(HttpSession session, String erreur) {

        ArrayList<String> erreurList = (ArrayList<String>) session.getAttribute("erreur");

        if ( erreurList == null )
            erreurList = new ArrayList<String>();

        erreurList.add(erreur);

        session.setAttribute("erreur", erreurList);
    }

}
