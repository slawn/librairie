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
    <h3>Recherche</h3>
</div>
<%

List<Livre> listLivre = (List<Livre>)request.getAttribute("recherche");

LibJsp.afficherListLivre(out, listLivre);

%>
<br />

<%@include file="template_footer.jsp" %>
