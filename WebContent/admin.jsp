
<%-- importing header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display items in List --%>
<div class="page-container">
  <div class="container">
      <div class="row row-offcanvas row-offcanvas-left">

        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
            <ul class="nav borderme">
              <li class="active"><a href="admin.jsp">Home</a></li>
              <li><a href="ReviewsController?action=PostedReviews">Posted Reviews</a></li>
              <li><a href="about.jsp">About True Review</a></li>
              <li><a href="how.jsp">User Guide</a></li>
            </ul>
        </div>
        <div class="col-xs-12 col-sm-9">
          <h1>You have logged in as an admin. Now you have the ability to Approve or Reject the Reviews created by the users by selecting the "Reviews Posted" section</h1>
          
        </div>
    </div>
  </div>
</div>
<%--importing footer page --%>
<%@ include file="footer.jsp" %>