package servlet;

import dao.aboutDAO;
import dao.visionDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import model.about;
import model.aboutImg;
import model.vision;
import model.visionImg;

@WebServlet(name = "uploadEdit", urlPatterns = {"/uploadEdit"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,     // 1MB buffer
    maxFileSize = 50 * 1024 * 1024,      // 50MB per file
    maxRequestSize = 50 * 1024 * 1024    // 50MB total
)
public class uploadEdit extends HttpServlet {

    // Utility method to resize + compress image
    private byte[] compressImage(InputStream imgStream, int maxWidth, int maxHeight, float quality) throws IOException {
        BufferedImage originalImage = ImageIO.read(imgStream);
        if (originalImage == null) {
            throw new IOException("Invalid image file!");
        }

        // Scale down if larger
        int newWidth = originalImage.getWidth();
        int newHeight = originalImage.getHeight();

        if (newWidth > maxWidth || newHeight > maxHeight) {
            float widthRatio = (float) maxWidth / newWidth;
            float heightRatio = (float) maxHeight / newHeight;
            float ratio = Math.min(widthRatio, heightRatio);

            newWidth = Math.round(newWidth * ratio);
            newHeight = Math.round(newHeight * ratio);
        }

        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g.dispose();

        // Compress as JPEG
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter jpgWriter = writers.next();

        ImageWriteParam jpgWriteParam = jpgWriter.getDefaultWriteParam();
        jpgWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        jpgWriteParam.setCompressionQuality(quality); // 0.0 = lowest, 1.0 = highest

        jpgWriter.setOutput(new MemoryCacheImageOutputStream(baos));
        jpgWriter.write(null, new javax.imageio.IIOImage(resizedImage, null, null), jpgWriteParam);
        jpgWriter.dispose();

        return baos.toByteArray();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            String year= request.getParameter("year");
            if(year != null)
            {
                    {
            // Acheiv
            
            String title= request.getParameter("titile");
            Part image= request.getPart("photo");
            String p1= request.getParameter("point1");
            String p2= request.getParameter("point2");
            String p3= request.getParameter("point3");
            String p4= request.getParameter("point4");
            String p5= request.getParameter("point5");
            
            if (image != null && image.getSize() > 0) {
                    InputStream imgAch = image.getInputStream();
                    byte[] compressedImgAchiv = compressImage(imgAch, 1024, 1024, 0.7f); // Resize + compress
                    
                    //acheivImg acI= new achevImg(new ByteArrayInputStream(compressedImgAchiv), year);
                    

            }
                    }
            }
            
            aboutDAO ao = new aboutDAO();
            visionDAO vo = new visionDAO();
            
            // If id is provided → image upload
            if (id != null) {
                Part img = request.getPart("image" + id);
                if (img != null && img.getSize() > 0) {
                    InputStream imgStream = img.getInputStream();
                    byte[] compressedImg = compressImage(imgStream, 1024, 1024, 0.7f); // Resize + compress

                    aboutImg abI = new aboutImg(new ByteArrayInputStream(compressedImg), id);
                    visionImg viI= new visionImg(new ByteArrayInputStream(compressedImg),id);
                    if("7".equals(id))
                    {
                        if (vo.insertImg(viI, id)) {
                        response.sendRedirect("Edit_vision.jsp");
                        return;
                    }
                    }
                    else if(!("7".equals(id)))
                    {if (ao.insertImg(abI, id)) {
                        response.sendRedirect("Edit_about.jsp");
                        return;
                    }}
                    
                }
            }

            // If no id → About Us text update
            
            String text = request.getParameter("txt");
            
            if (text != null ) {
                about ab = new about(text);
                vision vi= new vision(text);
                
                if("7".equals(id))
                {
                    if(vo.insertText(vi))
                    {
                        response.sendRedirect("Edit_vision.jsp");
                    return;
                    }
                }
                else if(!("7".equals(id))){
                if (ao.insertText(ab)) {
                    response.sendRedirect("Edit_about.jsp");
                    return;
                }
                }
            }

            response.sendRedirect("tryagain.html");
        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "UploadEdit Servlet with image compression";
    }
}
