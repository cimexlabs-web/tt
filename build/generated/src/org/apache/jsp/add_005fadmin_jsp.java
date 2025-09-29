package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_005fadmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/admin.css\">\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Add Admin</title>\n");
      out.write("    <script>\n");
      out.write("        function validateForm() {\n");
      out.write("            let form = document.forms[0];\n");
      out.write("\n");
      out.write("            let name = form.name.value.trim();\n");
      out.write("            let username = form.username.value.trim();\n");
      out.write("            let mail = form.mail.value.trim();\n");
      out.write("            let pws = form.pws.value;\n");
      out.write("            let rpws = form.rpws.value;\n");
      out.write("            let type = form.type.value;\n");
      out.write("\n");
      out.write("            // 1. Name validation (no numbers)\n");
      out.write("            if (!isNaN(name)) {\n");
      out.write("                alert(\"❌ Name cannot be only numbers\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            // 2. Username validation (min 5 chars, no spaces)\n");
      out.write("            if (username.length < 5 || username.includes(\" \")) {\n");
      out.write("                alert(\"❌ Username must be at least 5 characters and contain no spaces\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            // 3. Email validation\n");
      out.write("            let emailPattern = /^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$/;\n");
      out.write("            if (!emailPattern.test(mail)) {\n");
      out.write("                alert(\"❌ Please enter a valid email address\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            // 4. Password validation (min 6 chars)\n");
      out.write("            if (pws.length < 6) {\n");
      out.write("                alert(\"❌ Password must be at least 6 characters long\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            // 5. Re-enter password validation\n");
      out.write("            if (pws !== rpws) {\n");
      out.write("                alert(\"❌ Passwords do not match\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            // 6. Type validation\n");
      out.write("            if (type === \"\") {\n");
      out.write("                alert(\"❌ Please select an admin type\");\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            return true; // ✅ allow submit\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Add Admin</h1>\n");
      out.write("    <form action=\"admin\" method=\"post\" onsubmit=\"return validateForm()\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div>\n");
      out.write("                <input type=\"text\" name=\"name\" placeholder=\"Enter name\" required>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <input type=\"text\" name=\"username\" placeholder=\"Enter username\" required>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <input type=\"text\" name=\"mail\" placeholder=\"Enter mail\" required>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <input type=\"password\" name=\"pws\" placeholder=\"Enter new password\" required>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <input type=\"password\" name=\"rpws\" placeholder=\"Re-enter password\" required>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <select name=\"type\" required>\n");
      out.write("                    <option value=\"\">--Select type--</option>\n");
      out.write("                    <option value=\"NAdmin\">Normal Admin</option>\n");
      out.write("                    <option value=\"SAdmin\">Super Admin</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <button type=\"submit\">Submit</button>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <button type=\"reset\">Reset</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
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
