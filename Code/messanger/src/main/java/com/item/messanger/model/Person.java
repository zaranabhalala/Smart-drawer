package com.item.messanger.model;

import javax.xml.bind.annotation.XmlRootElement;

//Person is one entity class
@XmlRootElement
public class Person {

    //Data-Members
    private String first_name;
    private String last_name;
    private Long contact_no;
    private String address;
    private Long adhar_id;

    //Constructors
    public Person() {
    }

    public Person(String first_name, String last_name, Long contact_no, String address, Long adhar_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.contact_no = contact_no;
        this.address = address;
        this.adhar_id = adhar_id;
    }

    public Person(long aLong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //getter and setters of data-members
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getContact_no() {
        return contact_no;
    }

    public void setContact_no(Long contact_no) {
        this.contact_no = contact_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getAdhar_id() {
        return adhar_id;
    }

    public void setAdhar_id(Long adhar_id) {
        this.adhar_id = adhar_id;
    }

}
