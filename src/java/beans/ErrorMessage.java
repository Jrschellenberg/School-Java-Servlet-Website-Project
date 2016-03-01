package beans;

/**
 *
 * @author Christopher
 */
public class ErrorMessage {
    
    private String msg;

    /**
     *
     */
    public ErrorMessage() {
        msg="";
    }
    
    /**
     *
     * @return returns the message stored in the bean
     */
    public String getMsg() {
        return msg;
    }

    /**
     *
     * @param m variable used to set the message in the bean.
     */
    public void setMsg(String m) {
        msg = m;
    }



}
