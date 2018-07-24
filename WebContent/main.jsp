
<%-- importing header page --%>
<%@ include file="header.jsp" %>
<%-- Code to display items in List --%>
<div class="container">
      <div class="row row-offcanvas row-offcanvas-left">
		<div class="col-xs-8 col-sm-4 sidebar-offcanvas" id="sidebar" role="navigation">
            <ul class="nav borderme">
              <li>Number of Posts made: <b>${sessionScope.theUser.numOfPosts} </b></li>
              <li>Number of Posts Approved: <b>${sessionScope.theUser.numOfPostedReviews}</b> </li>
              <li><br></li>
              <li><a href="UserController?action=main">Home</a></li>
               <li><a href="CreateReview.jsp">Create Review</a></li>
              <li><a href="ReviewsController?action=myReviews">My Reviews</a></li>
              <c:if test="${sessionScope.theUser == null && sessionScope.theAdmin == null }">
                        <li><a href="aboutus.jsp">About Review Creator</a></li>
                        <li><a href="how.jsp">User Guide</a></li>
                        </c:if>
                        <c:if test="${sessionScope.theUser.name != null}">
                        <li><a href="aboutus.jsp">About Review Creator</a></li>
                        <li><a href="how.jsp">User Guide</a></li>
                        </c:if>
            </ul>
        </div>
<div class="col-xs-12 col-sm-6">
          <h3>You have logged in as Reporter. You can create a new Review, view the previously created review too.
          </h3>
          
        </div>
    </div>
  </div>

<%@ include file="footer.jsp" %>