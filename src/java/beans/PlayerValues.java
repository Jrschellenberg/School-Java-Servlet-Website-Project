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
    
    private String playerName;
    private String playerBirthday;
    private String playerPicture;
    private String playerPosition;
    private int playerHeight;
    private int playerNumber;
    private String playerFoot;
    
    public PlayerValues(){
        playerName = "";
        playerBirthday = "";
        playerPicture = "";
        playerPosition = "";
        playerHeight = 0;
        playerNumber = 0;
        playerFoot = "";
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerBirthday() {
        return playerBirthday;
    }

    public void setPlayerBirthday(String playerBirthday) {
        this.playerBirthday = playerBirthday;
    }

    public String getPlayerPicture() {
        return playerPicture;
    }

    public void setPlayerPicture(String playerPicture) {
        this.playerPicture = playerPicture;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getPlayerHeight() {
        return playerHeight;
    }

    public void setPlayerHeight(int playerHeight) {
        this.playerHeight = playerHeight;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerFoot() {
        return playerFoot;
    }

    public void setPlayerFoot(String playerFoot) {
        this.playerFoot = playerFoot;
    }
    
}
