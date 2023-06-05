package org.acme.boundary.rest.DTOs;

import java.util.ArrayList;
import java.util.List;

import org.acme.entity.Adresse;
import org.acme.entity.Bestellung;
import org.acme.entity.Kunde;

public class KundeDTO {
    private String vorname;
    private String nachname;
    private Adresse adresse;
    private List<Bestellung> bestellungen = new ArrayList<Bestellung>();
    private Long id;
    

    public KundeDTO() {
    }

    public KundeDTO(String vorname, String nachname, Adresse adresse, ArrayList<Bestellung> bestellungen, Long id) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.bestellungen = bestellungen;
        this.id = id;
    }

    public String getVorname() {
        return this.vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return this.nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Adresse getAdresse() {
        return this.adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Bestellung> getBestellungen() {
        return this.bestellungen;
    }

    public void setBestellungen(List<Bestellung> bestellungen) {
        this.bestellungen = bestellungen;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KundeDTO vorname(String vorname) {
        setVorname(vorname);
        return this;
    }

    public KundeDTO nachname(String nachname) {
        setNachname(nachname);
        return this;
    }

    public KundeDTO adresse(Adresse adresse) {
        setAdresse(adresse);
        return this;
    }

    public KundeDTO bestellungen(List<Bestellung> bestellungen) {
        setBestellungen(bestellungen);
        return this;
    }

    public KundeDTO id(Long id) {
        setId(id);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " vorname='" + getVorname() + "'" +
            ", nachname='" + getNachname() + "'" +
            ", adresse='" + getAdresse() + "'" +
            ", bestellungen='" + getBestellungen() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }




    public static class kundeDTOConverter{
        public static KundeDTO toDTO(Kunde kunde) {
            KundeDTO dto = new KundeDTO();

            dto.setVorname(kunde.getVorname());
            dto.setNachname(kunde.getNachname());
            dto.setAdresse(kunde.getAdresse());
            dto.setId(kunde.getId());
            dto.setBestellungen(kunde.getBestellungen());

            return dto;
        }

        public static Kunde toKunde(KundeDTO dto) {
            Kunde kunde = new Kunde();

            kunde.setAdresse(dto.getAdresse());
            kunde.setBestellungen(dto.getBestellungen());
            kunde.setId(dto.getId());
            kunde.setNachname(dto.getNachname());
            kunde.setVorname(dto.getVorname());

            return kunde;
        }
    }
}
