/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author Justin
 */
public class LoginBean {
    private boolean loggedIn = false;
    
    public boolean isLoggedIn(){ return this.loggedIn;}
    
    public void setLoggedIn(boolean loggedIn){
        this.loggedIn = loggedIn;
    }
            
    
}
