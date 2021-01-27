package com.item.messanger.Resource;

import com.item.messanger.model.Maptag_Person;
import com.item.messanger.service.Maptag_PersonService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//path maptagpersons is the Prime path of Maptag_PersonResources 
//calling guidelines : http://localhost:8082/messanger/webapi/maptagpersons/
@Path("/maptagpersons")
public class Maptag_PersonResources {

    //creating instance of Maptag_PersonService class
    Maptag_PersonService maptag_personservice = new Maptag_PersonService();

    //calling guidelines : http://localhost:8082/messanger/webapi/maptagpersons
    //Method: GET
    //method getallMappedPerson returns the JSON List of Person class of all Mapped Person 
    @GET
    @Produces(MediaType.APPLICATION_JSON)//Produces JSON
    public List<Maptag_Person> getallMappedPerson() {
        return maptag_personservice.getallMappedPerson();//Call and return getallMappedPerson method of Maptag_PersonService class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/maptagpersons/get/{adhar_id}
    //Method: GET
    //method getMappedPerson returns the JSON List of Person class of specific Mapped Person 
    @GET
    @Path("get/{adhar_id}")
    @Produces(MediaType.APPLICATION_JSON)//Produces JSON
    public List<Maptag_Person> getMappedPerson(@PathParam("adhar_id") long adhar_id) {//@PathParam is use for getting data from URI path
        return maptag_personservice.getMappedPerson(adhar_id);//Call and return getMappedPerson method of Maptag_PersonService class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/maptagpersons/
    //Method: POST
    //method addPersonMap Map/Add Person with Tag
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addPersonMap(@FormParam("tagNo") String tagid, @FormParam("uniqueid") Long addhar) {//@FormParam({form_element_ID}) get data from form element.
        //Creating Instance of Maptag_Person Class
        Maptag_Person maptag = new Maptag_Person(tagid, addhar);

        maptag_personservice.addPersonMap(maptag);//Calling of addPersonMap method of Maptag_PersonService class

        //the following code of this method is for redirection of tag_map_person.jsp page after done with mapping 
        java.net.URI location;
        try {
            location = new java.net.URI("http://localhost:8082/SmrtDrw2/flex-admin-v1.2/tag_map_person.jsp");
            return Response.temporaryRedirect(location).build();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Maptag_PersonResources.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/maptagpersons/deletemappedperson/{adhar_id}
    //Method: POST
    //method Delete entry of specific Mapped Person 
    @GET
    @Path("deletemappedperson/{adhar_id}")
    @Produces(MediaType.TEXT_PLAIN)//to produce plain text
    public Response deleteMessage(@PathParam("adhar_id") Long adhar_id) {//@PathParam is use for getting data from URI path
        maptag_personservice.removeMappedPerson(adhar_id);//calling of removeMappedPerson method of Maptag_PersonService class

        //the following code of this method is for redirection of tag_map_person.jsp page after done after deleting 
        try {
            URI location = new java.net.URI("http://localhost:8082/SmrtDrw2/flex-admin-v1.2/tag_map_person.jsp");
            return Response.temporaryRedirect(location).build();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ItemResources.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
