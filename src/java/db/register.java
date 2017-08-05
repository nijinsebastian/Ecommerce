package db;


import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nijin
 */
public class register {
    
    public  boolean a;
     public  database  db = new database();
   
    
    public  boolean emailcheck(String email) throws SQLException{
        
         a = db.connect("jdbc:mysql://localhost:3306/test2?zeroDateTimeBehavior=convertToNull","test","test");
    
        ResultSet rs1= null;
        boolean b=true;
        ArrayList<String> params = new ArrayList<>();
        params.add(email);
       rs1=(ResultSet) db.runQuery("select * from userdetails where email=?", params);
       if(rs1.first()){
          b=false;
                }
       else{
        b=true;
    }
       
        return b;
    }
    public int registerFunction(String name,String email,String password,String phonenumber,String address){
   
     a = db.connect("jdbc:mysql://localhost:3306/test2?zeroDateTimeBehavior=convertToNull","test","test"); 
        int i=0;
        ArrayList<String> params = new ArrayList<>();
        params.add(name);
        params.add(email);
        params.add(password);
        params.add(phonenumber);
        params.add(address);
       // boolean a = db.connect("jdbc:mysql://localhost:3306/test2?zeroDateTimeBehavior=convertToNull","test","test");
       i= db.runUpdate("INSERT INTO `userdetails` (`name`, `email`,`password`, `phonenumber`, `address`) VALUES (?,?,?,?,?)",params);
        
        return i;
    }
   
}
