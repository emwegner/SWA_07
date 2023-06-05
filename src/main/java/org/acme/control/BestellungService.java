package org.acme.control;

import java.util.List;

import org.acme.entity.Bestellung;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface BestellungService {
    public Bestellung bestellungAbfragen(Long id);
    public List<Bestellung> bestellungenAbfragen();
}
