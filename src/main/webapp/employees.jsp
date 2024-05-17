<%@ page import="java.sql.*" %>
<%@ page import="model.Employee" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" />

<%
    String DB_URL = "jdbc:mysql://localhost:3306/jsp";
    String DB_USER = "root";
    String DB_PASS = "123456";
    Connection connection = null;
    ArrayList<Employee> employees = new ArrayList<Employee>();
    try {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection to the database
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        Statement statement = connection.createStatement();

        // Execute a SQL query
        String sql = "SELECT * FROM jsp_employees";
        ResultSet resultSet = statement.executeQuery(sql);

        // Process the ResultSet
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");

            // Create an Employee object and add it to the list
            Employee employee = new Employee(id, email, firstName, lastName);
            employees.add(employee);
        }
    } catch (ClassNotFoundException e) {
        out.println("MySQL JDBC Driver not found: " + e.getMessage());
    } catch (SQLException e) {
        out.println("Database error: " + e.getMessage());
    } finally {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                out.println("Error closing the connection: " + e.getMessage());
            }
        }
    }
    request.setAttribute("pageTitle", "Employees");
%>

<%@ include file="layout/header.jsp" %>
<table class="table table-striped table-bordered">
    <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
        </tr>
    </thead>
    <% for (Employee employee : employees) { %>
    <tr>
        <td><%= employee.getId() %></td>
        <td><%= employee.getFirst()%></td>
        <td><%= employee.getLast()%></td>
        <td><%= employee.getAge()%></td>
    </tr>
    <% } %>
</table>
<%@ include file="layout/footer.jsp" %>
