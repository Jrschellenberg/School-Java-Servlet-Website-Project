package beans;

/**
 *
 * @author Christopher
 */
public class NationValues {
    
    private int nationId;
    private String nationName;
    private String nationPicture;
    
    /**
     *
     */
    public NationValues() {
        nationId=0;
        nationName="";
        nationPicture="";
    }
    
    /**
     *
     * @return returns the nation Id stored in the bean.
     */
    public int getNationId() {
        return nationId;
    }

    /**
     *
     * @param nationId the var used to set the nation id in the bean
     */
    public void setNationId(int nationId) {
        this.nationId = nationId;
    }
    
    /**
     *
     * @return returns the nation name stored in the bean
     */
    public String getNationName() {
        return nationName;
    }

    /**
     *
     * @param nationName var used to store the nation name in the bean
     */
    public void setNationName(String nationName) {
        this.nationName = nationName;
    }
    
    /**
     *
     * @return returns the nation picture stored in the bean
     */
    public String getNationPicture() {
        return nationPicture;
    }

    /**
     *
     * @param nationPicture the var used to the store the nation picture in the bean.
     */
    public void setNationPicture(String nationPicture) {
        this.nationPicture = nationPicture;
    }



}
