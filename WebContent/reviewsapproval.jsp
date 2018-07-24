
<%@ include file="header.jsp" %>
<a href="UserController?action=main" id="back_to_page">&laquo;Back to the Main Page</a>

<div class="container">
    <table class="table table-bordered">
        <thead class="changeColor">
            <tr>
                <th>Review </th>
                <th>Review Code</th>
                <th>Approve/Reject</th>
                <th>View the Review</th>
            </tr>
        </thead>
        <tbody>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:forEach var="reviews" items="${reviewsList}">
            <tr>
                <td>${reviews.title}</td>
                <td>${reviews.reviewsCode}</td>
                <td><form class="inline" action="ReviewsController?action=approve&reviewsCode=${reviews.reviewsCode}" method="post">
                        <button class="color" type="submit">Approve</button></form>
                <form class="inline" action="ReviewsController?action=disapprove&reviewsCode=${reviews.reviewsCode}" method="post">
                    <button class="color" type="submit">Reject</button></form></td>
                <td><a class="blued" href="ReviewsController?action=viewReviews&reviewsCode=${reviews.reviewsCode}" >View</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
        <%@ include file="footer.jsp" %>