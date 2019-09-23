/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PMS_pack;
import java.sql.*;
/**
 *
 * @author Mammu
 */
public class dbconnection {
    
    
    public void query(String s)
    {
         try
       {
       Class.forName("com.mysql.jdbc.Driver");
       Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
       Statement st=cn.createStatement();
       st.execute(s);
       cn.close();
       
       }
       catch(Exception ex)
       {
          System.out.print(ex.toString());
       }
    }
    
    
      public ResultSet selectquery(String s)
    {
        ResultSet rs=null;
         try
       {
       Class.forName("com.mysql.jdbc.Driver");
       Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
       Statement st=cn.createStatement();
        rs=st.executeQuery(s);
       }
       catch(Exception ex)
       {
          System.out.print(ex.toString());
       }
         return rs;
    }
}
