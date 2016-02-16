package beans;

/**
 *
 * @author Christopher
 */
public class LeagueValues {
    
    private int leagueId;
    private String leagueName;
    private String leaguePicture;
    
    public LeagueValues() {
        leagueId=0;
        leagueName="";
        leaguePicture="";
    }
    
    public int getLeagueId() {
        return leagueId;
    }
    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }
    
    public String getLeagueName() {
        return leagueName;
    }
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }
    
    public String getLeaguePicture() {
        return leaguePicture;
    }
    public void setLeaguePicture(String leaguePicture) {
        this.leaguePicture = leaguePicture;
    }



}
