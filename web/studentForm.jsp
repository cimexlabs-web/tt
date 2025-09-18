jsp

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Table Tennis Registration</title>
    <link rel="stylesheet" href="style.css">
    <script src="script.js" defer></script>
</head>
<body>
    <div class="form-container">
        <h2>Table Tennis Registration Form</h2>
        <form action="submitForm.jsp" method="post">
            <label for="name">Full Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="batch">Batch:</label>
            <input type="text" id="batch" name="batch" required>

            <label for="degree">Degree:</label>
            <input type="text" id="degree" name="degree" required>

            <label for="faculty">Faculty:</label>
            <input type="text" id="faculty" name="faculty" required>

            <label for="studentId">Student ID:</label>
            <input type="text" id="studentId" name="studentId" required>

            <label>Gender:</label>
            <select name="gender" id="gender" required>
                <option value="">--Select Gender--</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
            </select>

            <label for="whatsapp">WhatsApp Number:</label>
            <input type="text" id="whatsapp" name="whatsapp" required>

            <label>Do you have Table Tennis experience?</label>
            <select id="experience" name="experience" onchange="toggleExperienceFields()" required>
                <option value="">--Select Option--</option>
                <option value="No">No</option>
                <option value="Yes">Yes</option>
            </select>

            <div id="experienceFields" class="hidden">
                <label for="yearStarted">Year Started Playing:</label>
                <input type="number" id="yearStarted" name="yearStarted" placeholder="e.g. 2018">

                <label for="achievements">Achievements:</label>
                <textarea id="achievements" name="achievements" placeholder="List your achievements"></textarea>
            </div>

            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
