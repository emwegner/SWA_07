package org.acme.boundary.rest;

import java.util.List;

import org.acme.Security.User;
import org.acme.boundary.rest.DTOs.KundeDTO;
import org.acme.boundary.rest.DTOs.KundeDTO.kundeDTOConverter;
import org.acme.boundary.rest.DTOs.newKundeDTO;
import org.acme.control.KundenService;
import org.acme.entity.Adresse;
import org.acme.entity.Kunde;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;



@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/kunden")
public class KundenResource {

    @Inject
    KundenService kundenservice;

    @Inject
    Template kundenTemplate;
    @Inject
    Template kundeTemplate;
    @Inject
    Template errorTemplate;
    @Inject
    Template loginTemplate;

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_PLAIN)
    public TemplateInstance getKunden() {
        return kundenTemplate.data("kunden", kundenservice.kundenAbfragen());  
    }

    @GET
    @Path("/res")
    @RolesAllowed("admin")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getKunden2() {
        return Response.ok(kundenservice.kundenAbfragen()).build();
    }


    @GET
    @RolesAllowed("admin")
    @Path("/{id}")
    public TemplateInstance getKunde(@PathParam("id") Long id) {
        Kunde kunde = kundenservice.kundeAbfragen(id);
        if(kunde != null) return kundeTemplate.data("kunde", kunde);  
        else return errorTemplate.data("kunde", kundenservice.kundeAbfragen(id));  
    }

    @GET
    @RolesAllowed("user")
    @Path("/me")
    public TemplateInstance getMe(@Context SecurityContext securityContext) {
    String username = securityContext.getUserPrincipal().getName();
    List<User> users = User.listAll();
    for(User user: users) {
        if(user.username.equals(username)) {
            return kundeTemplate.data("kunde", kundenservice.kundeAbfragen(user.kundenid));  
        }
    }
    return errorTemplate.data("kunde", null);  
    }

    @Transactional
    @PermitAll
    @POST
    public Response addKunde(KundeDTO dto) {
        if(dto != null) {
            Kunde kunde = kundeDTOConverter.toKunde(dto);
            kundenservice.kundeAnlegen(kunde.getVorname(),kunde.getNachname(),kunde.getAdresse());
            return Response.ok("Kunde hinzugefuegt!").build();    
        } 
        return Response.notModified("Not Valid : addKunde").build();
      
    }

    @Transactional
    @PermitAll
    @POST
    @Path("/add")
    public TemplateInstance registerKunde(newKundeDTO input) {
        kundenservice.kundeAnlegen(input.getVorname(),input.getNachname(),input.getAdresse());
        List<Kunde> kunden = Kunde.listAll();
        Long id = (long) 0;
        for(Kunde kunde : kunden) {
            if(kunde.getVorname().equals(input.getVorname())) {
                if(kunde.getNachname().equals(input.getNachname())) {
                    id = kunde.getId();
            }
        }
    }
        User.add(input.getUsername(),input.getPassword(), "user", id);
        return loginTemplate.data("login", null);  
    }

    @Transactional
    @PATCH
    @Path("/{id}")
    public Response addAdresse(@PathParam("id")Long id, Adresse adresse) {
        if(id != null && adresse != null) {
            kundenservice.adresseAnlegen(id, adresse);
            return Response.ok("Adresse zu Kunde hinzugefuegt!").build();    
        } 
        return Response.notModified("Not Valid : addAdresse").build();
        
    }

    @Transactional
    @PATCH
    @Path("adresse/{id}")
    public Response editAdresse(@PathParam("id")Long id, Adresse adresse) {
        if(id != null && adresse != null) {
            kundenservice.adresseAendern(id, adresse);
            return Response.ok("Adresse von Kunde geaendert!").build();    
        } 
        return Response.notModified("Not Valid : editAdresse").build();
        
    }

    @Transactional
    @DELETE
    @RolesAllowed("admin")
    @Path("/{id}")
    public Response deleteKunde(@PathParam("id") Long id) {
        if(id != null) {
            kundenservice.kundeLoeschen(id);
            return Response.ok("Kunde geloescht!").build();    
        } 
        return Response.notModified("Not Valid : deleteKunde").build();
        
    }
  
    @Transactional
    @DELETE
    @RolesAllowed("admin")
    @Path("/adresse/{id}")
    public Response deleteAdresse(@PathParam("id") Long id) {
        if(id != null) {
            kundenservice.adresseLoeschen(id);
            return Response.ok("Adresse von Kunde geloescht!").build();    
        } 
        return Response.notModified("Not Valid : deleteAdresse").build();
           
    }


    

    
}
