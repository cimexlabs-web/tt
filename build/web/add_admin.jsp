<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/admin.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Admin</title>
    <script>
        function validateForm() {
            let form = document.forms[0];

            let name = form.name.value.trim();
            let username = form.username.value.trim();
            let mail = form.mail.value.trim();
            let pws = form.pws.value;
            let rpws = form.rpws.value;
            let type = form.type.value;

            // 1. Name validation (no numbers)
            if (!isNaN(name)) {
                alert("❌ Name cannot be only numbers");
                return false;
            }

            // 2. Username validation (min 5 chars, no spaces)
            if (username.length < 5 || username.includes(" ")) {
                alert("❌ Username must be at least 5 characters and contain no spaces");
                return false;
            }

            // 3. Email validation
            let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailPattern.test(mail)) {
                alert("❌ Please enter a valid email address");
                return false;
            }

            // 4. Password validation (min 6 chars)
            if (pws.length < 6) {
                alert("❌ Password must be at least 6 characters long");
                return false;
            }

            // 5. Re-enter password validation
            if (pws !== rpws) {
                alert("❌ Passwords do not match");
                return false;
            }

            // 6. Type validation
            if (type === "") {
                alert("❌ Please select an admin type");
                return false;
            }

            return true; // ✅ allow submit
        }
    </script>
</head>
<body>
    <%
    if (session == null || !("SAdmin".equals(session.getAttribute("role")))) {
        response.sendRedirect("login.html");
        return;
    }%>
    <h1>Add Admin</h1>
    <form action="admin" method="post" onsubmit="return validateForm()">
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
                <select name="type" required>
                    <option value="">--Select type--</option>
                    <option value="NAdmin">Normal Admin</option>
                    <option value="SAdmin">Super Admin</option>
                </select>
            </div>
            <div>
                <button type="submit">Submit</button>
            </div>
            <div>
                <button type="reset">Reset</button>
            </div>
        </div>
    </form>
</body>
</html>
