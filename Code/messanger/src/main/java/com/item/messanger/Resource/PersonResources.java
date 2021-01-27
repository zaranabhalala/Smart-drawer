package com.item.messanger.Resource;

import com.item.messanger.model.Person;
import com.item.messanger.service.PersonService;
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

//path persons is the Prime path of PersonResources 
//calling guidelines : http://localhost:8082/messanger/webapi/persons/
@Path("/persons")
public class PersonResources {

    //creating instance of PersonService Class
    PersonService personservice = new PersonService();

    //calling guidelines : http://localhost:8082/messanger/webapi/persons/all
    //Method: POST
    //method getallPerson returns the JSON List of Person class 
    @POST
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)//to produce JSON 
    public List<Person> getallPerson() {
        return personservice.getallPerson();//return and call getallPerson of PersonService class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/persons/unmapped
    //Method: POST
    //method getallPerson returns the JSON List of unmapped Person class 
    @POST
    @Path("/unmapped")
    @Produces(MediaType.APPLICATION_JSON)//to produce JSON
    public List<Person> getUnmapped() {
        return personservice.getUnmapped();//return and call getUnmapped method of PersonService class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/persons/mapped
    //Method: POST
    //method getallPerson returns the JSON List of mapped Person class    
    @POST
    @Path("/mapped")
    @Produces(MediaType.APPLICATION_JSON)//to produce JSON
    public List<Person> getMapped() {
        return personservice.getMapped();//return and call getMapped method of PersonService class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/persons/{adhar _id}
    //Method: GET
    //method getPerson returns the JSON List of specific Person class 
    @GET
    @Path("/{adhar_id}")
    @Produces(MediaType.APPLICATION_JSON)//to produce JSON
    public List<Person> getPerson(@PathParam("adhar_id") long adhar_id) {//@PathParam is use for getting data from URI path
        return personservice.getPerson(adhar_id);//call and return getPerson method of PersonService Class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/persons
    //Method: POST
    //method addPerson Add Person into the database
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)//to consume get data from form
    public Response addPerson(@FormParam("exampleAadharNo") Long addhar, @FormParam("exampleAddress") String address,
            @FormParam("exampleFirstName") String first_name, @FormParam("exampleLastName") String last_name, @FormParam("exampleContactNo") Long contact) {//@FormParam({form_element_ID}) get data from form element.
        try {
            //Filling data into objects from parameters
            Person person = new Person(first_name, last_name, contact, address, addhar);

            personservice.addPerson(person);//calling addPerson method of PersonService class

            //the following code of this method is for redirection of person_table.jsp page after done with adding
            java.net.URI location = new java.net.URI("http://localhost:8082/SmrtDrw2/flex-admin-v1.2/person_table.jsp");
            return Response.temporaryRedirect(location).build();
        } catch (URISyntaxException ex) {
            Logger.getLogger(PersonResources.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/delete/{adhar_id}
    //Method: GET
    //method DeletePerson Delete Person from database by addhar id
    @GET
    @Path("/delete/{adhar_id}")
    @Produces(MediaType.TEXT_PLAIN)//To produce plain text
    public Response DeletePerson(@PathParam("adhar_id") Long adhar_id) {//@PathParam is use for getting data from URI path
        personservice.DeletePerson(adhar_id);//call and return DeletePerson method of PersonService class

        //the following code of this method is for redirection of person_table.jsp page after done with deleting
        java.net.URI location;
        try {
            location = new java.net.URI("http://localhost:8082/SmrtDrw2/flex-admin-v1.2/person_table.jsp");
            return Response.temporaryRedirect(location).build();
        } catch (URISyntaxException ex) {
            Logger.getLogger(PersonResources.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
