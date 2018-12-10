package de.fhr.inf.vv;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "KUNDEN")
public class Kunde {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Version
    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "VORNAME")
    private String vorname;

    @Column(name = "NACHNAME")
    private String nachname;

    @Column(name = "GEBURTSTAG")
    private String geburtstag;


    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;

    @OneToMany(targetEntity = Vertraege.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Vertraege> vertraege;

    private Kunde() {
    }

    public Kunde(String vorname, String nachname, String geburtstag, Adresse adresse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtstag = geburtstag;
        this.adresse = adresse;
        this.version = 1;
    }

    public Kunde(String vorname, String nachname, String geburtstag, Adresse adresse, List<Vertraege> vertraege) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtstag = geburtstag;
        this.adresse = adresse;
        this.vertraege = vertraege;
        this.version = 1;
    }

    public Long getId() {
        return id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(String geburtstag) {
        this.geburtstag = geburtstag;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Vertraege> getVertraege() {
        return vertraege;
    }

    public void setVertraege(List<Vertraege> vertraege) {
        this.vertraege = vertraege;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kunde kunde = (Kunde) o;

        return id != null ? id.equals(kunde.id) : kunde.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "id=" + id +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", geburtstag=" + geburtstag +
                '}';
    }
}