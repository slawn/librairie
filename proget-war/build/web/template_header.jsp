<%-- 
    Document   : template_header
    Created on : 9 déc. 2011, 14:47:25
    Author     : Treemo
--%>

<%@page import="session.SessionUtilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BooxStore</title>
    </head>
    <body>
        <%

        // affichage puis supression du buffer d'erreur

        SessionUtilisateur sessionUser = new SessionUtilisateur(request);
        ArrayList<String> list = sessionUser.getErreur();

        if ( list != null )
            for(int i = 0; i < list.size();i++)
                out.println( "<b>" + list.get(i) + "</b><br />" );

        sessionUser.clearErreur();

        %>