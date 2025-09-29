<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/web_edit.css">

    <title>Edit Vision</title>
    <script>
    function x()
        {
           return window.confirm("Are you sure ?");
            
        }
    </script>
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

    <form action="uploadEdit" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="7">
        <textarea name="txt" placeholder="Write Vision text here..." required><%= request.getAttribute("visionText") != null ? request.getAttribute("visionText") : "" %></textarea>
            <button type="submit" class="submit-btn" onclick="return x()">Update Text</button>
        </div>
    </form>
</div>

<!-- Vision Photo -->
<div class="edit-section">
    <div class="edit-header"><h1>Change Vision Photo</h1></div>
    <div class="image-wrapper">

        <div class="db-image" >
            <img src="mainImage?id=7" alt="Database images">
        </div>

        <!-- Upload New Image -->
        <form action="uploadEdit" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="7"> <!-- ID for Vision photo -->
            <label for="visionPhotoUpload">
                <div class="image-placeholder" id="visionPlaceholder">Click or Drag & Drop Image Here</div>
            </label>
            <input type="file" name="image7" id="visionPhotoUpload" accept="image/*" onchange="previewVisionImage(event)" required>
            <button type="submit" class="submit-btn" onclick="return x()">Update Text</button>
            

        
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

</html>

