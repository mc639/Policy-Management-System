<%@page  import="java.sql.*" %>
<%@include file="header.jsp" %>
<head>
</head>
<form action="addtax" name="f1"  method="post">
    
     <div class="row">
     <div class="col-md-5">
            <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Tax Name :</h5></label>
            <input type="text" name="t2" required="required" class="form-control" onkeypress="return isAlfa(event)">
            
            </div>
     </div>
     </div>
    
     <div class="row">
     <div class="col-md-5">
           <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Tax Percentage :</h5></label>
            <input type="text" name="t3" required="required" class="form-control" onkeypress="return isNumber(event)">
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
      ResultSet rs= st.executeQuery("select * From tax");
       
    %>
    <table class="table-hover table-striped">
        <tr>
            <td  style="padding:10px">Tax_id</td>
            <td  style="padding:10px">Tax_name</td>
            <td  style="padding:10px">Tax_percentage</td>
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
                     <td style="padding:10px"><a class="btn btn-info btn-fill" href="deletetax?x=<%= rs.getString(1) %>">Delete</a></td>
                 <td style="padding:10px"><a class="btn btn-info btn-fill" href="#">Edit</a></td>
                 </tr>
                 <%
             }
            %>
    </table>
<%@include file="footer.jsp" %>