/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.item.messanger.service;

import com.item.messanger.database.DatabaseClass;
import com.item.messanger.model.Maptag_Person;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Maptag_PersonService is brain class of Maptag_PersonResources class
public class Maptag_PersonService {

    //Creating instance of DatabaseClass
    DatabaseClass dbc = new DatabaseClass();
    //Getting Hashmap instance of entity class
    private Map<Integer, Maptag_Person> maptag_person = dbc.getMaptag_Person();

    //Default Constructor
    public Maptag_PersonService() {
    }

    //retun all mapped tag and person
    public List<Maptag_Person> getallMappedPerson() {

        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from map_tag_person");//SQL Query
            int i = 1;
            maptag_person.clear();
            while (rs.next()) {
                //Putting query result into the Hash-Map
                maptag_person.put(i, new Maptag_Person(rs.getString(1), rs.getLong(2), rs.getDate(3)));
                i++;
            }
            con.close();//closing connection
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<Maptag_Person>(maptag_person.values());//retun all mapped tag and person
    }

    //Get Specific Mapped person   
    public List<Maptag_Person> getMappedPerson(Long adhar_id) {

        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from map_tag_person where Addhar_ID='" + adhar_id + "'");//SQL Query
            int i = 1;
            maptag_person.clear();
            while (rs.next()) {
                //Putting query result into the Hash-Map
                maptag_person.put(i, new Maptag_Person(rs.getString(1), rs.getLong(2), rs.getTime(3)));
                i++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<Maptag_Person>(maptag_person.values());//return Specific Person 
    }

    //mapping(Adding)Person with tag
    public Maptag_Person addPersonMap(Maptag_Person mps) {
        //Getting data from parameter object
        String tagid = mps.getTag_id();
        Long adharid = mps.getAdhar_id();

        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            int flag = stmt.executeUpdate("INSERT INTO `smart_drawer`.`map_tag_person` (`Tag_Serial_No`,`Addhar_ID`) VALUES ('" + tagid + "'," + adharid + ");");//SQL Query
            if (flag == 1) {//checking
                //System.out.println("Success fully added into table");
                return mps; //retun mapping object 
            }
            con.close();//Closing db connection
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //Removing mapped person (De-attach tag with person
    public boolean removeMappedPerson(Long adhar_id) {
        try {
            //JDBC Code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            int flag = stmt.executeUpdate("DELETE FROM `smart_drawer`.`map_tag_person` WHERE `Addhar_ID` = '" + adhar_id + "';");//SQL query
            if (flag == 1) {
                //System.out.println("Success fully deleted from table");
                return true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
