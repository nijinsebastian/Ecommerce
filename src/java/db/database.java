package db;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nijin
 */
    import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.AbstractList;
        import java.util.ArrayList;
        import java.util.Arrays;

        import net.sf.json.JSONArray;
        import net.sf.json.JSONObject;

/**
 *
 * @author 1691620
 */
public class database {
   

    private static Connection conn;
    private static String[] syntaxTexts = {"/a/","/c/"};
     public static long timestamp = System.currentTimeMillis() / 1000L;
    public boolean connect(String dbURL, String username, String password) {
        boolean response=false;
        try {
            //step1 load the driver class
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, username, password);
            //conn = DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE");
            if (conn != null) {
                response = true;
            } else {
                response = false;
            }
        } 
        catch (ClassNotFoundException | SQLException e) {
          
           return response;
        }
        return response;

    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public ResultSet runQuery(String sqlQuery, ArrayList<String> params) {
        PreparedStatement stmt;
        ResultSet rs=null;
        String query = sqlQuery;
        try {
            stmt = conn.prepareStatement(query);
            int k=1;
            for(int i=0;i<params.size();i++){
                stmt.setString(k,params.get(i));
                k++;
            }
            rs = stmt.executeQuery();
        } catch (SQLException e) {
           System.out.println(e);

        }
        return rs;
    }
     public int runUpdate(String sqlQuery, ArrayList<String> params) {
        PreparedStatement stmt;
        int rs=0;
        String query = sqlQuery;
        try {
            stmt = conn.prepareStatement(query);
            int k=1;
            for(int i=0;i<params.size();i++){
                stmt.setString(k,params.get(i));
                k++;
            }
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
           System.out.println(e);

        }
        return rs;
    }
}
