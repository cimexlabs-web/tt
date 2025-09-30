<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Player</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <link rel="stylesheet" type="text/css" href="css/formStyle.css"> 
    
    <script>
        function validateForm() {
            let name = document.forms["playerForm"]["fname"].value.trim();
            let batch = document.forms["playerForm"]["batch"].value.trim();
            let phone = document.forms["playerForm"]["phone"].value.trim();
            let mail = document.forms["playerForm"]["mail"].value.trim();
            let sid = document.forms["playerForm"]["sid"].value.trim();

            // Full name validation: only letters and spaces
            let nameRegex = /^[A-Za-z\s]+$/;
            if (!nameRegex.test(name)) {
                alert("Full name should only contain letters and spaces.");
                return false;
            }

            // Batch format validation: e.g., 22.1
            let batchRegex = /^[0-9]{2}\.[0-9]$/;
            if (!batchRegex.test(batch)) {
                alert("Batch must be in format EX: 22.1");
                return false;
            }

            // Phone validation: 10 digits starting with 0
            let phoneRegex = /^0\d{9}$/;
            if (!phoneRegex.test(phone)) {
                alert("Enter a valid phone number (EX: 0701231231).");
                return false;
            }

            // Email validation
            let emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
            if (!emailRegex.test(mail)) {
                alert("Enter a valid email address.");
                return false;
            }

            // SID validation (optional but good practice)
            if (sid !== "" && !/^[0-9A-Za-z]+$/.test(sid)) {
                alert("SID should only contain letters and numbers.");
                return false;
            }

            return true; // All validations passed
        }
    </script>
</head>
<body>
    <%
    if (session == null || !("SAdmin".equals(session.getAttribute("role")) || "NAdmin".equals(session.getAttribute("role")))) {
        response.sendRedirect("login.html");
        return;
    }%>
    <div class="form-container">
        <h1>Add New Player</h1>
        <form name="playerForm" action="uploadPlayer" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
            
            <div class="form-group">
                <label>Full Name:</label>
                <input type="text" name="fname" required>
            </div>
            
            <div class="form-group">
                <label>Batch:</label>
                <input type="text" name="batch" placeholder="EX: 22.1" required>
            </div>
            <div class="form-group">
                <label>Faculty:</label>
                <select name="faculty" required>
                    <option value="">-- Select Faculty --</option>
                    <option value="foc">FOC</option>
                    <option value="fob">FOB</option>
                    <option value="foe">FOE</option>
                </select>
            </div>
            <div class="form-group">
                <label>SID:</label>
                <input type="text" name="sid">
            </div>
            <div class="form-group">
                <label>Gender:</label>
                <select name="gender" required>
                    <option value="">-- Select Gender --</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
            </div>
            <div class="form-group">
                <label>Phone:</label>
                <input type="text" name="phone" placeholder="EX: 0701231231" required>
            </div>
            <div class="form-group">
                <label>Student Mail:</label>
                <input type="text" name="mail" required>
            </div>
            <div class="form-group">
                <label>School:</label>
                <input type="text" name="school" required>
            </div>
            <div class="form-group">
                <label>Achievements:</label>
                <textarea name="achiev"></textarea>
            </div>
            <div class="form-group">
                <label>Team:</label>
                <select name="team" required>
                    <option value="">-- Select Team --</option>
                    <option value="boyA">Boys A</option>
                    <option value="boyB">Boys B</option>
                    <option value="girlA">Girls A</option>
                    <option value="girlB">Girls B</option>
                </select>
            </div>
            <div class="form-group">
                <label>Photo:</label>
                <input type="file" name="photo" accept="image/*" required>
            </div>
            <div class="form-group submit-btn">
                <button type="submit">Add Player</button><br>
                <a href="javascript:history.back()" class="btn">Back</a> 
            </div>
        </form>
    </div>
</body>
</html>
