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
 * @author ZEEL 01
 */
@WebServlet(name = "updatepolicy_plan", urlPatterns = {"/updatepolicy_plan"})
public class updatepolicy_plan extends HttpServlet {

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
        String plan_id = request.getParameter("t13");
        String policyname=request.getParameter("t14");
        String planname=request.getParameter("t15");
        String Tabularrate=request.getParameter("t16");
        String r2to5=request.getParameter("t17");
        String r2abv=request.getParameter("t18");
        String p6m=request.getParameter("t19");
        String p12m=request.getParameter("t20");
        String years=request.getParameter("t21");
        PrintWriter out=response.getWriter();
        dbconnection obj=new dbconnection();
        obj.query("update policy_plan set policy_id='"+policyname+"',tabular_rate='"+Tabularrate+"',rebet_2_to_5_lac='"+r2to5+"',rebet_above_5_lac='"+r2abv+"',premium_mode_six_month='"+p6m+"',premium_mode_one_year='"+p12m+"',no_of_years='"+years+"',plan_name='"+planname+"' where plan_id='"+plan_id+"'");
        response.sendRedirect("policy_plan.jsp");
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

