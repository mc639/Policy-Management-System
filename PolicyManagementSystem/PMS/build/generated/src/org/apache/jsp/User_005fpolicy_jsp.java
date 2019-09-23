package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import PMS_pack.dbconnection;

public final class User_005fpolicy_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\" />\n");
      out.write("\t<link rel=\"icon\" type=\"image/png\" href=\"assets/img/favicon.ico\">\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n");
      out.write("\n");
      out.write("\t<title>Policy Management System</title>\n");
      out.write("\n");
      out.write("\t<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core CSS     -->\n");
      out.write("    <link href=\"assets/css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("    <!-- Animation library for notifications   -->\n");
      out.write("    <link href=\"assets/css/animate.min.css\" rel=\"stylesheet\"/>\n");
      out.write("\n");
      out.write("    <!--  Light Bootstrap Table core CSS    -->\n");
      out.write("    <link href=\"assets/css/light-bootstrap-dashboard.css\" rel=\"stylesheet\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!--  CSS for Demo Purpose, don't include it in your project     -->\n");
      out.write("    <link href=\"assets/css/demo.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!--     Fonts and icons     -->\n");
      out.write("    <link href=\"http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>\n");
      out.write("    <link href=\"assets/css/pe-icon-7-stroke.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"wrapper\">\n");
      out.write("    <div class=\"sidebar\" data-color=\"blue\"  data-image=\"assets/img/sidebar-2.jpg\">\n");
      out.write("\n");
      out.write("    <!--\n");
      out.write("\n");
      out.write("        Tip 1: you can change the color of the sidebar using: data-color=\"blue | azure | green | orange | red | purple\"\n");
      out.write("        Tip 2: you can also add an image using data-image tag\n");
      out.write("\n");
      out.write("    -->\n");
      out.write("\n");
      out.write("    \t<div class=\"sidebar-wrapper\">\n");
      out.write("            <div class=\"logo\">\n");
      out.write("                <a href=\"#\" class=\"simple-text\">\n");
      out.write("                     <img src=\"assets/img/policy1.png\" height=\"100px\" width=\"100px\"/>\n");
      out.write("                    <h3>PMS</h3>\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <ul class=\"nav\">\n");
      out.write("                <li >\n");
      out.write("                    <a href=\"welcome.jsp\">\n");
      out.write("                        <!--<i class=\"pe-7s-graph\"></i>-->\n");
      out.write("                        <p>Dashboard</p>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"User.jsp\">\n");
      out.write("                    <!-- <i class=\"pe-7s-user\"></i> -->\n");
      out.write("                        <p>Client</p>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"policy.jsp\">\n");
      out.write("                    <!--    <i class=\"pe-7s-\"></i> -->\n");
      out.write("                        <p>Policy</p>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"policy_plan.jsp\">\n");
      out.write("                    <!--    <i class=\"pe-7s-news-paper\"></i> -->\n");
      out.write("                        <p>Policy Plan</p>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"User_policy.jsp\">\n");
      out.write("                    <!--    <i class=\"pe-7s-science\"></i> -->\n");
      out.write("                        <p>Client Policy</p>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\">\n");
      out.write("                    <!--    <i class=\"pe-7s-map-marker\"></i> -->\n");
      out.write("                        <p>Quotation</p>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"Premium.jsp\">\n");
      out.write("                    <!--    <i class=\"pe-7s-bell\"></i> -->\n");
      out.write("                        <p>Premium Details</p>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("\t\t<li>\n");
      out.write("                    <a href=\"#\">\n");
      out.write("                    <!--    <i class=\"pe-7s-bell\"></i> -->\n");
      out.write("                        <p>Client Wishlist</p>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#\">\n");
      out.write("                    <!--   <i class=\"pe-7s-bell\"></i> -->\n");
      out.write("                        <p>Reports</p>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                \n");
      out.write("\t\t\t\t\n");
      out.write("            </ul>\n");
      out.write("    \t</div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"main-panel\">\n");
      out.write("        <nav class=\"navbar navbar-default navbar-fixed\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                   <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navigation-example-2\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <!--<a class=\"navbar-brand\" href=\"#\">Dashboard</a> -->\n");
      out.write("                </div>\n");
      out.write("                <div class=\"collapse navbar-collapse\">\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-left\">\n");
      out.write("                       \n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        \n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("                              <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                                    Settings\n");
      out.write("                                    <b class=\"caret\"></b>\n");
      out.write("                              </a>\n");
      out.write("                              <ul class=\"dropdown-menu\">\n");
      out.write("                                  <li><a href=\"Change_Password.jsp\">Change Password</a></li>\n");
      out.write("                               \n");
      out.write("                              </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"logout\">\n");
      out.write("                                Log out \n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <div class=\"content\">\n");
      out.write("                            \n");
      out.write('\n');
      out.write('\n');

    dbconnection obj=new dbconnection();
    ResultSet rsc=obj.selectquery("select * from user");
    

      out.write("\n");
      out.write("<form action=\"adduser_policy\" method=\"post\">\n");
      out.write("    \n");
      out.write("    <div class=\"row\">\n");
      out.write("     <div class=\"col-md-5\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label><h5 style=\"color:black\"><b style=\"color:red\">*</b> User :</h5></label>\n");
      out.write("            <select name=\"t1\" class=\"form-control\">\n");
      out.write("                ");

                     while(rsc.next())
                     {
                         
      out.write("\n");
      out.write("                         <option value='");
      out.print( rsc.getString(1) );
      out.write('\'');
      out.write('>');
      out.print( rsc.getString(2) );
      out.write("</option>\n");
      out.write("                         ");

                     }    
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("        </div>\n");
      out.write("     </div>\n");

    dbconnection objj=new dbconnection();
    ResultSet rscs=objj.selectquery("select * from policy_plan");
    

      out.write("\n");
      out.write("     <div class=\"col-md-5\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label><h5 style=\"color:black\"><b style=\"color:red\">*</b> Plan Name :</h5></label>\n");
      out.write("             <select name=\"t2\" class=\"form-control\">\n");
      out.write("                ");

                     while(rscs.next())
                     {
                         
      out.write("\n");
      out.write("                         <option value='");
      out.print( rscs.getString(1) );
      out.write('\'');
      out.write('>');
      out.print( rscs.getString(9) );
      out.write("</option>\n");
      out.write("                         ");

                     }    
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("            </div>\n");
      out.write("     </div>\n");
      out.write("    </div>\n");
      out.write("   \n");
      out.write("    <div class=\"row\">\n");
      out.write("     <div class=\"col-md-5\">\n");
      out.write("         <div class=\"form-group\">\n");
      out.write("            <label><h5 style=\"color:black\"><b style=\"color:red\">*</b> Policy Purchase Date :</h5></label>\n");
      out.write("            <input type=\"date\" required=\"required\" name=\"t3\" class=\"form-control\">\n");
      out.write("            </div>\n");
      out.write("     </div>\n");
      out.write("    \n");
      out.write("     <div class=\"col-md-5\">\n");
      out.write("         <div class=\"form-group\">\n");
      out.write("            <label><h5 style=\"color:black\"><b style=\"color:red\">*</b> Policy Amount :</h5></label>\n");
      out.write("            <input type=\"text\" required=\"required\" name=\"t4\" class=\"form-control\" onkeypress=\"return isNumber(event)\">\n");
      out.write("            </div>\n");
      out.write("     </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <div class=\"row\">\n");
      out.write("     <div class=\"col-md-5\">\n");
      out.write("         <div class=\"form-group\">\n");
      out.write("            <label><h5 style=\"color:black\"><b style=\"color:red\">*</b> Nominee Name :</h5></label>\n");
      out.write("            <input type=\"text\" required=\"required\" name=\"t5\" class=\"form-control\" onkeypress=\"return isAlfa(event)\">\n");
      out.write("            </div>\n");
      out.write("     </div>\n");
      out.write("   \n");
      out.write("     <div class=\"col-md-5\">\n");
      out.write("                 <div class=\"form-group\">\n");
      out.write("            <label><h5 style=\"color:black\"><b style=\"color:red\">*</b> Nominee Relationship type :</h5></label>\n");
      out.write("            <input type=\"text\" required=\"required\" name=\"t6\" class=\"form-control\" onkeypress=\"return isAlfa(event)\">\n");
      out.write("            </div>\n");
      out.write("     </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <div class=\"row\">\n");
      out.write("     <div class=\"col-md-5\">\n");
      out.write("         <div class=\"form-group\">\n");
      out.write("            <label><h5 style=\"color:black\"><b style=\"color:red\">*</b> Premium type :</h5></label>\n");
      out.write("            <select required=\"required\" name=\"t7\" class=\"form-control\" >\n");
      out.write("                <option value=\"0\">Yearly</option>\n");
      out.write("                <option value=\"1\">Half-yearly</option>\n");
      out.write("                <option value=\"2\">Monthly</option>\n");
      out.write("            </select>\n");
      out.write("            </div>\n");
      out.write("     </div>\n");
      out.write("    \n");
      out.write("     <div class=\"col-md-5\">\n");
      out.write("         <div class=\"form-group\">\n");
      out.write("            <label><h5 style=\"color:black\"><b style=\"color:red\">*</b> Policy Status :</h5></label>\n");
      out.write("            <select required=\"required\" name=\"t8\" class=\"form-control\" >\n");
      out.write("                <option value=\"0\">Exist</option>\n");
      out.write("                <option value=\"1\">Lapsed</option>\n");
      out.write("            </select>\n");
      out.write("            </div>\n");
      out.write("     </div>\n");
      out.write("    </div>\n");
      out.write("                         \n");
      out.write("     <div class=\"row\">\n");
      out.write("     <div class=\"col-md-5\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("          <input type=\"submit\"  class=\"btn btn-info btn-fill\" value=\"Submit\"> \n");
      out.write("            <input type=\"reset\"  class=\"btn btn-info btn-fill\" value=\"Cancel\">\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("     </div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("\n");

    Class.forName("com.mysql.jdbc.Driver");
       Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
       Statement st=cn.createStatement();     
      ResultSet rs= st.executeQuery("select * From user_policy up , user u , policy_plan pp where up.user_id=u.user_id and up.plan_id=pp.plan_id ");
       
    
      out.write("\n");
      out.write("\n");
      out.write("    <table class=\"table-hover table-striped\">\n");
      out.write("        <tr>\n");
      out.write("            <td style=\"padding:10px\">User Name</td>\n");
      out.write("            <td style=\"padding:10px\">Plan Name</td>\n");
      out.write("            <td style=\"padding:10px\">Policy Purchase Date</td>\n");
      out.write("            <td style=\"padding:10px\">Policy Amount </td>\n");
      out.write("            <td style=\"padding:10px\">Nominee Name</td>\n");
      out.write("            <td style=\"padding:10px\">Nominee Relationship type</td>\n");
      out.write("            <td style=\"padding:10px\">Premium Type</td>\n");
      out.write("            <td style=\"padding:10px\">Policy Status</td>\n");
      out.write("            <td>&nbsp;</td>\n");
      out.write("            <td>&nbsp;</td>\n");
      out.write("        </tr>\n");
      out.write("        ");

             while(rs.next())
             {
                 
      out.write("\n");
      out.write("                 <tr>\n");
      out.write("                     \n");
      out.write("                     <td style=\"padding:10px\">");
      out.print( rs.getString(11) );
      out.write("</td>\n");
      out.write("                     <td style=\"padding:10px\">");
      out.print( rs.getString(41) );
      out.write("</td>\n");
      out.write("                     <td style=\"padding:10px\">");
      out.print( rs.getString(4) );
      out.write("</td>\n");
      out.write("                     <td style=\"padding:10px\">");
      out.print( rs.getString(5) );
      out.write("</td>\n");
      out.write("                     <td style=\"padding:10px\">");
      out.print( rs.getString(6) );
      out.write("</td>\n");
      out.write("                     <td style=\"padding:10px\">");
      out.print( rs.getString(7) );
      out.write("</td>\n");
      out.write("                     <td style=\"padding:10px\">\n");
      out.write("                         ");

                            if(rs.getString(8).equals("0"))
                            {
                                out.print("Yearly");
                            }
                            else if(rs.getString(8).equals("1"))
                            {
                                out.print("Half-Yearly");
                            }
                            else
                            {
                                out.print("Monthly");
                            }
                         
      out.write("\n");
      out.write("                     </td>\n");
      out.write("                    \n");
      out.write("                     <td style=\"padding:10px\">\n");
      out.write("                          ");

                            if(rs.getString(9).equals("0"))
                            {
                                out.print("Exist");
                            }
                            else
                            {
                                out.print("Lapsed");
                            }
                         
      out.write("\n");
      out.write("                     </td>\n");
      out.write("                     \n");
      out.write("                     <td style=\"padding:10px\"><a class=\"btn btn-info btn-fill\" href=\"deleteuser_policy?x=");
      out.print( rs.getString(1) );
      out.write("\">Delete</a></td>\n");
      out.write("                 <td style=\"padding:10px\"><a class=\"btn btn-info btn-fill\" href=\"#\">Edit</a></td>\n");
      out.write("                 </tr>\n");
      out.write("                 ");

             }
            
      out.write("\n");
      out.write("    </table>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <footer class=\"footer\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <nav class=\"pull-left\">\n");
      out.write("                 \n");
      out.write("                </nav>\n");
      out.write("                <p class=\"copyright pull-right\">\n");
      out.write("                    &copy; 2017 PMS\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("    <!--   Core JS Files   -->\n");
      out.write("    <script src=\"assets/js/jquery-1.10.2.js\" type=\"text/javascript\"></script>\n");
      out.write("\t<script src=\"assets/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"assets/js/Validation.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("\t<!--  Checkbox, Radio & Switch Plugins -->\n");
      out.write("\t<script src=\"assets/js/bootstrap-checkbox-radio-switch.js\"></script>\n");
      out.write("\n");
      out.write("\t<!--  Charts Plugin -->\n");
      out.write("\t<script src=\"assets/js/chartist.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!--  Notifications Plugin    -->\n");
      out.write("    <script src=\"assets/js/bootstrap-notify.js\"></script>\n");
      out.write("\n");
      out.write("    <!--  Google Maps Plugin    -->\n");
      out.write("    <script type=\"text/javascript\" src=\"https://maps.googleapis.com/maps/api/js?sensor=false\"></script>\n");
      out.write("\n");
      out.write("    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->\n");
      out.write("\t<script src=\"assets/js/light-bootstrap-dashboard.js\"></script>\n");
      out.write("\n");
      out.write("\t<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->\n");
      out.write("\t<script src=\"assets/js/demo.js\"></script>\n");
      out.write("\n");
      out.write("\t\n");
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
