<%-- 
    Document   : cerrarSesion
    Created on : 31/12/2020, 02:56:48 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession sesionOk = request.getSession();
    sesionOk.invalidate();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:forward page="index.jsp"/>
    </body>
</html>
