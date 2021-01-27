package com.item.messanger.Resource;

import com.item.messanger.model.Tagbank;
import com.item.messanger.service.TagbankService;
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

//path tagbanktags is the Prime path of TagbankResources 
//calling guidelines : http://localhost:8082/messanger/webapi/tagbanktags/
@Path("/tagbanktags")
public class TagbankResources {
    //creating instance of TagbankService

    TagbankService tagbankservice = new TagbankService();

    //calling guidelines : http://localhost:8082/messanger/webapi/tagbanktags/
    //Method: GET
    //method getalltag returns the JSON List of all available tags
    @GET
    @Produces(MediaType.APPLICATION_JSON)//to produce JSON
    public List<Tagbank> getalltag() {
        return tagbankservice.getAlltags();//call and return getAlltags method of TagbankService class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/tagbanktags/{tagid}
    //Method: GET
    //method get_tag returns the JSON List of specific tags
    @GET
    @Path("/{tagid}")
    @Produces(MediaType.APPLICATION_JSON)//to produce JSON
    public List<Tagbank> get_tag(@PathParam("tagid") String id) {//@PathParam is use for getting data from URI path
        return tagbankservice.gettags(id);//call and return gettags method of TagbankService class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/tagbanktags/mappedtag
    //Method: POST
    //method get_Mappedtag returns the JSON List of all mapped tags(Person or Item)
    @POST
    @Path("/mappedtag")
    @Produces(MediaType.APPLICATION_JSON)//to produce tags
    public List<Tagbank> get_Mappedtag() {
        return tagbankservice.getAllMappedtags();//call and return getAllMappedtags method of TagbankService class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/tagbanktags/unmappedtag
    //Method: POST
    //method get_Unmappedtag returns the JSON List of all un-mapped tags(Person or Item)    
    @POST
    @Path("/unmappedtag")
    @Produces(MediaType.APPLICATION_JSON)//to produce JSON  
    public List<Tagbank> get_Unmappedtag() {
        return tagbankservice.getAllunmappedtags();//call and return getAllunmappedtags method of TagbankService class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/tagbanktags/
    //Method: POST
    //method addTags add new Tag into the system 
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)//to consume get data from form
    public Response addTags(@FormParam("tag_Id") String tag_Id) {//@FormParam({form_element_ID}) get data from form element.
        //creating instance of Tagbank
        Tagbank tagbank = new Tagbank(tag_Id);
        tagbankservice.addtag(tagbank);//calling addtag method of TagbankService class

        //the following code of this method is for redirection of tagBank_table.jsp page after done with adding
        java.net.URI location;
        try {
            location = new java.net.URI("http://localhost:8082/SmrtDrw2/flex-admin-v1.2/tagBank_table.jsp");
            return Response.temporaryRedirect(location).build();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ItemResources.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/tagbanktags/deletetag/{tagno}
    //Method: GET
    //method DeleteTag delete tag from system
    @GET
    @Path("/deletetag/{tagno}")
    @Produces(MediaType.TEXT_PLAIN)//to produce plain text
    public Response DeleteTag(@PathParam("tagno") String id) {//@PathParam is use for getting data from URI path
        tagbankservice.DeleteTag(id);//calling DeleteTag method of TagbankService class

        //the following code of this method is for redirection of tagBank_table.jsp page after done with Deleting
        try {
            URI location = new java.net.URI("http://localhost:8082/SmrtDrw2/flex-admin-v1.2/tagBank_table.jsp");
            return Response.temporaryRedirect(location).build();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ItemResources.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
