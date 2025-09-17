<%@page import="java.sql.ResultSet"%>
<%@page import="dao.playerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/search.css">

<div class="container">
    <h2>Player Details</h2>

    <%
        String sid = request.getParameter("id");
        playerDAO p = new playerDAO();
        ResultSet r = p.getDetails(sid);

        if(r.next()) {
    %>
    <form action="updateField" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="<%= sid %>">
        <table>
            <tr>
                <th>First Name</th>
                <td><%= r.getString("fname") %></td>
                <td>
                    <input type="text" name="fname" placeholder="New First Name">
                    <button type="submit" name="field" value="fname">Update</button>
                </td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td><%= r.getString("lname") %></td>
                <td>
                    <input type="text" name="lname" placeholder="New Last Name">
                    <button type="submit" name="field" value="lname">Update</button>
                </td>
            </tr>
            <tr>
                <th>Batch</th>
                <td><%= r.getString("batch") %></td>
                <td>
                    <input type="text" name="batch" placeholder="New Batch">
                    <button type="submit" name="field" value="batch">Update</button>
                </td>
            </tr>
            <tr>
                <th>Faculty</th>
                <td><%= r.getString("faculty") %></td>
                <td>
                    <input type="text" name="faculty" placeholder="New Faculty">
                    <button type="submit" name="field" value="faculty">Update</button>
                </td>
            </tr>
            <tr>
                <th>Student ID</th>
                <td><%= r.getString("sid") %></td>
                <td>
                    <input type="text" name="sid" placeholder="New Student ID">
                    <button type="submit" name="field" value="sid">Update</button>
                </td>
            </tr>
            <tr>
                <th>Gender</th>
                <td><%= r.getString("gender") %></td>
                <td>
                    <input type="text" name="gender" placeholder="New Gender">
                    <button type="submit" name="field" value="gender">Update</button>
                </td>
            </tr>
            <tr>
                <th>Phone</th>
                <td><%= r.getString("phone") %></td>
                <td>
                    <input type="text" name="phone" placeholder="New Phone">
                    <button type="submit" name="field" value="phone">Update</button>
                </td>
            </tr>
            <tr>
                <th>School</th>
                <td><%= r.getString("school") %></td>
                <td>
                    <input type="text" name="school" placeholder="New School">
                    <button type="submit" name="field" value="school">Update</button>
                </td>
            </tr>
            <tr>
                <th>Achievement</th>
                <td><%= r.getString("achievement") %></td>
                <td>
                    <input type="text" name="achievement" placeholder="New Achievement">
                    <button type="submit" name="field" value="achievement">Update</button>
                </td>
            </tr>
            <tr>
                <th>Photo</th>
                <td><img src="searchImage?id=<%=id%>" alt="Player Photo" style="width:100px; height:100px;"></td>
                <td>
                    <input type="file" name="photo" accept="image/*">
                    <button type="submit" name="field" value="photo">Update</button>
                </td>
            </tr>
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
