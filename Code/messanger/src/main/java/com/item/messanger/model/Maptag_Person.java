package com.item.messanger.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

//Maptag_Person is one entity class
@XmlRootElement
public class Maptag_Person {

    //Data-Members
    private String tag_id;
    private Long adhar_id;
    private Date timeStamp;

    //Constructors
    public Maptag_Person() {
    }

    public Maptag_Person(String tag_id, Long adhar_id) {
        this.tag_id = tag_id;
        this.adhar_id = adhar_id;
    }

    public Maptag_Person(String tag_id, Long adhar_id, Date timeStamp) {
        this.tag_id = tag_id;
        this.adhar_id = adhar_id;
        this.timeStamp = timeStamp;
    }

    //Getter and Setters of data-members
    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public Long getAdhar_id() {
        return adhar_id;
    }

    public void setAdhar_id(Long adhar_id) {
        this.adhar_id = adhar_id;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

}
