
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.playerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/view.css">
    <title>View Players</title>
    
</head>
<body>
    <%
        String team = request.getParameter("team");
        playerDAO p = new playerDAO();
        
        ResultSet r = p.getPlayerDetail(team);
    %>
    
    <h2>Players in Team: <%= team %></h2>
    
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Batch</th>
            <th>Faculty</th>
            <th>Student ID</th>
            <th>Gender</th>
            <th>Phone</th>
            <th>School</th>
            
        </tr>
        <%
            while(r.next()) {
        %>
        <tr>
    <td data-label="First Name"><%= r.getString("fname") %></td>
    <td data-label="Last Name"><%= r.getString("lname") %></td>
    <td data-label="Batch"><%= r.getString("batch") %></td>
    <td data-label="Faculty"><%= r.getString("faculty") %></td>
    <td data-label="Student ID"><%= r.getString("sid") %></td>
    <td data-label="Gender"><%= r.getString("gender") %></td>
    <td data-label="Phone"><%= r.getString("phone") %></td>
    <td data-label="School"><%= r.getString("school") %></td>
    
</tr>

        <%
            }
        %>
    </table>
</body>
</html>
