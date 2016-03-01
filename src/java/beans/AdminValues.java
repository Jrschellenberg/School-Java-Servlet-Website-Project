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
public class AdminValues {
    private String msg;
    
    /**
     *
     */
    public AdminValues(){
        msg = "";
    }

    /**
     *
     * @return returns the String msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     *
     * @param msg Sets the message in the bean with this parameter.
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
}
