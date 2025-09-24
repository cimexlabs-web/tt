<%-- 
    Document   : student_request
    Created on : Sep 24, 2025, 11:27:48 PM
    Author     : Akila Perera
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="dao.playerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/card_request.css">
    <title>QR Requests</title>
</head>
<body>
    <h1 class="page-title">QR Requests</h1>
    <div class="card-container">
        <%
            playerDAO p = new playerDAO();
            ResultSet r = p.getRequestDetail();
            while(r.next()) {
                String id = r.getString("id");
        %>
        <div class="card">
            <h2><%= r.getString("name") %></h2>
            <p><strong>ID:</strong> <%= id %></p>
            <p><strong>Batch:</strong> <%= r.getString("batch") %></p>
            <p><strong>Degree:</strong> <%= r.getString("degree") %></p>
            <p><strong>Faculty:</strong> <%= r.getString("faculty") %></p>
            <p><strong>Student ID:</strong> <%= r.getString("sid") %></p>
            <p><strong>Gender:</strong> <%= r.getString("gender") %></p>
            <p><strong>Phone:</strong> <%= r.getString("phone") %></p>
            <p><strong>Phone:</strong> <%= r.getString("Student_Mail") %></p>
            <p><strong>Experience:</strong> <%= r.getString("experience") %></p>
            <p><strong>Start Day:</strong> <%= r.getString("start_date") %></p>
            <p><strong>Achievement:</strong> <%= r.getString("achievement") %></p>

            <!-- Team Selection -->
            <label for="team-<%= id %>">Assign Team:</label>
            <select id="team-<%= id %>" class="team-select">
                <option value="">-- Select Team --</option>
                <option value="Team A">Team A</option>
                <option value="Team B">Team B</option>
                <option value="Team C">Team C</option>
            </select>

            <!-- Action Links -->
            <div class="btn-group">
                <a href="ApproveServlet?id=<%= id %>&status=approved" class="btn approve">Approve</a>
                <a href="ApproveServlet?id=<%= id %>&status=rejected" class="btn reject">Not Approve</a>
            </div>
        </div>
        <%
            }
        %>
    </div>
</body>
</html>
