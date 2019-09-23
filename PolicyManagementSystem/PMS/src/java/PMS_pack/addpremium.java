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
import java.sql.*;

/**
 *
 * @author Mammu
 */
@WebServlet(name = "addpremium", urlPatterns = {"/addpremium"})
public class addpremium extends HttpServlet {

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
        String user_policy_id=request.getParameter("t1");
        String paymentdate=request.getParameter("t2");
        String amount=request.getParameter("t3");
        String chequeno=request.getParameter("t5");
        String payment_mode=request.getParameter("t4");
        PrintWriter out=response.getWriter();
        dbconnection obj=new dbconnection();
        obj.query("insert into premium(user_policy_id,payment_date,amount,cheque_number,payment_mode) values("+user_policy_id+",'"+paymentdate+"',"+amount+",'"+chequeno+"',"+payment_mode+")");
        response.sendRedirect("Premium.jsp");
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
