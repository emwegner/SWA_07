package org.acme.boundary.rest.DTOs;

import org.acme.entity.Pizza;
import java.util.Objects;

public class BestellpunktDTO {
    private int pizzaid;
    private int amount;


    public BestellpunktDTO() {
    }

    public BestellpunktDTO(int pizzaid, int amount) {
        this.pizzaid = pizzaid;
        this.amount = amount;
    }

    public int getPizzaid() {
        return this.pizzaid;
    }

    public void setPizzaid(int pizzaid) {
        this.pizzaid = pizzaid;
    }

    public BestellpunktDTO pizzaid(int pizzaid) {
        setPizzaid(pizzaid);
        return this;
    }
    

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BestellpunktDTO amount(int amount) {
        setAmount(amount);
        return this;
    }

    
}
