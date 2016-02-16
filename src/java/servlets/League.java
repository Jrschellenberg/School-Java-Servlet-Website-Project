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
public class League {
    
    public boolean leagueFound(String id) throws ClassNotFoundException, SQLException {
        
        DBconnection.db.getDbCon();
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM Leagues WHERE League_id ='"+ id +"' ");
        
        while (resultSet.next()) {
            return true;
        } 
        return false;
    }
    
    
    public ArrayList<LeagueValues> allLeagues() throws ClassNotFoundException, SQLException {
        
        ArrayList<LeagueValues> results = new ArrayList<LeagueValues>();

        DBconnection.db.getDbCon();
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM leagues ");

        while (resultSet.next()) { //safeguard if query executed or not.
            
            LeagueValues values = new LeagueValues();
            
            values.setLeagueId(resultSet.getInt("League_id"));
            values.setLeagueName(resultSet.getString("League_name"));
            values.setLeaguePicture(resultSet.getString("League_picture"));
       
            results.add(values);
        }
        
        return results;
    }
    
    public ArrayList<ClubValues> clubs(String leagueId) throws ClassNotFoundException, SQLException {
        
        ArrayList<ClubValues> results = new ArrayList<ClubValues>();

        DBconnection.db.getDbCon();
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM clubs WHERE club_league_id='"+ leagueId +"' ");

        while (resultSet.next()) { //safeguard if query executed or not.
            
            ClubValues values = new ClubValues();
            
            values.setClubId(resultSet.getInt("Club_id"));
            values.setClubLeagueId(resultSet.getInt("club_league_id"));
            values.setClubName(resultSet.getString("Club_name"));
            values.setClubPicture(resultSet.getString("Club_picture"));
       
            results.add(values);
        }
        
        return results;
    }
    

    public ArrayList<PlayerValues> players(String leagueId) throws ClassNotFoundException, SQLException {
        
        ArrayList<PlayerValues> results = new ArrayList<PlayerValues>();
        
        
        
        DBconnection.db.getDbCon();
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM players p INNER JOIN clubs c on p.player_club_id=c.club_id WHERE c.club_league_id='" + leagueId + "'");
       
         
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
