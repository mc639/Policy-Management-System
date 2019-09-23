<%@page import="PMS_pack.dbconnection"%>
<%@page  import="java.sql.*" %>

<%@include file="header.jsp" %>
<head>
</head>

<%
    dbconnection obj=new dbconnection();
    ResultSet rsc=obj.selectquery("select * From user_policy up , user u , policy_plan pp where up.user_id=u.user_id and up.plan_id=pp.plan_id ");
    String id=request.getParameter("x");
    ResultSet rss=obj.selectquery("select * From premium where premium_id="+ id+"");
    rss.next();
    %>

<form action="updatepremium" name="f1"  method="post">
    <input type="hidden" value="<%= rss.getString(1) %>" name="t11">
    <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> User :</b></label>
            <select name="t1" class="form-control">
                <%
                      while(rsc.next())
                     {
                         if(rsc.getString(1).equals(rss.getString(1)))
                         {
                         %>
                         <option selected value='<%= rsc.getString(1) %>'><%= rsc.getString(11)%> , <%= rsc.getString(41)%></option>
                         <%
                             }
                          else
{
                         %>
                         <option value='<%= rsc.getString(1) %>'><%= rsc.getString(11)%> , <%= rsc.getString(41)%></option>
                         <%

}
}
                %>
            </select>
            
        </div>
     </div>
     </div>
            
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> Payment Date :</b></label>
            <input type="date" name="t2" value="<%= rss.getString(3) %>" required="required" class="form-control">
             
        </div>
     </div>
     </div>
            
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> Amount :</b></label>
            <input type="text" name="t3" value="<%= rss.getString(4) %>" required="required" class="form-control" onkeypress="return isNumber(event)">
             
        </div>
     </div>
     </div>
     
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> Payment Mode :</b></label>
            <select name="t4" required="required" value="<%= rss.getString(6) %>" class="form-control">
                <option value="0">Cash</option>
                <option value="1">Cheque</option>
            </select>
             
        </div>
     </div>
     </div>
            
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b>Cheque Number :</b></label>
            <input type="text" name="t5" value="<%= rss.getString(5) %>" class="form-control" onkeypress="return isNumber(event)">
             
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

