package org.acme.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {
    private String plz;
    private String ort;
    private String strasse;
    private String hausnr;


    public Adresse() {
    }

    public Adresse(String plz, String ort, String strasse, String hausnr) {
        this.plz = plz;
        this.ort = ort;
        this.strasse = strasse;
        this.hausnr = hausnr;
    }

    public String getPlz() {
        return this.plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return this.ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getStrasse() {
        return this.strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnr() {
        return this.hausnr;
    }

    public void setHausnr(String hausnr) {
        this.hausnr = hausnr;
    }

    public Adresse plz(String plz) {
        setPlz(plz);
        return this;
    }

    public Adresse ort(String ort) {
        setOrt(ort);
        return this;
    }

    public Adresse strasse(String strasse) {
        setStrasse(strasse);
        return this;
    }

    public Adresse hausnr(String hausnr) {
        setHausnr(hausnr);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " plz='" + getPlz() + "'" +
            ", ort='" + getOrt() + "'" +
            ", strasse='" + getStrasse() + "'" +
            ", hausnr='" + getHausnr() + "'" +
            "}";
    }
    
}
