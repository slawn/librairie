<%-- 
    Document   : AjoutCategorie
    Created on : 14 déc. 2011, 16:49:39
    Author     : edge
--%>

<%@page import="javax.ejb.EJB"%>
<%@page import="categorie.CategorieManagerBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="categorie.CategorieManager"%>
<%@page import="categorie.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@include file="template_header.jsp" %>

<%

List<Categorie> liste_categorie= (List<Categorie>) request.getAttribute("categorieList");

if(liste_categorie != null)
{
%>


<table width="40%" style="margin-left:auto;margin-right:auto;">
    <tr>
        <th>Nom</th>
        <th>Modifier</th>
        <th>Suprimer</th>
    </tr>
    <tr>
    <%

    for(Categorie categorie : liste_categorie)
    {
        %>
        <form method="post">
            <tr>
                <td>
                    <input type="text" name="nom_categorie" value="<%=categorie.getNomCategorie() %>" />
                    <input type="hidden" name="id_categorie" value="<%=categorie.getIdCategorie() %>" />
                </td>

                <td><input type="submit" value="Sauvegarder" /></td>
                <td><input type="submit" name="mod" value="Supprimer" /></td>
            </tr>
        </form>
   <%
    }
    %>
</table>
<%
}
 else
    out.println("<p>Y a pas de categorie</p>");
%>
<%@include file="template_footer.jsp" %>