<%-- 
    Document   : Livre
    Created on : 13 déc. 2011, 19:05:01
    Author     : Treemo
--%>

<%@page import="livre.Livre"%>
<%@page import="java.util.ArrayList"%>
<%

Livre livre = (Livre) request.getAttribute("livre");

String etatStock = (livre.getNombreStockLivre() > 0 ? "Disponible" : "En réapprovisionnement");

%>
<%@include file="template_header.jsp" %>

        <form method="POST" class="no_style" >
            <table width="90%" style="margin-left:auto;margin-right:auto;">
                        <tr>
                            <td><%=livre.getTitreLivre() %><br /></td>

                                <td rowspan="2">
                                    Prix : <%=livre.getPrixLivre() %> &euro;<br />
                                    <%=etatStock %><br />
                                    <% if ( livre.getNombreStockLivre() > 0 ) { %>
                                    <input type="text" name="ajoutNbPanier" value="1" />
                                    <input type="submit" value="Ajouter au panier" />
                                    <% } %>
                                </td>
                        </tr>

                        <tr><td>Auteur : <%=livre.getAuteurLivre() %><br /></td></tr>

                        <tr><td>Résumé:</td></tr>
                        <tr><td><%=livre.getSommaireLivre() %></td></tr>
                </table>
        </form>

<%@include file="template_footer.jsp" %>
