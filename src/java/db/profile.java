/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.ResultSet;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.json.JSONObject;

/**
 *
 * @author nijin
 */

public class profile {
    database db = new database();
     boolean a = db.connect("jdbc:mysql://localhost:3306/test2?zeroDateTimeBehavior=convertToNull","test","test");
    /* public static void main(String args[]) throws SQLException, IOException{
         profile pro=new profile();
         String json=pro.readDetails("1");
         System.out.println(json);
     }*/
     public boolean addressUpdation(String address,String username,String password){
         int i=0;
        ArrayList<String> params = new ArrayList<>();
        params.add(address);
        params.add(username);
        params.add(password);
       // boolean a = db.connect("jdbc:mysql://localhost:3306/test2?zeroDateTimeBehavior=convertToNull","test","test");
       //UPDATE `userdetails` SET `email` = 'nijin12@gmail.com' WHERE `userdetails`.`userID` = 1;
       i= db.runUpdate("UPDATE `userdetails` SET `Address`=? where userdetails.userName=? and userdetails.password=?",params);
        System.out.println("i"+i);
        return true;
    }
     public String readDetails(String userid) throws SQLException, IOException{
         String jsondetails=null;
         JSONObject obj = new JSONObject();
          a = db.connect("jdbc:mysql://localhost:3306/test2?zeroDateTimeBehavior=convertToNull","test","test");
    
        ResultSet rs1= null;
       // boolean b=true;
        ArrayList<String> params = new ArrayList<>();
        params.add(userid);
       rs1=(ResultSet) db.runQuery("select * from userdetails where userID= ?", params);
       while(rs1.next())
       {
           
           obj.put("userid", rs1.getString("userID"));
           obj.put("name", rs1.getString("name"));
           obj.put("password", rs1.getString("password"));
           obj.put("phonenumber", rs1.getString("phonenumber"));
            obj.put("address", rs1.getString("address"));
             obj.put("email", rs1.getString("email"));
           
       }
       
      jsondetails=obj.toString();
         return jsondetails;
     }
     public int updateField(String data,String userid, String modifyingfield){
         int res=0;
          a = db.connect("jdbc:mysql://localhost:3306/test2?zeroDateTimeBehavior=convertToNull","test","test");
           ArrayList<String> params = new ArrayList<>();
       
        params.add(data);
        params.add(userid); 
        
        switch (modifyingfield) {
            case "name":
                res= db.runUpdate("UPDATE `userdetails` SET name = ? WHERE `userdetails`.`userID` = ?",params);
                break;
             case "password":
                res= db.runUpdate("UPDATE `userdetails` SET password = ? WHERE `userdetails`.`userID` = ?",params);
                break;
             case "address":
                res= db.runUpdate("UPDATE `userdetails` SET address = ? WHERE `userdetails`.`userID` = ?",params);
                break;
            case "phonenumber":
                res= db.runUpdate("UPDATE `userdetails` SET phonenumber = ? WHERE `userdetails`.`userID` = ?",params);
                break;
                
            case "email":
                res= db.runUpdate("UPDATE `userdetails` SET email = ? WHERE `userdetails`.`userID` = ?",params);
                break;
                
            default: 
                res =0;
                break;
        }
        
        
        
         
         return res;
     }
    
}
