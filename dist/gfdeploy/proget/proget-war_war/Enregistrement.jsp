<%-- 
    Document   : Enregistrement
    Created on : 9 déc. 2011, 15:18:05
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

if (request.getParameter("login") != null && request.getParameter("password") != null)
    loginResult = "<b>Login / mot de passe incorect</b>";

%>

<%@include file="template_header.jsp" %>

        <%=loginResult %>
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
                                <td colspan="2" style="text-align:center"><input type="submit" name="valider" /></td>
                        </tr>
                </table>
        </form>

<%@include file="template_footer.jsp" %>

