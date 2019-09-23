<%@page import="PMS_pack.dbconnection"%>
<%@page  import="java.sql.*" %>
<%@include file="header.jsp" %>

<%
    dbconnection obj=new dbconnection();
    String id=request.getParameter("x");
    ResultSet rss=obj.selectquery("select * From policy where policy_id="+ id+"");
    rss.next();
    %>
    
<form action="updatepolicy" name="f1"  method="post">
    <input type="hidden" value="<%= rss.getString(1) %>" name="t3">
    <div class="row">
     <div class="col-md-5">
            <div class="form-group">
            <label><b><b style="color:red">*</b> Policy Number  :</b></label>
            <input type="text" required="required" name="t5" value="<%= rss.getString(3) %>" class="form-control" onkeypress="return isNumber(event)">
            
            </div>
     </div>
    
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> Policy Name :</b></label>
            <input type="text" required="required" name="t4" value="<%= rss.getString(2) %>" class="form-control">
            
            </div>
     </div>
    </div>
   
    <div class="row">
     <div class="col-md-5">
         <div class="form-group">
            <label><b><b style="color:red">*</b> Sum Assurance :</b></label>
            <input type="text" required="required" name="t6" value="<%= rss.getString(4) %>" class="form-control" onkeypress="return isNumber(event)">
            
            </div>
     </div>
    
     <div class="col-md-5">
         <div class="form-group">
            <label><b><b style="color:red">*</b> Surrender Policy Percentage :</b></label>
            <input type="text" required="required" name="t7" value="<%= rss.getString(5) %>" class="form-control" onkeypress="return isNumber(event)">
            
            </div>
     </div>
    </div>
    
    <div class="row">
     <div class="col-md-5">
         <div class="form-group">
            <label><b><b style="color:red">*</b> Minimum Age :</b></label>
            <input type="text" required="required" name="t8" value="<%= rss.getString(6) %>" class="form-control" onkeypress="return isNumber(event)">
            
            </div>
     </div>
    
     <div class="col-md-5">
         <div class="form-group">
            <label><b><b style="color:red">*</b> Maximum Age :</b></label>
            <input type="text" required="required" name="t9" value="<%= rss.getString(7) %>" class="form-control" onkeypress="return isNumber(event)">
            </div>
     </div>
    </div>
                         
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <input type="submit"  class="btn btn-info btn-fill" value="Update">
            <input type="reset"  class="btn btn-info btn-fill" value="Cancel">
        </div>
    </div>
     </div>
</form>

<br>
<br>

<%@include file="footer.jsp" %>