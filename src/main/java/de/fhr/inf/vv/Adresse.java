package de.fhr.inf.vv;

import javax.persistence.*;

@Entity
@Table(name = "ADRESSE")
public class Adresse {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "STRASSE")
    private String strasse;

    @Column(name = "POSTLEITZAHL")
    private String postleitzahl;

    @Column(name = "ORT")
    private String ort;

    private Adresse() {

    }

    public Adresse(String Strasse, String Postleitzahl, String Ort) {
        this.strasse = Strasse;
        this.postleitzahl = Postleitzahl;
        this.ort = Ort;
    }

    public String getOrt() {
        return ort;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

}

