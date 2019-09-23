<%@page  import="java.sql.*" %>
<%@include file="header.jsp" %>

<form action="addpolicy" name="f1"  method="post">
    
    <div class="row">
     <div class="col-md-5">
            <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Policy Number  :</h5></label>
            <input type="text" required="required" name="t5" class="form-control" onkeypress="return isNumber(event)">
            
            </div>
     </div>
    
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Policy Name :</h5></label>
            <input type="text" required="required" name="t4" class="form-control">
            
            </div>
     </div>
    </div>
   
    <div class="row">
     <div class="col-md-5">
         <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Sum Assurance :</h5></label>
            <input type="text" required="required" name="t6" class="form-control" onkeypress="return isNumber(event)">
            
            </div>
     </div>
    
     <div class="col-md-5">
         <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Surrender Policy Percentage :</h5></label>
            <input type="text" required="required" name="t7" class="form-control" onkeypress="return isNumber(event)">
            
            </div>
     </div>
    </div>
    
    <div class="row">
     <div class="col-md-5">
         <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Minimum Age :</h5></label>
            <input type="text" required="required" name="t8" class="form-control" onkeypress="return isNumber(event)">
            
            </div>
     </div>
    
     <div class="col-md-5">
         <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Maximum Age :</h5></label>
            <input type="text" required="required" name="t9" class="form-control" onkeypress="return isNumber(event)">
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
      ResultSet rs= st.executeQuery("select * From policy");
       
    %>
    <table class="table-hover table-striped">
        <tr>
            <td style="padding:10px">Policy id</b></td>
            <td style="padding:10px">Policy Name</td>
            <td style="padding:10px">Policy Number</td>
            <td style="padding:10px">Sum Insurance</td>
            <td style="padding:10px">Surrender Policy Percentage</td>
            <td style="padding:10px">Minimum Age</td>
            <td style="padding:10px">Maximum Age</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <%
             while(rs.next())
             {
                 %>
                 <tr>
                     <td style="padding:10px"><%= rs.getString(1) %></td>
                     <td style="padding:10px"><%= rs.getString(2) %></td>
                     <td style="padding:10px"><%= rs.getString(3) %></td>
                     <td style="padding:10px"><%= rs.getString(4) %></td>
                     <td style="padding:10px"><%= rs.getString(5) %></td>
                     <td style="padding:10px"><%= rs.getString(6) %></td>
                     <td style="padding:10px"><%= rs.getString(7) %></td>
                     <td style="padding:10px"><a class="btn btn-info btn-fill" href="deletepolicy?x=<%= rs.getString(1) %>">Delete</a></td>
                 <td style="padding:10px"><a class="btn btn-info btn-fill"  href="editpolicy.jsp?x=<%= rs.getString(1) %>">Edit</a></td>
                 </tr>
                 <%
             }
            %>
    </table>

<%@include file="footer.jsp" %>