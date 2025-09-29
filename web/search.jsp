<%@page import="java.sql.ResultSet"%>
<%@page import="dao.playerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/searchPlayer.css">

<div class="container">
    <h2>Player Details</h2>

    <%
        String sid = request.getParameter("id");
        playerDAO p = new playerDAO();
        ResultSet r = p.getDetails(sid);

        if(r.next()) {
    %>
    <form action="updateField" method="post" enctype="multipart/form-data">
        <input type="hidden" name="sid" value="<%= sid %>">
        <table>
            <tr>
                <th>Name</th>
                <td><%= r.getString("name") %></td>
                
            </tr>
            
            <tr>
                <th>Batch</th>
                <td><%= r.getString("batch") %></td>
                
            </tr>
            <tr>
                <th>Faculty</th>
                <td><%= r.getString("faculty") %></td>
                
            </tr>
            <tr>
                <th>Student ID</th>
                <td><%= r.getString("sid") %></td>
                
            </tr>
            <tr>
                <th>Team</th>
                <td><%= r.getString("team") %></td>
                
            </tr>
            <tr>
                <th>Gender</th>
                <td><%= r.getString("gender") %></td>
                
            </tr>
            <tr>
                <th>Phone</th>
                <td><%= r.getString("phone") %></td>
                
            </tr>
            <tr>
                <th>Student Mail</th>
                <td><%= r.getString("mail") %></td>
                
            </tr>
            <tr>
                <th>School</th>
                <td><%= r.getString("school") %></td>
                
            </tr>
            <tr>
                <th>Achievement</th>
                <td><%= r.getString("achievement") %></td>
                
            </tr>
            <tr>
                <th>Photo</th>
                <td><img src="searchImage?id=<%=sid%>" alt="Player Photo" style="width:100px; height:100px;"></td>
                <td>
                    <input type="file" name="photo" accept="image/*">
                    <button type="submit" name="field" value="photo">Update</button>
                </td>
            </tr>
        </table>
    </form>
                <form action="updateField" method="post" enctype="multipart/form-data">
                <table>
                    
            <th>What Field Do You Want To Change ?</th>
            <td>
                <select name="column" required>
                    <option value="name">Name</option>
                    <option value="batch">Batch</option>
                    <option value="faculty">Faculty</option>
                    <option value="sid">Student ID</option>
                    <option value="gender">Gender</option>
                    <option value="phone">phone</option>
                    <option value="mail">Mail</option>
                    <option value="school">School</option>
                    <option value="achievement">Achievement</option>
                    
                </select>
            </td>
                <td>
                    <input type="hidden" name="sid" value="<%= sid %>">
                    <input type="text" name="value" placeholder="Enter New Data" required>
                    <button type="submit" name="field">Update</button>
                </td>
        </table>
    </form>
    <%
        } else {
    %>
        <p style="color:red; text-align:center;">No player found with ID <%= sid %></p>
    <%
        }
    %>
</div>
