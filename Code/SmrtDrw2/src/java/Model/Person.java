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
public class Person { //POJO Class for Person

    private String first_name;
    private String last_name;
    private Long contact_no;
    private String address;
    private Long adhar_id;

    public Person() { //No argument Constructor for Person class
    }

    public Person(String first_name, String last_name, Long contact_no, String address, Long adhar_id) { //Parameterized Constructor for Person class
        this.first_name = first_name;
        this.last_name = last_name;
        this.contact_no = contact_no;
        this.address = address;
        this.adhar_id = adhar_id;
    }

    public Person(Long adhar_id) { //Parameterized Constructor of Adhar_id for Person class
        this.adhar_id = adhar_id;
    }

    public Person(String first_name, String last_name, Long adhar_id) { //Parameterized Constructor of First_name, Last_name and Adhar_id for Person class
        this.first_name = first_name;
        this.last_name = last_name;
        this.adhar_id = adhar_id;
    }
    
    // Getter and Setter Method for Person class
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
    

