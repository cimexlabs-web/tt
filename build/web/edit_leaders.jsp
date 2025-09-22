<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/web_edit.css">
    <title>Edit Leaders</title>
    
</head>
<body>
<%
    if (session == null || !("SAdmin".equals(session.getAttribute("role")) || "NAdmin".equals(session.getAttribute("role")))) {
        response.sendRedirect("login.html");
        return;
    }

    Map<Integer,String> images = new HashMap<>();
    for(int i=1;i<=3;i++){
        images.put(i, "fetchImageServlet?id="+i);
    }
%>

<a href="javascript:history.back()" class="back-btn">← Back</a>


<% String[] labels = {"President","MIC","MIC"}; %>
<% for(int i=1;i<=3;i++){ %>
<div class="edit-about">
    <div class="edit-header">
        <h1>Edit <%= labels[i-1] %></h1>
    </div>

    <div class="image-wrapper">
        <div class="db-image">
            <img src="leaderImage?id=<%=i%>" alt="<%=labels[i-1]%>">
        </div>

        <!-- ONE form for image + name + message -->
        <form action="uploadLeader" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="<%=i%>">

            <!-- Image -->
            <label for="imageUpload<%=i%>">
                <div class="image-placeholder" id="placeholder<%=i%>">
                    Click or Drag & Drop Image Here
                </div>
            </label>
            <input type="file" name="image<%=i%>" id="imageUpload<%=i%>" accept="image/*" onchange="previewImage(event,<%=i%>)">
            <br><br><br>
            <!-- Title/Name -->
            <label for="title<%=i%>">Title:</label>
            <select name="title" id="title<%=i%>">
                <option value="">-Select title-</option>
                <option value="Mr">Mr</option>
                <option value="Mrs">Mrs</option>
                <option value="Miss">Miss</option>
            </select>
                <br><br>
            <label for="name<%=i%>">Name:</label>
            <input type="text" name="name" id="name<%=i%>" placeholder="Leader Name" 
                   value="<%= request.getAttribute("leaderName"+i) != null ? request.getAttribute("leaderName"+i) : "" %>" required>

            <!-- Message -->
            <br><br><br>
            <textarea name="txt" placeholder="Write message here..."><%= request.getAttribute("aboutText"+i) != null ? request.getAttribute("aboutText"+i) : "" %></textarea>

            <button type="submit" class="submit-btn">Update</button>
        </form>
    </div>
</div>
<% } %>






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
