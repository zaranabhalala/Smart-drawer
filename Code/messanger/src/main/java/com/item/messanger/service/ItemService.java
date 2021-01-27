package com.item.messanger.service;

import com.item.messanger.database.DatabaseClass;
import com.item.messanger.model.Item;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//ItemService class is the Brain class of ItemResources class
public class ItemService {

    //default constructor
    public ItemService() {
    }

    DatabaseClass dbc = new DatabaseClass();//dbc is instance of DataBaseClass
    private Map<Integer, Item> item = dbc.getItem();//getting Hashmap from DataBaseClass

    //Gives the List of Available Items  
    public List<Item> getallItem() {

        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from item");//SQl Query
            int i = 1;
            item.clear();
            while (rs.next()) {
                //putting result(Items) in to Hash-Map
                item.put(i, new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
                i++;
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<Item>(item.values());//return Arrylist of Items.
    }

    //Gives specific Item by item id
    public List<Item> getItem(String id) {

        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from item where Item_ID='" + id + "'");//SQL Query

            int i = 1;
            item.clear();
            while (rs.next()) {
                //putting result(Items) in to Hash-Map
                item.put(i, new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
                i++;
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return new ArrayList<Item>(item.values());//Return Specific Item

    }

    //Gives List of Item in specific Drawer
    public List<Item> getDrawerItem(String id) {
        try {
            //JDBC Code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT item.* FROM item JOIN map_tag_item ON item.`Item_ID`=`map_tag_item`.`Item_ID` WHERE `Drawerid`='" + id + "'");//SQl Query

            int i = 1;
            item.clear();
            while (rs.next()) {
                //putting result into the Hash-Map
                item.put(i, new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
                i++;
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return new ArrayList<Item>(item.values());//return Arraylist of Item in specific Drawer
    }

    //Gives All Mapped Items
    public List<Item> getallMappedItem() {

        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT item.* FROM item,map_tag_item WHERE `item`.`Item_ID`=`map_tag_item`.`Item_ID`;");//SQL Query
            int i = 1;
            item.clear();
            while (rs.next()) {
                //putting result into the Hash-Map
                item.put(i, new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
                i++;

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return new ArrayList<Item>(item.values());//return Arraylist of mapped Items

    }

    //Gives All UnMapped Items
    public List<Item> getallUnmappedItem() {

        try {
            //JDBC Code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT item.* FROM `item` LEFT JOIN `map_tag_item` ON `item`.`Item_ID`=`map_tag_item`.`Item_ID` WHERE `map_tag_item`.`Item_ID` IS NULL ;");//SQL Query
            int i = 1;
            item.clear();
            while (rs.next()) {
                //putting result in Hash-Map 
                item.put(i, new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5)));
                i++;
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<Item>(item.values());//return unmapped Items
    }

    //Adding new Item in to the database
    public Item AddItem(Item item) {
        //getting properties if item(Item)
        String ItemName = item.getItem_Name();
        String ItemDescription = item.getItem_Description();
        String Batch_No = item.getBatchno();
        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            int flag = stmt.executeUpdate("INSERT INTO `smart_drawer`.`item` (`Item_Name`,`Item_Description`,`Batch_No`) VALUES ('" + ItemName + "','" + ItemDescription + "','" + Batch_No + "'); ");//SQl Query

//            if (flag == 1) {
//                System.out.println("Item Success fully added into table");
//
//            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    //Removing Item from database using ItemID 
    public boolean removeItem(String id) {

        try {
            //JDBC Code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            int flag = stmt.executeUpdate("DELETE FROM `smart_drawer`.`item` WHERE `Item_ID` = '" + id + "';");//SQl Query

            if (flag == 1) {
                //System.out.println("Success fully Deleted from Item table");
                //return tag;
                return true;
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
