<%-- 
    Document   : edit_players
    Created on : Sep 17, 2025, 7:28:09 PM
    Author     : Akila Perera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/editPlayers.css">
        <title>Edit Player</title>
    </head>
    <body>
        <%
    if (session == null || !("SAdmin".equals(session.getAttribute("role")) || "NAdmin".equals(session.getAttribute("role")))) {
        response.sendRedirect("login.html");
        return;
    }%>
        <div class="container">
            <form action="search.jsp" method="post">
            <div class="input">
                <input type="text" name="id" placeholder="Enter Student ID Number" required>
            </div>
                <div class="search">
                    <button type="submit">Search</button>
                </div>
            </form>
        </div>
    </body>
</html>
