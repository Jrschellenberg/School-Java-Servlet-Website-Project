/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.LeagueValues;
import java.sql.ResultSet;
import java.sql.SQLException;
import beans.PlayerValues;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class Player {
    
    public ArrayList<PlayerValues> allPlayers() throws ClassNotFoundException, SQLException {
        
        ArrayList<PlayerValues> results = new ArrayList<PlayerValues>();

        DBconnection.db.getDbCon();
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM players");

        while (resultSet.next()) { //safeguard if query executed or not.
            
            PlayerValues values = new PlayerValues();
            
            values.setPlayerId(resultSet.getInt("Player_id"));
            values.setPlayerName(resultSet.getString("Player_name"));
            values.setPlayerBirthday(resultSet.getString("Player_birthday"));
            values.setPlayerPicture(resultSet.getString("Player_picture"));
            values.setPlayerPosition(resultSet.getString("Player_position"));
            values.setPlayerHeight(resultSet.getInt("Player_height"));
            values.setPlayerNumber(resultSet.getInt("Player_number"));
            values.setPlayerFoot(resultSet.getString("Player_foot"));
            
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
    
    public PlayerValues playerStats(String id) throws ClassNotFoundException, SQLException {
        PlayerValues values = new PlayerValues();
        
        DBconnection.db.getDbCon();
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM players WHERE player_id='" + id + "' ");
       
        
        while (resultSet.next()) { //safeguard if query executed or not.
            values.setPlayerName(resultSet.getString("Player_name"));
            values.setPlayerBirthday(resultSet.getString("Player_birthday"));
            values.setPlayerPicture(resultSet.getString("Player_picture"));
            values.setPlayerPosition(resultSet.getString("Player_position"));
            values.setPlayerHeight(resultSet.getInt("Player_height"));
            values.setPlayerNumber(resultSet.getInt("Player_number"));
            values.setPlayerFoot(resultSet.getString("Player_foot"));
            
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
        }
        
        return values;
    }
    
    
    
}
