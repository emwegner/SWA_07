package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Pizza extends PanacheEntityBase {

    private String name;
    private String beschreibung;
    private float preis;

    @Id
    private Long id;


    public Pizza() {
    }

    public Pizza(String name, String beschreibung, float preis) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.preis = preis;
    }


    @Id
    @SequenceGenerator(name = "pizzaSeq", sequenceName = "pizza_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "pizzaSeq")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return this.beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public float getPreis() {
        return this.preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }



    public Pizza name(String name) {
        setName(name);
        return this;
    }

    public Pizza beschreibung(String beschreibung) {
        setBeschreibung(beschreibung);
        return this;
    }

    public Pizza preis(float preis) {
        setPreis(preis);
        return this;
    }

    public Pizza id(Long id) {
        setId(id);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", beschreibung='" + getBeschreibung() + "'" +
            ", preis='" + getPreis() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }
    
}
