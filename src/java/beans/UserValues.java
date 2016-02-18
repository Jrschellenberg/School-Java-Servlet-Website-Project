/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Christopher
 */
public class UserValues {
    private volatile static UserValues uniqueInstance;
    private String msg;
    private String username;
    private String password;    

    public UserValues() {
        msg = "";
    }

    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String m) {
        msg = m;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String u) {
        username = u;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String p) {
        password = p;
    }
}
