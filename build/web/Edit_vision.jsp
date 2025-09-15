<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Vision</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        .edit-section {
            max-width: 900px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
        .edit-header {
            text-align: center;
            margin-bottom: 20px;
        }
        .image-wrapper {
            display: flex;
            justify-content: space-between;
            gap: 20px;
            align-items: center;
            margin-bottom: 15px;
        }
        .db-image {
            width: 200px;
            height: 200px;
            border: 2px solid #ccc;
            border-radius: 10px;
            background-size: cover;
            background-position: center;
        }
        .image-placeholder {
            width: 200px;
            height: 200px;
            border: 2px dashed #aaa;
            border-radius: 10px;
            background-size: cover;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
            color: #aaa;
            cursor: pointer;
            transition: 0.3s;
        }
        .image-placeholder.dragover {
            border-color: #4CAF50;
            background-color: #f0fff0;
            color: #4CAF50;
        }
        input[type="file"] {
            display: none;
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
        textarea {
            width: 100%;
            min-height: 120px;
            padding: 10px;
            font-size: 16px;
            border-radius: 8px;
            border: 1px solid #ccc;
            margin-bottom: 15px;
        }
        .back-btn {
            display: inline-block;
            margin: 20px;
            padding: 10px 20px;
            background: #555;
            color: white;
            text-decoration: none;
            border-radius: 8px;
        }
        .back-btn:hover {
            background: #333;
        }
    </style>
</head>
<body>
<%
    if (session == null || !("SAdmin".equals(session.getAttribute("role")) || "NAdmin".equals(session.getAttribute("role")))) {
        response.sendRedirect("login.html");
        return;
    }

    // ==== Placeholder for DB/Servlet image fetch ====
    // Example: store the vision photo URL from DB
    String visionImage = "fetchVisionImageServlet?id=1"; 
%>

<!-- Back Button -->
<a href="javascript:history.back()" class="back-btn">← Back</a>

<!-- Vision Text -->
<div class="edit-section">
    <div class="edit-header"><h1>Edit Vision Text</h1></div>
    <form action="updateVisionServlet" method="post">
        <textarea name="visionText" placeholder="Write Vision text here..."><%= request.getAttribute("visionText") != null ? request.getAttribute("visionText") : "" %></textarea>
        <div style="text-align:center;">
            <button type="submit" class="submit-btn">Update Text</button>
        </div>
    </form>
</div>

<!-- Vision Photo -->
<div class="edit-section">
    <div class="edit-header"><h1>Change Vision Photo</h1></div>
    <div class="image-wrapper">
        <!-- Existing DB Image -->
        <div class="db-image" style="background-image:url('<%= visionImage %>');"></div>

        <!-- Upload New Image -->
        <form action="uploadVisionServlet" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="1"> <!-- ID for Vision photo -->
            <label for="visionPhotoUpload">
                <div class="image-placeholder" id="visionPlaceholder">Click or Drag & Drop Image Here</div>
            </label>
            <input type="file" name="image" id="visionPhotoUpload" accept="image/*" onchange="previewVisionImage(event)">
            <div style="text-align:center;">
                <button type="submit" class="submit-btn">Submit</button>
            </div>
        </form>
    </div>
</div>

<script>
function previewVisionImage(event){
    const placeholder = document.getElementById("visionPlaceholder");
    const fileInput = document.getElementById("visionPhotoUpload");
    const file = event.target.files[0];
    if(file){
        const reader = new FileReader();
        reader.onload = function(e){
            placeholder.style.backgroundImage = "url('" + e.target.result + "')";
            placeholder.innerHTML = "";
        }
        reader.readAsDataURL(file);
    }
}

// Drag & Drop for Vision photo
const visionPlaceholder = document.getElementById("visionPlaceholder");
const visionFileInput = document.getElementById("visionPhotoUpload");

visionPlaceholder.addEventListener("dragover", function(e){
    e.preventDefault();
    visionPlaceholder.classList.add("dragover");
});

visionPlaceholder.addEventListener("dragleave", function(e){
    e.preventDefault();
    visionPlaceholder.classList.remove("dragover");
});

visionPlaceholder.addEventListener("drop", function(e){
    e.preventDefault();
    visionPlaceholder.classList.remove("dragover");
    const file = e.dataTransfer.files[0];
    if(file){
        visionFileInput.files = e.dataTransfer.files;
        previewVisionImage({target:{files:[file]}});
    }
});
</script>

</body>
</html>
