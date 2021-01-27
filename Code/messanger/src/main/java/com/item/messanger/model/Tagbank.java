package com.item.messanger.model;

import javax.xml.bind.annotation.XmlRootElement;

//Tagbank is one entity class
@XmlRootElement
public class Tagbank {

    //Data-Members
    private String tagid;

    //constructors
    public Tagbank() {

    }

    public Tagbank(String tagid) {
        this.tagid = tagid;
    }

    //Getter and Setters of data-members
    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
    }

}
