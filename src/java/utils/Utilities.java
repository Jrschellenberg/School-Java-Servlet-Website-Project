/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Justin
 */
public class Utilities {

    public boolean foundCookie(String target, Cookie[] cookies) {
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (target.equals(cookie.getName())) {        //A cookie with user login credentials was found. Push them to home.jsp                    
                    return true;
                }
            }
        }
        return false;
    }
    
    public void forwardRequest(HttpServletRequest request, HttpServletResponse response, String url)
    throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
    
    public void includeRequest(HttpServletRequest request, HttpServletResponse response, String url)
    throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.include(request, response);
    }

}
