<%@page import="PMS_pack.dbconnection"%>
<%@page  import="java.sql.*" %>

<%@include file="header.jsp" %>

<form action="" name="f1"  method="post">
    
    <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b>Email Address :</b></label>
            <input type="text" name="t7" class="form-control" >
            <br>
        </div>
     </div>
     </div>
    
    <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <input type="submit"  class="btn btn-info btn-fill" value="Submit" onclick="ValidateEmail(document.f1.t7)"> 
            <input type="reset"  class="btn btn-info btn-fill" value="Cancel">
        </div>
        </div>
     </div>
</form>

<%@include file="footer.jsp" %>