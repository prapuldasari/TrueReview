
<%-- importing header page --%>
<%@include file="header.jsp" %>
<%-- Section to input login details --%>
<div class="container ">
    <div class="row">
    <div class="centerDiv is-Responsive">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
    <%-- Code to create login form--%>
    <form action="UserController?action=login" method="post" class="form-group ">
        <input type="hidden" name="action" value="login">
        <div class="form-group text-center">
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" name="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
        </div>
        <div class="form-group text-center">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>
        <div class="form-group">
            <input type="submit" value="Log On" class="btn btn-def btn-block">
        </div>
        <div class="form-group">
            <h1 align="center">${requestScope.msg}</h1>
        </div>
        <div class="form-group text-center">
            <a href="signup.jsp" >Sign up for a new account</a>
        </div>
        </form>
    
</div>
</div>
</div>
</div>
    <%-- importing footer page --%>
<%@include file="footer.jsp" %>