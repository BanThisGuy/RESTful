package de.fhr.inf.vv;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VertraegeService {

    @Autowired
    private VertraegeRepository repoV;

    @GetMapping(value = "/vertraege/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vertraege> findById(@PathVariable String id) {
        Vertraege v = repoV.findOne(Long.parseLong(id));
        return new ResponseEntity<Vertraege>(v, HttpStatus.OK);
    }

    @GetMapping(value = "/vertraege",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Vertraege>> findAll() {
        List<Vertraege> liste = new ArrayList<>();
        Iterable<Vertraege> iterator = repoV.findAll();
        iterator.forEach(liste::add);
        return new ResponseEntity<List<Vertraege>>(liste, HttpStatus.OK);
    }

    @PutMapping(value = "/vertraege/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vertraege> aendereVertrag(
            @PathVariable String id, @RequestBody Vertraege vNeu) {
        Vertraege vAlt = repoV.findOne(Long.parseLong(id));
        vAlt.setJahresbeitrag(vNeu.getJahresbeitrag());
        vAlt.setVertragsart(vNeu.getVertragsart());
        repoV.save(vAlt);
        return new ResponseEntity<Vertraege>(vAlt, HttpStatus.OK);
    }

    @DeleteMapping(value = "/vertraege/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vertraege> loescheVertrag(@PathVariable String id) {
        Vertraege vAlt = repoV.findOne(Long.parseLong(id));
        if (vAlt != null) repoV.delete(vAlt);
        return new ResponseEntity<Vertraege>(vAlt, HttpStatus.OK);
    }

    @PostMapping(value = "/vertraege",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> neuerVertrag(@RequestBody Vertraege v,
                                             UriComponentsBuilder ucBuilder) {
        repoV.save(v);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/vertraege/{id}").buildAndExpand(v.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}


