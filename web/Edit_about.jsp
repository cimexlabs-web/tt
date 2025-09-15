<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit About</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f4f9; margin: 0; padding: 0; }
        .edit-about { max-width: 900px; margin: 50px auto; background: #fff; padding: 20px; border-radius: 12px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); }
        .edit-header { text-align: center; margin-bottom: 20px; }
        .image-wrapper { display: flex; justify-content: space-between; gap: 20px; align-items: center; margin-bottom: 15px; }
        .db-image, .image-placeholder { width: 200px; height: 200px; border-radius: 10px; background-size: cover; background-position: center; }
        .db-image { border: 2px solid #ccc; display: flex; }
        .image-placeholder { border: 2px dashed #aaa; display: flex; justify-content: center; align-items: center; color: #aaa; cursor: pointer; transition: 0.3s; }
        .image-placeholder.dragover { border-color: #4CAF50; background-color: #f0fff0; color: #4CAF50; }
        input[type="file"] { display: none; }
        .submit-btn { padding: 10px 20px; background: #4CAF50; color: white; border: none; border-radius: 8px; cursor: pointer; }
        .submit-btn:hover { background: #45a049; }
        textarea { width: 100%; min-height: 120px; padding: 10px; font-size: 16px; border-radius: 8px; border: 1px solid #ccc; margin-bottom: 15px; }
        .back-btn { display: inline-block; margin: 20px; padding: 10px 20px; background: #555; color: white; text-decoration: none; border-radius: 8px; }
        .back-btn:hover { background: #333; }
    </style>
</head>
<body>
<%
    if (session == null || !("SAdmin".equals(session.getAttribute("role")) || "NAdmin".equals(session.getAttribute("role")))) {
        response.sendRedirect("login.html");
        return;
    }

    Map<Integer,String> images = new HashMap<>();
    for(int i=1;i<=6;i++){
        images.put(i, "fetchImageServlet?id="+i);
    }
%>

<a href="javascript:history.back()" class="back-btn">← Back</a>

<!-- All Image Uploads -->
<%
    String[] labels = {"LOGO","Cover Photo","Photo 1","Photo 2","Photo 3","Photo 4"};
    for(int i=0;i<6;i++){
%>
<div class="edit-about">
    <div class="edit-header"><h1>Change <%=labels[i]%></h1></div>
    <div class="image-wrapper">
        <div class="db-image" >
            <img  src="mainImage?id=<%=i+1%>" alt="Cover">
        </div>
        <form action="uploadEdit" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="<%=i+1%>">
            <label for="imageUpload<%=i%>">
                <div class="image-placeholder" id="placeholder<%=i%>">Click or Drag & Drop Image Here</div>
            </label>
                <input type="file" name="image<%=i+1%>" id="imageUpload<%=i%>" accept="image/*" onchange="previewImage(event,<%=i%>)" required>
            <div style="text-align:center;"><button type="submit" class="submit-btn">Submit</button></div>
        </form>
    </div>
</div>
<% } %>

<!-- About Us Text -->
<div class="edit-about">
    <div class="edit-header"><h1>Edit About Us Text</h1></div>
    <form action="uploadEdit" method="post">
        <textarea name="aboutUs" placeholder="Write About Us here..." required><%= request.getAttribute("aboutText") != null ? request.getAttribute("aboutText") : "" %></textarea>
        <div style="text-align:center;"><button type="submit" class="submit-btn">Update Text</button></div>
    </form>
</div>

<script>
function previewImage(event,index){
    const placeholder=document.getElementById("placeholder"+index);
    const fileInput=document.getElementById("imageUpload"+index);
    const file=event.target.files[0];
    if(file){
        const reader=new FileReader();
        reader.onload=function(e){
            placeholder.style.backgroundImage="url('"+e.target.result+"')";
            placeholder.innerHTML="";
        }
        reader.readAsDataURL(file);
    }
}

// Drag & Drop for placeholders
for(let i=0;i<6;i++){
    const placeholder=document.getElementById("placeholder"+i);
    const fileInput=document.getElementById("imageUpload"+i);
    placeholder.addEventListener("dragover",e=>{e.preventDefault();placeholder.classList.add("dragover");});
    placeholder.addEventListener("dragleave",e=>{e.preventDefault();placeholder.classList.remove("dragover");});
    placeholder.addEventListener("drop",e=>{
        e.preventDefault();
        placeholder.classList.remove("dragover");
        const file=e.dataTransfer.files[0];
        if(file){
            fileInput.files=e.dataTransfer.files;
            previewImage({target:{files:[file]}},i);
        }
    });
}
</script>

</body>
</html>