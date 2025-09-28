<%-- 
    Document   : change_admin
    Created on : Sep 27, 2025, 10:35:05 AM
    Author     : Akila Perera
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="dao.userDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Users</title>
    </head>
    <body>
        <div class="nadmin">
            <h1>Normal Admin List</h1>
            <%
                if(session==null || !"SAdmin".equals(session.getAttribute("role")))
                {
                    response.sendRedirect("login.html");
                }
                
                userDAO user= new userDAO();
                ResultSet rs= user.viewUser("NAdmin");
            
                while(rs.next())
                {
            %>
            
            <div class="container">
                <div>
                    <%=rs.getString("name")%>
                </div>
                <div>
                    <%=rs.getString("mail")%>
                </div>
                <div>
                    <a href="admin?id=<%=rs.getString("id")%>">Delete</a>
                </div>
            </div>
            <%}
            rs.close();
            %>
        </div>
        
        <div class="sadmin">
            <h1>Super Admin List</h1>
            
            <%
                ResultSet rs2= user.viewUser("SAdmin");
                
                while(rs2.next())
                {
            %>
            
            <div class="container">
                <div>
                    <%=rs2.getString("name")%>
                </div>
                <div>
                    <%=rs2.getString("mail")%>
                </div>
                <div>
                    <a href="admin?id=<%=rs2.getString("id")%>">Delete</a>
                </div>
                
            </div>
            
            <%}%>
        </div>
        
        <div class="btn">
            <a href="add_admin.jsp">Add Admin</a>
        </div>
    </body>
</html>
