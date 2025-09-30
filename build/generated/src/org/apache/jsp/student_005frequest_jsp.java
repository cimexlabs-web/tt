package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import dao.playerDAO;

public final class student_005frequest_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/student_r.css\">\n");
      out.write("    <title>QR Requests</title>\n");
      out.write("    \n");
      out.write("    <script>\n");
      out.write("    function confirmAction(message) {\n");
      out.write("        return window.confirm(message || \"Are you sure?\");\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1 class=\"page-title\">QR Requests</h1>\n");
      out.write("    <div class=\"card-container\">\n");
      out.write("        ");

            if (session == null || !("SAdmin".equals(session.getAttribute("role")) || "NAdmin".equals(session.getAttribute("role"))))
        {
            response.sendRedirect("login.html");
            return;
        }
            playerDAO p = new playerDAO();
            ResultSet r = p.getRequestDetail();
            while(r.next()) {
                String id = r.getString("id");
        
      out.write("\n");
      out.write("        <a href=\"javascript:history.back()\" class=\"back-btn\">← Back</a>\n");
      out.write("        <div class=\"card\">\n");
      out.write("            <h2>");
      out.print( r.getString("name") );
      out.write("</h2>\n");
      out.write("            <div class=\"card-details\">\n");
      out.write("                \n");
      out.write("                <div class=\"detail\"><span>Batch:</span> ");
      out.print( r.getString("batch") );
      out.write("</div>\n");
      out.write("                <div class=\"detail\"><span>Degree:</span> ");
      out.print( r.getString("degree") );
      out.write("</div>\n");
      out.write("                <div class=\"detail\"><span>Faculty:</span> ");
      out.print( r.getString("faculty") );
      out.write("</div>\n");
      out.write("                <div class=\"detail\"><span>Student ID:</span> ");
      out.print( r.getString("sid") );
      out.write("</div>\n");
      out.write("                <div class=\"detail\"><span>Gender:</span> ");
      out.print( r.getString("gender") );
      out.write("</div>\n");
      out.write("                <div class=\"detail\"><span>Phone:</span> ");
      out.print( r.getString("phone") );
      out.write("</div>\n");
      out.write("                <div class=\"detail\"><span>Email:</span> ");
      out.print( r.getString("mail") );
      out.write("</div>\n");
      out.write("                <div class=\"detail\"><span>School:</span> ");
      out.print( r.getString("school") );
      out.write("</div>\n");
      out.write("                <div class=\"detail\"><span>Experience:</span> ");
      out.print( r.getString("experience") );
      out.write("</div>\n");
      out.write("                <div class=\"detail\"><span>Start Year:</span> ");
      out.print( r.getString("start_date") );
      out.write("</div>\n");
      out.write("                <div class=\"detail\"><span>Achievement:</span> ");
      out.print( r.getString("achievement") );
      out.write("</div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Action buttons -->\n");
      out.write("            <div class=\"btn-group\">\n");
      out.write("                <form action=\"Approve\" method=\"get\" style=\"flex:1;\">\n");
      out.write("                    <!-- hidden fields -->\n");
      out.write("                    <input type=\"hidden\" name=\"id\" value=\"");
      out.print( id );
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"mail\" value=\"");
      out.print( r.getString("mail") );
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"name\" value=\"");
      out.print( r.getString("name") );
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"batch\" value=\"");
      out.print( r.getString("batch") );
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"faculty\" value=\"");
      out.print( r.getString("faculty") );
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"sid\" value=\"");
      out.print( r.getString("sid") );
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"gender\" value=\"");
      out.print( r.getString("gender") );
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"phone\" value=\"");
      out.print( r.getString("phone") );
      out.write("\">\n");
      out.write("                    \n");
      out.write("                    <input type=\"hidden\" name=\"school\" value=\"");
      out.print( r.getString("school") );
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"achievement\" value=\"");
      out.print( r.getString("achievement") );
      out.write("\">\n");
      out.write("\n");
      out.write("                    <!-- team select -->\n");
      out.write("                    <select name=\"team\" id=\"team-");
      out.print( id );
      out.write("\" class=\"team-select\" required>\n");
      out.write("                        <option value=\"\">-- Select Team --</option>\n");
      out.write("                        <option value=\"boyA\">Boys Team A</option>\n");
      out.write("                        <option value=\"boyB\">Boys Team B</option>\n");
      out.write("                        <option value=\"girlA\">Girls Team A</option>\n");
      out.write("                        <option value=\"girlB\">Girls Team B</option>\n");
      out.write("                        \n");
      out.write("                    </select>\n");
      out.write("                        \n");
      out.write("                    <button type=\"submit\" name=\"status\" value=\"approved\" class=\"btn approve\" onclick=\"return confirmAction('Approve this student?')\">\n");
      out.write("                        Approve\n");
      out.write("                    </button>\n");
      out.write("                </form>\n");
      out.write("                \n");
      out.write("                <a href=\"Approve?id=");
      out.print( id );
      out.write("&status=rejected\" class=\"btn reject\" onclick=\"return confirmAction('Reject this student?')\">\n");
      out.write("                    Not Approve\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
