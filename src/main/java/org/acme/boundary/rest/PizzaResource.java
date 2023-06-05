package org.acme.boundary.rest;

import org.acme.boundary.rest.DTOs.PizzaDTO;
import org.acme.boundary.rest.DTOs.PizzaDTO.pizzaDTOConverter;
import org.acme.control.PizzaService;
import org.acme.entity.Pizza;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/pizzen")
public class PizzaResource {

    @Inject
    PizzaService pizzaservice;

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    Template pizzenTemplate;

    @Inject
    Template pizzaTemplate;

    @Inject 
    Template errorTemplate;

    @GET
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public TemplateInstance get() {
        return pizzenTemplate.data("pizzen", pizzaservice.pizzenAbfragen());  
    }



    @GET
    @PermitAll
    @Path("/{id}")
    public TemplateInstance getPizza(@PathParam("id") Long id) {
        Pizza pizza = pizzaservice.pizzaAbfragen(id);
        if(pizza != null) return pizzaTemplate.data("pizza", pizza);  
        else return errorTemplate.data("pizza", pizza);
    }

    @Transactional
    @POST
    @RolesAllowed("admin")
    public Response addPizza(PizzaDTO dto) {
    
        if(dto != null) {
            Pizza pizza = pizzaDTOConverter.toPizza(dto);
            pizzaservice.pizzaAnlegen(pizza.getName(),pizza.getBeschreibung(),pizza.getPreis());
            return Response.ok("Pizza hinzugefuegt!").build();    
        } 
        return Response.notModified("Not Valid : addPizza").build();    
    }

    
    @Transactional
    @DELETE
   @RolesAllowed("admin")
    @Path("/{id}")
    public Response deletePizza(@PathParam("id") Long id) {
        if(id != null) {
            pizzaservice.pizzaLoeschen(id);
            return Response.ok("Pizza geloescht!").build();    
        } 
        return Response.notModified("Not Valid : deletePizza").build();
        
    }

    

    
}
