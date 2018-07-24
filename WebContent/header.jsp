<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%-- Title--%>
<title>TrueReview</title>
<link rel="stylesheet" href="styles/main.css">
<link rel="stylesheet" href="styles/css/bootstrap.min.css">
        <script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
        <!-- BootStrap -->
          <link rel="stylesheet" href="styles/bootstrap.min.css">
        <script type="text/javascript">
        </script>
</head>
<body>
 <div class="jumbotron">
      <div class="container">
        <h1>TrueReview</h1>
        <p>See and Post Reviews</p>      
      </div>
    </div>
        <div id="header" >
            <nav class="navbar navbar-inverse" id="header_menu">
                <ul  class="left" >
                
                <li> <a href="UserController?action=index" style= "display: block;padding:0.85em 1em; line-height: 1em;text-decoration: none;color: yellowgreen;font-size: 22px">TrueReview</a></li>
                </ul>
                <ul class="right" class = "nav navbar-nav">
                    <c:if test="${theUser == null && theAdmin == null}">
                        <li><a href="UserController?action=about">About Us</a></li>
                        <li class="active"><a href="UserController?action=how">How it Works</a></li>
                        <li class="active"><a href="login.jsp">Login</a></li>
                          <li class="active"><a href="UserController?action=contact">Support</a></li>
                          <li class="active"><a href="UserController?action=sitemap">Sitemap</a></li>
                    </c:if>
                        <c:if test="${theUser != null}">
                        <li><a href="UserController?action=about">About Us</a></li>
                        <li><a href="UserController?action=how">How it Works</a></li>
                        <li>Hello,<c:out value = "${theUser.name}"/></li>
                        <li><a href="UserController?action=logout">Logout</a></li>
                        <li><a href="UserController?action=contact">Support</a></li>
                        <li><a href="UserController?action=sitemap">Sitemap</a></li>
                        </c:if>
                        <c:if test="${theAdmin != null}">
                        <li><a href="UserController?action=about">About Us</a></li>
                        <li><a href="UserController?action=how">How it Works</a></li>
                        <li>Hello, <c:out value = "${theAdmin.name  }"/> </li>
                        <li><a href="UserController?action=logout">Logout</a></li>
                        <li><a href="UserController?action=contact">Support</a></li>
                        <li><a href="UserController?action=sitemap">Sitemap</a></li>
                        </c:if>
                </ul>
            </nav>
        </div>
</body>
</html>