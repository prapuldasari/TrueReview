
<%@include file="header.jsp" %>

<a href="UserController?action=main">&laquo;Back to the Main Page</a>
<div class="container">
    <div class="row">
    <img src="${requestScope.reviews.urlToImage}" style="max-width:300px;max-height:200px;"></div>
    <div class="row">
        <h1>${requestScope.reviews.title}</h1></div>
    <div class="row">    
        <h4>${requestScope.reviews.description}</h4></div>
    <div class="row">
        <a href="${requestScope.reviews.url}">View Full Article</a></div>
    
</div>

<%@include file="footer.jsp" %>
