
<%@include file="header.jsp" %>

<script>
   </script>
<form name="f1" action="" method="post">                                
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label>New Password</label>
                                                <input type="text" name="t1" class="form-control"  placeholder="Enter New Password " required="required" >
                                                <br>
                                            </div>
                                        </div>
                                      </div>
    
                                      <div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label>Confirm Password</label>
                                                <input type="text" name="t2" class="form-control"  placeholder="Enter the Password again " required="required" >
                                                <br>
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

<%@include file="footer.jsp" %>