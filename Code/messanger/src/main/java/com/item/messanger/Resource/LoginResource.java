
package com.item.messanger.Resource;

import com.item.messanger.service.LoginService;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//path login is the Prime path of LoginResource
//calling guidelines : http://localhost:8082/messanger/webapi/login/

@Path("/login")
public class LoginResource {
    //creating instance of loginService class
    LoginService loginservice = new LoginService();
    
    //calling guidelines : http://localhost:8082/messanger/webapi/login/Check 
    //Method: POST
    //method Check whether user is authorized or not
    @POST
    @Path("/Check")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)//to consume get data from form
    public Response check(@FormParam("email") String Email, @FormParam("password") String Password) {//@FormParam({form_element_ID}) get data from form element.

       Boolean flag = loginservice.CheckLogin(Email, Password);

        { 
            java.net.URI location;
            try {
                if (flag == true) {
                    //if flag=true than it response to transaction page
                    location = new java.net.URI("http://localhost:8082/SmrtDrw2/flex-admin-v1.2/Transaction.jsp");
                    return Response.temporaryRedirect(location).build();
                }
                else
                {//if flag is false than login page is redirected for entering right uername and password
                    location = new java.net.URI("http://localhost:8082/SmrtDrw2/flex-admin-v1.2/login.jsp?status=false");
                    return Response.temporaryRedirect(location).build();
                    
                }
            }

        catch (URISyntaxException ex) {
            Logger.getLogger(ItemResources.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        }
    }
}
    


