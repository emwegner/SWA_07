package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity

public class Bestellungspunkt extends PanacheEntityBase {
    @OneToOne
    private Pizza pizza;
    private int amount;
    private float preis;

    @Id
    private Long id;

@ManyToOne
    public Pizza getPizza() {
        return this.pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPreis() {
        return this.preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }


    public Bestellungspunkt(Pizza pizza, int amount) {
        this.pizza = pizza;
        this.amount = amount;
        this.preis = pizza.getPreis() * amount;
    }


    public Bestellungspunkt() {
    }

   

    @Id
    @SequenceGenerator(name = "BestellungpunktSeq", sequenceName = "Bestellungpunkt_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "BestellungpunktSeq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "{" +
            " pizza='" + getPizza() + "'" +
            ", amount='" + getAmount() + "'" +
            ", preis='" + getPreis() + "'" +
            ", id='" + getId() + "'" +
            "}";
    }





}
