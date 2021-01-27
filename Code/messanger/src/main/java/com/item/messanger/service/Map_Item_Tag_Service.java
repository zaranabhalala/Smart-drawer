package com.item.messanger.service;

import com.item.messanger.database.DatabaseClass;
import com.item.messanger.model.Map_Item_Tag;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Map_Item_Tag_Service is brain class of Map_Tag_Item_Resource class
public class Map_Item_Tag_Service {

    //Creating instance of Database class
    DatabaseClass dbc = new DatabaseClass();
    private Map<Integer, Map_Item_Tag> map_item_tag = dbc.getMap_item_tag();//Getting Hashmap from DataBase Class

    //Default Constructor
    public Map_Item_Tag_Service() {
    }

    //return list of all mapped Items
    public List<Map_Item_Tag> getAll_Map_Item_Tag() {

        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from map_tag_item");//SQL Query
            int i = 1;
            map_item_tag.clear();
            while (rs.next()) {
                //putting result into Hash-Map
                map_item_tag.put(i, new Map_Item_Tag(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getDate(4)));
                i++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<Map_Item_Tag>(map_item_tag.values());//return Arraylist of all Mapped Items
    }

    //get specific mapped item tag 
    public List<Map_Item_Tag> get_Map_Item_Tag(String id) {

        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from map_tag_item where Tag_Serial_No='" + id + "'");//SQL Query
            int i = 1;
            map_item_tag.clear();
            while (rs.next()) {
                //putting result into Hash-Map 
                map_item_tag.put(i, new Map_Item_Tag(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getDate(4)));
                i++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<Map_Item_Tag>(map_item_tag.values());//Return specific mapped Item 
    }

    //Mapping Tag with Item
    public Map_Item_Tag add_Map_Item_Tag(Map_Item_Tag mits) {
        //Getting data from parameter's object
        String tagid = mits.getTag_serial_no();
        int itemid = mits.getItem_id();
        try {
            //JDBC Connection
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            int flag = stmt.executeUpdate("INSERT INTO `smart_drawer`.`map_tag_item` (`Tag_Serial_No`,`Item_ID`) VALUES ('" + tagid + "'," + itemid + "); ");//SQL Query
//            if (flag == 1) {
//                System.out.println("Success fully added into table");
//            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //removing Item Mapping by item id
    public boolean remove_Map_Item_Tag(String id) {
        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            int flag = stmt.executeUpdate("DELETE FROM `smart_drawer`.`map_tag_item` WHERE `Item_ID` = '" + id + "';");//SQL Query

            if (flag == 1) {
                //System.out.println("Success fully deleted into item-map table");
                return true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
