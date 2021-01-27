
package com.item.messanger.Resource;

import com.item.messanger.model.Item;
import com.item.messanger.service.ItemService;
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

//path item is the Prime path of ItemResources 
//calling guidelines : http://localhost:8082/messanger/webapi/item/
@Path("/item")
public class ItemResources {

    //creating instance of ItemService class
    ItemService itemservice = new ItemService();

    //calling guidelines : http://localhost:8082/messanger/webapi/item/getallitems 
    //Method: POST
    //method getAllItem returns the JSON List of Item class of all Added Items 
    @POST
    @Path("/getallitems")
    @Produces(MediaType.APPLICATION_JSON)//to produce JSON
    public List<Item> getAllItem() {
        return itemservice.getallItem();//return getallItem method of ItemService class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/item/{itemid} 
    //Method: GET
    //method getItem returns the JSON List of Item class of Specific item id 
    @GET
    @Path("/{itemid}")
    @Produces(MediaType.APPLICATION_JSON)//to produce JSON
    public List<Item> getItem(@PathParam("itemid") String id) {//@PathParam is use for getting data from URI path
        return itemservice.getItem(id);//return getItem method of ItemService class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/item/UnmappedItem 
    //Method: POST
    //method getAllUnmappedItem returns the JSON List of Item class of UnMapped_Item with tag
    @POST
    @Path("/UnmappedItem")
    @Produces(MediaType.APPLICATION_JSON)//to produce JSON
    public List<Item> getAllUnmappedItem() {
        return itemservice.getallUnmappedItem();//return getallUnmappedItem method of ItemService class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/item/MappedItem 
    //Method: POST
    //method getAllMappedItem returns the JSON List of Item class of Mapped_Item with tag
    @POST
    @Path("/MappedItem")
    @Produces(MediaType.APPLICATION_JSON)//to produce JSON
    public List<Item> getAllMappedItem() {
        return itemservice.getallMappedItem();//return getallMappedItem method of ItemService class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/item/DrawerItem/{drawerid} 
    //Method: POST
    //method getDrawerItem returns the JSON List of Item class which is available in specific drawer
    @POST
    @Path("/DrawerItem/{drawerid}")
    @Produces(MediaType.APPLICATION_JSON)//to produce JSON
    public List<Item> getDrawerItem(@PathParam("drawerid") String id) {//@PathParam is use for getting data from URI path
        return itemservice.getDrawerItem(id);//return getDrawerItem method of ItemService class
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/item
    //Method: POST
    //method getDrawerItem Add tag with item 
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)//to consume get data from form
    public Response add_Item_Tag(@FormParam("Item_Name") String Item_Name, @FormParam("Item_Description") String Item_Description, @FormParam("Batch_No") String Batch_No) {//@FormParam({form_element_ID}) get data from form element.

        Item item = new Item(Item_Name, Item_Description, Batch_No);//Insert parameters into item entity
        itemservice.AddItem(item);//call AddItem of ItemService Class to add Maping

        //the following code of this method is for redirection of View-items.jsp page after done with adding
        java.net.URI location;
        try {
            location = new java.net.URI("http://localhost:8082/SmrtDrw2/flex-admin-v1.2/View-items.jsp");
            return Response.temporaryRedirect(location).build();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ItemResources.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    //calling guidelines : http://localhost:8082/messanger/webapi/item/deleteitem/{itemid}
    //Method: GET
    //method DeleteMappedItem delete the entry of added Item
    @GET
    @Path("/deleteitem/{itemid}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response DeleteItem(@PathParam("itemid") String id) {//@PathParam is use for getting data from URI path
        itemservice.removeItem(id);////call removeItem of ItemService Class to delete MappedItem
        
         //the following code of this method is for redirection of View-items.jsp page after done with delete item
        try {
            URI location = new java.net.URI("http://localhost:8082/SmrtDrw2/flex-admin-v1.2/View-items.jsp");
            return Response.temporaryRedirect(location).build();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ItemResources.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
