<%@page import="PMS_pack.dbconnection"%>
<%@page  import="java.sql.*" %>

<%@include file="header.jsp" %>
<%

    dbconnection obj=new dbconnection();
    ResultSet rsc=obj.selectquery("select *from city");
    
%>
<head>
    
</head>

<form action="adduser" name="f1"  method="post" enctype="multipart/form-data">
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> First Name :</h5></label>
            <input type="text" name="t1" required="required" class="form-control" onkeypress="return isAlfa(event)">
            <br>
        </div>
     </div>
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Middle Name :</h5></label>
            <input type="text" name="t2" required="required" class="form-control" onkeypress="return isAlfa(event)">
            <br>
        </div>
     </div>
     </div>
    
    <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Last Name :</h5></label>
            <input type="text" name="t3" required="required" class="form-control" onkeypress="return isAlfa(event)">
            <br>
        </div>
     </div>
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Address :</h5></label>
            <textarea name="t4" required="required" class="form-control"></textarea>
            <br>
        </div>
     </div>
     </div>
    
    <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> City :</h5></label>
            <select name="t5" class="form-control">
                <%
                     while(rsc.next())
                     {
                         %>
                         <option value='<%= rsc.getString(1) %>'><%= rsc.getString(2) %></option>
                         <%
                     }    
                %>     
            </select>
            <br>
        </div>
     </div>
 
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Phone Number :</h5></label>
            <input type="text" name="t6" required="required" maxlength="10" class="form-control"onkeypress="return isNumber(event)">
            <br>
        </div>
     </div>
     </div>
      
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black">Email Address :</h5></label>
            <input type="text" name="t7" class="form-control">
            <br>
        </div>
     </div>
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Birth Date</h5></label>
            <input type="Date" name="t8" required="required" class="form-control">
            <br>
        </div>
     </div>
     </div>
     
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Photo :</h5></label>
            <input type="file" name="t9" required="required" accept="image/*" class="form-control">
            <br>
        </div>
     </div>
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Marital Status :</h5></label>
            <select name="t10" class="form-control">
                <option value="1">Single</option>
                <option value="2">Married</option>
                <option value="3">Widow/Widower</option>
                <option value="4">Divorced</option>
            </select>
            <br>
        </div>
     </div>
     </div>
            
      <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Gender :</h5></label>
            <select name="t11" class="form-control">
                <option value="1">Male</option>
                <option value="2">Female</option>
                <option value="3">Others</option>
            </select>
            <br>
        </div>
     </div>
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Login id :</h5></label>
            <input type="text" name="t12" required="required" class="form-control">
            <br>
        </div>
     </div>
     </div>
      
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Password :</h5></label>
            <input type="text" name="t13" required="required" maxlength="15" class="form-control">
            <br>
        </div>
     </div>
     
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black">Anniversary Date </h5></label>
            <input type="date" name="t14" class="form-control">
            <br>
        </div>
     </div>
     </div>
      
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> id proof :</h5></label>
            <input type="file" name="t15" required="required" accept="image/*"  class="form-control">
            <br>
        </div>
     </div>
     
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Address proof :</h5></label>
            <input type="file" name="t16" required="required" accept="image/*"  class="form-control">
            <br>
        </div>
     </div>
     </div>
            
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"> Office Address :</h5></label>
            <textarea name="t21" class="form-control"></textarea>
            <br>
        </div>
     </div>
    
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="black"><b style="color:red">*</b> User type :</h5></label>
            <select name="t17" required="required" class="form-control">
                <option value="0">Client</option>
                <option value="1">Administrator</option>
            </select>
            <br>
        </div>
     </div>
     </div>
     
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black"><b style="color:red">*</b> Premium Payment Mode :</h5></label>
             <select name="t18" required="required" class="form-control">
                <option value="0">Online</option>
                <option value="1">Manual</option>
            </select>
            <br>
        </div>
     </div>
     
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black">Bank Name :</h5></label>
            <input type="text" name="t19"  class="form-control" onkeypress="return isAlfa(event)">
            <br>
        </div>
     </div>
     </div>
     
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><h5 style="color:black">Account Number :</h5></label>
            <input type="text" name="t20" class="form-control" onkeypress="return isNumber(event)">
            <br>
        </div>
     </div>
     </div>
    
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <input type="submit"  class="btn btn-info btn-fill" value="Submit" onclick="ValidateEmail(document.f1.t7);lengthRange(document.f1.t13,8,15)"> 
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
      ResultSet rs= st.executeQuery("select *From user u,city c where u.city_id=c.city_id");
       
    %>
    <table   class="table-hover table-striped">
        <tr >
            <td style="padding:10px">User id</td>
            <td style="padding:10px">First Name</td>
            <td style="padding:10px">Middle Name</td>
            <td style="padding:10px">Last Name</td>
            <td style="padding:10px">Address</td>
            <td style="padding:10px">City</td>
            <td style="padding:10px">Phone Number</td>
            
            <td style="padding:10px">Birth Date</td>
            <td style="padding:10px">Photo</td>
            <td style="padding:10px">Martial status</td>
            <td style="padding:10px">Gender</td>
            
            <td>&nbsp;</td>
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
                     <td style="padding:10px"><%= rs.getString(25) %></td>
                     <td style="padding:10px"><%= rs.getString(7) %></td>
                     <td style="padding:10px"><%= rs.getString(9) %></td>
                     <td style="padding:10px"><a href="<%= rs.getString(10) %>" target="_blank"><img src='<%= rs.getString(10) %>' width="50" height="50"></a></td>
                     <td style="padding:10px"><%= rs.getString(11) %></td>
                     <td style="padding:10px"><%
                            if(rs.getString(12).equals("1"))
                            {
                                out.print("Male");
                            }
                            else
                            {
                                out.print("Female");
                            }
                         %></td>
                     <td style="padding:10px"><a class="btn btn-info btn-fill" href="deleteuser?x=<%= rs.getString(1) %>">Delete</a></td>
                 <td style="padding:10px"><a class="btn btn-info btn-fill" href="#">Edit</a></td>
                 <td style="padding:10px"><a class="btn btn-info btn-fill" href="User_Details.jsp?x=<%= rs.getString(1) %>">Details</a></td>
                 
                 </tr>
  
                 <%
             }
            %>
    </table>
  
<%@include file="footer.jsp" %>