package org.acme.entity;

import java.util.ArrayList;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Kunde extends PanacheEntityBase{

    private String vorname;
    private String nachname;

    @Embedded
    @OneToOne
    private Adresse adresse;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kunde", orphanRemoval = true)
    private List<Bestellung> bestellungen = new ArrayList<Bestellung>();

    @Id
    private Long id;

    

    public Kunde() {
    }

    public Kunde(String vorname, String nachname, Adresse adresse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
    }



    public Kunde(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
        adresse = new Adresse();
    }

    public void addBestellpunkt(int pizzaid, int amount){
        Bestellung bestellung = new Bestellung();
        bestellung.addPizza(Pizza.findById(pizzaid),amount);
        bestellungen.add(bestellung);
    }

    
    @Id
    @SequenceGenerator(name = "kundeSeq", sequenceName = "kunde_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "kundeSeq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Kunde vorname(String vorname) {
        setVorname(vorname);
        return this;
    }

    public Kunde nachname(String nachname) {
        setNachname(nachname);
        return this;
    }

    public Kunde adresse(Adresse adresse) {
        setAdresse(adresse);
        return this;
    }

    @OneToMany(targetEntity = Bestellung.class, fetch = FetchType.EAGER)
    public List<Bestellung> getBestellungen() {
        return this.bestellungen;
    }

    public void setBestellungen(List<Bestellung> bestellungen) {
        this.bestellungen = bestellungen;
    }


    public static void add(String vorname, String nachname, Adresse adresse) { 
        Kunde kunde = new Kunde();
       kunde.setVorname(vorname);
        kunde.setNachname(nachname);
        kunde.setAdresse(adresse);
        kunde.persist();
    }

    @Override
    public String toString() {
        return "{" +
            ", vorname='" + getVorname() + "'" +
            ", nachname='" + getNachname() + "'" +
            ", adresse='" + getAdresse() + "'" +
            "}";
    }

    
}
