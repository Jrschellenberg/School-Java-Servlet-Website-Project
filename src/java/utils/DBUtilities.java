/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import beans.ClubValues;
import beans.LeagueValues;
import beans.NationValues;
import beans.PlayerValues;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class DBUtilities {
    private volatile static DBUtilities uniqueInstance;
    
    private DBUtilities(){
        DBconnection.getDbCon();
    }
    
    /**
     *
     * @return returns a unique instance of this class. So only 1 object exists.
     */
    public static DBUtilities getInstance(){
        if(uniqueInstance == null){
            synchronized(DBUtilities.class){
                if(uniqueInstance == null){
                    uniqueInstance = new DBUtilities();
                }
            }
            
        }
        return uniqueInstance;
    }
    
    
    /**
     *
     * @param id The club id to be searched in the DB query
     * @return returns true if the club is found, false if not.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean clubFound(String id) throws ClassNotFoundException, SQLException {
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM clubs WHERE Club_id ='"+ id +"' ");
        
        while (resultSet.next()) {
            return true;
        } 
        return false;
    }
    
    /**
     * 
     * @return returns an ArrayList of club values to set elements in the clubs Page.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<ClubValues> allClubs() throws ClassNotFoundException, SQLException {
        
        ArrayList<ClubValues> results = new ArrayList<>();

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM clubs ");

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
    
    /**
     *
     * @param clubId The club Id query for players matching the specified club id in the database.
     * @return returns an ArrayList of the 
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<PlayerValues> clubPlayers(String clubId) throws ClassNotFoundException, SQLException {
        
        ArrayList<PlayerValues> results = new ArrayList<>();

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM players WHERE player_club_id='" + clubId + "'");
       
         
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
    
    //Start of League Code   

    /**
     *
     * @param id league id to query in the database
     * @return true if league is found, false if not found.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean leagueFound(String id) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM Leagues WHERE League_id ='"+ id +"' ");
        
        while (resultSet.next()) {
            return true;
        } 
        return false;
    }
    
    /**
     *
     * @return an Arraylist of leaguevalues to hold in a bean containing leagueID, leagueName, and leaguePicture
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<LeagueValues> allLeagues() throws ClassNotFoundException, SQLException {
        
        ArrayList<LeagueValues> results = new ArrayList<>();

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
    
    /**
     *
     * @param leagueId the league id to query.
     * @return returns the clubs information stored in a clubValues bean if 
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<ClubValues> clubs(String leagueId) throws ClassNotFoundException, SQLException {
        
        ArrayList<ClubValues> results = new ArrayList<>();

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
    
    /**
     *
     * @param leagueId the league Id column number to queue in the database
     * @return returns the results of players in the queued league id stored in an arrayList.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<PlayerValues> leaguePlayers(String leagueId) throws ClassNotFoundException, SQLException {
        
        ArrayList<PlayerValues> results = new ArrayList<>();

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
    
    
    
     //Start of Nation Utilities.   

    /**
     *
     * @param id the primary key id of nations table to be queued in the database
     * @return returns true if the query returns a nation, false if not
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean nationFound(String id) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM nations WHERE Nation_id ='"+ id +"' ");
        
        while (resultSet.next()) {
            return true;
        } 
        return false;
    }
    
    /**
     *
     * @return returns all of the nations listed in the nations table stored in an arrayList
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<NationValues> allNations() throws ClassNotFoundException, SQLException {
        
        ArrayList<NationValues> results = new ArrayList<>();

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
    
    /**
     *
     * @param nationId the primary key nationId to query the database
     * @return returns the players that are listed under the nationId parameter used. results are returned in an arraylist.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<PlayerValues> nationPlayers(String nationId) throws ClassNotFoundException, SQLException {
        
        ArrayList<PlayerValues> results = new ArrayList<>();

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
    
    
    
    //Start of Players Code.

    /**
     *
     * @return returns all the players from the players table, stored in an arrayList.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
        
    public ArrayList<PlayerValues> allPlayers() throws ClassNotFoundException, SQLException {
        
        ArrayList<PlayerValues> results = new ArrayList<>();

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
    
    /**
     *
     * @param id the primary key from the players table to query the database
     * @return returns a player whose stats are stored in a bean PlayerValues unique to the param id used.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public PlayerValues playerStats(String id) throws ClassNotFoundException, SQLException {
        PlayerValues values = new PlayerValues();

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
    
    
    //Register DbUtils Start

    /**
     *
     * @param username the username supplied by a user by a form from the browser
     * @param password the password supplied by a user by a form from the browser.
     * @return returns an integer code to determine if the action was valid or not.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    
    
        public int userRegister(String username, String password) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert(
                "INSERT INTO users (user_username,user_password,user_type) VALUES ('" + username + "','" + password + "',1)"
        );

        return result;
    }

    /**
     *
     * @param username the username supplied by a user from the browser.
     * @return returns true if the username already exists, otherwise returns false.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean usernameExist(String username) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM users Where user_username='" + username + "' ");
        
        while (resultSet.next()) {
                return true;
        }

        return false;
    }
    
    /**
     *
     * @param username the username supplied by a user via form from the browser
     * @param password the password supplied by a user via form from the browser
     * @return returns true if the username and password match a record in the database, otherwise returns false.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Boolean userLogin(String username, String password) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM users Where user_username='" + username + "' ");

        while (resultSet.next()) {
            //Look for password
            if (resultSet.getString("user_password").equals(password)) {
                return true;
            }
        }

        return false;
    }
    
    /**
     *
     * @param username the username supplied by a user via form from the browser.
     * @return returns true if the user is reconized as an admin. otherwise returns false.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Boolean userTypeAdmin(String username) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM users WHERE user_username='" + username + "' AND User_type =0 ");
        
        while(resultSet.next()){
                return true;           
        }
        
        return false;
    }
    
    
    
    //Search Functionality

    /**
     *
     * @param name the 
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    
        public ArrayList<PlayerValues> searchPlayerStats(String name) throws ClassNotFoundException, SQLException {        
        ArrayList<PlayerValues> results = new ArrayList<>();

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM players WHERE player_name LIKE '%"+ name +"%' ");
           
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
    
    /**
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean foundPlayers(String name) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM players WHERE player_name LIKE '%"+ name +"%' ");
        
        while (resultSet.next()) {
            return true;
        }
        return false;
    }  
    
    
    
    
}
