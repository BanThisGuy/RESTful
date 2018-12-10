package de.fhr.inf.vv;

import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

public class RealKundenverwaltung implements Kundenverwaltung {
    public static final String REST_SERVICE_URI = "http://localhost:8080";

    public RealKundenverwaltung() {
    }

    // CRUD für Kunden
    // Ausgabe aller Kunden
    @Override
    public void listAllKunden() {
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>>
                kundenMap = restTemplate.getForObject(REST_SERVICE_URI + "/kunden/", List.class);


        if (kundenMap != null) {
            for (LinkedHashMap<String, Object> map : kundenMap) {
                System.out.println("Kunde : id=" + map.get("id")
                        + ", Vorname=" + map.get("vorname")
                        + ", Nachname=" + map.get("nachname")
                        + ", Geburtstag=" + map.get("geburtstag"));
            }
        } else {
            System.out.println("Keine Kunden");
        }
    }

    // Create Kunde
    @Override
    public void createKunde() {
        RestTemplate restTemplate = new RestTemplate();
        Kunde klaus = new Kunde("Klaus", "Kaiser", "1980-12-10", new Adresse("Kaiserstr.", "82452", "Kaiserort"));
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/kunden/"
                , klaus, Kunde.class);
        System.out.println("Location : " + uri.toASCIIString());
    }

    // Get Kunde
    @Override
    public void getKunde() {
        RestTemplate restTemplate = new RestTemplate();
        Kunde kunde = restTemplate.getForObject(REST_SERVICE_URI + "/kunden/1", Kunde.class);
        System.out.println(kunde);
    }

    // Update Kunde
    @Override
    public void updateKunde() {
        RestTemplate restTemplate = new RestTemplate();
        Kunde tommy = new Kunde("Tommy", "Pinnball", "1960-01-01", new Adresse("Pinnbalstr.", "82455", "Pinnort"));
        restTemplate.put(REST_SERVICE_URI + "/kunden/1", tommy);
        System.out.println(tommy);
    }

    // Delete Kunde
    @Override
    public void deleteKunde() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/kunden/3");
    }
}
