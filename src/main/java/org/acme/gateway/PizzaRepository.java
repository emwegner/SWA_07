package org.acme.gateway;

import java.util.List;

import org.acme.control.PizzaService;
import org.acme.entity.Pizza;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;
@RequestScoped
public class PizzaRepository implements PizzaService, PanacheRepository<Pizza>{

    @Override
    public void pizzaAnlegen(String name, String beschreibung, float preis) {
        Pizza pizza = new Pizza(name,beschreibung,preis);
        pizza.persist();
    }

    @Override
    public void pizzaBearbeiten(Long id, String name,String beschreibung, float preis) {
        findById(id).setName(name);
        findById(id).setBeschreibung(beschreibung);
        findById(id).setPreis(preis);
    }

    @Override
    public List<Pizza> pizzenAbfragen() {
        return listAll();
    }

    @Override
    public Pizza pizzaAbfragen(Long id) {
        return findById(id);
    }

    @Override
    public boolean pizzaLoeschen(Long id) {
        return deleteById(id);
    }
    
}
