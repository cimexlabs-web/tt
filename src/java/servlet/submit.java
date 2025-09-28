/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.submitDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.student;

/**
 *
 * @author Akila Perera
 */
@WebServlet(name = "submit", urlPatterns = {"/submit"})
public class submit extends HttpServlet {

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
            out.println("<title>Servlet submit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet submit at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        
        request.setCharacterEncoding("UTF-8"); // allow Unicode
    
    String name     = request.getParameter("name");
    String batch    = request.getParameter("batch");
    String degree   = request.getParameter("degree");
    String faculty  = request.getParameter("faculty");
    String sid      = request.getParameter("studentId"); // matches HTML
    String gender   = request.getParameter("gender");
    String phone    = request.getParameter("whatsapp");  // matches HTML
    String mail    = request.getParameter("mail");
    String scl     = request.getParameter("school");
    String exp      = request.getParameter("experience");
    String year     = request.getParameter("yearStarted");
    String achi     = request.getParameter("achievements");

    
    student student = new student(
        name,batch,degree,faculty,sid,gender,phone,mail,scl,exp,year,achi
    );

    
    submitDAO dao = new submitDAO();

    try {
        
        if (dao.addStudent(student)) {
            
            response.sendRedirect("Successfully_submit.html");
        } else {
            
            response.sendRedirect("try_again.html");
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("try_again.html"); // fallback
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
