package db;

import com.mysql.jdbc.ResultSet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nijin
 */
public class home {
    
    database db = new database();
     boolean a = db.connect("jdbc:mysql://localhost:3306/test2?zeroDateTimeBehavior=convertToNull","test","test");
    /* public static void main(String args[]) throws SQLException, IOException{
         home pro=new home();
         String json=pro.readDetails();
         System.out.println(json);
     }*/
  
     public String readDetails() throws SQLException, IOException{
         String jsondetails=null;
         JSONObject obj = new JSONObject();
         JSONObject obj1 = new JSONObject();
         JSONArray arr=new JSONArray();
          a = db.connect("jdbc:mysql://localhost:3306/test2?zeroDateTimeBehavior=convertToNull","test","test");
    
        ResultSet rs1= null;
       // boolean b=true;
        ArrayList<String> params = new ArrayList<>();
    
       rs1=(ResultSet) db.runQuery("select * from productdetails", params);
       
       
       while(rs1.next())
       {
           
           obj.put("productid", rs1.getString("productid"));
           obj.put("productname", rs1.getString("productname"));
           obj.put("description", rs1.getString("description"));
           obj.put("prize", rs1.getString("prize"));
            
           arr.add(obj);
       }
       obj1.put("Results", arr);
      jsondetails=obj1.toString();
         return jsondetails;
     }
    
}
