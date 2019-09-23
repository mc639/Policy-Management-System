
<%@include file="header.jsp" %>

<script>
    function check()
    {
         var np=document.f1.t2.value;
         var cp=document.f1.t3.value;
         var flag=true;
        if(np!=cp)
        {
            document.getElementById("d1").innerHTML="Password Didn't Match ";
             flag=false;
        }
        else
        {
             document.getElementById("d1").innerHTML="";
        }
      return flag;
    }
    
   </script>
<form name="f1" onsubmit="return check();" action="updatepassword" method="post">                                
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <h5 style="color:black"<label>Old Password </label></h5>
                                                <input type="password" name="t1" class="form-control"  placeholder="Enter Old Password" required="required" >
                                                <br>
                                            </div>
                                        </div>
                                      </div>

                
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <h5 style="color:black"<label> New Password</label></h5>
                                                <input type="password" name="t2" class="form-control"  placeholder="Enter New Password" required="required" >
                                                <br>
                                            </div>
                                        </div>
                                      </div>
    
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <h5 style="color:black"<label> Confirm Password</label></h5>
                                                <input type="password" name="t3" class="form-control"  placeholder="Confirm Password" required="required" >
                                                
                                                <br>
                                                <div id="d1"></div>
                                            </div>
                                        </div>
                                      </div>
                                    
                                    
                                    <button type="submit" class="btn btn-info btn-fill ">Submit</button>
									&nbsp;&nbsp;
									<button type="reset" class="btn btn-info btn-fill ">Cancel</button>
									
                                    <div class="clearfix"></div>
                                </form>
   <br>
   <br>
   <%
        if(request.getParameter("x")!=null)
        {
            if(request.getParameter("x").equals("1"))
            {
                %>
                <b> Your Password has been changed Successfully</b>
                 <%       
            }
            else
            {
               %>
               <b>Invalid Old Password </b>
               <%       
                
            }
        }        

       %>

<%@include file="footer.jsp" %>