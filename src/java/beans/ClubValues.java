package beans;

/**
 *
 * @author Christopher
 */
public class ClubValues {
    
    private int clubId;
    private int clubLeagueId;
    private String clubName;
    private String clubPicture;
    private String clubLeagueName;
    private String clubLeaguePicture;
    
    /**
     *
     */
    public ClubValues() {
        clubId=0;
        clubLeagueId=0;
        clubName="";
        clubPicture="";
        clubLeagueName="";
        clubLeaguePicture="";
    }
    
    /**
     *
     * @return returns the beans clubId value.
     */
    public int getClubId() {
        return clubId;
    }

    /**
     *
     * @param clubId Used to set the Beans clubId value
     */
    public void setClubId(int clubId) {
        this.clubId = clubId;
    }
    
    /**
     *
     * @return returns beans League Id reference in the clubs table.
     */
    public int getClubLeagueId() {
        return clubLeagueId;
    }

    /**
     *
     * @param clubLeagueId used to set the League Id reference in the clubs table.
     */
    public void setClubLeagueId(int clubLeagueId) {
        this.clubLeagueId = clubLeagueId;
    }
    
    /**
     *
     * @return returns the club name from clubs table.
     */
    public String getClubName() {
        return clubName;
    }

    /**
     *
     * @param clubName variable to set the Club_name in clubs table.
     */
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
    
    /**
     *
     * @return returns the Club_picture value stored in bean from clubs table.
     */
    public String getClubPicture() {
        return clubPicture;
    }

    /**
     *
     * @param clubPicture variable to set the Club_picture in the bean from the clubs table.
     */
    public void setClubPicture(String clubPicture) {
        this.clubPicture = clubPicture;
    }

    /**
     *
     * @return returns the League_name from the leagues table cross referenced by club_league_id from clubs table..
     */
    public String getClubLeagueName() {
        return clubLeagueName;
    }

    /**
     *
     * @param clubLeagueName used to set the League Name referenced by Club_league_id from clubs table.
     */
    public void setClubLeagueName(String clubLeagueName) {
        this.clubLeagueName = clubLeagueName;
    }
    
        /**
     *
     * @return returns the League_Picture from the leagues table cross referenced by club_league_id from clubs table..
     */
    public String getClubLeaguePicture() {
        return clubLeaguePicture;
    }

    /**
     *
     * @param clubLeaguePicture used to set the League Picture referenced by Club_league_id from clubs table.
     */
    public void setClubLeaguePicture(String clubLeaguePicture) {
        this.clubLeaguePicture = clubLeaguePicture;
    }


}
