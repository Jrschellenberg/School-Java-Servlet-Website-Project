/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.sql.*;

public class Register {

    public int userRegister(String username, String password) throws ClassNotFoundException, SQLException {

        DBconnection.db.getDbCon();
        int result = DBconnection.db.insert(
                "INSERT INTO users (user_username,user_password,user_type) VALUES ('" + username + "','" + password + "',1)"
        );

        return result;
    }

    
    public boolean usernameExist(String username) throws ClassNotFoundException, SQLException {

        DBconnection.db.getDbCon();
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM users Where user_username='" + username + "' ");
        
        while (resultSet.next()) {
                return true;
        }

        return false;
    }

}
