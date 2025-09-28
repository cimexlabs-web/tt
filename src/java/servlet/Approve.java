/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.deleteDAO;
import dao.playerDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.delete_student;
import model.player;

/**
 *
 * @author Akila Perera
 */
@WebServlet(name = "Approve", urlPatterns = {"/Approve"})
public class Approve extends HttpServlet {

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
            out.println("<title>Servlet Approve</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Approve at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        
        String id= request.getParameter("id");
        String status= request.getParameter("status");
        String team= request.getParameter("team");
        String mail= request.getParameter("mail");
        String studentName= request.getParameter("name");
        
        String batch = request.getParameter("batch");
            String faculty = request.getParameter("faculty");
            String sid = request.getParameter("sid");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            
            String school = request.getParameter("school");
            String achiev = null;
            achiev=request.getParameter("achievement");
        
                
        String t=null;
        if ("boyA".equals(team))
        {
            t="Boys A Team";
        }
        else if("boyB".equals(team))
        {
            t="Boys B Team";
        }
        else if("girlA".equals(team))
        {
            t="Girls A Team";
        }
        else if("girlB".equals(team))
        {
            t="Girls B Team";
        }
        
        
        
        try {
        if ("approved".equalsIgnoreCase(status) && !("reject").equals(status)) {
            String subject = "Table Tennis Registration Approved";
            String msg = "Dear " + studentName + ",\n\n" +
             "Congratulations! Your registration for the University Table Tennis Club has been approved.\n" +
             "You have been assigned to Team: " + t + ".\n\n" +
             "We have also created an official WhatsApp group where you’ll receive updates about announcements, matches, practices, and other events. Please join using the link below:\n" +
             //whatsappLink + "\n\n" +
             "Welcome to our club! We look forward to seeing your active participation.\n\n" +
             "Best regards,\n" +
             "President,\n" +
             "HIrushi Rathnayaka,\n" +
             "Table Tennis Club,\n" +
             "NSBM Green University"      ;
            
            playerDAO p=new playerDAO();
            
            player pl=new player(studentName,batch,faculty,sid,gender,phone,mail,school,team,achiev);
            
            if(p.addPlayer2(pl))
            {
                util.MailSender.sendMail(mail.trim(), subject, msg);
            }
            
            
            
        }

        delete_student delete=new delete_student(id);
        
        deleteDAO d=new deleteDAO();
        
        if(d.deleteStudent(delete))
        {
            response.sendRedirect("student_request.jsp");
        }
        
            } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("student_request.jsp?msg=error");
             }
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
        processRequest(request, response);
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
