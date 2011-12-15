<%-- 
    Document   : index
    Created on : 8 déc. 2011, 10:12:49
    Author     : Treemo
--%>

<%@page import="lib.LibJsp"%>
<%@page import="livre.Livre"%>
<%@page import="java.util.List"%>
<%@include file="template_header.jsp" %>

<div align="center">
    <h3>Meilleures ventes</h3>
</div>
<%

List<Livre> listTopLivre = (List<Livre>)request.getAttribute("topVente");

LibJsp.afficherListLivre(out, listTopLivre);

%>
<br />

<%@include file="template_footer.jsp" %>
