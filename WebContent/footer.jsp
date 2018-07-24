<%--  footer section --%>
<section class="copyright">
    &copy; TrueReview-prapul
     <c:if test="${cookie.hostName.value != null}">
     	<c:out value="${cookie.hostName.value }"></c:out>
     </c:if>
</section>


</body>
</html>