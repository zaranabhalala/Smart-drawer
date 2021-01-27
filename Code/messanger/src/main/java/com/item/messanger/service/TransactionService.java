package com.item.messanger.service;

import com.item.messanger.database.DatabaseClass;
import com.item.messanger.model.Transaction;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//TransactionService class is the Brain class of TransectionResources class
public class TransactionService {

    //creating instance of DatabaseClass
    DatabaseClass dbc = new DatabaseClass();
    //getting Hash-Map instance of entity class
    private Map<Integer, Transaction> transection = dbc.gettransection();

    //default constructor
    public TransactionService() {
    }

    //method getAlltransection returns all logged transections
    public List<Transaction> getAlltransection() {
        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT map_tag_item.Item_ID,item.Item_Name,transaction.* FROM `transaction`,`map_tag_item`,`item` WHERE transaction.Tag_Serial_No=map_tag_item.Tag_Serial_No and map_tag_item.Item_ID=item.Item_ID;");//SQL Query
            int i = 1;
            transection.clear();
            while (rs.next()) {
                //putting query data into hash-map 
                transection.put(i, new Transaction(rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getTimestamp(6), rs.getLong(7), rs.getInt(1), rs.getString(2)));
                i++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<Transaction>(transection.values());//return Arraylist of all Transections
    }

    //method addTransaction add new Transacton into the system
    public Transaction addTransaction(Transaction trs) {
        //Gedtting data from Transection(Parameter) Object 
        String tagid = trs.getTag_serial_no();
        int drwid = trs.getDrawerid();
        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            //Core Logic of Transection
            int flag = stmt.executeUpdate("INSERT INTO `smart_drawer`.`transaction` (`Tag_Serial_No`,`Drawerid`) VALUES ('" + tagid + "'," + drwid + "); ");//SQL Query
            ResultSet rs = stmt.executeQuery("SELECT Drawerid FROM `smart_drawer`.`map_tag_item`WHERE `Tag_Serial_No` = " + tagid + "; ");//SQL Query
            int Dbdrwid = 0;
            while (rs.next()) {
                Dbdrwid = rs.getInt(1);
            }
            int flag2;
            if (Dbdrwid == 0) {
                flag2 = stmt.executeUpdate("UPDATE `smart_drawer`.`map_tag_item` SET `Drawerid` = '" + drwid + "' WHERE `Tag_Serial_No` = '" + tagid + "'; ");//SQL Query
            } else if (Dbdrwid == drwid) {
                flag2 = stmt.executeUpdate("UPDATE `smart_drawer`.`map_tag_item` SET `Drawerid` = '0' WHERE `Tag_Serial_No` = '" + tagid + "'; )");//SQL Query
            }
            //end of core logic of Transaction

            if (flag == 1) {
                //System.out.println("Success fully added into table");
                return trs;
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //method addTransaction add new Transacton into the system
    public void addTransaction(String id, Integer dr) {
        String tagid = id;
        int drwid = dr;
        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            //core logic of Transaction
            int flag = stmt.executeUpdate("INSERT INTO `smart_drawer`.`transaction` (`Tag_Serial_No`,`Drawerid`) VALUES ('" + tagid + "'," + drwid + "); ");//SQL Query
            ResultSet rs = stmt.executeQuery("SELECT Drawerid,Item_ID FROM `smart_drawer`.`map_tag_item`WHERE `Tag_Serial_No` = '" + tagid + "'; ");//SQL Query
            int Dbdrwid = 0;
            int Item_ID = 0;
            while (rs.next()) {
                Dbdrwid = rs.getInt(1);
                Item_ID = rs.getInt(2);
            }
            int flag2;
            if (Dbdrwid != 0) {
                flag2 = stmt.executeUpdate("UPDATE `smart_drawer`.`map_tag_item` SET `Drawerid` = '0' WHERE `Item_ID` = '" + Item_ID + "' ");//SQL Query
            } else {
                flag2 = stmt.executeUpdate("UPDATE `smart_drawer`.`map_tag_item` SET `Drawerid` = '1' WHERE `Item_ID` = '" + Item_ID + "' ");//SQL Query
            }
            //end of core logic of Transaction
            if (flag == 1) {
                // System.out.println("Success fully added into table");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //method addTransaction add new Transacton into the system
    public void addTransactionPerson(String id, Integer dr,String ai) {
        String tagid = id;
        int drwid = dr;
        String adharid=ai;
        long addharid2=0;//addharid2 is actual addhar id of tag mapped person
        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            //core logic of Transaction
            ResultSet rs1=stmt.executeQuery("SELECT `Addhar_ID` FROM `map_tag_person` WHERE `Tag_Serial_No` = \""+adharid+"\"");
            while (rs1.next()) {
                addharid2 = rs1.getLong(1);
            }
            
            int flag = stmt.executeUpdate("INSERT INTO `smart_drawer`.`transaction` (`Tag_Serial_No`,`Drawerid`,`Addhar_ID`) VALUES ('" + tagid + "','" + drwid + "','"+addharid2+"'); ");//SQL Query
            ResultSet rs = stmt.executeQuery("SELECT Drawerid,Item_ID FROM `smart_drawer`.`map_tag_item`WHERE `Tag_Serial_No` = '" + tagid + "'; ");//SQL Query
            int Dbdrwid = 0;
            int Item_ID = 0;
            while (rs.next()) {
                Dbdrwid = rs.getInt(1);
                Item_ID = rs.getInt(2);
            }
            int flag2;
            if (Dbdrwid != 0) {
                flag2 = stmt.executeUpdate("UPDATE `smart_drawer`.`map_tag_item` SET `Drawerid` = '0' WHERE `Item_ID` = '" + Item_ID + "' ");//SQL Query
            } else {
                flag2 = stmt.executeUpdate("UPDATE `smart_drawer`.`map_tag_item` SET `Drawerid` = '1' WHERE `Item_ID` = '" + Item_ID + "' ");//SQL Query
            }
            //end of core logic of Transaction
            if (flag == 1) {
                // System.out.println("Success fully added into table");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Method removeTransaction delete Transection from system by transection_id 
    public boolean removeTransaction(String id) {
        try {
            //JDBC connection
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
