<%@page  import="java.sql.*" %>
<%@page import="PMS_pack.dbconnection"%>
<%@include file="header.jsp" %>

<%
    dbconnection obj=new dbconnection();
    ResultSet rsc=obj.selectquery("select * from user");
    
%>
<form action="adduser_policy" method="post">
    
    <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> User :</h5></label>
            <select name="t1" class="form-control">
                <%
                     while(rsc.next())
                     {
                         %>
                         <option value='<%= rsc.getString(1) %>'><%= rsc.getString(2) %></option>
                         <%
                     }    
                %>
            </select>
        </div>
     </div>
<%
    dbconnection objj=new dbconnection();
    ResultSet rscs=objj.selectquery("select * from policy_plan");
    
%>
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Plan Name :</h5></label>
             <select name="t2" class="form-control">
                <%
                     while(rscs.next())
                     {
                         %>
                         <option value='<%= rscs.getString(1) %>'><%= rscs.getString(9) %></option>
                         <%
                     }    
                %>
            </select>
            </div>
     </div>
    </div>
   
    <div class="row">
     <div class="col-md-5">
         <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Policy Purchase Date :</h5></label>
            <input type="date" required="required" name="t3" class="form-control">
            </div>
     </div>
    
     <div class="col-md-5">
         <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Policy Amount :</h5></label>
            <input type="text" required="required" name="t4" class="form-control" onkeypress="return isNumber(event)">
            </div>
     </div>
    </div>
    
    <div class="row">
     <div class="col-md-5">
         <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Nominee Name :</h5></label>
            <input type="text" required="required" name="t5" class="form-control" onkeypress="return isAlfa(event)">
            </div>
     </div>
   
     <div class="col-md-5">
                 <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Nominee Relationship type :</h5></label>
            <input type="text" required="required" name="t6" class="form-control" onkeypress="return isAlfa(event)">
            </div>
     </div>
    </div>
    
    <div class="row">
     <div class="col-md-5">
         <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Premium type :</h5></label>
            <select required="required" name="t7" class="form-control" >
                <option value="0">Yearly</option>
                <option value="1">Half-yearly</option>
                <option value="2">Monthly</option>
            </select>
            </div>
     </div>
    
     <div class="col-md-5">
         <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Policy Status :</h5></label>
            <select required="required" name="t8" class="form-control" >
                <option value="0">Exist</option>
                <option value="1">Lapsed</option>
            </select>
            </div>
     </div>
    </div>
                         
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
          <input type="submit"  class="btn btn-info btn-fill" value="Submit"> 
            <input type="reset"  class="btn btn-info btn-fill" value="Cancel">
        </div>
    </div>
     </div>
</form>

<br>
<br>

<%
    Class.forName("com.mysql.jdbc.Driver");
       Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pms", "root", "root");
       Statement st=cn.createStatement();     
      ResultSet rs= st.executeQuery("select * From user_policy up , user u , policy_plan pp where up.user_id=u.user_id and up.plan_id=pp.plan_id ");
       
    %>

    <table class="table-hover table-striped">
        <tr>
            <td style="padding:10px">User Name</td>
            <td style="padding:10px">Plan Name</td>
            <td style="padding:10px">Policy Purchase Date</td>
            <td style="padding:10px">Policy Amount </td>
            <td style="padding:10px">Nominee Name</td>
            <td style="padding:10px">Nominee Relationship type</td>
            <td style="padding:10px">Premium Type</td>
            <td style="padding:10px">Policy Status</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <%
             while(rs.next())
             {
                 %>
                 <tr>
                     
                     <td style="padding:10px"><%= rs.getString(11) %></td>
                     <td style="padding:10px"><%= rs.getString(41) %></td>
                     <td style="padding:10px"><%= rs.getString(4) %></td>
                     <td style="padding:10px"><%= rs.getString(5) %></td>
                     <td style="padding:10px"><%= rs.getString(6) %></td>
                     <td style="padding:10px"><%= rs.getString(7) %></td>
                     <td style="padding:10px">
                         <%
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
                         %>
                     </td>
                    
                     <td style="padding:10px">
                          <%
                            if(rs.getString(9).equals("0"))
                            {
                                out.print("Exist");
                            }
                            else
                            {
                                out.print("Lapsed");
                            }
                         %>
                     </td>
                     
                     <td style="padding:10px"><a class="btn btn-info btn-fill" href="deleteuser_policy?x=<%= rs.getString(1) %>">Delete</a></td>
                 <td style="padding:10px"><a class="btn btn-info btn-fill" href="#">Edit</a></td>
                 </tr>
                 <%
             }
            %>
    </table>

<%@include file="footer.jsp" %>