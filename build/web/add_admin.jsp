<%-- 
    Document   : add_admin
    Created on : Sep 27, 2025, 12:14:27 PM
    Author     : Akila Perera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Admin</title>
    </head>
    <body>
        <h1>Add Admin</h1>
        <form action="admin" method="post">
        <div class="container">
            <div>
                <input type="text" name="name" placeholder="Enter name" required>
            </div>
            <div>
                <input type="text" name="username" placeholder="Enter username" required>
            </div>
            <div>
                <input type="text" name="mail" placeholder="Enter mail" required>
            </div>
            <div>
                <input type="password" name="pws" placeholder="Enter new password" required>
            </div>
            <div>
                <input type="password" name="rpws" placeholder="Re-enter password" required>
            </div>
            <div>
                <select name="type">
                    <option value="">--Select type--</option>
                    <option value="NAdmin">Normal Admin</option>
                    <option value="SAdmin">Super Admin</option>
                </select>
            </div>
            <div>
                <button type="submit">Submit</button>
            </div>
            <div>
                <button type="reset">reset</button>
            </div>
        </div>
        </form>
    </body>
</html>
