package servlet;

import dao.aboutDAO;
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
            aboutDAO ao = new aboutDAO();

            // If id is provided → image upload
            if (id != null) {
                Part img = request.getPart("image" + id);
                if (img != null && img.getSize() > 0) {
                    InputStream imgStream = img.getInputStream();
                    byte[] compressedImg = compressImage(imgStream, 1024, 1024, 0.7f); // Resize + compress

                    aboutImg abI = new aboutImg(new ByteArrayInputStream(compressedImg), id);

                    if (ao.insertImg(abI, id)) {
                        response.sendRedirect("Edit_about.jsp");
                        return;
                    }
                }
            }

            // If no id → About Us text update
            String aboutText = request.getParameter("aboutUs");
            if (aboutText != null && !aboutText.trim().isEmpty()) {
                about ab = new about(aboutText);
                if (ao.insertText(ab)) {
                    response.sendRedirect("Edit_about.jsp");
                    return;
                }
            }

            response.getWriter().println("No data received!");
        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "UploadEdit Servlet with image compression";
    }
}
