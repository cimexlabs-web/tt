<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="mainCss.css">
    <title>Select team</title>
</head>
<body class="admin-page-body">
    <%
        if (session == null || !("SAdmin".equals(session.getAttribute("role")) || "NAdmin".equals(session.getAttribute("role"))))
        {
            response.sendRedirect("login.html");
            return;
        }
        
        String dashboardPage = "NAdmin.jsp"; 
        if ("SAdmin".equals(session.getAttribute("role"))) {
            dashboardPage = "SAdmin.jsp";
        }
    %>
    
    <div class="admin-page-container">
        <div class="admin-page-header">
            <h1>Select Team</h1>
            
        </div>
        
        <div class="admin-panel-button">
            <a href="view_team.jsp?team=boyA" class="admin-page-btn">
                <i class="fas fa-people-group"></i>
                <input type="hidden" name="team" value="boyA">
                <span>Boys Team A</span>
            </a>
            <a href="view_team.jsp?team=boyB" class="admin-page-btn">
                <i class="fas fa-people-group"></i>
                <input type="hidden" value="boyB" name="team">
                <span>Boys Team B</span>
            </a>
            <a href="view_team.jsp?team=girlA" class="admin-page-btn">
                <i class="fas fa-people-group"></i>
                <input type="hidden" value="girlA" name="team">
                <span>Girls Team A</span>
            </a>
            <a href="view_team.jsp?team=girlB" class="admin-page-btn">
                <i class="fas fa-people-group"></i>
                <input type="hidden" value="girlB" name="team">
                <span>Girls Team B</span>
            </a>
        </div>
        
        <div style="text-align: center; margin-top: 30px;">
            <a href="<%= dashboardPage %>" class="admin-back-btn">
                <i class="fas fa-arrow-left"></i> Back to Dashboard
            </a>
        </div>
    </div>
</body>
</html>