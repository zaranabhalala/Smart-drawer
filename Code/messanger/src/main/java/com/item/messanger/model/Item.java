package com.item.messanger.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

//Entity/POJO Item Class
@XmlRootElement
public class Item {

//Properties/Data - members    
    private int Item_ID;
    private String Item_Name;
    private String Item_Description;
    private String Batchno;
    private Date created;

    //Constructors
    public Item() {

    }

    public Item(int Item_ID) {
        this.Item_ID = Item_ID;
    }

    public Item(String Item_Name, String Item_Description, String Batchno) {
        this.Item_Name = Item_Name;
        this.Item_Description = Item_Description;
        this.Batchno = Batchno;
    }

    public Item(int Item_ID, String Item_Name, String Item_Description, String Batchno, Date created) {
        this.Item_ID = Item_ID;
        this.Item_Name = Item_Name;
        this.Item_Description = Item_Description;
        this.Batchno = Batchno;
        this.created = created;
    }

    //Getter and Setter methods for datamembers    
    public int getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(int Item_ID) {
        this.Item_ID = Item_ID;
    }

    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String Item_Name) {
        this.Item_Name = Item_Name;
    }

    public String getItem_Description() {
        return Item_Description;
    }

    public void setItem_Description(String Item_Description) {
        this.Item_Description = Item_Description;
    }

    public String getBatchno() {
        return Batchno;
    }

    public void setBatchno(String Batchno) {
        this.Batchno = Batchno;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
