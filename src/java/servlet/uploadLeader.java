/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.aboutDAO;
import dao.leaderDAO;
import dao.visionDAO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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

import model.leader;
import model.leaderImg;


/**
 *
 * @author Akila Perera
 */
@WebServlet(name = "uploadLeader", urlPatterns = {"/uploadLeader"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,     // 1MB buffer
    maxFileSize = 50 * 1024 * 1024,      // 50MB per file
    maxRequestSize = 50 * 1024 * 1024    // 50MB total
)
public class uploadLeader extends HttpServlet {
    
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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet uploadLeader</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet uploadLeader at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
        String id = request.getParameter("id");
        leaderDAO dao = new leaderDAO();

        // 1️⃣ Image
        Part image = request.getPart("image" + id);
        if (image != null && image.getSize() > 0) {
            byte[] compressedImg = compressImage(image.getInputStream(), 1024, 1024, 0.7f);
            dao.insertImg(new leaderImg(new ByteArrayInputStream(compressedImg), id), id);
        }

        // 2️⃣ Message
        String text = request.getParameter("txt");
        if (text != null && !text.trim().isEmpty()) {
            dao.insertText(new leader(text.trim()), id);
        }

        // 3️⃣ Name + Title
        String title = request.getParameter("title");
        String name  = request.getParameter("name");
        if (title != null && name != null && !name.trim().isEmpty()) {
            dao.insertName(name, title, id);
        }

        response.sendRedirect("edit_leaders.jsp");

    } catch (Exception e) {
        response.getWriter().println("Error: " + e.getMessage());
    }
}



    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
