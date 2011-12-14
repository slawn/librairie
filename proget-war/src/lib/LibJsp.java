/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import livre.Livre;

/**
 *
 * @author Treemo
 */
public class LibJsp {

    private static final int tailleLargeurLivre = 3;

    public static void afficherListLivre( JspWriter out, List<Livre> listLivre) {

        try {

            if ( listLivre == null ) {

                out.println("<b>Aucun livre dans cette categorie</b><br />");
                return;
            }

            out.println("<table width=\"80%\" style=\"text-align:center\" >");
            out.println("<tr>");

            for(int i = 0; i < listLivre.size(); i++) {

                if( i%(tailleLargeurLivre+1) == 0 )
                    out.println("</tr><tr>");
                
                    out.println("<td width=\""+(100/tailleLargeurLivre)+"%\">");

                    if ( i < listLivre.size() ) {

                        Livre livre = listLivre.get(i);

                        out.println("<a href=\"Livre?livre=" + livre.getIdLivre() + "\"><b>" + livre.getTitreLivre() + "</b></a>");
                    }
                    
                    out.println("</td>");
            }

            out.println("</tr>");
            out.println("</table>");

        } catch (IOException ex) {
                Logger.getLogger(LibJsp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
