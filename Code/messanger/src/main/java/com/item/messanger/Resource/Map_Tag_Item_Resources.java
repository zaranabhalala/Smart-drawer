
package com.item.messanger.Resource;

import com.item.messanger.model.Map_Item_Tag;
import com.item.messanger.service.Map_Item_Tag_Service;
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

//path mapitemtag is the Prime path of Map_Tag_Item_Resources 
//calling guidelines : http://localhost:8082/messanger/webapi/mapitemtag/
@Path("/mapitemtag")
public class Map_Tag_Item_Resources {

    //creating instance of Map_Item_Tag_Service class
    Map_Item_Tag_Service mapitemtagservice = new Map_Item_Tag_Service();

    //calling guidelines : http://localhost:8082/messanger/webapi/mapitemtag
    //Method: GET
    //method getAll_Map_Item_Tag returns the JSON List of Item class of all Mapped Items 
    @GET
    @Produces(MediaType.APPLICATION_JSON)//to produce JSON
    public List<Map_Item_Tag> getAll_Map_Item_Tag() {

        return mapitemtagservice.getAll_Map_Item_Tag();//return call getAll_Map_Item_Tag method of Map_Item_Tag_Service class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/mapitemtag/{tagid}
    //Method: GET
    //method get_Map_Item_Tag returns the specific Item class from Mapped Items 
    @GET
    @Path("/{tagid}")
    @Produces(MediaType.APPLICATION_JSON)//to produce JSON
    public List<Map_Item_Tag> get_Map_Item_Tag(@PathParam("tagid") String id) {//@PathParam is use for getting data from URI path
        return mapitemtagservice.get_Map_Item_Tag(id);//return call get_Map_Item_Tag method of Map_Item_Tag_Service class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/mapitemtag/
    //Method: POST
    //method add_Map_Item_Tag Map/Add Item with Tag
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response add_Map_Item_Tag(@FormParam("tagNo") String tagid, @FormParam("itemid") int itemid) {//@FormParam({form_element_ID}) get data from form element.
        //creating & filling instance of Map_Item_Tag class
        Map_Item_Tag mapitemtag = new Map_Item_Tag(tagid, itemid);
        mapitemtagservice.add_Map_Item_Tag(mapitemtag);//called add_Map_Item_Tag method of Map_Item_Tag_Service class

        //the following code of this method is for redirection of View-items.jsp page after done with mapping 
        java.net.URI location;
        try {
            location = new java.net.URI("http://localhost:8082/SmrtDrw2/flex-admin-v1.2/tag_map_item.jsp");
            return Response.temporaryRedirect(location).build();

        } catch (URISyntaxException ex) {
            Logger.getLogger(Maptag_PersonResources.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/mapitemtag//deletemappeditem/{itemid}
    //Method: POST
    //method Delete entry of specific Mapped Item 
    @GET
    @Path("/deletemappeditem/{itemid}")
    @Produces(MediaType.TEXT_PLAIN)//to produce plain text
    public Response deleteMessage(@PathParam("itemid") String id) {//@PathParam is use for getting data from URI path
        mapitemtagservice.remove_Map_Item_Tag(id);//calling of remove_Map_Item_Tag method of Map_Item_Tag_Service class

        //the following code of this method is for redirection of tag_map_item.jsp page after done with deleteing
        try {
            URI location = new java.net.URI("http://localhost:8082/SmrtDrw2/flex-admin-v1.2/tag_map_item.jsp");
            return Response.temporaryRedirect(location).build();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ItemResources.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
