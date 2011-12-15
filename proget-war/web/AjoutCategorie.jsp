<%-- 
    Document   : AjoutCategorie
    Created on : 14 déc. 2011, 16:49:39
    Author     : edge
--%>

<%@page import="java.util.Iterator"%>
<%@page import="categorie.CategorieManager"%>
<%@page import="categorie.Categorie"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@include file="template_header.jsp" %>

<%
String nom_categorie="";
CategorieManager gestion_cat = new CategorieManager();
List<Categorie> liste_categorie = new ArrayList();


liste_categorie=gestion_cat.getCategorieList();


if (request.getParameter("nom_categorie") != null)
    nom_categorie = request.getParameter("nom_categorie");


if(liste_categorie != null)
{
%>


<table>
    <tr>
        <th>Nom</th>
        <th>Modifier</th>
        <th>Suprimer</th>
    </tr>
    <tr>
    <%
    Iterator i = liste_categorie.iterator();
//while(i.hasNext()){
  //String x = (String)i.next();
    while(i.hasNext())
    {
        String x = (String)i.next();
        %>
        <td><input type="text" name="nom_categorie" value="<%=nom_categorie %>" /></td>
        <td><a href=""></a></td>
        <td><a href=""> </a></td>
   <%
    }

    %>
    </tr>
</table>
<%
}
 else
    {%>
    <p>Y a pas de categorie t'as vu !!</p>
   <% }
%>
<%@include file="template_footer.jsp" %>