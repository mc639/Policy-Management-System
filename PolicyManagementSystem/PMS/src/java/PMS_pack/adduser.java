package PMS_pack;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Mammu
 */
@WebServlet(urlPatterns = {"/adduser"})
public class adduser extends HttpServlet {
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
        String first_name="";
        String middle_name="";
        String last_name="";
        String address="";
        String city_id="";
        String phone_no="";
        String email="";
        String dob="";
       // String photo="";
        String marital_status="";
        String gender="";
        String login_id="";
        String password="";
        String ani_date="";
        //String id_proof="";
       // String add_proof="";
        String user_type="";
        String premium_pay_method="";
        String bank_name="";
        String acc_no="";
        String office_address="";
        
        ExpDate d = new ExpDate();
        String reg_date=d.getCurrDate();
        PrintWriter out=response.getWriter();
          // String DESTINATION_DIR_PATH1 = "photo/profile";
   // String DESTINATION_DIR_PATH2 = "photo/idproof";
    //String DESTINATION_DIR_PATH3 = "photo/addressproof";
     int ind,ind1; 
           String realPath1,realPath2,realPath3;
          realPath1="H:\\PolicyManagementSystem\\PMS\\web\\photo\\profile";
          realPath2="H:\\PolicyManagementSystem\\PMS\\web\\photo\\idproof";
          realPath3="H:\\PolicyManagementSystem\\PMS\\web\\photo\\addressproof";
          
          //  realPath1 = getServletContext().getRealPath(DESTINATION_DIR_PATH1);
         //   realPath2 = getServletContext().getRealPath(DESTINATION_DIR_PATH2);
           // realPath3 = getServletContext().getRealPath(DESTINATION_DIR_PATH3);
            
           /*ind=realPath1.indexOf("build");
         ind1=realPath1.indexOf("web");
       realPath1  = realPath1.substring(0,ind)+realPath1.substring(ind1);

       
           ind=realPath2.indexOf("build");
         ind1=realPath2.indexOf("web");
       realPath2  = realPath2.substring(0,ind)+realPath2.substring(ind1);

       
           ind=realPath3.indexOf("build");
         ind1=realPath3.indexOf("web");
       realPath3  = realPath3.substring(0,ind)+realPath3.substring(ind1);
*/
               File destinationDir1 = new File(realPath1);
               File destinationDir2 = new File(realPath2);
               File destinationDir3 = new File(realPath3);

        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
 ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
         try
         {
                List items = uploadHandler.parseRequest(request);
                java.util.Iterator i=items.iterator();
                while(i.hasNext())
                {
                    FileItem item = (FileItem) i.next();
                     if (item.isFormField()) {
                        
                        switch (item.getFieldName()) {
                            case "t1":
                                first_name=item.getString();
                                break;
                            case "t2":
                                middle_name=item.getString();
                                break;
                            case "t3":
                                last_name=item.getString();
                                break;
                            case "t4":
                                address=item.getString();
                                break;
                            case "t5":
                                city_id=item.getString();
                                break;
                            case "t6":
                                phone_no=item.getString();
                                break;
                            case "t7":
                                email=item.getString();
                                break;
                            case "t8":
                                dob=item.getString();
                                break;
                            case "t10":
                                marital_status=item.getString();
                                break;
                            case "t11":
                                gender=item.getString();
                                break;
                            case "t12":
                                login_id=item.getString();
                                break;
                            case "t13":
                                password=item.getString();
                                break;
                            case "t14":
                                ani_date=item.getString();
                                break;
                            case "t17":
                                user_type=item.getString();
                                break;
                            case "t18":
                                premium_pay_method=item.getString();
                                break;
                            case "t19":
                                bank_name=item.getString();
                                break;
                            case "t20":
                                acc_no=item.getString();
                                break;
                            case "t21":
                                office_address=item.getString();
                                break;
                            default:
                                break;
                        }
                                 
                     }
                     else
                     {
                        switch (item.getFieldName()) {
                            case "t9":
                                {
                                    File file = new File(destinationDir1, item.getName());
                                    item.write(file);
                                    realPath1="photo/profile"+"/"+item.getName();
                                    break;
                                }
                            case "t15":
                                {
                                    File file = new File(destinationDir2, item.getName());
                                    item.write(file);
                                    realPath2="photo/idproof"+"/"+item.getName();
                                    break;
                                }
                            case "t16":
                                {
                                    File file = new File(destinationDir3, item.getName());
                                    item.write(file);
                                    realPath3="photo/addressproof"+"/"+item.getName();
                                    break; 
                                }
                            default:
                                break;
                        }
 
                     }
                }
         }
         catch(Exception ex)
         {
             out.print(ex.toString());
         }
        out.println(first_name+"<br>");
        out.println(middle_name+"<br>");
        out.println(last_name+"<br>");
        out.println(address+"<br>");
        out.println(city_id+"<br>");
        out.println(phone_no+"<br>");
        out.println(email+"<br>");
        out.println(dob+"<br>");
        out.println(realPath1+"<br>");
        out.println(marital_status+"<br>");
        out.println(gender+"<br>");
        out.println(login_id+"<br>");
        out.println(password+"<br>");
        out.println(ani_date+"<br>");
        out.println(realPath2+"<br>");
        out.println(realPath3+"<br>");
        out.println(office_address+"<br>");
        out.println(user_type+"<br>");
        out.println(premium_pay_method+"<br>");
        out.println(reg_date+"<br>");
        out.println(bank_name+"<br>");
        out.println(acc_no+"<br>");
        dbconnection obj=new dbconnection();
        obj.query("insert into user(first_name,middle_name,last_name,address,city_id,phone_no,email_id,dob,photo,marital_status,sex,login_id,password,anivarsary_date,id_proof,address_proof,office_address,user_type,premium_pay_mode,reg_date,bank_name,account_number) values('"+first_name+"','"+middle_name+"','"+last_name+"','"+address+"',"+city_id+",'"+phone_no+"','"+email+"','"+dob+"','"+realPath1+"',"+marital_status+","+gender+",'"+login_id+"','"+password+"','"+ani_date+"','"+realPath2+"','"+realPath3+"','"+office_address+"',"+user_type+","+premium_pay_method+",'"+reg_date+"','"+bank_name+"','"+acc_no+"')");
       response.sendRedirect("User.jsp");
    }
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
