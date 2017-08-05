/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nijin
 */
public class login {
     public  boolean a;
     public  database  db = new database();
     /*public static void main(String args[]) throws SQLException{
         String k=null;
         login lo=new login();
        k= lo.logincheck("nijin12@gmail.com", "nijin1234");
         System.out.println(k);
     }*/
     public String logincheck(String email, String password) throws SQLException{
         
          a = db.connect("jdbc:mysql://localhost:3306/test2?zeroDateTimeBehavior=convertToNull","test","test");
    String userid=null;
        ResultSet rs1= null;
       // boolean b=true;
        ArrayList<String> params = new ArrayList<>();
        params.add(email);
        params.add(password);
       rs1=(ResultSet) db.runQuery("select * from userdetails where email=? and password= ?", params);
       if(rs1.first()){
          userid =rs1.getString("userID");
         
                }
       else{
       userid="0";
    }
         return userid;
                 
     }
    
}
