<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/web_edit.css">
    <title>Edit About</title>
    
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
        <div class="db-image">
            <img src="mainImage?id=<%=i+1%>" alt="<%=labels[i]%>">
        </div>
        <form action="uploadEdit" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="<%=i+1%>">
            <label for="imageUpload<%=i%>">
                <div class="image-placeholder" id="placeholder<%=i%>">
                    Click or Drag & Drop Image Here
                </div>
            </label>
            <input type="file" name="image<%=i+1%>" id="imageUpload<%=i%>" accept="image/*" onchange="previewImage(event,<%=i%>)" required>
            <button type="submit" class="submit-btn" onclick="return x()">Submit</button>
        </form>
    </div>
</div>
<% } %>

<!-- About Us Text -->
<div class="edit-about">
    <div class="edit-header"><h1>Edit About Us Text</h1></div>
    <form action="uploadEdit" method="post">
        <textarea name="txt" placeholder="Write About Us here..." required>
            <%= request.getAttribute("aboutText") != null ? request.getAttribute("aboutText") : "" %>
        </textarea>
        <button type="submit" class="submit-btn" onclick="return x()">Update Text</button>
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
