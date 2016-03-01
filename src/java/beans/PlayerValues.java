/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Justin
 */
public class PlayerValues {
    
    private int playerId;
    private String playerName;
    private String playerBirthday;
    private String playerPicture;
    private String playerPosition;
    private int playerHeight;
    private int playerNumber;
    private String playerFoot;
    private String playerNation;
    private String playerClub;
    
    /**
     *
     */
    public PlayerValues(){
        playerId = 0;
        playerName = "";
        playerBirthday = "";
        playerPicture = "";
        playerPosition = "";
        playerHeight = 0;
        playerNumber = 0;
        playerFoot = "";
        playerNation = "";
        playerClub = "";
    }

    /**
     *
     * @return returns the player Id stored in the bean.
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     *
     * @param playerId var used to the store the player id in the bean.
     */
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    
    /**
     *
     * @return returns the player name stored in the bean.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     *
     * @param playerName var used to the store the player name in the bean.
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     *
     * @return returns the player birthday stored in the bean.
     */
    public String getPlayerBirthday() {
        return playerBirthday;
    }

    /**
     *
     * @param playerBirthday var used to the store the player birthday in the bean.
     */
    public void setPlayerBirthday(String playerBirthday) {
        this.playerBirthday = playerBirthday;
    }

    /**
     *
     * @return returns the player Picture stored in the bean.
     */
    public String getPlayerPicture() {
        return playerPicture;
    }

    /**
     *
     * @param playerPicture var used to store the player picture in the bean.
     */
    public void setPlayerPicture(String playerPicture) {
        this.playerPicture = playerPicture;
    }

    /**
     *
     * @return returns the player position stored in the bean.
     */
    public String getPlayerPosition() {
        return playerPosition;
    }

    /**
     *
     * @param playerPosition var used to store the player position in the bean.
     */
    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    /**
     *
     * @return returns the player height stored in the bean.
     */
    public int getPlayerHeight() {
        return playerHeight;
    }

    /**
     *
     * @param playerHeight var used to store the player height in the bean.
     */
    public void setPlayerHeight(int playerHeight) {
        this.playerHeight = playerHeight;
    }

    /**
     *
     * @return returns the player Number stored in the bean.
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     *
     * @param playerNumber var used to store the player Number in the bean.
     */
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    /**
     *
     * @return returns the player Foot stored in the bean.
     */
    public String getPlayerFoot() {
        return playerFoot;
    }

    /**
     *
     * @param playerFoot Var used to store the player foot in the bean.
     */
    public void setPlayerFoot(String playerFoot) {
        this.playerFoot = playerFoot;
    }
    
    /**
     *
     * @return returns the player Nation stored in the bean.
     */
    public String getPlayerNation() {
        return playerNation;
    }

    /**
     *
     * @param playerNation Var used to set the player Nation stored in the bean.
     */
    public void setPlayerNation(String playerNation) {
        this.playerNation = playerNation;
    }
    
    /**
     *
     * @return returns the player Club stored in the bean.
     */
    public String getPlayerClub() {
        return playerClub;
    }

    /**
     *
     * @param playerClub Var used to set the player Club and store it in the bean.
     */
    public void setPlayerClub(String playerClub) {
        this.playerClub = playerClub;
    }
    
}
