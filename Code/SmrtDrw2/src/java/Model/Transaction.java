/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
/**
 *
 * @author zarana
 */
public class Transaction { //POJO Class for Transaction

    private int transactionID;
    private String tag_serial_no;
    private int drawerid;
    private String timeStamp;
    private Long AddharId;
    private int Item_ID;
    private String Item_Name;

    public Transaction() { //No argument Constructor for Transaction class
    } 

    public Transaction(int transactionID, String tag_serial_no, int drawerid, String timeStamp, Long AddharId, int Item_ID, String Item_Name) {  //Parameterized Constructor for Transaction class
        this.transactionID = transactionID;
        this.tag_serial_no = tag_serial_no;
        this.drawerid = drawerid;
        this.timeStamp = timeStamp;
        this.AddharId = AddharId;
        this.Item_ID = Item_ID;
        this.Item_Name = Item_Name;
    }
    
    // Getter and Setter Method for Transaction class
    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String Item_Name) {
        this.Item_Name = Item_Name;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getTag_serial_no() {
        return tag_serial_no;
    }

    public Long getAddharId() {
        return AddharId;
    }

    public void setAddharId(Long AddharId) {
        this.AddharId = AddharId;
    }

    public int getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(int Item_ID) {
        this.Item_ID = Item_ID;
    }

    public void setTag_serial_no(String tag_serial_no) {
        this.tag_serial_no = tag_serial_no;
    }

    public int getDrawerid() {
        return drawerid;
    }

    public void setDrawerid(int drawerid) {
        this.drawerid = drawerid;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

}   

