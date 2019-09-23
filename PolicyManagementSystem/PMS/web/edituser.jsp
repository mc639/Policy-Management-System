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
            <label><b><b style="color:red">*</b> First Name :</b></label>
            <input type="text" name="t1" required="required" class="form-control" onkeypress="return isAlfa(event)">
            <br>
        </div>
     </div>
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> Middle Name :</b></label>
            <input type="text" name="t2" required="required" class="form-control" onkeypress="return isAlfa(event)">
            <br>
        </div>
     </div>
     </div>
    
    <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> Last Name :</b></label>
            <input type="text" name="t3" required="required" class="form-control" onkeypress="return isAlfa(event)">
            <br>
        </div>
     </div>
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> Address :</b></label>
            <textarea name="t4" required="required" class="form-control"></textarea>
            <br>
        </div>
     </div>
     </div>
    
    <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> City :</b></label>
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
            <label><b><b style="color:red">*</b> Phone Number :</b></label>
            <input type="text" name="t6" required="required" maxlength="10" class="form-control"onkeypress="return isNumber(event)">
            <br>
        </div>
     </div>
     </div>
      
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b>Email Address :</b></label>
            <input type="text" name="t7" class="form-control">
            <br>
        </div>
     </div>
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> Birth Date</b></label>
            <input type="Date" name="t8" required="required" class="form-control">
            <br>
        </div>
     </div>
     </div>
     
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> Photo :</b></label>
            <input type="file" name="t9" required="required" accept="image/*" class="form-control">
            <br>
        </div>
     </div>
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> Marital Status :</b></label>
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
            <label><b><b style="color:red">*</b> Gender :</b></label>
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
            <label><b><b style="color:red">*</b> Login id :</b></label>
            <input type="text" name="t12" required="required" class="form-control">
            <br>
        </div>
     </div>
     </div>
      
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> Password :</b></label>
            <input type="text" name="t13" required="required" maxlength="15" class="form-control">
            <br>
        </div>
     </div>
     
     <div class="col-md-5">
        <div class="form-group">
            <label><b>Anniversary Date </b></label>
            <input type="date" name="t14" class="form-control">
            <br>
        </div>
     </div>
     </div>
      
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> id proof :</b></label>
            <input type="file" name="t15" required="required" accept="image/*"  class="form-control">
            <br>
        </div>
     </div>
     
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> Address proof :</b></label>
            <input type="file" name="t16" required="required" accept="image/*"  class="form-control">
            <br>
        </div>
     </div>
     </div>
            
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b> Office Address :</b></label>
            <textarea name="t21" class="form-control"></textarea>
            <br>
        </div>
     </div>
    
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> User type :</b></label>
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
            <label><b><b style="color:red">*</b> Premium Payment Mode :</b></label>
             <select name="t18" required="required" class="form-control">
                <option value="0">Online</option>
                <option value="1">Manual</option>
            </select>
            <br>
        </div>
     </div>
     
     <div class="col-md-5">
        <div class="form-group">
            <label><b>Bank Name :</b></label>
            <input type="text" name="t19"  class="form-control" onkeypress="return isAlfa(event)">
            <br>
        </div>
     </div>
     </div>
     
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b>Account Number :</b></label>
            <input type="text" name="t20" class="form-control" onkeypress="return isNumber(event)">
            <br>
        </div>
     </div>
     </div>
    
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <input type="submit"  class="btn btn-info btn-fill" value="Update" onclick="ValidateEmail(document.f1.t7);lengthRange(document.f1.t13,8,15)"> 
            <input type="reset"  class="btn btn-info btn-fill" value="Cancel">
        </div>
        </div>
     </div>
</form>

<br>
<br>


  
<%@include file="footer.jsp" %>