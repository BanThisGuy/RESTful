package de.fhr.inf.vv;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableWebSecurity
public class Boot5Application {

    @Bean
    InitializingBean seedDatabase(KundeRepository repoK, VertraegeRepository repoV) {

        return () -> {
            repoK.save(new Kunde("Harry", "Hirsch", "2001-10-12", new Adresse("Hirschstr.", "83022", "Hirschort")));
            repoK.save(new Kunde("Willi", "Winzig", "1954-12-08", new Adresse("Winzigstr.", "83255", "Winzigort")));
            repoK.save(new Kunde("Bernd", "Winzig", "2001-03-18", new Adresse("Winzigerstr.", "83256", "Winzigerort")));
            repoV.save(new Vertraege("Haftpflicht", "300"));
            repoV.save(new Vertraege("Rechtsschutz", "150"));
            repoV.save(new Vertraege("KFZ", "750"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Boot5Application.class, args);
    }
}


