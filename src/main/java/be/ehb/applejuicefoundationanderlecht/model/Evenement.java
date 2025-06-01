package be.ehb.applejuicefoundationanderlecht.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titel;

    @NotBlank
    private String omschrijving;

    private LocalDateTime tijdstip;

    @NotBlank
    private String organisatie;

    @Email
    private String emailContactpersoon;

    @ManyToOne
    private Locatie locatie;

    public Evenement() {
    }
// Getters en setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public LocalDateTime getTijdstip() {
        return tijdstip;
    }

    public void setTijdstip(LocalDateTime tijdstip) {
        this.tijdstip = tijdstip;
    }

    public String getOrganisatie() {
        return organisatie;
    }

    public void setOrganisatie(String organisatie) {
        this.organisatie = organisatie;
    }

    public String getEmailContactpersoon() {
        return emailContactpersoon;
    }

    public void setEmailContactpersoon(String emailContactpersoon) {
        this.emailContactpersoon = emailContactpersoon;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }
}
