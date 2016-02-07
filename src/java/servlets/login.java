/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.sql.*;

public class login {
    
    public Boolean userLogin(String username, String password) throws ClassNotFoundException, SQLException {

        DBconnection.db.getDbCon();
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM users Where user_username='" + username + "' ");

        while (resultSet.next()) {

            //Look for password
            if (resultSet.getString("user_password").equalsIgnoreCase(password)) {
                return true;
            }

        }

        return false;
    }
}
