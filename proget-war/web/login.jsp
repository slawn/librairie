<%-- 
    Document   : login
    Created on : 9 déc. 2011, 09:00:40
    Author     : Treemo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="session" method="POST" action="session.do" >
                <table>
                        <tr>
                                <td>Login : </td>
                                <td><input type="text" name="login" /> </td>
                        </tr>

                        <tr>
                                <td>Mot de passe : </td>
                                <td><input type="password" name="password" /> </td>
                        </tr>

                        <tr>
                                <td colspan="2" style="text-align:center"><input type="submit" name="valider" /></td>
                        </tr>
                </table>
        </form>
    </body>
</html>
