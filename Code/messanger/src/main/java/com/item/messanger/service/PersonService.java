package com.item.messanger.service;

import com.item.messanger.database.DatabaseClass;
import com.item.messanger.model.Person;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//PersonService class is the Brain class of PersonResources class
public class PersonService {

    //creating instance of DatabaseClass Class
    DatabaseClass dbc = new DatabaseClass();
    //getting instance of hashmap from databaseclass
    private Map<Integer, Person> person = dbc.getPersons();

    //default constructor
    public PersonService() {
    }

    //method getallPerson person returns the all person which available in system
    public List<Person> getallPerson() {

        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from person");//SQL Query
            int i = 1;
            person.clear();
            while (rs.next()) {
                //putting result of query into the HashMap
                person.put(i, new Person(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getLong(5)));
                i++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<Person>(person.values());//return arraylist of all persons
    }

    //returns the all unmapped persons with tags
    public ArrayList<Person> getUnmapped() {

        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select person.* from person LEFT JOIN map_tag_person on person.`Addhar_ID`=map_tag_person.`Addhar_ID` where map_tag_person.`Addhar_ID` is NULL;");//SQL Query
            int i = 1;
            person.clear();
            while (rs.next()) {
                //putting result of query into the HashMap
                person.put(i, new Person(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getLong(5)));
                i++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<Person>(person.values());//return the list of all un-mapped persons 
    }

    //returns the all mapped persons with tags
    public List<Person> getMapped() {

        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT p.* FROM person p JOIN map_tag_person mtp ON p.Addhar_ID=mtp.Addhar_ID;");//SQL Query
            int i = 1;
            person.clear();
            while (rs.next()) {
                //putting result of query into the HashMap
                person.put(i, new Person(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getLong(5)));
                i++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<Person>(person.values());//return the list of all Mapped persons     
    }

    //gives specific person by addhar_id  
    public List<Person> getPerson(Long adhar_id) {

        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from person where Addhar_ID='" + adhar_id + "'");//SQL Query
            int i = 1;
            person.clear();
            while (rs.next()) {
                //putting result of query into the HashMap
                person.put(i, new Person(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getLong(5)));
                i++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<Person>(person.values());//return specific person
    }

    //Adding new Person into the system
    public Person addPerson(Person ps) {
        //Getting data from person object
        String fname = ps.getFirst_name();
        String lname = ps.getLast_name();
        Long contact = ps.getContact_no();
        String address = ps.getAddress();
        Long adharid = ps.getAdhar_id();
        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            int flag = stmt.executeUpdate("INSERT INTO `smart_drawer`.`person` (`First_Name`,`Last_Name`,`Contact_No`,`Address`,`Addhar_ID`) VALUES ('" + fname + "','" + lname + "'," + contact + ",'" + address + "'," + adharid + ");");//SQL Query           

            if (flag == 1) {
                //System.out.println("Success fully added into table");
                return ps;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    //Delete person from system by addhar-id
    public boolean DeletePerson(Long adhar_id) {

        try {
            //JDBC code
            Connection con = dbc.getconnection();
            Statement stmt = con.createStatement();
            int flag = stmt.executeUpdate("DELETE FROM `smart_drawer`.`person` WHERE `Addhar_ID` = '" + adhar_id + "';");//SQL Query

            if (flag == 1) {
                //System.out.println("Success fully deleted from table");
                return true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
