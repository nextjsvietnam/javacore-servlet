<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: sonnm
  Date: 5/10/2024
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Examples</title>
</head>
<body>
    <h1>Examples</h1>
    <h2>Add new example</h2>
    <ul>
        <%
            ArrayList<String> errors = (ArrayList<String>) request.getAttribute("errors");
            if (errors != null) {
                for (String error : errors) { %>
                    <li><%= error %></li>
                <% }
            }
        %>
    </ul>
    <form method="post" action="${pageContext.request.contextPath}/examples">
        <label for="title">Title</label>
        <input type="text" id="title" name="title" />
        <br/>
        <strong>Status</strong>
        <label>
            <input type="radio" name="status" value="0" /> Active
        </label>
        <label>
            <input type="radio" name="status" value="1" /> InActive
        </label>
        <br/>
        <button type="submit">Create an example</button>
    </form>
</body>
</html>
