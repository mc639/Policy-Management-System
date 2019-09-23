<%@page import="PMS_pack.dbconnection"%>
<%@page  import="java.sql.*" %>

<%@include file="header.jsp" %>
<head>
    
</head>

<%
    dbconnection obj=new dbconnection();
    ResultSet rsc=obj.selectquery("select *from country");
    
    %>
    

<form action="addstate" name="f1"  method="post">
    
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> State :</h5></label>
            <input type="text" name="t10" required="required" class="form-control" onkeypress="return isAlfa(event)">
            
        </div>
     </div>
     </div>
    
    <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Country :</h5></label>
            <select name="t11" class="form-control">
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
      ResultSet rs= st.executeQuery("select * From state s,country c where s.countryid=c.countryid");
       
    %>
    <table    class="table-hover table-striped">
        <tr >
            <td style="padding:10px">State Id</td>
            <td style="padding:10px">State</td>
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
                     <td style="padding:10px">  <%= rs.getString(5) %></td>
                     <td style="padding:10px"><a class="btn btn-info btn-fill" href="deletestate?x=<%= rs.getString(1) %>">Delete</a></td>
                 <td style="padding:10px"><a class="btn btn-info btn-fill" href="editstate.jsp?x=<%= rs.getString(1) %>">Edit</a></td>
                 </tr>
                 <%
             }
            %>
    </table>

<%@include file="footer.jsp" %>
