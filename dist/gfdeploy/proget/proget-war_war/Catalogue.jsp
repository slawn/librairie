<%-- 
    Document   : Catalogue
    Created on : 13 déc. 2011, 17:12:45
    Author     : Treemo
--%>

<%@page import="categorie.Categorie"%>
<%@page import="livre.Livre"%>
<%@page import="java.util.List"%>
<%@include file="template_header.jsp" %>

<%

List<Livre> listLivre = (List<Livre>)request.getAttribute("livre");

if ( listLivre != null ) {

    if ( listLivre != null )
        for(int i = 0; i < listLivre.size();i++)
            out.println( "<a href=\"Livre?livre=" + listLivre.get(i).getIdLivre() + "\">" + listLivre.get(i).getTitreLivre() + "</a><br />" );
       else
        out.println( "<b>Aucun livre dans cette categorie</b><br />" );
}
else {
    
    List<Categorie> listCategorie = (List<Categorie>)request.getAttribute("categorie");

    if ( listCategorie != null )
        for(int i = 0; i < listCategorie.size();i++)
            out.println( "<a href=\"?categorie=" + listCategorie.get(i).getIdCategorie() + "\">" + listCategorie.get(i).getNomCategorie() + "</a><br />" );
}

%>

<%@include file="template_footer.jsp" %>
