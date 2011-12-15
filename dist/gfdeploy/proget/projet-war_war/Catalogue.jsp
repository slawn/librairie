<%-- 
    Document   : Catalogue
    Created on : 13 déc. 2011, 17:12:45
    Author     : Treemo
--%>

<%@page import="lib.LibJsp"%>
<%@page import="categorie.Categorie"%>
<%@page import="livre.Livre"%>
<%@page import="java.util.List"%>
<%@include file="template_header.jsp" %>
<%

List<Categorie> listCategorie = (List<Categorie>)request.getAttribute("categorie");

if ( listCategorie == null ) {

    out.println("<div align=\"center\">");
    out.println("<h3>"+request.getAttribute("titreCategorie")+"</h3>");
    out.println("</div>");
    List<Livre> listLivre = (List<Livre>)request.getAttribute("livre");

    LibJsp.afficherListLivre(out, listLivre);
}
else if ( listCategorie != null ) {
    
            int tailleLargeur = 3;

            out.println("<div align=\"center\">");
            out.println("<h3>Catégorie</h3>");
            out.println("</div>");
            
            out.println("<table width=\"80%\" style=\"text-align:center;margin-left:auto;margin-right:auto;\">");
            out.println("<tr>");

            for(int i = 0; i < listCategorie.size(); i++) {

                if( i%(tailleLargeur+1) == 0 )
                    out.println("</tr><tr>");
                
                    out.println("<td width=\""+(100/tailleLargeur)+"%\">");

                    if ( i < listCategorie.size() ) {

                        Categorie categorie = listCategorie.get(i);

                        out.println( "<a href=\"?categorie=" + categorie.getIdCategorie() + "\">" + categorie.getNomCategorie() + "</a><br />" );
                    }
                    
                    out.println("</td>");
            }

            out.println("</tr>");
            out.println("</table>");
    }
 %>
<br />
<%@include file="template_footer.jsp" %>
