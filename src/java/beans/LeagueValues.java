package beans;

/**
 *
 * @author Christopher
 */
public class LeagueValues {
    
    private int leagueId;
    private String leagueName;
    private String leaguePicture;
    
    /**
     *
     */
    public LeagueValues() {
        leagueId=0;
        leagueName="";
        leaguePicture="";
    }
    
    /**
     *
     * @return returns the league id stored in the bean.
     */
    public int getLeagueId() {
        return leagueId;
    }

    /**
     *
     * @param leagueId variable to set the league id in the bean.
     */
    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }
    
    /**
     *
     * @return returns the league name stored in the bean.
     */
    public String getLeagueName() {
        return leagueName;
    }

    /**
     *
     * @param leagueName variable used to set the league name to be stored in bean.
     */
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }
    
    /**
     *
     * @return returns the league picture stored in the bean.
     */
    public String getLeaguePicture() {
        return leaguePicture;
    }

    /**
     *
     * @param leaguePicture variable used to set the league picture to be stored in bean.
     */
    public void setLeaguePicture(String leaguePicture) {
        this.leaguePicture = leaguePicture;
    }



}
