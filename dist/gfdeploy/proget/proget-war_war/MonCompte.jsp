<%-- 
    Document   : MonCompte
    Created on : 13 déc. 2011, 13:43:07
    Author     : Treemo
--%>

<%@page import="java.util.ArrayList"%>
<%

String nom = "";
String prenom = "";
String adresse = "";
String email = "";


if (request.getParameter("prenom") != null)
    prenom = request.getParameter("prenom");

if (request.getParameter("nom") != null)
    nom = request.getParameter("nom");

if (request.getParameter("adresse") != null)
    adresse = request.getParameter("adresse");

if (request.getParameter("email") != null)
    email = request.getParameter("email");

%>

<%@include file="template_header.jsp" %>
        <form name="session" method="POST" action="MonCompte" >
                <table>
                        <tr>
                                <td>Nom : </td>
                                <td><input type="text" name="nom" value="<%=nom %>" /> </td>
                        </tr>

                        <tr>
                                <td>Prenom : </td>
                                <td><input type="text" name="prenom" value="<%=prenom %>" /> </td>
                        </tr>

                        <tr>
                                <td>Adresse : </td>
                                <td><textarea name="adresse" ><%=adresse %></textarea></td>
                        </tr>

                        <tr>
                                <td>Email : </td>
                                <td><input type="text" name="email" value="<%=email %>" /></td>
                        </tr>

                        <tr>
                                <td colspan="2" style="text-align:center"><input type="submit" value="Enregistrement" /></td>
                        </tr>
                </table>
        </form>

<%@include file="template_footer.jsp" %>
