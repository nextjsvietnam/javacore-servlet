package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    String databaseUrl = "jdbc:mysql://localhost:3306/jsp";
    String databaseUser = "root";
    String databasePassword = "123456";
    String query = "Select id from jsp_users where email=? and password=?";
    public boolean check(String username, String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            return rs.next();

        } catch (Exception e) {
            return false;
        }
    }
}
