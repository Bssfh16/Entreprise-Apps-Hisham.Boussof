package com.anderlecht.ngo.Entreprise_Apps_Hisham_Boussof.controllers;

import com.anderlecht.ngo.Entreprise_Apps_Hisham_Boussof.models.Evenement;
import com.anderlecht.ngo.Entreprise_Apps_Hisham_Boussof.repositories.EvenementRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private EvenementRepository evenementRepository;

    @Autowired
    private JavaMailSender mailSender;
    
    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("evenementen", evenementRepository.findTop10ByOrderByTijdstipDesc());
        return "index";
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable Long id, Model model) {
        Evenement event = evenementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Onbekend event"));
        model.addAttribute("evenement", event);
        return "details";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("evenement", new Evenement());
        return "new";
    }

    @PostMapping("/new")
    public String saveEvenement(@Valid @ModelAttribute("evenement") Evenement evenement, BindingResult result) {
        if (result.hasErrors()) {
            return "new";
        }
        evenementRepository.save(evenement);
        return "redirect:/";
    }

    @GetMapping("/about")
    public String showAbout() {
        return "about";
    }

    @GetMapping("/contact")
    public String showContactForm() {
        return "contact";
    }

    @PostMapping("/contact")
    public String sendContactEmail(@RequestParam String naam, @RequestParam String email, @RequestParam String bericht, Model model) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("admin@anderlecht1070ngo.be");
        message.setSubject("Contact: " + naam);
        message.setText("Van: " + email + "\n\n" + bericht);
        
        mailSender.send(message);
        
        model.addAttribute("success", true);
        return "contact";
    }
}
