
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
        <c:forEach var="news" items="${reviewsList}">
            <tr>
                <td>${news.title}</td>
                <td>${news.newsCode}</td>
                <td><form class="inline" action="NewsController?action=approve&newsCode=${news.newsCode}" method="post">
                        <button class="color" type="submit">Approve</button></form>
                <form class="inline" action="NewsController?action=disapprove&newsCode=${news.newsCode}" method="post">
                    <button class="color" type="submit">Reject</button></form></td>
                <td><a class="blued" href="NewsController?action=viewNews&newsCode=${news.newsCode}" >View</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
        <%@ include file="footer.jsp" %>