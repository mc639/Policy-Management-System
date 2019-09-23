/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PMS_Webservice;

import PMS_pack.dbconnection;
import java.sql.ResultSet;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Rumaila
 */
@WebService(serviceName = "PMSWebservice")
public class PMSWebservice {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
     @WebMethod(operationName = "checklogin")
    public String checklogin(@WebParam(name = "l") String l,@WebParam(name = "p") String p) {
         dbconnection obj=new dbconnection();
         ResultSet rs= obj.selectquery("select *From user where login_id='"+ l +"' and password='"+p +"'");
         String str="";
         try
         {
         if(rs.next())
         {
             str=rs.getString(1)+"|"+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"|"+rs.getString(10);
         }
         else
         {
             str="Invalid Loginid And Password";
         }
         }
         catch(Exception ex)
         {
             
         }
        return str;
    }
    
  
       @WebMethod(operationName = "getpolicy")
    public String getpolicy() {
      String str="";
      dbconnection obj=new dbconnection();
      ResultSet rs=obj.selectquery("select *From policy");
      try
      {
        while(rs.next())
        {
          str=str+rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4)+"|"+rs.getString(5)+"|"+rs.getString(6)+"|"+rs.getString(7)+"#";
        }
      }catch(Exception ex)
      {
          
      }
      return str;
    }
    
    @WebMethod(operationName = "getpolicy_plan")
    public String getpolicy_plan(@WebParam(name = "id") String id){
         String str="";
      dbconnection obj=new dbconnection();
      ResultSet rs=obj.selectquery("select *From policy_plan pp, policy p where pp.policy_id=p.policy_id and pp.policy_id='"+id+"'");
      try
      {
        while(rs.next())
        {
          str=str+rs.getString(1)+"|"+rs.getString(11)+"|"+rs.getString(3)+"|"+rs.getString(4)+"|"+rs.getString(5)+"|"+rs.getString(6)+"|"+rs.getString(7)+"|"+rs.getString(8)+"|"+rs.getString(9)+"#";
        }
      }catch(Exception ex)
      {
          
      }
    return str;
    }@WebMethod(operationName = "update_password")
    public String update_password(@WebParam(name = "id") String id,@WebParam(name = "op") String op,@WebParam(name = "np") String np){
        String str="";
      dbconnection obj=new dbconnection(); 
        ResultSet rs=obj.selectquery("select *From user where user_id='"+id +"' and password='"+ op +"'");
   try
   {
        if(rs.next())
        {
            obj.query("update user set password='"+ np +"' where user_id='"+ id +"'");
            str = "Password Updated.";
        }
        else
        {
            str = "Password Not Updated.";
        }
   }
   catch(Exception ex)
   {
       
   }
   
   return str;
    }
    
    
     @WebMethod(operationName = "getprofile")
    public String getprofile(@WebParam(name = "id") String id) {
         dbconnection obj=new dbconnection();
         ResultSet rs= obj.selectquery("select *From user u,city c where u.city_id=c.city_id and user_id='"+ id +"' ");
         String str="";
         try
         {
         if(rs.next())
         {
             str=rs.getString(1)+"|"+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"|"+rs.getString(5)+"|"+rs.getString(25)+"|"+rs.getString(7)+"|"+rs.getString(8)+"|"+rs.getString(9)+"|"+rs.getString(10)+"|"+rs.getString(12);
         }
         else
         {
             str="Profile not Found...!!";
         }
         }
         catch(Exception ex)
         {
             
         }
        return str;
    }
    
    
    
    @WebMethod(operationName = "getuserpolicy")
    public String getuserpolicy(@WebParam(name = "id") String id) {
         dbconnection obj=new dbconnection();
         ResultSet rs= obj.selectquery("select *From user_policy u , policy_plan p, policy pp where u.plan_id=p.plan_id and p.policy_id=pp.policy_id and user_id='"+ id +"' ");
         String str="";
         try
         {
            while(rs.next())
            {
                str=rs.getString(1)+"|"+rs.getString(20)+"|"+rs.getString(18)+"|"+rs.getString(4)+"|"+rs.getString(5)+"|"+rs.getString(6)+"|"+rs.getString(7)+"|"+rs.getString(8)+"|"+rs.getString(9)+"#";
            }
            
         }
         catch(Exception ex)
         {
             
         }
        return str;
    }
    
    @WebMethod(operationName = "getpremium")
    public String getpremium(@WebParam(name = "id") String id) {
         dbconnection obj=new dbconnection();
         ResultSet rs= obj.selectquery("select * from premium pr, user_policy u, policy_plan p , policy pp where u.plan_id=p.plan_id and p.policy_id=pp.policy_id and pr.user_policy_id='"+ id +"' ");
         String str="";
         try
         {
            while(rs.next())
            {
                str=rs.getString(1)+"|"+rs.getString(26)+"|"+rs.getString(24)+"|"+rs.getString(3)+"|"+rs.getString(4)+"|"+rs.getString(5)+"|"+rs.getString(6)+"#";
            }
            
         }
         catch(Exception ex)
         {
             
         }
        return str;
    }
    
    
    @WebMethod(operationName = "addtowishlist")
    public String addtowishlist(@WebParam(name = "uid") String uid, @WebParam(name = "pid") String pid)
    {
         dbconnection obj=new dbconnection();
         obj.query("insert into wishlist(user_id,plan_id) values("+uid+","+pid+")");
         String str = "Inserted into wishlist";
         return str;
    }
    
    @WebMethod(operationName = "getwishlist")
    public String getwishlist(@WebParam(name = "id") String id) {
         dbconnection obj=new dbconnection();
         ResultSet rs= obj.selectquery("select * from wishlist w, policy pp, policy_plan p where pp.policy_id=p.policy_id and w.plan_id=p.plan_id and user_id='"+ id +"'");
         String str="";
         try
         {
            while(rs.next())
            {
                str=str+rs.getString(1)+"|"+rs.getString(5)+"|"+rs.getString(19)+"#";
            }
         }
         catch(Exception ex)
         {
             
         }
        return str;
    }
    
}