package org.acme.control;

import java.util.List;

import org.acme.entity.Bestellungspunkt;

public interface BestellpunktService {
    public Bestellungspunkt BestellungspunktAbfragen(Long id);
    public List<Bestellungspunkt> BestellungspunkteAbfragen();
    public boolean BestellungspunktLoeschen(Long id);
    public void BestellungspunktHinzufuegen(Bestellungspunkt bestellungspunkt);
}
