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
public class Administration extends HttpServlet {

    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        SessionUtilisateur session = new SessionUtilisateur(req);

        if ( !session.isConnected() || !session.isAdmin() )
                    resp.sendRedirect("./");

        RequestDispatcher view = req.getRequestDispatcher("administration.jsp");
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }
}
