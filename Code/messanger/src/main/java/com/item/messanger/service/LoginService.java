package com.item.messanger.service;

import com.item.messanger.database.DatabaseClass;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//LoginService class is the Brain class of LoginResources class
public class LoginService {

    //default constructor
    public LoginService() {
    }
    DatabaseClass dbc = new DatabaseClass();
    String Email;
    String Password;

    //Gives the bollean  value that username and password is true or false 
    public Boolean CheckLogin(String Email, String Password) {
        Boolean flag = false;
         this.Email= Email;
         this.Password=Password;
         

        try {
            //JDBC code
            System.out.println("DB: "+Email+Password );
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            //comparig username and password with database entry
            ResultSet rs = stmt.executeQuery("Select * from admin where username='" + Email + "' AND password='" + Password + "'");

           
            if (!rs.next()) {
                System.out.println(rs.getString(1)+rs.getString(2));
                flag = false;
            } else{
                
                flag = true;
            }
        } catch (Exception e) {
        }
       
        return flag;
    }
}
