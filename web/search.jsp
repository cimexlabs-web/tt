<%@page import="java.sql.ResultSet"%>
<%@page import="dao.playerDAO"%>
<link rel="stylesheet" href="css/search.css">
<div class="container">
    <h2>Player Details</h2>
    <%
        String id= request.getParameter("id");
        playerDAO p = new playerDAO();
        ResultSet r = p.getDetails(id);

        if(r.next()) {
    %>
    <table>
        <tr>
            <th>First Name</th>
            <td data-label="First Name"><%= r.getString("fname") %></td>
            
        </tr>
        <tr>
            <th>Last Name</th>
            <td data-label="Last Name"><%= r.getString("lname") %></td>
        </tr>
        <tr>
            <th>Batch</th>
            <td data-label="Batch"><%= r.getString("batch") %></td>
        </tr>
        <tr>
            <th>Faculty</th>
            <td data-label="Faculty"><%= r.getString("faculty") %></td>
        </tr>
        <tr>
            <th>Student ID</th>
            <td data-label="Student ID"><%= r.getString("sid") %></td>
        </tr>
        <tr>
            <th>Gender</th>
            <td data-label="Gender"><%= r.getString("gender") %></td>
        </tr>
        <tr>
            <th>Phone</th>
            <td data-label="Phone"><%= r.getString("phone") %></td>
        </tr>
        <tr>
            <th>School</th>
            <td data-label="School"><%= r.getString("school") %></td>
        </tr>
        <tr>
            <th>Photo</th>
            <td data-label="photo"><img src="searchImage?id=<%=id%>" alt="Table tennis match at NSBM"></td>
        </tr>
    </table>
    <%
        
        } else {
    %>
        <p style="text-align:center; color:red;">No player found with ID <%= id %></p>
    <%
        }
    %>
</div>
