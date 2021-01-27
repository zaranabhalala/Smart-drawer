
package com.item.messanger.Resource;

import com.item.messanger.model.Transaction;
import com.item.messanger.service.TransactionService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//path transections is the Prime path of TransectionResources class
//calling guidelines : http://localhost:8082/messanger/webapi/transections/
@Path("/transections")
public class TransectionResources {

    //creating instance of TransactionService
    TransactionService transactionservice = new TransactionService();

    //calling guidelines : http://localhost:8082/messanger/webapi/transections/
    //Method: POST
    //method GetAllTransaction returns the JSON List of all Transaction(IN/OUT)
    @POST
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)//to produce JSON
    public List<Transaction> GetAllTransaction() {
        return transactionservice.getAlltransection();//return and call getAlltransection method of TransactionService
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/transections/{tagid}/{draweid}
    //Method: GET
    //method addTransection add new Transaction(IN/OUT)
    @GET
    @Path("/{tagid}/{draweid}")
    public void addTransection(@PathParam("tagid") String id, @PathParam("draweid") Integer dr) {//@PathParam is use for getting data from URI path
        transactionservice.addTransaction(id, dr);//call addTransaction method of TransactionService
    }
    
    //calling guidelines : http://localhost:8082/messanger/webapi/transections/{tagid}/{draweid}
    //Method: GET
    //method addTransection add new Transaction(IN/OUT)
    @GET
    @Path("/{tagid}/{draweid}/{AddharId}")
    public void addTransectionPerson(@PathParam("tagid") String id, @PathParam("draweid") Integer draweid,@PathParam("AddharId") String AddharId) {//@PathParam is use for getting data from URI path
        transactionservice.addTransactionPerson(id, draweid, AddharId);//call addTransaction method of TransactionService
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/transections/
    //Method: POST
    //method addTransection add new Transaction(IN/OUT)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction addTransection(Transaction message) {
        return transactionservice.addTransaction(message);//return and call addTransaction method of TransactionService
    }

    //calling guidelines : http://localhost:8082/messanger/webapi/transections/{tagid}/
    //Method: GET
    //method deleteTransection delete Transaction(IN/OUT)
    @GET
    @Path("/{tagid}")
    @Produces(MediaType.TEXT_PLAIN)
    public void deleteTransection(@PathParam("tagid") String id) {//@PathParam is use for getting data from URI path
        transactionservice.removeTransaction(id);// call removeTransaction method of TransactionService
    }

}
