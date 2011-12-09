<%-- 
    Document   : Enregistrement
    Created on : 9 déc. 2011, 15:18:05
    Author     : Treemo
--%>

<%@page import="java.util.ArrayList"%>
<%

String login = "";
String pass = "";
String pass2 = "";
String nom = "";
String prenom = "";
String adresse = "";
String email = "";

if (request.getParameter("login") != null)
    login = request.getParameter("login");

if (request.getParameter("password") != null)
    pass = request.getParameter("password");

if (request.getParameter("password2") != null)
    pass2 = request.getParameter("password2");

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
        <form name="session" method="POST" action="Enregistrement" >
                <table>
                        <tr>
                                <td>Login : </td>
                                <td><input type="text" name="login" value="<%=login %>" /> </td>
                        </tr>

                        <tr>
                                <td>Mot de passe : </td>
                                <td><input type="password" name="password" value="<%=pass %>" /> </td>
                        </tr>

                        <tr>
                                <td>Mot de passe (vérification): </td>
                                <td><input type="password" name="password2" value="<%=pass2 %>" /> </td>
                        </tr>

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
                                <td><input type="text" name="adresse" value="<%=adresse %>" /> </td>
                        </tr>

                        <tr>
                                <td>Email : </td>
                                <td><input type="text" name="email" value="<%=email %>" /> </td>
                        </tr>

                        <tr>
                                <td colspan="2" style="text-align:center"><input type="submit" value="Enregistrement" /></td>
                        </tr>
                </table>
        </form>

<%@include file="template_footer.jsp" %>

