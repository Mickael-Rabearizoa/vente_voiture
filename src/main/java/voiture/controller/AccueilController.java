package voiture.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import voiture.repository.BestVendeurRepository;
import voiture.repository.UtilisateurRepository;
import voiture.repository.V_MarqueplusvenduRepository;
import voiture.repository.V_NbVenteCommissionNbAnnnonceRepository;

@Controller
public class AccueilController {

    @Autowired
    V_MarqueplusvenduRepository v_marqueplusvenduRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    V_NbVenteCommissionNbAnnnonceRepository v_nbVenteCommissionNbAnnnonceRepository;

    @Autowired
    BestVendeurRepository bestVendeurRepository;

    @GetMapping("/")
    public ModelAndView pageLogin(Model model){
        model.addAttribute("pageName" , "Login");
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/statistique")
    public ModelAndView pageStatistique(Model model){
        model.addAttribute("pageName" , "Statistique");
        model.addAttribute("commissionAnnuel" , v_marqueplusvenduRepository.getCommissionannuel());
        model.addAttribute("venteAnnuel" , v_marqueplusvenduRepository.getVenteannuel());
        model.addAttribute("nbrUtilistaeur" , utilisateurRepository.getNbUtilisateur());
        model.addAttribute("statAnnonceAchat" , v_nbVenteCommissionNbAnnnonceRepository.findAll());
        model.addAttribute("meilleurVendeur",bestVendeurRepository.findAll());
        model.addAttribute("meilleurMarque",v_marqueplusvenduRepository.getMarqueplusvendu());
        ModelAndView modelAndView = new ModelAndView("statistique");
        return modelAndView;
    }

    @GetMapping("/deconnexion")
    public ModelAndView pageLogout(Model model , HttpSession session){
        session.invalidate();
        model.addAttribute("pageName" , "Login");
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
}