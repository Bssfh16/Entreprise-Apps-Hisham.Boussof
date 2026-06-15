package com.anderlecht.ngo.Entreprise_Apps_Hisham_Boussof.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Titel is verplicht!")
    private String titel;

    @NotBlank(message = "Omschrijving is verplicht!")
    @Column(length = 1000)
    private String omschrijving;

    @NotNull(message = "Tijdstip is verplicht!")
    @org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private LocalDateTime tijdstip;

    private String organisatie;

    @NotBlank(message = "Email is verplicht")
    @Email(message = "Geef een geldig e-mailadres op!")
    private String mailContactpersoon;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locatie_id")
    private Locatie locatie;

    public Evenement() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitel() { return titel; }
    public void setTitel(String titel) { this.titel = titel; }
    public String getOmschrijving() { return omschrijving; }
    public void setOmschrijving(String omschrijving) { this.omschrijving = omschrijving; }
    public LocalDateTime getTijdstip() { return tijdstip; }
    public void setTijdstip(LocalDateTime tijdstip) { this.tijdstip = tijdstip; }
    public String getOrganisatie() { return organisatie; }
    public void setOrganisatie(String organisatie) { this.organisatie = organisatie; }
    public String getMailContactpersoon() { return mailContactpersoon; }
    public void setMailContactpersoon(String mailContactpersoon) { this.mailContactpersoon = mailContactpersoon; }
    public Locatie getLocatie() { return locatie; }
    public void setLocatie(Locatie locatie) { this.locatie = locatie; }
}