package servlets;

import java.sql.*;

public class Login {
    
    public Boolean userLogin(String username, String password) throws ClassNotFoundException, SQLException {

        DBconnection.db.getDbCon();
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM users Where user_username='" + username + "' ");

        while (resultSet.next()) {
            //Look for password
            if (resultSet.getString("user_password").equals(password)) {
                return true;
            }
        }

        return false;
    }
    
    public Boolean userTypeAdmin(String username) throws ClassNotFoundException, SQLException {
        
        DBconnection.db.getDbCon();
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM users WHERE user_username='" + username + "' AND User_type =0 ");
        
        while(resultSet.next()){
                return true;           
        }
        
        return false;
    }
}
