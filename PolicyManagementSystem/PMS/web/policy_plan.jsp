<%@page  import="java.sql.*" %>
<%@page import="PMS_pack.dbconnection"%>
<%@include file="header.jsp" %>

<%
    dbconnection obj=new dbconnection();
    ResultSet rsc=obj.selectquery("select * from policy");
    
%>
<form action="addpolicy_plan" method="post">
    
    <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Policy Name :</h5></label>
            <select name="t14" class="form-control">
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
     
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Plan Name :</h5></label>
            <input type="text" required="required" name="t15" class="form-control" >
            </div>
     </div>
    </div>
   
    <div class="row">
     <div class="col-md-5">
         <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Tabular rate :</h5></label>
            <input type="text" required="required" name="t16" class="form-control" >
            </div>
     </div>
    
     <div class="col-md-5">
         <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Rebate on 2 to 5 Lakh :</h5></label>
            <input type="text" required="required" name="t17" class="form-control" >
            </div>
     </div>
    </div>
    
    <div class="row">
     <div class="col-md-5">
         <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Rebate on 5 Lakh and above :</h5></label>
            <input type="text" required="required" name="t18" class="form-control" >
            </div>
     </div>
    
     <div class="col-md-5">
                 <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b>Discount on premium Mode for 6 Months :</h5></label>
            <input type="text" required="required" name="t19" class="form-control" >
            </div>
     </div>
    </div>
    
    <div class="row">
     <div class="col-md-5">
         <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b>Discount on premium Mode for 12 Months :</h5></label>
            <input type="text" required="required" name="t20" class="form-control" >
            </div>
     </div>
    
     <div class="col-md-5">
         <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Number of years :</h5></label>
            <input type="text" required="required" name="t21" class="form-control" onkeypress="return isNumber(event)">
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
      ResultSet rs= st.executeQuery("select * From policy_plan pp,policy p where pp.policy_id=p.policy_id");
       
    %>
    <table class="table-hover table-striped">
        <tr>
            <td style="padding:10px">Policy Name</td>
            <td style="padding:10px">Plan Name</td>
            <td style="padding:10px">Tabular Rate</td>
            <td style="padding:10px">Rebate on 2 to 5 Lakh </td>
            <td style="padding:10px">Rebate on 5 Lakh and above </td>
            <td style="padding:10px">Discount on premium Mode for 6 Months</td>
            <td style="padding:10px">Discount on premium Mode for 12 Months</td>
            <td style="padding:10px">Number of years</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <%
             while(rs.next())
             {
                 %>
                 <tr>
                     <td style="padding:10px"><%= rs.getString(11) %></td>
                     <td style="padding:10px"><%= rs.getString(9) %></td>
                     <td style="padding:10px"><%= rs.getString(3) %></td>
                     <td style="padding:10px"><%= rs.getString(4) %></td>
                     <td style="padding:10px"><%= rs.getString(5) %></td>
                     <td style="padding:10px"><%= rs.getString(6) %></td>
                     <td style="padding:10px"><%= rs.getString(7) %></td>
                     <td style="padding:10px"><%= rs.getString(8) %></td>
                     <td style="padding:10px"><a class="btn btn-info btn-fill" href="deletepolicy_plan?x=<%= rs.getString(1) %>">Delete</a></td>
                 <td style="padding:10px"><a class="btn btn-info btn-fill" href="editpolicy_plan.jsp?x=<%= rs.getString(1) %>">Edit</a></td>
                 </tr>
                 <%
             }
            %>
    </table>

<%@include file="footer.jsp" %>