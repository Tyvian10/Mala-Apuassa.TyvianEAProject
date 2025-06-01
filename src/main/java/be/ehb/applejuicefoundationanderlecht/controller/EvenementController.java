package be.ehb.applejuicefoundationanderlecht.controller;

import be.ehb.applejuicefoundationanderlecht.model.Evenement;
import be.ehb.applejuicefoundationanderlecht.model.Locatie;
import be.ehb.applejuicefoundationanderlecht.repository.EvenementRepository;
import be.ehb.applejuicefoundationanderlecht.repository.LocatieRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EvenementController {

    private final EvenementRepository evenementRepository;
    private final LocatieRepository locatieRepository;

    public EvenementController(EvenementRepository evenementRepository,
                               LocatieRepository locatieRepository) {
        this.evenementRepository = evenementRepository;
        this.locatieRepository = locatieRepository;
    }

    // INDEX: toon 10 laatste evenementen
    @GetMapping("/")
    public String index(Model model) {
        List<Evenement> laatste10 = evenementRepository.findTop10ByOrderByTijdstipDesc();
        model.addAttribute("evenementen", laatste10);
        return "index";
    }




    // FORMULIER TONEN: nieuw evenement
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("evenement", new Evenement());
        model.addAttribute("locaties", locatieRepository.findAll());
        return "new";
    }

    // FORMULIER VERWERKEN
    @PostMapping("/new")
    public String submitForm(@ModelAttribute("evenement") @Valid Evenement evenement,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("locaties", locatieRepository.findAll());
            return "new";
        }
        evenementRepository.save(evenement);
        return "redirect:/";
    }

    // DETAILPAGINA PER EVENEMENT
    @GetMapping("/details/{id}")
    public String detailPagina(@PathVariable("id") Long id, Model model) {
        Evenement evenement = evenementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Evenement niet gevonden met id: " + id));
        model.addAttribute("evenement", evenement);
        return "details";
    }//wanneer iemand surft naar /details/willekeurig nummer. dan wordt het nummer gezien als het id van een detail. Het id word opgezocht en detzilpagina van het corresponderende id word geretourneerd

    // wanneer de gebruiker surft naar /about dan wordt de methode aboutpagina uitgevoerd en wordt about geretourneerd
    @GetMapping("/about")
    public String aboutPagina() {
        return "about";
    }





}
