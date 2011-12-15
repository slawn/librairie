<%-- 
    Document   : Panier
    Created on : 13 déc. 2011, 17:15:28
    Author     : Treemo
--%>

<%@page import="panier.PanierStruct"%>
<%@page import="livre.Livre"%>
<%@page import="panier.Panier"%>
<%@include file="template_header.jsp" %>

<%

Panier pannier = sessionUser.getPannier();

if ( pannier.isEmpty() ) {
%>
    <div align="center">
        <h3>Votre panier est vide</h3>
    </div>
<%
}
else {
%>
    <div align="center">
        <h3>Votre panier</h3>
    </div>

    <table width="30%" style="margin-left:auto;margin-right:auto;">
        <tr>
            <td>Prix total : </td>
            <td  align="right"><%=pannier.getPrix() %> &euro;</td>
        </tr>

        <tr>
            <td></td>
            <td align="right">
                <form method="post" class="no_style" action="Paiement">
                    <input type="submit" value="Paiement" />
                </form>
            </td>
        </tr>
    </table>

    <div align="center">
        <h3>Contenu de votre panier</h3>
    </div>

    <table width="90%" style="margin-left:auto;margin-right:auto;">
        <tr>
            <td>Livre</td>
            <td>Nombre</td>
            <td>Prix a l'unité</td>
        </tr>

<%
    out.println("<tr>");

    for ( PanierStruct article : pannier.getListLivre() ) {

        out.println("<td><a href=\"Livre?livre=" + article.livre.getIdLivre() + "\">" + article.livre.getTitreLivre() + "</td>");
        out.println("<td>" + article.ajoutNbPanier + "</td>");
        out.println("<td>" + article.livre.getPrixLivre() + "</td>");

        out.println("<tr></tr>");
    }

    out.println("</tr></table>");
}
%>

<%@include file="template_footer.jsp" %>

