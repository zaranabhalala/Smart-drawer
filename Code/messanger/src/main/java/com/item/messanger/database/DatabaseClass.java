package com.item.messanger.database;

import com.item.messanger.model.Item;
import com.item.messanger.model.Map_Item_Tag;
import com.item.messanger.model.Maptag_Person;
import com.item.messanger.model.Person;
import com.item.messanger.model.Tagbank;
import com.item.messanger.model.Transaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

//The DatabaseClass created for
//getting database connection instance and getting Hash-Map instance
public class DatabaseClass {

    //Hash-Map Instance Creation of Entity classes
    private static Map<Integer, Tagbank> tags = new HashMap<>();
    private static Map<Integer, Transaction> transection = new HashMap<>();
    private static Map<Integer, Map_Item_Tag> map_item_tag = new HashMap<>();
    private static Map<Integer, Item> item = new HashMap<>();
    private static Map<Integer, Person> person = new HashMap<>();
    private static Map<Integer, Maptag_Person> maptag_person = new HashMap<>();

    //Connection initialization
    Connection con = null;

    //Setting Connection of database in constructor
    public DatabaseClass() {
        try {
            Class.forName("com.mysql.jdbc.Driver");//JDBC Connection library
            //getConnection("Database_Type://location:post/DataBase_Name", "ID", "Password");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/smart_drawer", "root", "root");

        } catch (Exception e) {
            e.getMessage();
        }

    }

    //Method getconnection() returns the database connection instance 
    public Connection getconnection() {
        return con;

    }

    
    //Following getter Methods returns the Hash-Map instace of entity class
    public static Map<Integer, Map_Item_Tag> getMap_item_tag() {
        return map_item_tag;
    }

    public static Map<Integer, Item> getItem() {
        return item;
    }

    

    public static Map<Integer, Tagbank> gettags() {
        return tags;
    }

    public static Map<Integer, Transaction> gettransection() {
        return transection;
    }

    public static Map<Integer, Person> getPersons() {
        return person;
    }

    public static Map<Integer, Maptag_Person> getMaptag_Person() {
        return maptag_person;
    }


}
