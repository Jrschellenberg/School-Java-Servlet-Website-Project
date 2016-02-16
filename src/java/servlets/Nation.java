/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.sql.*;
import beans.*;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class Nation {
    
    public boolean nationFound(String id) throws ClassNotFoundException, SQLException {
        
        DBconnection.db.getDbCon();
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM nations WHERE Nation_id ='"+ id +"' ");
        
        while (resultSet.next()) {
            return true;
        } 
        return false;
    }
    
    
    public ArrayList<NationValues> allNations() throws ClassNotFoundException, SQLException {
        
        ArrayList<NationValues> results = new ArrayList<NationValues>();

        DBconnection.db.getDbCon();
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM nations ");

        while (resultSet.next()) { //safeguard if query executed or not.
            
            NationValues values = new NationValues();
            
            values.setNationId(resultSet.getInt("Nation_id"));
            values.setNationName(resultSet.getString("Nation_name"));
            values.setNationPicture(resultSet.getString("Nation_picture"));
       
            results.add(values);
        }
        
        return results;
    }
    

    public ArrayList<PlayerValues> players(String nationId) throws ClassNotFoundException, SQLException {
        
        ArrayList<PlayerValues> results = new ArrayList<PlayerValues>();

        DBconnection.db.getDbCon();
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM players WHERE player_nation_id='" + nationId + "'");
       
         
        while (resultSet.next()) { //safeguard if query executed or not.
            
            PlayerValues values = new PlayerValues();
            
            values.setPlayerId(resultSet.getInt("Player_id"));
            values.setPlayerName(resultSet.getString("Player_name"));
            values.setPlayerPicture(resultSet.getString("Player_picture"));
            values.setPlayerPosition(resultSet.getString("Player_position"));
      
            ResultSet resultSetPlayerClub = DBconnection.db.query(
                "SELECT * FROM clubs WHERE Club_id='" + resultSet.getInt("Player_club_id") + "' ");
            while (resultSetPlayerClub.next()) {
                values.setPlayerClub(resultSetPlayerClub.getString("club_name"));
            }
            
             ResultSet resultSetPlayerNation = DBconnection.db.query(
                "SELECT * FROM nations WHERE Nation_id='" + resultSet.getInt("Player_nation_id") + "' ");
            while (resultSetPlayerNation.next()) {
                values.setPlayerNation(resultSetPlayerNation.getString("nation_name"));
             }
            
            results.add(values);
        }
        
        return results;
    }
    
}
