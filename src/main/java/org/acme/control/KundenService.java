package org.acme.control;


import java.util.List;

import org.acme.entity.Adresse;
import org.acme.entity.Kunde;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface KundenService {
    public void kundeAnlegen(String vorname, String nachname, Adresse adresse);
    public List<Kunde> kundenAbfragen();
    public Kunde kundeAbfragen(Long kundennr);
    public boolean kundeLoeschen(Long kundennr);
    public void adresseAnlegen(Long kundennr, Adresse adresse);
    public void adresseAendern(Long kundennr, Adresse adresse);
    public Adresse adresseAbfragen(Long kundennr);
    public boolean adresseLoeschen(Long kundennr);
   
}
