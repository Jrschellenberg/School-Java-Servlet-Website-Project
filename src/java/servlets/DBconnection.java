package servlets;
import java.sql.*;
/**
 * @desc A singleton database access class for MySQL
 * @author Ramindu
 * http://rdeshapriya.com/a-singleton-java-class-for-mysql-db-connection/
 */
public final class DBconnection {
    public Connection conn;
    private Statement statement;
    public static DBconnection db;
    private DBconnection() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "playesdb";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "123456";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    /**
     *
     * @return MysqlConnect Database connection object
     */
    public static synchronized DBconnection getDbCon() {
        if ( db == null ) {
            db = new DBconnection();
        }
        return db;
 
    }
    /**
     *
     * @param query String The query to be executed
     * @return a ResultSet object containing the results or null if not available
     * @throws SQLException
     */
    public ResultSet query(String query) throws SQLException{
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
    /**
     * @desc Method to insert data to a table
     * @param insertQuery String The Insert query
     * @return boolean
     * @throws SQLException
     */
    public int insert(String insertQuery) throws SQLException {
        statement = db.conn.createStatement();
        int result = statement.executeUpdate(insertQuery);
        return result;
 
    }
 
}