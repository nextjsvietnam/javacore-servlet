<%@ page import="java.sql.*" %>
<%@ page import="model.Employee" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<sql:setDataSource var="db"
                   driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/jsp"
                   user="root"
                   password="123456"
/>
<sql:query var="resultSet" dataSource="${db}">SELECT * FROM jsp_employees</sql:query>
<%
    request.setAttribute("pageTitle", "Employees");
%>
<%@ include file="layout/header.jsp" %>
<c:set var="str" value="Hello JSP" />
<c:if test="${fn:length(str) % 2 == 0}">
    Even
</c:if>
<c:if test="${fn:length(str) % 2 != 0}">
    Odd
</c:if>
<table class="table table-striped table-bordered">
    <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${resultSet.rows}" var="employee">
                <tr>
                    <td><c:out value="${employee.id}" /></td>
                    <td><c:out value="${employee.first_name}" /></td>
                    <td><c:out value="${employee.last_name}" /></td>
                    <td><c:out value="${employee.email}" />(${fn:length(employee.email)})</td>
                </tr>
        </c:forEach>
    </tbody>
</table>
<%@ include file="layout/footer.jsp" %>


