package org.acme.boundary.rest;

import java.util.List;

import org.acme.Security.User;
import org.acme.boundary.rest.DTOs.BestellpunktDTO;
import org.acme.control.BestellungService;
import org.acme.entity.Kunde;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/bestellungen")
public class BestellungResource {

    @Inject
    BestellungService bestellungService;

    @Inject
    Template bestellungTemplate;
    @Inject
    Template errorTemplate;

    
    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_PLAIN)
    public TemplateInstance getBestellungen() {
        return bestellungTemplate.data("bestellungen", bestellungService.bestellungenAbfragen());  
    }

    

    @POST
    @RolesAllowed("user")
    public Response addBestellpunkt(BestellpunktDTO dto, @Context SecurityContext securityContext) {
        
        String username = securityContext.getUserPrincipal().getName();
        System.out.println(username);
        
        List<User> users = User.listAll();
        Long id = (long) 0;
        for(User user: users){
            if(user.username.equals(username)) id = user.kundenid;
        }
        ((Kunde) Kunde.findById(id)).addBestellpunkt(dto.getPizzaid(),dto.getAmount());
    
        return Response.ok("Bestellung hinzugefuegt!").build();
    }



    @GET
    @RolesAllowed("user")
    @Produces(MediaType.TEXT_PLAIN)
    public TemplateInstance getBestellung(@Context SecurityContext securityContext) {
    String username = securityContext.getUserPrincipal().getName();
    List<User> users = User.listAll();
    for(User user: users) {
        if(user.username.equals(username)) {
            return bestellungTemplate.data("bestellungen", bestellungService.bestellungAbfragen(user.kundenid).getPizzen()); 
        }
    }
    return errorTemplate.data("bestellung", null);  
    }
 



    
}
