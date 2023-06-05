package org.acme.gateway;

import org.acme.control.KundenService;
import org.acme.entity.Adresse;
import org.acme.entity.Kunde;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class KundenRepository implements KundenService,PanacheRepository<Kunde>{

    @Override
    public void kundeAnlegen(String vorname, String nachname, Adresse adresse) {
        Kunde kunde = new Kunde(vorname, nachname, adresse);
        System.out.println("lul");
        kunde.persist();
        System.out.println(kunde);

    }

    @Override
    public List<Kunde> kundenAbfragen() {
        return listAll();
    }

    @Override
    public Kunde kundeAbfragen(Long kundennr) {
       return findById(kundennr);
    }

    @Override
    public boolean kundeLoeschen(Long kundennr) {
      return deleteById(kundennr);
    }

    @Override
    public void adresseAnlegen(Long kundennr, Adresse adresse) {
        findById(kundennr).setAdresse(adresse);
    }

    @Override
    public void adresseAendern(Long kundennr, Adresse adresse) {
        findById(kundennr).setAdresse(adresse);
    }

    @Override
    public Adresse adresseAbfragen(Long kundennr) {
        return findById(kundennr).getAdresse();
    }

    @Override
    public boolean adresseLoeschen(Long kundennr) {
        findById(kundennr).setAdresse(null);
        return true;
    }
    
    
}
