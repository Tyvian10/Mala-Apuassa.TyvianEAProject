package be.ehb.applejuicefoundationanderlecht.controller;

import be.ehb.applejuicefoundationanderlecht.model.Locatie;
import be.ehb.applejuicefoundationanderlecht.repository.LocatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LocatieController {

    private final LocatieRepository locatieRepository;

    @Autowired
    public LocatieController(LocatieRepository locatieRepository) {
        this.locatieRepository = locatieRepository;
    }

    @GetMapping("/locatie/new")
    public String toonForm(Model model) {
        model.addAttribute("locatie", new Locatie());
        return "locatie_form"; // verwijst naar locatie_form.html
    }

    @PostMapping("/locatie/new")
    public String verwerkFormulier(@ModelAttribute Locatie locatie) {
        locatieRepository.save(locatie);
        return "redirect:/new"; // terug naar het evenement-formulier bijvoorbeeld
    }
}
