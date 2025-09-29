
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Table Tennis Registration</title>
    
    
    <link rel="stylesheet" href="css/studentForm.css">
    
    <script>
        function x() {
        let name = document.form.name.value.trim();
        let batch = document.form.batch.value.trim();
        let studentId = document.form.studentId.value.trim();
        let number= document.form.whatsapp.length.trim();
        
        // Name should NOT be a number
        if (!isNaN(name)) {
            alert("❌ Please don't use numbers for the name");
            return false;
        }

        // Batch should be numbers only
        if (isNaN(batch)) {
            alert("❌ Batch must be a number");
            return false;
        }

        // Student ID must be exactly 5 digits (numbers only)
        if (isNaN(studentId) || studentId.length !== 5) {
            alert("❌ Student ID must be a 5-digit number");
            return false;
        }
        
        if (isNaN(number) || number.length !== 10) {
            alert("❌ please check your phone number");
            return false;
        }

        return true; // allow submission
    }
    </script>
    
    
</head>
<body>
    <div class="form-container">
        <img class="logo" src="mainImage?id=1" alt="Logo">
        <h2>Table Tennis Registration Form</h2>
        <form action="submit" method="post" name="form"  onsubmit="return x()" >
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
            
            <label for="mail">Student Mail:</label>
            <input type="text" id="mail" name="mail" required>
            
            <label for="school">School:</label>
            <input type="text" id="school" name="school" required>
            
            <label>Do you have Table Tennis experience?</label>
            <select id="experience" name="experience"  required>
                <option value="">--Select Option--</option>
                <option value="No">No</option>
                <option value="Yes">Yes</option>
            </select>
            <label style=" text-align: center; color: red">If you have experience, please fill below </label>
            
                <label for="yearStarted">Year Started Playing:</label>
                <input type="text" id="yearStarted" name="yearStarted" placeholder="e.g. 2018">

                <label for="achievements">Achievements:</label>
                <textarea id="achievements" name="achievements" placeholder="List your achievements"></textarea>
            

                <button type="submit">Submit</button>
            
        </form>
    </div>
    
</body>
</html>
