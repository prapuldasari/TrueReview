<%--importing header page --%>
<%@include file="header.jsp" %>

<div class="container ">
    <div class="row">
    <div class="centerDiv is-Responsive">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
        <form action="UserController?action=create" method="post" >
            <input type="hidden" name="action" value="signup" />
            <div class="form-group text-center">
                <label>Name</label>
                <input type="text" name="name" class="form-control" placeholder="Enter Name" required>
            </div>
            <div class="form-group text-center">
                <label>Email</label>
                <input type="email" name="email" class="form-control" placeholder="Enter Email  " required>
            </div>
            <div class="form-group text-center">
                <label>Password</label>
                <input type="password" name="password" class="form-control" placeholder="Enter Password" required>
            </div>
            <div class="form-group text-center">
                <label>Confirm Password</label>
                <input type="password" name="confirm_password" class="form-control" placeholder="Enter Password" required>
            </div>
            <div class="form-group text-center">
                <input type="submit" value="Register" class="btn btn-def btn-block">
            </div>
            <div class="form-group text-center">
                <h1 align="center">${requestScope.msg}</h1>
            </div>
        </form>
        </div>
    </div>
    </div>
</div>
<%-- importing footer page --%>
<%@include file="footer.jsp" %>