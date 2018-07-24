
<%@ include file="header.jsp" %>
<br>

<a href="UserController?action=main">&laquo;Back to the Main Page</a>
<br>
<br>
<br>
<div class="container">
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Reviews Title</th>
                <th>Reviews Code</th>
                <th>Reviews Status</th>
                <th>View Reviews</th>
            </tr>
        </thead>
        <tbody>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:forEach var="reviews" items="${reviewsList}">
            <tr>
                <td>${reviews.title}</td>
                <td>${reviews.reviewsCode}</td>
                <td>${reviews.reviewsStatus}</td>
                <td><a class="blued" href="ReviewsController?action=viewReviews&reviewsCode=${reviews.reviewsCode}" >View</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%-- Include tag is used to import footer page --%>
<%@ include file="footer.jsp" %>