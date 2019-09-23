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
@WebServlet(name = "updatepolicy", urlPatterns = {"/updatepolicy"})
public class updatepolicy extends HttpServlet {

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
        String policy_id = request.getParameter("t3");
        String policyname=request.getParameter("t4");
        String policynumber=request.getParameter("t5");
        String sum_insurance=request.getParameter("t6");
        String surrender_policy_value=request.getParameter("t7");
        String min_age=request.getParameter("t8");
        String max_age=request.getParameter("t9");
        PrintWriter out=response.getWriter();
        dbconnection obj=new dbconnection();
        obj.query("update policy set policy_name='"+policyname+"' , policy_no='"+policynumber+"',sum_insurance='"+sum_insurance+"',surrenderpolicy_amnt_percentage='"+surrender_policy_value+"',min_age='"+min_age+"',max_age='"+max_age+"' where policy_id='"+policy_id+"'");
        response.sendRedirect("policy.jsp");
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
