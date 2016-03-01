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
public class CommentValues {
    private String commentText;
    private String commentDate;
    private String userName;
    private String commentId;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
    
    public CommentValues(){
        commentText="";
        commentDate="";
        userName="";
        commentId="";
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        String delims = "[-]";
        String[] tokens = commentDate.split(delims);
        String[] months = {"January", "February", "March", "April","May","June","July","August","September","October","November","December"};
        int month = Integer.parseInt(tokens[1]) -1;        
        this.commentDate = months[month]+" "+tokens[2]+", "+tokens[0];
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
