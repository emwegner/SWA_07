package org.acme.control;

import java.util.List;

import org.acme.entity.Pizza;

public interface PizzaService {
    public void pizzaAnlegen(String name, String beschreibung, float preis);
    public void pizzaBearbeiten(Long id, String name,String beschreibung, float preis);
    public List<Pizza> pizzenAbfragen();
    public Pizza pizzaAbfragen(Long kundennr);
    public boolean pizzaLoeschen(Long kundennr);
}
