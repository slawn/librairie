<%-- 
    Document   : Livre
    Created on : 13 déc. 2011, 19:05:01
    Author     : Treemo
--%>

<%@page import="livre.Livre"%>
<%@page import="java.util.ArrayList"%>
<%

Livre livre = (Livre) request.getAttribute("livre");

%>

<%@include file="template_header.jsp" %>

        <form name="session" method="POST" action="Enregistrement" >
                <table>
                        <tr>
                                <td>Titre : </td>
                                <td><%=livre.getTitreLivre() %></td>
                        </tr>

                        <tr>
                                <td>Auteur : </td>
                                <td><%=livre.getAuteurLivre() %></td>
                        </tr>

                        
                </table>
        </form>

<%@include file="template_footer.jsp" %>


