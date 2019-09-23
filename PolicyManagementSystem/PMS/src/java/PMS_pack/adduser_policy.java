/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PMS_pack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Mammu
 */
@WebServlet(name = "adduser_policy", urlPatterns = {"/adduser_policy"})
public class adduser_policy extends HttpServlet {

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
        String user_id=request.getParameter("t1");
        String plan_id=request.getParameter("t2");
        String ppd=request.getParameter("t3");
        String p_amnt=request.getParameter("t4");
        String nominee_name=request.getParameter("t5");
        String nominee_rel=request.getParameter("t6");
        String premium_type=request.getParameter("t7");
        String policy_status=request.getParameter("t8");
        PrintWriter out=response.getWriter();
        dbconnection obj=new dbconnection();
        obj.query("insert into user_policy(user_id,plan_id,policy_purchase_date,policy_amnt,nominee_name,nominee_relation_type,premium_type,policy_status) values("+user_id+","+plan_id+",'"+ppd+"',"+p_amnt+",'"+nominee_name+"','"+nominee_rel+"',"+premium_type+","+policy_status+")");
        response.sendRedirect("User_policy.jsp");
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
