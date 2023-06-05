package org.acme.entity;

import java.util.ArrayList;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Bestellung extends PanacheEntityBase {

   @OneToMany
   private List<Bestellungspunkt> pizzen = new ArrayList<Bestellungspunkt>();
   @Id
   private Long id;

   @Id
   @SequenceGenerator(name = "BestellungSeq", sequenceName = "Bestellung_id_seq", allocationSize = 1, initialValue = 1)
   @GeneratedValue(generator = "BestellungSeq")
   public Long getId() {
       return id;
   }

   public void setId(Long id) {
       this.id = id;
   }

   public Bestellung() {
   }

   public Bestellung(ArrayList<Bestellungspunkt> pizzen, Long id) {
      this.pizzen = pizzen;
      this.id = id;
   }
   
  
   @OneToMany(targetEntity = Bestellungspunkt.class, fetch = FetchType.EAGER)
   public List<Bestellungspunkt> getPizzen() {
      return this.pizzen;
   }

   public void setPizzen(ArrayList<Bestellungspunkt> pizzen) {
      this.pizzen = pizzen;
   }

   public Bestellung pizzen(ArrayList<Bestellungspunkt> pizzen) {
      setPizzen(pizzen);
      return this;
   }

   public Bestellung id(Long id) {
      setId(id);
      return this;
   }

   public void addPizza(Pizza pizza, int amount) {
      Bestellungspunkt punkt = new Bestellungspunkt(pizza, amount);
      pizzen.add(punkt);
   }


   @Override
   public String toString() {
      return "{" +
         " pizzen='" + getPizzen() + "'" +
         ", id='" + getId() + "'" +
         "}";
   }

   

}
