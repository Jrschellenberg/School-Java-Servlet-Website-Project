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

    /**
     *
     */
    public UserValues() {
        msg = "";
    }

    /**
     *
     * @return returns the msg for User logins stored in the bean.
     */
    public String getMsg() {
        return msg;
    }

    /**
     *
     * @param m Var used to set the User Login Message and store it in the bean.
     */
    public void setMsg(String m) {
        msg = m;
    }
    
    /**
     *
     * @return returns the username stored in the bean.
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param u var used to set the username to be stored in the bean.
     */
    public void setUsername(String u) {
        username = u;
    }

    /**
     *
     * @return returns the password stored in the bean.
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param p var used to set the password to be stored in the bean.
     */
    public void setPassword(String p) {
        password = p;
    }
}
