/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lib.Utilisateur;

/**
 *
 * @author Treemo
 */
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

		//On récupère les identifiants et on les stocke dans notre objet de session
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();

                if ( Utilisateur.login(session, login, password) ) {

                    if ( Utilisateur.isAdmin(session) )
                        resp.sendRedirect("result.do");
                    else
                        resp.sendRedirect("result.do");
                }
	}

	protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

		doGet(req , resp);
	}
}
