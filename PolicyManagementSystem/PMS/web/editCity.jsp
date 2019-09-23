<%@page import="PMS_pack.dbconnection"%>
<%@page  import="java.sql.*" %>

<%@include file="header.jsp" %>
<head>
</head>

<%
    dbconnection obj=new dbconnection();
    ResultSet rsc=obj.selectquery("select * from state");
    String id=request.getParameter("x");
    ResultSet rss=obj.selectquery("select *From city where city_id="+ id+"");
    rss.next();
    
    %>

<form action="updatecity" name="f1"  method="post">
    <input type="hidden" value="<%= rss.getString(1) %>" name="t11">
     <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> City :</b></label>
            <input type="text" name="t12" value="<%= rss.getString(2) %>" required="required" class="form-control" onkeypress="return isAlfa(event)">
             
        </div>
     </div>
     </div>
    
    <div class="row">
     <div class="col-md-5">
        <div class="form-group">
            <label><b><b style="color:red">*</b> State :</b></label>
            <select name="t13" class="form-control">
                <%
                      while(rsc.next())
                     {
                         if(rsc.getString(1).equals(rss.getString(3)))
                         {
                         %>
                         <option selected  value='<%= rsc.getString(1) %>'><%= rsc.getString(2) %></option>
                         <%
                             }
                          else
{
                         %>
                         <option   value='<%= rsc.getString(1) %>'><%= rsc.getString(2) %></option>
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
            <input type="submit"  class="btn btn-info btn-fill" value="Update"> 
            <input type="reset"  class="btn btn-info btn-fill" value="Cancel">
        </div>
        </div>
     </div>
</form>

<br>
<br>

<%@include file="footer.jsp" %>
