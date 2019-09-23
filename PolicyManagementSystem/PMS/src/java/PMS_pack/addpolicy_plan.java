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
@WebServlet(name = "addpolicy_plan", urlPatterns = {"/addpolicy_plan"})
public class addpolicy_plan extends HttpServlet {

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
        obj.query("insert into policy_plan(policy_id,tabular_rate,rebet_2_to_5_lac,rebet_above_5_lac,premium_mode_six_month,premium_mode_one_year,no_of_years,plan_name) values("+policyname+","+Tabularrate+","+r2to5+","+r2abv+","+p6m+","+p12m+","+years+",'"+planname+"')");
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
