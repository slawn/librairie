package servlet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
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

        if (login != null && password != null ) {


             Admin admin = utilisateur.loginAdmin(login, password);

            if ( admin != null)

                session.login(admin);
            else {

                Client client = utilisateur.loginClient(login, password);

                if ( client != null)
                    session.login(client);
            }

            if ( session.isConnected() ) {

                if ( session.isAdmin() )
                    resp.sendRedirect("result.do");
                else
                    resp.sendRedirect("result.do");
            }
            else
                session.addErreur("Login / mot de passe incorect");
       }
        
        RequestDispatcher view = req.getRequestDispatcher("login.jsp");
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }
}
