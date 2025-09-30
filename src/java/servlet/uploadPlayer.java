package servlet;

import dao.playerDAO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.player;

/**
 *
 * @author Akila
 */
@WebServlet(name = "uploadPlayer", urlPatterns = {"/uploadPlayer"})
@MultipartConfig(maxFileSize = 10 * 1024 * 1024) // 10MB
public class uploadPlayer extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // Collect form fields
            String id = request.getParameter("id");
            String fname = request.getParameter("fname");
            
            String batch = request.getParameter("batch");
            String faculty = request.getParameter("faculty");
            String sid = request.getParameter("sid");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String mail= request.getParameter("mail");
            String school = request.getParameter("school");
            String achiev = request.getParameter("achiev");
            String team = request.getParameter("team");
            
            
            

            // Handle image
            Part img = request.getPart("photo");
            byte[] compressedImg = null;
            if (img != null && img.getSize() > 0) {
                InputStream imgStream = img.getInputStream();
                compressedImg = compressImage(imgStream, 1024, 1024, 0.7f);
                
                player pl=new player(new ByteArrayInputStream(compressedImg),fname,batch,faculty,sid,gender,phone,mail,school,team,achiev);
                playerDAO p=new playerDAO();
                
                if(p.addPlayer(pl))
                {
                    response.sendRedirect("add_player.jsp");
                }
                else
                {
                    response.sendRedirect("try_again.html");
                }
                
            }
            
            
            

        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
