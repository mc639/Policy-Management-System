<%@page  import="java.sql.*" %>
<%@page import="PMS_pack.dbconnection"%>
<%@include file="header.jsp" %>
<head>
</head>

<%
    dbconnection obj=new dbconnection();
    String id=request.getParameter("x");
    ResultSet rss=obj.selectquery("select *From country where countryid="+ id+"");
    rss.next();
    %>

<form action="updatecountry" name="f1"  method="post">
    <input type="hidden" value="<%= rss.getString(1) %>" name="t0">
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> Country :</b></label>
            <input type="text" name="t1" required="required" class="form-control" onkeypress="return isAlfa(event)">
            <br>
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
