package org.acme.gateway;

import java.util.List;

import org.acme.control.BestellungService;
import org.acme.entity.Bestellung;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class BestellungRepository implements BestellungService,PanacheRepository<Bestellung> {
    
    @Override
    public List<Bestellung> bestellungenAbfragen() {
        return listAll();
    }

    @Override
    public Bestellung bestellungAbfragen(Long id) {
       return (Bestellung) findById(id);
    }

}
