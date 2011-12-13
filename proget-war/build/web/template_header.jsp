<%-- 
    Document   : template_header
    Created on : 9 déc. 2011, 14:47:25
    Author     : Treemo
--%>

<%@page import="session.SessionUtilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >

<html>
    <head>
        <meta charset="UTF-8">
        <title>BooXtore</title>
         <link rel="stylesheet" media="screen" type="text/css" href="global.css" />
    </head>
    <body>


<header>
	<center><img id="top" src="logo3.png"/></center>
</header>

<nav>
            <ul class="menu1">
            <li><a href="./"><b>Accueil</b></a></li>
            <li><a href="Catalogue"><b>Catalogue</b></a></li>
            <li><a href="Panier"><b>Panier</b></a></li>
            <li><a href="Contacts"><b>Contactez-nous</b></a></li>

            <%
                SessionUtilisateur sessionUser = new SessionUtilisateur(request);

                if ( sessionUser.isConnected() ) {

                    if ( sessionUser.isAdmin() )
                        out.println("<li><a href=\"Administration\"><b>Administration</b></a></li>");
                    else
                        out.println("<li><a href=\"MonCompte\"><b>Mon compte</b></a></li>");

                    out.println("<li><a href=\"Logout\"><b>Déconnexion</b></a></li>");
                } else
                    out.println("<li><a href=\"Login\"><b>Connexion</b></a></li>");

            %>

        </ul>
</nav>


<article id="corps">

        <%

        // affichage puis supression du buffer d'erreur
        ArrayList<String> list = sessionUser.getErreur();

        if ( list != null )
            for(int i = 0; i < list.size();i++)
                out.println( "<b>" + list.get(i) + "</b><br />" );

        sessionUser.clearErreur();

        %>