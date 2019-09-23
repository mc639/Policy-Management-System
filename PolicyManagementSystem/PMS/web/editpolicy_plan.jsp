<%@page  import="java.sql.*" %>
<%@page import="PMS_pack.dbconnection"%>
<%@include file="header.jsp" %>

<%
    dbconnection obj=new dbconnection();
    ResultSet rsc=obj.selectquery("select * from policy");
    String id=request.getParameter("x");
    ResultSet rss=obj.selectquery("select * From policy_plan where plan_id="+ id+"");
    rss.next();
    
%>
<form action="updatepolicy_plan" method="post">
    <input type="hidden" value="<%= rss.getString(1) %>" name="t13">
    <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> Policy Name :</b></label>
            <select name="t14" class="form-control">
                
     <%
                      while(rsc.next())
                     {
                         if(rsc.getString(1).equals(rss.getString(2)))
                         {
                         %>
                         <option selected value='<%= rsc.getString(1) %>'><%= rsc.getString(2) %></option>
                         <%
                             }
                          else
{
                         %>
                         <option value='<%= rsc.getString(1) %>'><%= rsc.getString(2) %></option>
                         <%

}
}
                %>
            </select>
        </div>
     </div>
     
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> Plan Name :</b></label>
            <input type="text" required="required" value="<%= rss.getString(9) %>" name="t15" class="form-control" >
            </div>
     </div>
    </div>
   
    <div class="row">
     <div class="col-md-5">
         <div class="form-group">
            <label><b><b style="color:red">*</b> Tabular rate :</b></label>
            <input type="text" required="required" value="<%= rss.getString(3) %>" name="t16" class="form-control" >
            </div>
     </div>
    
     <div class="col-md-5">
         <div class="form-group">
            <label><b><b style="color:red">*</b> Rebate on 2 to 5 Lakh :</b></label>
            <input type="text" required="required" value="<%= rss.getString(4) %>" name="t17" class="form-control" >
            </div>
     </div>
    </div>
    
    <div class="row">
     <div class="col-md-5">
         <div class="form-group">
            <label><b><b style="color:red">*</b> Rebate on 5 Lakh and above :</b></label>
            <input type="text" required="required" value="<%= rss.getString(5) %>" name="t18" class="form-control" >
            </div>
     </div>
    
     <div class="col-md-5">
                 <div class="form-group">
            <label><b><b style="color:red">*</b>Discount on premium Mode for 6 Months :</b></label>
            <input type="text" required="required" value="<%= rss.getString(6) %>" name="t19" class="form-control" >
            </div>
     </div>
    </div>
    
    <div class="row">
     <div class="col-md-5">
         <div class="form-group">
            <label><b><b style="color:red">*</b>Discount on premium Mode for 12 Months :</b></label>
            <input type="text" required="required" value="<%= rss.getString(7) %>" name="t20" class="form-control" >
            </div>
     </div>
    
     <div class="col-md-5">
         <div class="form-group">
            <label><b><b style="color:red">*</b> Number of years :</b></label>
            <input type="text" required="required" name="t21" value="<%= rss.getString(8) %>" class="form-control" onkeypress="return isNumber(event)">
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

<%@include file="footer.jsp" %>