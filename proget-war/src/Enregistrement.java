/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
        String password2 = req.getParameter("password2");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String adresse = req.getParameter("adresse");
        String email = req.getParameter("email");

        HttpSession session = req.getSession();

        if (login != null && password != null && session != null ) {

            if ( Utilisateur.creation(session, login, password, password2, nom, prenom, adresse, email) ) {

                
            }
        }

        RequestDispatcher view = req.getRequestDispatcher("Enregistrement.jsp");
        view.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {

        doGet(req , resp);
    }
}
