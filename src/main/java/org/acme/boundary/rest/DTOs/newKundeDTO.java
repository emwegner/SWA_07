package org.acme.boundary.rest.DTOs;

import org.acme.entity.Adresse;
import java.util.Objects;

public class newKundeDTO {
    private String vorname;
    private String nachname;
    private Adresse adresse;
    private String username;
    private String password;


    public newKundeDTO() {
    }

    public newKundeDTO(String vorname, String nachname, Adresse adresse, String username, String password) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public newKundeDTO vorname(String vorname) {
        setVorname(vorname);
        return this;
    }

    public newKundeDTO nachname(String nachname) {
        setNachname(nachname);
        return this;
    }

    public newKundeDTO adresse(Adresse adresse) {
        setAdresse(adresse);
        return this;
    }

    public newKundeDTO username(String username) {
        setUsername(username);
        return this;
    }

    public newKundeDTO password(String password) {
        setPassword(password);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof newKundeDTO)) {
            return false;
        }
        newKundeDTO newKundeDTO = (newKundeDTO) o;
        return Objects.equals(vorname, newKundeDTO.vorname) && Objects.equals(nachname, newKundeDTO.nachname) && Objects.equals(adresse, newKundeDTO.adresse) && Objects.equals(username, newKundeDTO.username) && Objects.equals(password, newKundeDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vorname, nachname, adresse, username, password);
    }

    @Override
    public String toString() {
        return "{" +
            " vorname='" + getVorname() + "'" +
            ", nachname='" + getNachname() + "'" +
            ", adresse='" + getAdresse() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
    
}
