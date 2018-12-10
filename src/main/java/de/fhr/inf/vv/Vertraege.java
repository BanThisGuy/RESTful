package de.fhr.inf.vv;

import javax.persistence.*;

@Entity
@Table(name = "VERTRAEGE")
public class Vertraege {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Version
    @Column(name = "VERSION")
    private Integer version;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "KUNDE_ID")
    private Kunde kunde;

    @Column(name = "VERTRAGSART")
    private String vertragsart;

    @Column(name = "JAHRESBEITRAG")
    private String jahresbeitrag;

    private Vertraege() {
    }

    public Vertraege(String vertragsart, String jahresbeitrag) {

        this.vertragsart = vertragsart;
        this.jahresbeitrag = jahresbeitrag;
        this.version = 1;
    }


    public Long getId() {
        return id;
    }

    public String getVertragsart() {
        return vertragsart;
    }

    public void setVertragsart(String vertragsart) {
        this.vertragsart = vertragsart;
    }

    public String getJahresbeitrag() {
        return jahresbeitrag;
    }

    public void setJahresbeitrag(String jahresbeitrag) {
        this.jahresbeitrag = jahresbeitrag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertraege vertrag = (Vertraege) o;

        return id != null ? id.equals(vertrag.id) : vertrag.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Vertrag{" +
                "id=" + id +
                ", Vertragsart='" + vertragsart + '\'' +
                ", Jahresbeitrag='" + jahresbeitrag + '\'' +
                '}';
    }
}
