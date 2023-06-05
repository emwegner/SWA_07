package org.acme.boundary.rest.DTOs;

import org.acme.entity.Pizza;

public class PizzaDTO {
    private String name;
    private String beschreibung;
    private float preis;
    private Long id;


    public PizzaDTO() {
    }

    public PizzaDTO(String name, String beschreibung, float preis, Long id) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.preis = preis;
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

    public void setPreis(Float preis) {
        this.preis = preis;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PizzaDTO name(String name) {
        setName(name);
        return this;
    }

    public PizzaDTO beschreibung(String beschreibung) {
        setBeschreibung(beschreibung);
        return this;
    }

    public PizzaDTO preis(Float preis) {
        setPreis(preis);
        return this;
    }

    public PizzaDTO id(Long id) {
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

      
    public static class pizzaDTOConverter{
        public static PizzaDTO toDTO(Pizza pizza) {
            PizzaDTO dto = new PizzaDTO();

            dto.setBeschreibung(pizza.getBeschreibung());
            dto.setId(pizza.getId());
            dto.setName(pizza.getName());
            dto.setPreis(pizza.getPreis());

            return dto;
        }

        public static Pizza toPizza(PizzaDTO dto) {
            Pizza pizza = new Pizza();

            pizza.setBeschreibung(dto.getBeschreibung());
            pizza.setId(dto.getId());
            pizza.setName(dto.getName());
            pizza.setPreis(dto.getPreis());

            return pizza;
        }
    }
    
   

}
