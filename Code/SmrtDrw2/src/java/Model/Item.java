/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author item model
 */
public class Item { //POJO class for Item

    int Item_ID;
    String Item_Name;
    String Item_Description;
    String Batch_No;
    String Time;

    
    public Item(int Item_ID, String Item_Name, String Item_Description, String Batch_No, String Time) { //Parameterized Constructor for Item class
        this.Item_ID = Item_ID;
        this.Item_Name = Item_Name;
        this.Item_Description = Item_Description;
        this.Batch_No = Batch_No;
        this.Time = Time;

    }

    public Item(int Item_ID, String Item_Name) {
        this.Item_ID = Item_ID;
        this.Item_Name = Item_Name;
    }


    public Item(int Item_ID) {
        this.Item_ID = Item_ID;
    }

    public Item(String Item_Name) {
        this.Item_Name = Item_Name;
    }

    
    // Getter and Setter Method for Item class
    public void setItem_ID(int Item_ID) {
        this.Item_ID = Item_ID;
    }

    public void setItem_Name(String Item_Name) {
        this.Item_Name = Item_Name;
    }

    public void setItem_Description(String Item_Description) {
        this.Item_Description = Item_Description;
    }

    public void setBatch_No(String Batch_No) {
        this.Batch_No = Batch_No;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public int getItem_ID() {
        return Item_ID;
    }

    public String getItem_Name() {
        return Item_Name;
    }

    public String getItem_Description() {
        return Item_Description;
    }

    public String getBatch_No() {
        return Batch_No;
    }

    public String getTime() {
        return Time;
    }

}
