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
public class Tagbank { //POJO class for Tagbank

    public Tagbank() { //No argument Constructor for Tagbank class

    }
    private String tagid;

    public Tagbank(String tagid) { //Parameterized Constructor for Tagbank class
        this.tagid = tagid;
    }
    
    // Getter and Setter Method for Tagbank class
    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
    }

}
