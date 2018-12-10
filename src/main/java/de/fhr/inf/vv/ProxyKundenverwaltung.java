package de.fhr.inf.vv;

public class ProxyKundenverwaltung implements Kundenverwaltung {
    private RealKundenverwaltung realKundenverwaltung;

    ProxyKundenverwaltung() {
    }

    // Proxy CRUD für Kunden
    // Proxy ausgabe aller Kunden
    @Override
    public void listAllKunden() {
        if (realKundenverwaltung == null) {
            realKundenverwaltung = new RealKundenverwaltung();
        }
        realKundenverwaltung.listAllKunden();
    }

    // Proxy create Kunde
    @Override
    public void createKunde() {
        if (realKundenverwaltung == null) {
            realKundenverwaltung = new RealKundenverwaltung();
        }
        realKundenverwaltung.createKunde();
    }

    // Proxy read Kunde
    @Override
    public void getKunde() {
        if (realKundenverwaltung == null) {
            realKundenverwaltung = new RealKundenverwaltung();
        }
        realKundenverwaltung.getKunde();
    }

    // Proxy update Kunde
    @Override
    public void updateKunde() {
        if (realKundenverwaltung == null) {
            realKundenverwaltung = new RealKundenverwaltung();
        }
        realKundenverwaltung.updateKunde();
    }

    // Proxy delete Kunde
    @Override
    public void deleteKunde() {
        if (realKundenverwaltung == null) {
            realKundenverwaltung = new RealKundenverwaltung();
        }
        realKundenverwaltung.deleteKunde();
    }
}
