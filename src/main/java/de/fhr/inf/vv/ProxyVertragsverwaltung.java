package de.fhr.inf.vv;

public class ProxyVertragsverwaltung implements Vertragsverwaltung {
    private RealVertragsverwaltung realVertragsverwaltung;

    ProxyVertragsverwaltung() {
    }

    // Proxy CRUD für Verträge
    // Proxy für ausgabe aller Verträge
    @Override
    public void listAllVertraege() {
        if (realVertragsverwaltung == null) {
            realVertragsverwaltung = new RealVertragsverwaltung();
        }
        realVertragsverwaltung.listAllVertraege();
    }

    // Proxy für create Vertrag
    @Override
    public void createVertrag() {
        if (realVertragsverwaltung == null) {
            realVertragsverwaltung = new RealVertragsverwaltung();
        }
        realVertragsverwaltung.createVertrag();
    }

    // Proxy für read Vertrag
    @Override
    public void getVertrag() {
        if (realVertragsverwaltung == null) {
            realVertragsverwaltung = new RealVertragsverwaltung();
        }
        realVertragsverwaltung.getVertrag();
    }

    // Proxy für update Vertrag
    @Override
    public void updateVertrag() {
        if (realVertragsverwaltung == null) {
            realVertragsverwaltung = new RealVertragsverwaltung();
        }
        realVertragsverwaltung.updateVertrag();
    }

    // Proxy für delete Vertrag
    @Override
    public void deleteVertrag() {
        if (realVertragsverwaltung == null) {
            realVertragsverwaltung = new RealVertragsverwaltung();
        }
        realVertragsverwaltung.deleteVertrag();
    }
}


