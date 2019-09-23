<%@page import="PMS_pack.dbconnection"%>
<%@page  import="java.sql.*" %>

<%@include file="header.jsp" %>
<head>
</head>

<%
    dbconnection obj=new dbconnection();
    ResultSet rsc=obj.selectquery("select * from state");
    
    %>

<form action="addcity" name="f1"  method="post">
    
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> City :</h5></label>
            <input type="text" name="t12" required="required" class="form-control" onkeypress="return isAlfa(event)">
             
        </div>
     </div>
     </div>
    
    <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> State :</h5></label>
            <select name="t13" class="form-control">
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
      ResultSet rs= st.executeQuery("select * From city c,state s where c.state_id=s.state_id");
       
    %>
    <table    class="table-hover table-striped">
        <tr >
            <td style="padding:10px">City Id</td>
            <td style="padding:10px">City</td>
            <td style="padding:10px">State</td>
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
                     <td style="padding:10px"><a href="deletecity?x=<%= rs.getString(1) %>" class="btn btn-info btn-fill">Delete</a></td>
                 <td style="padding:10px"><a href="editCity.jsp?x=<%= rs.getString(1) %>" class="btn btn-info btn-fill">Edit</a></td>
                 </tr>
                 <%
             }
            %>
    </table>

<%@include file="footer.jsp" %>
