package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class studentForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Table Tennis Registration</title>\r\n");
      out.write("    \r\n");
      out.write("    <script src=\"Script/studentForm.js\" defer></script>\r\n");
      out.write("    \r\n");
      out.write("    <style>\r\n");
      out.write("        /* Admin Panel Styles */\r\n");
      out.write(".admin-body {\r\n");
      out.write("    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\r\n");
      out.write("    background: linear-gradient(135deg, #004D26 0%, #003319 100%);\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    min-height: 100vh;\r\n");
      out.write("    display: flex;\r\n");
      out.write("    align-items: center;\r\n");
      out.write("    justify-content: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".admin-container {\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    max-width: 1200px;\r\n");
      out.write("    padding: 20px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".admin-header {\r\n");
      out.write("    color: white;\r\n");
      out.write("    margin-bottom: 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".admin-header h1 {\r\n");
      out.write("    font-size: 2.5rem;\r\n");
      out.write("    margin-bottom: 10px;\r\n");
      out.write("    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".admin-header p {\r\n");
      out.write("    font-size: 1.1rem;\r\n");
      out.write("    opacity: 0.9;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".panel-button {\r\n");
      out.write("    display: grid;\r\n");
      out.write("    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));\r\n");
      out.write("    gap: 25px;\r\n");
      out.write("    margin-top: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".a-btn {\r\n");
      out.write("    display: flex;\r\n");
      out.write("    flex-direction: column;\r\n");
      out.write("    align-items: center;\r\n");
      out.write("    justify-content: center;\r\n");
      out.write("    background: white;\r\n");
      out.write("    color: #004D26;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    padding: 30px 20px;\r\n");
      out.write("    border-radius: 15px;\r\n");
      out.write("    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.15);\r\n");
      out.write("    transition: all 0.3s ease;\r\n");
      out.write("    min-height: 180px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".a-btn:hover {\r\n");
      out.write("    transform: translateY(-5px);\r\n");
      out.write("    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);\r\n");
      out.write("    background: #f8f9fa;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".a-btn i {\r\n");
      out.write("    font-size: 2.5rem;\r\n");
      out.write("    margin-bottom: 15px;\r\n");
      out.write("    color: #004D26;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".a-btn span {\r\n");
      out.write("    font-size: 1.2rem;\r\n");
      out.write("    font-weight: 600;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Responsive Design */\r\n");
      out.write("@media screen and (max-width: 768px) {\r\n");
      out.write("    .panel-button {\r\n");
      out.write("        grid-template-columns: 1fr;\r\n");
      out.write("        gap: 20px;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .a-btn {\r\n");
      out.write("        min-height: 150px;\r\n");
      out.write("        padding: 25px 15px;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .a-btn i {\r\n");
      out.write("        font-size: 2rem;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .a-btn span {\r\n");
      out.write("        font-size: 1.1rem;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .admin-header h1 {\r\n");
      out.write("        font-size: 2rem;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media screen and (max-width: 480px) {\r\n");
      out.write("    .admin-container {\r\n");
      out.write("        padding: 15px;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .panel-button {\r\n");
      out.write("        gap: 15px;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .a-btn {\r\n");
      out.write("        min-height: 130px;\r\n");
      out.write("        padding: 20px 15px;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .a-btn i {\r\n");
      out.write("        font-size: 1.8rem;\r\n");
      out.write("        margin-bottom: 10px;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"form-container\">\r\n");
      out.write("        <h2>Table Tennis Registration Form</h2>\r\n");
      out.write("        <form action=\"submit\" method=\"post\">\r\n");
      out.write("            <label for=\"name\">Full Name:</label>\r\n");
      out.write("            <input type=\"text\" id=\"name\" name=\"name\" required>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"batch\">Batch:</label>\r\n");
      out.write("            <input type=\"text\" id=\"batch\" name=\"batch\" required>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"degree\">Degree:</label>\r\n");
      out.write("            <input type=\"text\" id=\"degree\" name=\"degree\" required>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"faculty\">Faculty:</label>\r\n");
      out.write("            <input type=\"text\" id=\"faculty\" name=\"faculty\" required>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"studentId\">Student ID:</label>\r\n");
      out.write("            <input type=\"text\" id=\"studentId\" name=\"studentId\" required>\r\n");
      out.write("\r\n");
      out.write("            <label>Gender:</label>\r\n");
      out.write("            <select name=\"gender\" id=\"gender\" required>\r\n");
      out.write("                <option value=\"\">--Select Gender--</option>\r\n");
      out.write("                <option value=\"Male\">Male</option>\r\n");
      out.write("                <option value=\"Female\">Female</option>\r\n");
      out.write("                <option value=\"Other\">Other</option>\r\n");
      out.write("            </select>\r\n");
      out.write("\r\n");
      out.write("            <label for=\"whatsapp\">WhatsApp Number:</label>\r\n");
      out.write("            <input type=\"text\" id=\"whatsapp\" name=\"whatsapp\" required>\r\n");
      out.write("\r\n");
      out.write("            <label>Do you have Table Tennis experience?</label>\r\n");
      out.write("            <select id=\"experience\" name=\"experience\" onchange=\"toggleExperienceFields()\" required>\r\n");
      out.write("                <option value=\"\">--Select Option--</option>\r\n");
      out.write("                <option value=\"No\">No</option>\r\n");
      out.write("                <option value=\"Yes\">Yes</option>\r\n");
      out.write("            </select>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"experienceFields\" class=\"hidden\">\r\n");
      out.write("                <label for=\"yearStarted\">Year Started Playing:</label>\r\n");
      out.write("                <input type=\"number\" id=\"yearStarted\" name=\"yearStarted\" placeholder=\"e.g. 2018\">\r\n");
      out.write("\r\n");
      out.write("                <label for=\"achievements\">Achievements:</label>\r\n");
      out.write("                <textarea id=\"achievements\" name=\"achievements\" placeholder=\"List your achievements\"></textarea>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <button type=\"submit\">Submit</button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
