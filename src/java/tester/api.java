/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import db.register;
import db.login;
import db.profile;
import db.home;
import db.newproduct;
import java.io.IOException;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 * REST Web Service
 *
 * @author nijin
 */
@Path("api")
public class api {

    @Context
    private UriInfo context;


    /**
     * Retrieves representation of an instance of tester.api
     * @param y
     * @return an instance of java.lang.String
     */
    @Path("register")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String getj(MultivaluedMap<String, String> formParams) throws SQLException {
        register ab = new register();
        String email,password,name,phonenumber,address,res=null;
        name=formParams.get("name").get(0);
        email = formParams.get("email").get(0);
        password =  formParams.get("password").get(0);
        phonenumber=formParams.get("phonenumber").get(0);
        address=formParams.get("address").get(0);
        //res = email;
      
        if(ab.emailcheck(email)){
          
           int a = ab.registerFunction(name,email, password,phonenumber,address);
           res = String.valueOf(a);
// res= "registered";
        }
        else
        {
            res="2";
        //   res= "Already existing emailid"; 
        }
           
        
    return res;
//TODO return proper representation object
       // throw new UnsupportedOperationException();
    }

    @Path("login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String getlogin(MultivaluedMap<String, String> formParams) throws SQLException {
         
       
        String email,password,res=null,logincheck=null;
        login lo=new login();
      
        email = formParams.get("email").get(0);
        password =  formParams.get("password").get(0);
        logincheck=lo.logincheck(email, password);
       
        
        
    return logincheck;
    }
    @Path("profile")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String getprofile(MultivaluedMap<String, String> formParams) throws SQLException, IOException {
         
       
        String id,profiledetails=null;
        profile pro=new profile();
      
        id = formParams.get("id").get(0);
        profiledetails= pro.readDetails(id);
       
       
        
        
    return profiledetails;
//TODO return proper representation object
       // throw new UnsupportedOperationException();
    }
    
    @Path("name")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String putname(MultivaluedMap<String, String> formParams) throws SQLException {
         
       
        String userid,data,modifyingfield,res=null;
        int p;
        profile pp=new profile();
        userid= formParams.get("userid").get(0);
        data = formParams.get("data").get(0);
        modifyingfield=formParams.get("modifyingfield").get(0);
       p=pp.updateField(data, userid, modifyingfield);
       res=String.valueOf(p);
       
        
        
    return res;
    }
    
    @Path("retrive")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String retrive() throws SQLException, IOException {
         
       
        String res=null;
        home ho=new home();
        res=ho.readDetails();
        
        
    return res;
    }
    @Path("productdetails/{productid}")
   @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public String findByName(@PathParam("productid") String query) throws SQLException, IOException {
        
       newproduct pro=new newproduct();
          System.out.println(query);
         String json=pro.readDetails(query);
        return json;
    }
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getData() {
    return "hgh2";
//TODO return proper representation object
       // throw new UnsupportedOperationException();
    }
    /**
     * PUT method for updating or creating an instance of api
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
