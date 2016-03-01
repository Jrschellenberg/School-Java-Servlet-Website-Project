/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import beans.ClubValues;
import beans.CommentValues;
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

    private DBUtilities() {
        DBconnection.getDbCon();
    }

    /**
     *
     * @return returns a unique instance of this class. So only 1 object exists.
     */
    public static DBUtilities getInstance() {
        if (uniqueInstance == null) {
            synchronized (DBUtilities.class) {
                if (uniqueInstance == null) {
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
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM clubs WHERE Club_id ='" + id + "' ");

        while (resultSet.next()) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return returns an ArrayList of club values to set elements in the clubs
     * Page.
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
     * @param clubId The club Id query for players matching the specified club
     * id in the database.
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
                values.setPlayerClubPicture(resultSetPlayerClub.getString("club_picture"));
            }

            ResultSet resultSetPlayerNation = DBconnection.db.query(
                    "SELECT * FROM nations WHERE Nation_id='" + resultSet.getInt("Player_nation_id") + "' ");
            while (resultSetPlayerNation.next()) {
                values.setPlayerNation(resultSetPlayerNation.getString("nation_name"));
                values.setPlayerNationPicture(resultSetPlayerNation.getString("nation_picture"));
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

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM Leagues WHERE League_id ='" + id + "' ");

        while (resultSet.next()) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return an Arraylist of leaguevalues to hold in a bean containing
     * leagueID, leagueName, and leaguePicture
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

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM clubs WHERE club_league_id='" + leagueId + "' ");

        while (resultSet.next()) { //safeguard if query executed or not.

            ClubValues values = new ClubValues();

            values.setClubId(resultSet.getInt("Club_id"));
            values.setClubLeagueId(resultSet.getInt("club_league_id"));
            values.setClubName(resultSet.getString("Club_name"));
            values.setClubPicture(resultSet.getString("Club_picture"));

            ResultSet resultSetClubLeague = DBconnection.db.query(
                    "SELECT * FROM leagues WHERE League_id='" + resultSet.getInt("club_league_id") + "' ");
            while (resultSetClubLeague.next()) {
                values.setClubLeagueName(resultSetClubLeague.getString("league_name"));
            }

            results.add(values);
        }

        return results;
    }

    /**
     *
     * @param leagueId the league Id column number to queue in the database
     * @return returns the results of players in the queued league id stored in
     * an arrayList.
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
                values.setPlayerClubPicture(resultSetPlayerClub.getString("club_picture"));
            }

            ResultSet resultSetPlayerNation = DBconnection.db.query(
                    "SELECT * FROM nations WHERE Nation_id='" + resultSet.getInt("Player_nation_id") + "' ");
            while (resultSetPlayerNation.next()) {
                values.setPlayerNation(resultSetPlayerNation.getString("nation_name"));
                values.setPlayerNationPicture(resultSetPlayerNation.getString("nation_picture"));
            }

            results.add(values);
        }

        return results;
    }

    //Start of Nation Utilities.   
    /**
     *
     * @param id the primary key id of nations table to be queued in the
     * database
     * @return returns true if the query returns a nation, false if not
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean nationFound(String id) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM nations WHERE Nation_id ='" + id + "' ");

        while (resultSet.next()) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return returns all of the nations listed in the nations table stored in
     * an arrayList
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
     * @return returns the players that are listed under the nationId parameter
     * used. results are returned in an arraylist.
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
                values.setPlayerClubPicture(resultSetPlayerClub.getString("club_picture"));
            }

            ResultSet resultSetPlayerNation = DBconnection.db.query(
                    "SELECT * FROM nations WHERE Nation_id='" + resultSet.getInt("Player_nation_id") + "' ");
            while (resultSetPlayerNation.next()) {
                values.setPlayerNation(resultSetPlayerNation.getString("nation_name"));
                values.setPlayerNationPicture(resultSetPlayerNation.getString("nation_picture"));
            }

            results.add(values);
        }

        return results;
    }

    //Start of Players Code.
    /**
     *
     * @return returns all the players from the players table, stored in an
     * arrayList.
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
                values.setPlayerClubPicture(resultSetPlayerClub.getString("club_picture"));
            }

            ResultSet resultSetPlayerNation = DBconnection.db.query(
                    "SELECT * FROM nations WHERE Nation_id='" + resultSet.getInt("Player_nation_id") + "' ");
            while (resultSetPlayerNation.next()) {
                values.setPlayerNation(resultSetPlayerNation.getString("nation_name"));
                values.setPlayerNationPicture(resultSetPlayerNation.getString("nation_picture"));
            }

            results.add(values);
        }

        return results;
    }

    /**
     *
     * @param id the primary key from the players table to query the database
     * @return returns a player whose stats are stored in a bean PlayerValues
     * unique to the param id used.
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
                values.setPlayerClubPicture(resultSetPlayerClub.getString("club_picture"));
            }

            ResultSet resultSetPlayerNation = DBconnection.db.query(
                    "SELECT * FROM nations WHERE Nation_id='" + resultSet.getInt("Player_nation_id") + "' ");
            while (resultSetPlayerNation.next()) {
                values.setPlayerNation(resultSetPlayerNation.getString("nation_name"));
                values.setPlayerNationPicture(resultSetPlayerNation.getString("nation_picture"));
            }
        }

        return values;
    }

    //Register DbUtils Start
    /**
     *
     * @param username the username supplied by a user by a form from the
     * browser
     * @param password the password supplied by a user by a form from the
     * browser.
     * @return returns an integer code to determine if the action was valid or
     * not.
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
     * @return returns true if the username already exists, otherwise returns
     * false.
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
     * @return returns true if the username and password match a record in the
     * database, otherwise returns false.
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
     * @param username the username supplied by a user via form from the
     * browser.
     * @return returns true if the user is reconized as an admin. otherwise
     * returns false.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Boolean userTypeAdmin(String username) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM users WHERE user_username='" + username + "' AND User_type =0 ");

        while (resultSet.next()) {
            return true;
        }

        return false;
    }

    //Search Functionality
    /**
     *
     * @param name the players with a name like param name to be queried
     * @return an arrayList of playerValues to be stored in a bean containing all the players stats containing the name "name"
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<PlayerValues> searchPlayerStats(String name) throws ClassNotFoundException, SQLException {
        ArrayList<PlayerValues> results = new ArrayList<>();

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM players WHERE player_name LIKE '%" + name + "%' ");

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
                values.setPlayerClubPicture(resultSetPlayerClub.getString("club_picture"));
            }

            ResultSet resultSetPlayerNation = DBconnection.db.query(
                    "SELECT * FROM nations WHERE Nation_id='" + resultSet.getInt("Player_nation_id") + "' ");
            while (resultSetPlayerNation.next()) {
                values.setPlayerNation(resultSetPlayerNation.getString("nation_name"));
                values.setPlayerNationPicture(resultSetPlayerNation.getString("nation_picture"));
            }

            results.add(values);
        }

        return results;
    }

    /**
     *
     * @param name The players name to be queried, Used with the search function.
     * @return Returns true if players found, false if non found.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean foundPlayers(String name) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM players WHERE player_name LIKE '%" + name + "%' ");

        while (resultSet.next()) {
            return true;
        }
        return false;
    }

    //admin Page Functionality.

    /**
     *
     * @param username The user to be removed from the database.
     * @return int returns 1 if executed successfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int removeUser(String username) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert("DELETE FROM users WHERE User_username='" + username + "';");
        return result;

    }

    /**
     *
     * @param username the username associated with the password
     * @return String returns the password of the queried username
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public String getUserPassword(String username) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT User_password FROM users WHERE User_username='" + username + "'");

        while (resultSet.next()) {
            return resultSet.getString("User_password");
        }

        return "";
    }

    /**
     *
     * @param username The username to be granted admin priviledges 
     * @return int returns 1 if executed successfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int addAdminUser(String username) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert("UPDATE users SET User_type=0 WHERE User_username='" + username + "';");
        return result;

    }

    /**
     *
     * @param username The user Name to be revoked of admin rights from the database.
     * @return int returns 1 if executed successfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int removeAdminUser(String username) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert("UPDATE users SET User_type=1 WHERE User_username='" + username + "';");
        return result;

    }

    /**
     *
     * @param name The player name to query.
     * @return True if player name is found, false if not.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean playerExist(String name) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM players WHERE player_name='" + name + "';");

        while (resultSet.next()) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param nation The players reference to which nation to be inserted into the row
     * @param club The players reference to which club to be inserted into the row
     * @param playerName The players name to be inserted into the row
     * @param birthday The players Birthday of form yyyy-mm-dd to be inserted into the row
     * @param picture The players Picture Reference to be inserted into the row
     * @param position The players Position to be inserted into the row
     * @param height The players height to be inserted into the row
     * @param number the players Number to be inserted into the row
     * @param foot the players foot to be inserted into the row
     * @return int Returns 1 if executed successfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int addPlayer(String nation, String club, String playerName, String birthday, String picture, String position, String height, String number, String foot) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert("INSERT INTO players (`Player_nation_id`, `Player_club_id`, `Player_name`, `Player_birthday`, `Player_picture`, `Player_position`, `Player_height`, `Player_number`, `Player_foot`)"
                + "VALUES(" + nation + ", " + club + ", '" + playerName + "', '" + birthday + "', '" + picture + "', '" + position + "', " + height + " , " + number + " , '" + foot + "');");
        return result;

    }

    /**
     *
     * @param nation The nations name used to reference the corresponding nation Id.
     * @return String. The nation Id to be returned
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public String getNationId(String nation) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT Nation_id FROM nations WHERE Nation_name='" + nation + "';");

        while (resultSet.next()) {
            return resultSet.getString("Nation_id");
        }

        return "";
    }

    /**
     *
     * @param club The club name.
     * @return String The club Id of the referenced club name
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public String getClubId(String club) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT Club_id FROM clubs WHERE Club_name='" + club + "';");

        while (resultSet.next()) {
            return resultSet.getString("Club_id");
        }

        return "";
    }

    /**
     *
     * @param name The players Name to be used to reference the players picture
     * @return String The players Picture
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public String getPlayerPicture(String name) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT Player_picture FROM players WHERE Player_name='" + name + "';");

        while (resultSet.next()) {
            return resultSet.getString("Player_picture");
        }

        return "";
    }

    /**
     *
     * @param name The name of the player to be removed.
     * @return int Returns 1 if executed successfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int removePlayer(String name) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert("DELETE FROM players WHERE Player_name='" + name + "';");
        return result;

    }

    /**
     *
     * @param nation The players reference to which nation to be inserted into the row
     * @param club The players reference to which club to be inserted into the row
     * @param playerName The players name to be inserted into the row
     * @param birthday The players Birthday of form yyyy-mm-dd to be inserted into the row
     * @param picture The players Picture Reference to be inserted into the row
     * @param position The players Position to be inserted into the row
     * @param height The players height to be inserted into the row
     * @param number the players Number to be inserted into the row
     * @param foot the players foot to be inserted into the row
     * @return int Returns 1 if executed successfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int editPlayer(String nation, String club, String playerName, String birthday, String picture, String position, String height, String number, String foot) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert("UPDATE players SET Player_nation_id=" + nation + ", Player_club_id=" + club + ", Player_birthday='" + birthday + "', "
                + "Player_picture='" + picture + "', Player_position='" + position + "', Player_height=" + height + ", Player_number=" + number + ", Player_foot='" + foot + "' WHERE Player_name='" + playerName + "';");
        return result;

    }

    /**
     *
     * @param league The league name used to find out the associated league Id to it.
     * @return Returns the League Id as a String.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public String getLeagueId(String league) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT League_id FROM leagues WHERE League_name='" + league + "';");

        while (resultSet.next()) {
            return resultSet.getString("League_id");
        }

        return "";
    }

    /**
     *
     * @param leagueName the league name used to add a league to the table.
     * @return int Returns 1 if executed successfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int addLeague(String leagueName) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert(
                "INSERT INTO leagues (League_name, League_picture) VALUES ('" + leagueName + "','" + leagueName + ".png');"
        );

        return result;
    }

    /**
     *
     * @param leagueName The league name used to reference which league to remove.
     * @return int Returns 1 if executed successfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int removeLeague(String leagueName) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert(
                "DELETE FROM leagues WHERE League_name='" + leagueName + "';"
        );

        return result;
    }

    /**
     *
     * @param nationName The Nation name to be used when adding a new nation to the nation table.
     * @return int Returns 1 if executed sucessfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int addNation(String nationName) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert(
                "INSERT INTO nations (Nation_name, Nation_picture) VALUES ('" + nationName + "','" + nationName + ".png');"
        );

        return result;
    }

    /**
     *
     * @param nationName The nation Named used to reference which row to delete.
     * @return int Returns 1 if executed successfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int removeNation(String nationName) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert(
                "DELETE FROM nations WHERE Nation_name='" + nationName + "';"
        );

        return result;
    }

    /**
     *
     * @param clubName The clubName to be added to the clubs table.
     * @param leagueId The League Id field required for the clubs table.
     * @return int Returns 1 if executed sucdessfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int addClub(String clubName, String leagueId) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert(
                "INSERT INTO clubs (Club_league_id, Club_name, Club_picture) VALUES (" + leagueId + ",'" + clubName + "', '" + clubName + ".png');"
        );

        return result;
    }

    /**
     *
     * @param clubName The clubname to be updated and also used to reference the row in the table.
     * @param leagueId The league Id to be updated
     * @return int Returns 1 if executed successfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int editClub(String clubName, String leagueId) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert("UPDATE clubs SET Club_league_id=" + leagueId + ", Club_name='" + clubName + "' WHERE Club_name='" + clubName + "';");

        return result;
    }

    /**
     *
     * @param clubName The Club name used to delete the club from the clubs table.
     * @return int Returns 1 if executed sucessfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int removeClub(String clubName) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert(
                "DELETE FROM clubs WHERE Club_name='" + clubName + "';"
        );

        return result;
    }

    /**
     *
     * @param id The player_id from the page requested ie(Players?p=2) id would equal 2.
     * @return An ArrayList of Comment Values stored in a bean. To be used on a jsp view page.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<CommentValues> playerComments(String id) throws ClassNotFoundException, SQLException {
        ArrayList<CommentValues> results = new ArrayList<CommentValues>();

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM comments WHERE Comment_player_id='" + id + "' ");

        while (resultSet.next()) { //safeguard if query executed or not.

            CommentValues values = new CommentValues();
            values.setCommentId(resultSet.getString("Comment_id"));
            values.setCommentText(resultSet.getString("Comment_txt"));
            values.setCommentDate(resultSet.getString("Comment_date"));

            ResultSet resultSetUser = DBconnection.db.query(
                    "SELECT * FROM users WHERE User_id='" + resultSet.getInt("Comment_user_id") + "' ");
            while (resultSetUser.next()) {
                values.setUserName(resultSetUser.getString("User_username"));
            }

            results.add(values);
        }

        return results;
    }

    /**
     *
     * @param id the comment id to search for in the database.
     * @return true if Found, false if not
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean commentsExist(String id) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT * FROM comments WHERE Comment_player_id='" + id + "';");

        while (resultSet.next()) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param id The player id to search for in the database.
     * @return true if found, false if not
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean playerFound(String id) throws ClassNotFoundException, SQLException {
        ResultSet resultSet = DBconnection.db.query("SELECT * FROM players WHERE Player_id ='" + id + "' ");

        while (resultSet.next()) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param userId The user Id of the user making the comment
     * @param playerId The player Id of the player being commented on
     * @param commentTxt The comment written
     * @param commentDate The date the comment was written.
     * @return int Returns 1 if executed successfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int addComment(String userId, String playerId, String commentTxt, String commentDate) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert(
                "INSERT INTO comments (Comment_user_id, Comment_player_id, Comment_txt, Comment_date) VALUES (" + userId + ",'" + playerId + "', '" + commentTxt + "', '" + commentDate + "');"
        );

        return result;
    }

    /**
     *
     * @param username The username of the user 
     * @return String returns the user Id of the user queried
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public String getUserId(String username) throws ClassNotFoundException, SQLException {

        ResultSet resultSet = DBconnection.db.query("SELECT User_id FROM users WHERE User_username='" + username + "'");

        while (resultSet.next()) {
            return resultSet.getString("User_id");
        }

        return "";
    }

    /**
     *
     * @param userId The user Id editing the comment
     * @param playerId The player Id of the comment being edited.
     * @param commentTxt The new comment to be used.
     * @param commentId The comment Id to reference the right comment to edit.
     * @return int Returns 1 if executed sucessfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int editComment(String userId, String playerId, String commentTxt, String commentId) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert(
                "UPDATE comments SET Comment_user_id=" + userId + ", Comment_player_id=" + playerId + ", Comment_txt=\"" + commentTxt + "\" WHERE Comment_id=" + commentId + ";");

        return result;
    }

    /**
     *
     * @param commentId The id of the comment to be removed.
     * @return int Returns 1 if executed sucessfully
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int removeComment(String commentId) throws ClassNotFoundException, SQLException {

        int result = DBconnection.db.insert(
                "DELETE from comments WHERE Comment_id="+commentId+";");

        return result;
    }

}
