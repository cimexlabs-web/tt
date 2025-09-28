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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <title>Table Tennis Registration</title>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/studentForm.css\">\r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"form-container\">\r\n");
      out.write("        <img class=\"logo\" src=\"mainImage?id=1\" alt=\"Logo\">\r\n");
      out.write("        <h2>Table Tennis Registration Form</h2>\r\n");
      out.write("        <form action=\"submit\" method=\"post\" >\r\n");
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
      out.write("            \r\n");
      out.write("            <label for=\"mail\">Student Mail:</label>\r\n");
      out.write("            <input type=\"text\" id=\"mail\" name=\"mail\" required>\r\n");
      out.write("\r\n");
      out.write("            <label>Do you have Table Tennis experience?</label>\r\n");
      out.write("            <select id=\"experience\" name=\"experience\"  required>\r\n");
      out.write("                <option value=\"\">--Select Option--</option>\r\n");
      out.write("                <option value=\"No\">No</option>\r\n");
      out.write("                <option value=\"Yes\">Yes</option>\r\n");
      out.write("            </select>\r\n");
      out.write("            <label style=\" text-align: center; color: red\">If you have experience, please fill below </label>\r\n");
      out.write("            \r\n");
      out.write("                <label for=\"yearStarted\">Year Started Playing:</label>\r\n");
      out.write("                <input type=\"text\" id=\"yearStarted\" name=\"yearStarted\" placeholder=\"e.g. 2018\">\r\n");
      out.write("\r\n");
      out.write("                <label for=\"achievements\">Achievements:</label>\r\n");
      out.write("                <textarea id=\"achievements\" name=\"achievements\" placeholder=\"List your achievements\"></textarea>\r\n");
      out.write("            \r\n");
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
