
<%@include file="header.jsp" %>
<br>
<a href="UserController?action=main">&laquo;Back to the Main Page</a>
<div class="container col-md-10 col-md-offset-1 centerme">
    <form action="ReviewsController?action=addReviews" method="post">
        
        <div class="form-group form-inline ">
            <label class="col-md-2" for="code">Reviews Code</label>
            <input class="col-md-5" type="text" name="reviewsCode" id="code"required /><br>
        </div>
        <div class="form-group form-inline">
            <label class="col-md-2"> Title</label>
            <input class="col-md-5" type="text" name="Title" required /><br>
        </div>  
        <div class="form-group form-inline">
        <label class="col-md-2"> Description</label>
        <input class="col-md-5" type="text" name="Description" required/><br></div>
        <div class="form-group form-inline">
        <label class="col-md-2"> url</label>
        <input class="col-md-5" type="text" name="url" required/><br></div>
        <div class="form-group form-inline">
        <label class="col-md-2">Image URL</label>
        <input class="col-md-5" type="text" name="UrlToImage" required/><br></div>
        <br>
        <div class="form-group">
            <input type="submit" value="Create Reviews" class="btn"></div>
    </form>
</div>
<%@include file="footer.jsp" %>
