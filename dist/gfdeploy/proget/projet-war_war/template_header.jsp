<%-- 
    Document   : template_header
    Created on : 9 déc. 2011, 14:47:25
    Author     : Treemo
--%>

<%@page import="session.SessionUtilisateur"%>
<%@page import="java.util.ArrayList"%>
<%
    SessionUtilisateur sessionUser = new SessionUtilisateur(request);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" media="screen" type="text/css" href="global.css" />
    <title>BooXtore</title>
    <meta name="description" content="">
	<link rel="icon" type="image/png" href="livre.ico" />
<!--[if IE]><link rel="shortcut icon" type="image/x-icon" href="livre.ico" /><![endif]-->
  </head>
<body>

<header>
</header>

<nav>
	<ul class="menu1">
	<li><a href="./"><b>Accueil</b></a></li>
            <%

                if ( !sessionUser.isAdmin() ) {

                     out.println("<li><a href=\"Catalogue\"><b>Catalogue</b></a></li>");
                     out.println("<li><a href=\"Panier\"><b>Panier</b></a></li>");
                }
            %>
            <li><a href="Contacts"><b>Contactez-nous</b></a></li>
            <%

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
        <form id="search_bar" method="post" action="Recherche">
            <input type="text" name="recherche" id="search_bar_input" />
            <input type="image" src="loupe.png" alt="Recherche" id="search_bar_submit"/>
        </form>
<article id="corps">

        <%

        // affichage puis supression du buffer d'erreur
        ArrayList<String> list = sessionUser.getErreur();

        if ( list != null )
            for(int i = 0; i < list.size();i++)
                out.println( "<div align=\"centers\"><b>" + list.get(i) + "</b><br />" );

        sessionUser.clearErreur();

        %>