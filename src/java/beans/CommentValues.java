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

    /**
     *
     */
    public CommentValues() {
        commentText = "";
        commentDate = "";
        userName = "";
        commentId = "";
    }

    /**
     *
     * @return returns the comment Text stored in bean gathered from comments table row.
     */
    public String getCommentText() {
        return commentText;
    }

    /**
     *
     * @param commentText variable used to set the comment Text in bean from comments table row.
     */
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    /**
     *
     * @return returns the comments Date stored in bean from comments table row.
     */
    public String getCommentDate() {
        return commentDate;
    }

    /**
     *
     * @param commentDate variable to store the comment date in the bean. It gets parsed into Month_Day,_Year format from comments table row.
     */
    public void setCommentDate(String commentDate) {
        String delims = "[-]";
        String[] tokens = commentDate.split(delims);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int month = Integer.parseInt(tokens[1]) - 1;
        this.commentDate = months[month] + " " + tokens[2] + ", " + tokens[0];
    }

    /**
     *
     * @return returns the User name stored in bean which is gathered from comments table being cross referenced with users table.
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName Variaible Used to set the user name in the bean.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return returns the commentId stored in bean from the comments table.
     */
    public String getCommentId() {
        return commentId;
    }

    /**
     *
     * @param commentId Variable to set the Comment_id in the bean from the
     * comments table.
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

}
