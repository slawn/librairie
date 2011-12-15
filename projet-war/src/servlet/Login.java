package servlet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.SessionUtilisateur;
import utilisateur.Admin;
import utilisateur.Client;
import utilisateur.UtilisateurManagerBean;

/**
 *
 * @author Treemo
 */
public class Login extends HttpServlet {

    @EJB
    UtilisateurManagerBean utilisateur;

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        SessionUtilisateur session = new SessionUtilisateur(req);

        // redirection si deja connecté
        redirectionConnecte(session, req, resp);

        if (login != null && password != null ) {


             Admin admin = utilisateur.loginAdmin(login, password);

            if ( admin != null)

                session.login(admin);
            else {

                Client client = utilisateur.loginClient(login, password);

                if ( client != null)
                    session.login(client);
            }

            if ( !redirectionConnecte(session, req, resp) )
                session.addErreur("Login / mot de passe incorect");
       }

        if ( !session.isConnected() ) {

            RequestDispatcher view = req.getRequestDispatcher("login.jsp");
            view.forward(req, resp);
        }
    }

    private boolean redirectionConnecte(SessionUtilisateur session, HttpServletRequest req, HttpServletResponse resp) {

        if ( session.isConnected() ) {

            try {
                if (session.isAdmin()) {
                    resp.sendRedirect("Administration");
                } else {

                    String page = req.getParameter("redirection");

                    if ( page == null )
                        page = req.getHeader("referer");

                    if ( page == null )
                        page = "./";

                    resp.sendRedirect( page );
                }
                return true;
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }


}
