package de.fhr.inf.vv;

public class RestClientSpring {

    public static void main(String args[]) {
        CRUDkunden();
        CRUDvertraege();
    }

    private static void CRUDkunden() {
        Kundenverwaltung kundenverwaltung = new ProxyKundenverwaltung();
        kundenverwaltung.listAllKunden();
        kundenverwaltung.getKunde();
        kundenverwaltung.createKunde();
        kundenverwaltung.listAllKunden();
        kundenverwaltung.updateKunde();
        kundenverwaltung.listAllKunden();
        kundenverwaltung.deleteKunde();
        kundenverwaltung.listAllKunden();
    }

    private static void CRUDvertraege() {
        Vertragsverwaltung vertragsverwaltung = new ProxyVertragsverwaltung();
        vertragsverwaltung.listAllVertraege();
        vertragsverwaltung.getVertrag();
        vertragsverwaltung.createVertrag();
        vertragsverwaltung.listAllVertraege();
        vertragsverwaltung.updateVertrag();
        vertragsverwaltung.listAllVertraege();
        vertragsverwaltung.deleteVertrag();
        vertragsverwaltung.listAllVertraege();
    }
}

