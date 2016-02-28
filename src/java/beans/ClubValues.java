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
    
    public ClubValues() {
        clubId=0;
        clubLeagueId=0;
        clubName="";
        clubPicture="";
        clubLeagueName="";
    }
    
    public int getClubId() {
        return clubId;
    }
    public void setClubId(int clubId) {
        this.clubId = clubId;
    }
    
    public int getClubLeagueId() {
        return clubLeagueId;
    }
    public void setClubLeagueId(int clubLeagueId) {
        this.clubLeagueId = clubLeagueId;
    }
    
    public String getClubName() {
        return clubName;
    }
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
    
    public String getClubPicture() {
        return clubPicture;
    }
    public void setClubPicture(String clubPicture) {
        this.clubPicture = clubPicture;
    }

    public String getClubLeagueName() {
        return clubLeagueName;
    }
    public void setClubLeagueName(String clubLeagueName) {
        this.clubLeagueName = clubLeagueName;
    }


}
