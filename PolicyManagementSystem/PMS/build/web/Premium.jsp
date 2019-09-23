<%@page import="PMS_pack.dbconnection"%>
<%@page  import="java.sql.*" %>

<%@include file="header.jsp" %>
<head>
</head>

<%
    dbconnection obj=new dbconnection();
    ResultSet rsc=obj.selectquery("select * From user_policy up , user u , policy_plan pp where up.user_id=u.user_id and up.plan_id=pp.plan_id ");
    
    %>

<form action="addpremium" name="f1"  method="post">
    <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> User :</h5></label>
            <select name="t1" class="form-control">
                <%
                     while(rsc.next())
                     {
                         %>
                         <option value='<%= rsc.getString(1) %>'><%= rsc.getString(11)%> , <%= rsc.getString(41)%></option>
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
            <label><h5 style="color:black"><b style="color:red">*</b> Payment Date :</h5></label>
            <input type="date" name="t2" required="required" class="form-control">
             
        </div>
     </div>
     </div>
            
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Amount :</h5></label>
            <input type="text" name="t3" required="required" class="form-control" onkeypress="return isNumber(event)">
             
        </div>
     </div>
     </div>
     
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Payment Mode :</h5></label>
            <select name="t4" required="required" class="form-control">
                <option value="0">Cash</option>
                <option value="1">Cheque</option>
            </select>
             
        </div>
     </div>
     </div>
            
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black">Cheque Number :</h5></label>
            <input type="text" name="t5" class="form-control" onkeypress="return isNumber(event)">
             
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
      ResultSet rs= st.executeQuery("select * From user_policy up , user u , policy_plan pp , premium pr where up.user_id=u.user_id and up.plan_id=pp.plan_id ");
       
    %>
    <table    class="table-hover table-striped">
        <tr >
            <td style="padding:10px">User Policy</td>
            <td style="padding:10px">Payment Date</td>
            <td style="padding:10px">Amount</td>
            <td style="padding:10px">Payment Mode</td>
            <td style="padding:10px">Cheque Number</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <%
             while(rs.next())
             {
                 %>
                 <tr>
                     <td style="padding:10px"><%= rs.getString(11) %> ,<%= rs.getString(41) %></td>
                     <td style="padding:10px">  <%= rs.getString(44) %></td>
                      <td style="padding:10px">  <%= rs.getString(45) %></td>
                      <td style="padding:10px"><%  
                         if(rs.getString(47).equals("0"))
                            {
                                out.print("Cash");
                            }
                            else
                            {
                                out.print("Cheque");
                            }%>
                     </td>
                      <td style="padding:10px">  <%= rs.getString(46) %></td>
                     <td style="padding:10px"><a class="btn btn-info btn-fill" href="deletepremium?x=<%= rs.getString(42) %>">Delete</a></td>
                 <td style="padding:10px"><a class="btn btn-info btn-fill" href="editpremium.jsp?x=<%= rs.getString(42) %>">Edit</a></td>
                 </tr>
                 <%
             }
            %>
    </table>

<%@include file="footer.jsp" %>

