<%-- 
    Document   : view_messages
    Created on : Sep 28, 2025, 3:38:23 PM
    Author     : Akila Perera
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="dao.webDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/view.css">
        <script>
    function x()
        {
           return window.confirm("Are you sure ?");
            
        }
    </script>
        <title>Web Messages</title>
    </head>
    <body>
        <%
    if (session == null || !("SAdmin".equals(session.getAttribute("role")) || "NAdmin".equals(session.getAttribute("role")))) {
        response.sendRedirect("login.html");
        return;
    }
    
        String team = request.getParameter("team");
        webDAO p = new webDAO();
        
        ResultSet r=p.getMsg();
    %>
    
    <h2>Web Messages</h2>
    
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>Name</th>
            <th>Mail</th>
            <th>Message</th>
            
            
        </tr>
        <%
            while(r.next()) {
        %>
        <tr>
    <td data-label="First Name"><%= r.getString("name") %></td>
    <td data-label="Last Name"><%= r.getString("email") %></td>
    <td data-label="School"><%= r.getString("message") %></td>
    <td><a href="deleteMsg?id=<%= r.getString("id")%>" onclick="return x()">Delete</a></td>
    
</tr>

        <%
            }
        %>
    </table>
</body>
</html>
