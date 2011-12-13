<%-- 
    Document   : index
    Created on : 8 déc. 2011, 10:12:49
    Author     : Treemo
--%>

<%@page import="livre.Livre"%>
<%@page import="java.util.List"%>
<%@include file="template_header.jsp" %>

        <a href="Login">Login</a>
        <a href="Logout">Logout</a>

        <%

        List<Livre> listTopLivre = (List<Livre>)request.getAttribute("topVente");

        if ( listTopLivre != null )
            for(int i = 0; i < listTopLivre.size();i++)
                out.println( "<b>" + listTopLivre.get(i).getTitreLivre() + " => " + listTopLivre.get(i).getNombreVenteLivre() + "</b><br />" );

        %>

<%@include file="template_footer.jsp" %>
