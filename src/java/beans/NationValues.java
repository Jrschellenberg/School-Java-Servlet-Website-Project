package beans;

/**
 *
 * @author Christopher
 */
public class NationValues {
    
    private int nationId;
    private String nationName;
    private String nationPicture;
    
    public NationValues() {
        nationId=0;
        nationName="";
        nationPicture="";
    }
    
    public int getNationId() {
        return nationId;
    }
    public void setNationId(int nationId) {
        this.nationId = nationId;
    }
    
    public String getNationName() {
        return nationName;
    }
    public void setNationName(String nationName) {
        this.nationName = nationName;
    }
    
    public String getNationPicture() {
        return nationPicture;
    }
    public void setNationPicture(String nationPicture) {
        this.nationPicture = nationPicture;
    }



}
