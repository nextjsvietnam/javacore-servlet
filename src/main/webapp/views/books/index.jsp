<%@include file="/layout/header.jsp" %>
<%
    // HTTP 1.1
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    // HTTP 1.0
    response.setHeader("Pragma", "no-cache");
    // Proxies
    response.setHeader("Expires", "0");
%>
<h1><c:out value="${pageTitle}" /></h1>
<p>Hello world 123!</p>
<%@include file="/layout/footer.jsp" %>