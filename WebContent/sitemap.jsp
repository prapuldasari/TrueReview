<%--importing header page --%>
<%@include file="header.jsp" %>
<%-- Section tag is used to write description  --%>
<li><a href="UserController?action=index">Home</a></li>
<li><a href="UserController?action=about">About Us</a></li>
<li class="active"><a href="UserController?action=how">How it Works</a></li>
<li class="active"><a href="login.jsp">Login</a></li>
<li class="active"><a href="UserController?action=contact">Support</a></li>
<li class="active"><a href="UserController?action=sitemap">Sitemap</a></li>

<%--importing footer page --%>
</section>
<%@include file="footer.jsp" %>