<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="util.DBconnection"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/web_edit.css">
    <title>Edit Achievements</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        .edit-section {
            max-width: 900px;
            margin: 40px auto;
            background: #fff;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
        .edit-header {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 6px;
        }
        input[type="text"], input[type="number"], textarea {
            width: 100%;
            padding: 10px;
            border-radius: 8px;
            border: 1px solid #ccc;
            font-size: 15px;
        }
        input[type="file"] {
            margin-top: 5px;
        }
        .submit-btn {
            padding: 10px 20px;
            background: #4CAF50;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
        }
        .submit-btn:hover {
            background: #45a049;
        }
        .achievement-card {
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 15px;
            margin-bottom: 20px;
            background: #fafafa;
        }
        .achievement-card img {
            max-width: 150px;
            border-radius: 6px;
            display: block;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    
    <%
        if (session == null || !("SAdmin".equals(session.getAttribute("role")) || "NAdmin".equals(session.getAttribute("role")))) {
        response.sendRedirect("login.html");
        return;
    }
        %>

<!-- Add New Achievement -->
<div class="edit-section">
    
    <div class="edit-header"><h1>Add New Achievement</h1></div>
    <form action="uploadAchievement" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="achiv">
        <div class="form-group">
            <label>Year</label>
            <input type="number" name="year" required>
        </div>
        <div class="form-group">
            <label>Title</label>
            <input type="text" name="title" required>
        </div>
        <div class="form-group">
            <label>Achievement Photo</label>
            <input type="file" name="photo" accept="image/*" required>
        </div>
        <div class="form-group">
            <label>Bullet Point 1</label>
            <input type="text" name="point1">
        </div>
        <div class="form-group">
            <label>Bullet Point 2</label>
            <input type="text" name="point2">
        </div>
        <div class="form-group">
            <label>Bullet Point 3</label>
            <input type="text" name="point3">
        </div>
        <div class="form-group">
            <label>Bullet Point 4</label>
            <input type="text" name="point4">
        </div>
        <div class="form-group">
            <label>Bullet Point 5</label>
            <input type="text" name="point5">
        </div>
        <div style="text-align:center;">
            <button type="submit" class="submit-btn">Add Achievement</button>
        </div>
    </form>
</div>




</body>
</html>
