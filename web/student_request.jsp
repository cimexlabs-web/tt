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
    <link rel="stylesheet" href="css/student_req.css">
    <title>QR Requests</title>
</head>
<body>
    <h1 class="page-title">QR Requests</h1>
    <div class="card-container">
        <%
            if (session == null || !("SAdmin".equals(session.getAttribute("role")) || "NAdmin".equals(session.getAttribute("role"))))
        {
            response.sendRedirect("login.html");
            return;
        }
            playerDAO p = new playerDAO();
            ResultSet r = p.getRequestDetail();
            while(r.next()) {
                String id = r.getString("id");
        %>
        <div class="card">
            <h2><%= r.getString("name") %></h2>
            <div class="card-details">
                <div class="detail"><span>ID:</span> <%= r.getString("id") %></div>
                <div class="detail"><span>Batch:</span> <%= r.getString("batch") %></div>
                <div class="detail"><span>Degree:</span> <%= r.getString("degree") %></div>
                <div class="detail"><span>Faculty:</span> <%= r.getString("faculty") %></div>
                <div class="detail"><span>Student ID:</span> <%= r.getString("sid") %></div>
                <div class="detail"><span>Gender:</span> <%= r.getString("gender") %></div>
                <div class="detail"><span>Phone:</span> <%= r.getString("phone") %></div>
                <div class="detail"><span>Email:</span> <%= r.getString("mail") %></div>
                <div class="detail"><span>School:</span> <%= r.getString("school") %></div>
                <div class="detail"><span>Experience:</span> <%= r.getString("experience") %></div>
                <div class="detail"><span>Start Day:</span> <%= r.getString("start_date") %></div>
                <div class="detail"><span>Achievement:</span> <%= r.getString("achievement") %></div>
            </div>

            <!-- Action buttons -->
            <div class="btn-group">
                <form action="Approve" method="get" style="flex:1;">
                    <!-- hidden fields -->
                    <input type="hidden" name="id" value="<%= id %>">
                    <input type="hidden" name="mail" value="<%= r.getString("mail") %>">
                    <input type="hidden" name="name" value="<%= r.getString("name") %>">
                    <input type="hidden" name="batch" value="<%= r.getString("batch") %>">
                    <input type="hidden" name="faculty" value="<%= r.getString("faculty") %>">
                    <input type="hidden" name="sid" value="<%= r.getString("sid") %>">
                    <input type="hidden" name="gender" value="<%= r.getString("gender") %>">
                    <input type="hidden" name="phone" value="<%= r.getString("phone") %>">
                    
                    <input type="hidden" name="school" value="<%= r.getString("school") %>">
                    <input type="hidden" name="achievement" value="<%= r.getString("achievement") %>">

                    <!-- team select -->
                    <select name="team" id="team-<%= id %>" class="team-select" required>
                        <option value="">-- Select Team --</option>
                        <option value="boyA">Boys Team A</option>
                        <option value="boyB">Boys Team B</option>
                        <option value="girlA">Girls Team A</option>
                        <option value="girlB">Girls Team B</option>
                        <option value="reject">reject</option>
                    </select>

                    <button type="submit" name="status" value="approved" class="btn approve">
                        Approve
                    </button>
                </form>

                <a href="Approve?id=<%= id %>&status=rejected" class="btn reject">
                    Not Approve
                </a>
            </div>
        </div>
        <%
            }
        %>
    </div>
</body>
</html>
