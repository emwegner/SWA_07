package org.acme.gateway;

import java.util.List;

import org.acme.control.BestellpunktService;
import org.acme.entity.Bestellungspunkt;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class BestellungspunktRepository implements BestellpunktService,PanacheRepository<Bestellungspunkt> {
    
    @Override
    public Bestellungspunkt BestellungspunktAbfragen(Long id) {
       return findById(id);
    }

    @Override
    public List<Bestellungspunkt> BestellungspunkteAbfragen() {
        return listAll();
    }

    @Override
    public boolean BestellungspunktLoeschen(Long id) {
       return deleteById(id);
    }

    @Override
    public void BestellungspunktHinzufuegen(Bestellungspunkt bestellungspunkt) {
        bestellungspunkt.persist();
    }
    
}
