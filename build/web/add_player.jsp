<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Player</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- Important for mobile -->
    <link rel="stylesheet" type="text/css" href="css/formStyle.css"> 
</head>
<body>
    <div class="form-container">
        <h1>Add New Player</h1>
        <form action="uploadPlayer" method="post" enctype="multipart/form-data">
            
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
                <select name="faculty">
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
                <select name="gender">
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
                <input type="text" name="mail"  required>
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
                <select name="team">
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
                <button type="submit">Add Player</button>
            </div>
        </form>
    </div>
</body>
</html>
