/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.SessionUtilisateur;

/**
 *
 * @author Treemo
 */
public class Logout extends HttpServlet {
   
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        SessionUtilisateur session = new SessionUtilisateur(req);
        session.logout();

        String page = req.getHeader("referer");

        if ( page == null )
            page = "./";

        resp.sendRedirect( page );
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }
}
