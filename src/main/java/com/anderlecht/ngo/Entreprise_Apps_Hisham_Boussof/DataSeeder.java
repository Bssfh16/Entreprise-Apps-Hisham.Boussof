package com.anderlecht.ngo.Entreprise_Apps_Hisham_Boussof;

import com.anderlecht.ngo.Entreprise_Apps_Hisham_Boussof.models.Evenement;
import com.anderlecht.ngo.Entreprise_Apps_Hisham_Boussof.models.Locatie;
import com.anderlecht.ngo.Entreprise_Apps_Hisham_Boussof.repositories.EvenementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner loadData(EvenementRepository evenementRepository) {
        return args -> {
            if (evenementRepository.count() == 0) {
                
                String[] titels = {
                    "Voedselbedeling De Schakel", 
                    "Huiswerkbegeleiding Kuregem", 
                    "Taalcafé Anderlecht",
                    "Fietsherstelpunt De Velo", 
                    "Juridisch Adviesloket", 
                    "Buurttuin De Kiem",
                    "Warme Winter Inzamelactie", 
                    "Digipunt Senioren", 
                    "Vrouwennetwerk Abattoir", 
                    "Sport Voor Iedereen"
                };
                
                String[] omschrijvingen = {
                    "Wekelijkse verdeling van verse voedselpakketten voor kwetsbare gezinnen.",
                    "Naschoolse ondersteuning en een rustige studeerplek voor jongeren uit de wijk.",
                    "Een gezellige ontmoetingsplaats waar nieuwkomers spelenderwijs Nederlands oefenen.",
                    "Sociale werkplaats waar buurtbewoners samen met vrijwilligers hun fiets repareren.",
                    "Gratis en laagdrempelig eerstelijnsadvies voor huur- en verblijfskwesties.",
                    "Een gedeelde moestuin waar bewoners samen groenten kweken en kookworkshops volgen.",
                    "Inzameling en distributie van winterjassen en dekens voor daklozen in het Brussels Gewest.",
                    "Vrijwilligers helpen ouderen met smartphones, online bankieren en overheidswebsites.",
                    "Een veilige plek voor emancipatie, loopbaanbegeleiding en netwerking voor vrouwen.",
                    "Gratis wekelijkse zaalvoetbal- en basketbalsessies om jongeren via sport te verbinden."
                };

                String[] locatieNamen = {
                    "Buurtcentrum De Schakel", 
                    "Jeugdhuis Kuregem", 
                    "Bibliotheek De Rinck", 
                    "Atelier Velo", 
                    "Sociaal Huis Anderlecht", 
                    "Ecologisch Park Neerpede", 
                    "Parochiezaal Sint-Guido", 
                    "Dienstencentrum De Rotonde", 
                    "Ontmoetingsruimte Abattoir", 
                    "Sporthal Simonet"
                };

                String[] adressen = {
                    "Wayezstraat 142, 1070 Anderlecht", 
                    "Grondelstraat 85, 1070 Anderlecht", 
                    "Dapperheidsplein 17, 1070 Anderlecht", 
                    "Bergensesteenweg 210, 1070 Anderlecht", 
                    "Verzetsplein 3, 1070 Anderlecht", 
                    "Neerpedestraat 300, 1070 Anderlecht", 
                    "Sint-Guidostraat 44, 1070 Anderlecht", 
                    "Eloyestraat 101, 1070 Anderlecht", 
                    "Jules Ruhlstraat 5, 1070 Anderlecht", 
                    "Théo Verbeecklaan 2, 1070 Anderlecht"
                };

                for (int i = 0; i < 10; i++) {
                    Locatie loc = new Locatie();
                    loc.setNaam(locatieNamen[i]);
                    loc.setAdres(adressen[i]);
                    loc.setCapaciteit(30 + (i * 10));

                    Evenement ev = new Evenement();
                    ev.setTitel(titels[i]);
                    ev.setOmschrijving(omschrijvingen[i]);
                    ev.setTijdstip(LocalDateTime.now().plusDays(i + 2).withHour(14).withMinute(0).withSecond(0).withNano(0));
                    ev.setOrganisatie("Anderlecht 1070 NGO");
                    ev.setMailContactpersoon("info@anderlecht1070ngo.be");
                    ev.setLocatie(loc);
                    
                    evenementRepository.save(ev);
                }

                System.out.println("De 10 Evenementen werden succesvol ingeladen!");
            }
        };
    }
}