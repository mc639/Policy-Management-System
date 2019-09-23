<%@page  import="java.sql.*" %>

<%@include file="header.jsp" %>


<%
     if(session.getAttribute("id")==null||session.getAttribute("id").toString().equals(""))
     {
         response.sendRedirect("login.jsp");
     }
     else
     {
    %>
<form action="addcountry" name="f1"  method="post">
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h3 style="color:black"><b style="color:red">*</b> Country :</h3></label>
            <input type="text" name="t1" required="required" class="form-control" onkeypress="return isAlfa(event)">
            <br>
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
      ResultSet rs= st.executeQuery("select *From country");
       
    %>
    <table    class="table-hover table-striped">
        <tr >
            <td style="padding:10px">Country Id</td>
            <td style="padding:10px">Country</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <%
             while(rs.next())
             {
                 %>
                 <tr>
                     <td style="padding:10px"><%= rs.getString(1) %></td>
                     <td style="padding:10px">  <%= rs.getString(2) %></td>
                     <td style="padding:10px"><a class="btn btn-info btn-fill" href="deletecountry?x=<%= rs.getString(1) %>">Delete</a></td>
                 <td style="padding:10px"><a class="btn btn-info btn-fill" href="editCountry.jsp?x=<%= rs.getString(1) %>">Edit</a></td>
                 </tr>
                 <%
             }
            %>
    </table>
            <%
                }
                %>
<%@include file="footer.jsp" %>
