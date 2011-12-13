<%-- 
    Document   : login
    Created on : 9 déc. 2011, 09:00:40
    Author     : Treemo
--%>

<%

String login = "";
String pass = "";
String loginResult = "";

if (request.getParameter("login") != null)
    login = request.getParameter("login");

if (request.getParameter("password") != null)
    pass = request.getParameter("password");

%>

<%@include file="template_header.jsp" %>

        <form name="session" method="POST" action="Login" >
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
                                <td style="text-align:center"><input type="submit" name="valider" /></td>
                                <td style="text-align:center"><a href="Enregistrement">Enregistrement</a></td>
                        </tr>
                </table>
        </form>

<%@include file="template_footer.jsp" %>
