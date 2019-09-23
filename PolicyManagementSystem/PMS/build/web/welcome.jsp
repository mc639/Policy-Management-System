<%@page import="PMS_pack.dbconnection"%>
<%@page  import="java.sql.*" %>

<%@include file="header.jsp" %>

<%
     if(session.getAttribute("id")==null||session.getAttribute("id").toString().equals(""))
     {
         response.sendRedirect("login.jsp");
     }
     else
     {
    %>
<%
      String id=session.getAttribute("id").toString();
      dbconnection obj=new dbconnection();
      ResultSet rs=obj.selectquery("select *from user where user_id='"+ id +"'");
      rs.next();
    %>

    <h2> Welcome <%= rs.getString(2) %></h2>
    <%
        }
%>
    <%@include file="footer.jsp" %>