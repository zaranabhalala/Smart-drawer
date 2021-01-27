/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.item.messanger.service;

import com.item.messanger.database.DatabaseClass;
import com.item.messanger.model.Tagbank;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//TagbankService class is the Brain class of TagbankResources class
public class TagbankService {

    //creating instance of DatabaseClass
    DatabaseClass dbc = new DatabaseClass();
    //getting instance of entity Hash-Map from databaseclass
    private Map<Integer, Tagbank> tagbank = dbc.gettags();
    private Map<Integer, Tagbank> tagbankspecific = dbc.gettags();

    //default constructor
    public TagbankService() {
    }

    //Method getAlltags retun JSON list of All Tags
    public List<Tagbank> getAlltags() {
        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tag_bank");//SQL Query
            int i = 1;
            tagbank.clear();
            while (rs.next()) {
                //Putting query result into the Hash-Map
                tagbank.put(i, new Tagbank(rs.getString(1)));
                i++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<Tagbank>(tagbank.values());//return Arraylist of all tags
    }

    //Method gettags gives specific tag from tagbank by tag_id
    public List<Tagbank> gettags(String id) {
        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tag_bank where tagid='" + id + "'");//SQL Query
            int i = 1;
            tagbankspecific.clear();
            while (rs.next()) {
                //putting query result into the Hash-Map
                tagbankspecific.put(i, new Tagbank(rs.getString(1)));
                i++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<Tagbank>(tagbankspecific.values());//return specific tag by tag_id
    }

    //method getAllunmappedtags gives JSON List of all unmapped tags(Item/Person) 
    public List<Tagbank> getAllunmappedtags() {
        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tag_bank WHERE tagid NOT IN(SELECT Tag_Serial_No FROM `map_tag_person` UNION SELECT Tag_Serial_No FROM `map_tag_item`); ");//SQl Query
            tagbank.clear();
            int i = 1;
            while (rs.next()) {
                //Putting query result into Hash-Map
                tagbank.put(i, new Tagbank(rs.getString(1)));
                i++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<Tagbank>(tagbank.values());//return Arraylist of all un-mapped tags
    }

    //method getAllMappedtags gives JSON List of all mapped tags(Item/Person)
    public List<Tagbank> getAllMappedtags() {

        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Tag_Serial_No FROM `map_tag_person` UNION SELECT Tag_Serial_No FROM `map_tag_item` ");//SQL Query
            int i = 1;
            tagbank.clear();
            while (rs.next()) {
                //putting query result into the Hash-Map
                tagbank.put(i, new Tagbank(rs.getString(1)));
                i++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<Tagbank>(tagbank.values());//retun Arrylist of all mapped tags
    }

    //method addtag add new tag into the system 
    public Tagbank addtag(Tagbank tag) {
        //getting data from parameter's object
        String tagid = tag.getTagid();
        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            int flag = stmt.executeUpdate("INSERT INTO `smart_drawer`.`tag_bank` (`tagid`) VALUES ('" + tagid + "'); ");//SQL Query

            if (flag == 1) {
                //System.out.println("Success fully added into table");
                return tag;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //DeleteTag method delete tag from system by tagid
    public boolean DeleteTag(String id) {

        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            int flag = stmt.executeUpdate("DELETE FROM `smart_drawer`.`tag_bank` WHERE `tagid` = '" + id + "';");//SQL Query

            if (flag == 1) {
                //System.out.println("Success fully added into table");
                return true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
