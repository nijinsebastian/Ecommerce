/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.ResultSet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author nijin
 */
public class newproduct {
    database db = new database();
     boolean a ;
     /* public static void main(String args[]) throws SQLException, IOException{
         newproduct pro=new newproduct();
          System.out.println("hi");
         String json=pro.readDetails("1");
         System.out.println(json);
     }*/
    
    public String readDetails(String productid) throws SQLException, IOException{
         String jsondetails=null;
         JSONObject obj = new JSONObject();
         JSONObject obj1 = new JSONObject();
         JSONArray arr=new JSONArray();
          a = db.connect("jdbc:mysql://localhost:3306/test2?zeroDateTimeBehavior=convertToNull","test","test");
    
        ResultSet rs1= null;
       // boolean b=true;
        ArrayList<String> params = new ArrayList<>();
        params.add(productid);
    
       rs1=(ResultSet) db.runQuery("select * from productmoredetails where productid=?", params);
       
       
       while(rs1.next())
       {
           
           obj.put("productid", rs1.getString("productid"));
           obj.put("descriptionname", rs1.getString("descriptionname"));
           obj.put("descriptionvalue", rs1.getString("descriptionvalue"));
           obj.put("type", rs1.getString("type"));
           obj.put("descriptionid", rs1.getString("descriptionid"));
            
           arr.add(obj);
       }
       obj1.put("Results", arr);
      jsondetails=obj1.toString();
         return jsondetails;
     }
    
}
