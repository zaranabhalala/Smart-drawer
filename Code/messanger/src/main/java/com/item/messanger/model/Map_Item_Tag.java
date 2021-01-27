package com.item.messanger.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

//Map_Item_Tag is entity/POJO class
@XmlRootElement
public class Map_Item_Tag {

    //Properties/data-members of Map_Item_Tag class
    private String tag_serial_no;
    private int drawerid;
    private int item_id;
    private Date timeStamp;

    //constructors
    public Map_Item_Tag() {
    }

    public Map_Item_Tag(String tag_serial_no, int item_id) {
        this.tag_serial_no = tag_serial_no;
        this.item_id = item_id;
    }

    public Map_Item_Tag(String tag_serial_no, int drawerid, int item_id, Date timeStamp) {
        this.tag_serial_no = tag_serial_no;
        this.drawerid = drawerid;
        this.item_id = item_id;
        this.timeStamp = timeStamp;
    }

    //Getter and Setter methods of data-members
    public String getTag_serial_no() {
        return tag_serial_no;
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

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

}
