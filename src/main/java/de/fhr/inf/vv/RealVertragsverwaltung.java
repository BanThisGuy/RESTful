package de.fhr.inf.vv;

import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

public class RealVertragsverwaltung implements Vertragsverwaltung {
    public static final String REST_SERVICE_URI = "http://localhost:8080";

    RealVertragsverwaltung() {
    }

    // CRUD für Verträge
    // Ausgabe aller Verträge
    @Override
    public void listAllVertraege() {
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>>
                vertraegeMap = restTemplate.getForObject(REST_SERVICE_URI + "/vertraege/", List.class);


        if (vertraegeMap != null) {
            for (LinkedHashMap<String, Object> map : vertraegeMap) {
                System.out.println("Vertrag : id=" + map.get("id")
                        + ", Vertragsart=" + map.get("vertragsart")
                        + ", Jahresbeitrag=" + map.get("jahresbeitrag")
                );
            }
        } else {
            System.out.println("Keine Vertraege");
        }
    }

    // Create Vertrag
    @Override
    public void createVertrag() {
        RestTemplate restTemplate = new RestTemplate();
        Vertraege riesterrente = new Vertraege("RiesterRente", "600");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/vertraege/"
                , riesterrente, Vertraege.class);
        System.out.println("Location : " + uri.toASCIIString());
    }

    // Read Vertrag
    @Override
    public void getVertrag() {
        RestTemplate restTemplate = new RestTemplate();
        Vertraege vertrag = restTemplate.getForObject(REST_SERVICE_URI + "/vertraege/1", Vertraege.class);
        System.out.println(vertrag);
    }

    // Update Vertrag
    @Override
    public void updateVertrag() {
        RestTemplate restTemplate = new RestTemplate();
        Vertraege handyvertrag = new Vertraege("handyvertrag", "120");
        restTemplate.put(REST_SERVICE_URI + "/vertraege/1", handyvertrag);
        System.out.println(handyvertrag);
    }

    // Delete Vertrag
    @Override
    public void deleteVertrag() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/vertraege/3");
    }
}
