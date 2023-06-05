//DAS KANN VERMUTLICH WEG?
package org.acme.boundary.rest;

import org.acme.boundary.rest.DTOs.LoginDTO;
import org.acme.control.KundenService;


import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/login")
public class LoginResource {

    @Inject
    Template loginTemplate;

    @Inject
    KundenService kundenservice;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public TemplateInstance get() {
        String logindata = "data";
        return loginTemplate.data("data", logindata);  
    }


    @POST
    @Path("/log")
    @PermitAll
    public Response login(LoginDTO input) {
        System.out.println(input.getName());
        System.out.println(input.getPassword());
        
     /* 
        List<User> user = User.listAll();
       for(int i = 0; i < user.size(); i++) {
        if(username.equals(user.get(i).username)) {
            if(password.equals(user.get(i).password)) {
                return Response.ok("Login erfolgreich").build(); 
            }
        }

       }
       */
        return Response.ok("Login gescheitert").build(); 
    }

    
}
