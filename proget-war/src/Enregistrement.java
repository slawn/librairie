/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
public class Enregistrement extends HttpServlet {
   
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        if (login != null && password != null && session != null ) {

            if ( Utilisateur.creation(session, login, password) ) {

            }
        }

        RequestDispatcher view = req.getRequestDispatcher("login.jsp");
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }
}
