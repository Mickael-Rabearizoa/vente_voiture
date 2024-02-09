package voiture.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import voiture.model.*;
import voiture.repository.*;
import voiture.service.ExceptionService;
import voiture.service.V_AnnonceUtilisateurService;
import voiture.tools.Role;

import java.util.List;
import java.util.Optional;

@Controller
public class BackOfficeController {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    V_MarqueplusvenduRepository v_marqueplusvenduRepository;

    @Autowired
    V_NbVenteCommissionNbAnnnonceRepository v_nbVenteCommissionNbAnnnonceRepository;

    @Autowired
    BestVendeurRepository bestVendeurRepository;

    @Autowired
    V_AnnonceUtilisateurService v_annonceUtilisateurService;

    @Autowired
    AnnonceutilisateurRepository annonceutilisateurRepository;

    @Autowired
    ExceptionService exceptionService;

    @Autowired
    PhotoRepository photoRepository;

    @PostMapping("/login")
    public ModelAndView pageStatistique(Model model , HttpServletRequest request , HttpSession session){
        try{
            Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByLogin(request.getParameter("login"));
            if(utilisateurOptional.isPresent()){
                Utilisateur utilisateur = utilisateurOptional.get();
                if(utilisateur.getRole() == Role.ROLE_USER){
                    model.addAttribute("pageName" , "Login");
                    model.addAttribute("loginError", "Accès refusé");
                    ModelAndView modelAndView = new ModelAndView("login");
                    return modelAndView;
                }
                if (passwordEncoder.matches(request.getParameter("password"), utilisateur.getPassword())) {
                    model.addAttribute("pageName" , "Statistique");
                    session.setAttribute("user" , utilisateur);
                    model.addAttribute("commissionAnnuel" , v_marqueplusvenduRepository.getCommissionannuel());
                    model.addAttribute("venteAnnuel" , v_marqueplusvenduRepository.getVenteannuel());
                    model.addAttribute("nbrUtilistaeur" , utilisateurRepository.getNbUtilisateur());
                    model.addAttribute("statAnnonceAchat" , v_nbVenteCommissionNbAnnnonceRepository.findAll());
                    model.addAttribute("meilleurVendeur",bestVendeurRepository.findAll());
                    model.addAttribute("meilleurMarque",v_marqueplusvenduRepository.getMarqueplusvendu());
                    ModelAndView modelAndView = new ModelAndView("statistique");
                    return modelAndView;
                } else {
                    model.addAttribute("pageName" , "Login");
                    model.addAttribute("passwordError", "Mot de passe incorrect!");
                    ModelAndView modelAndView = new ModelAndView("login");
                    return modelAndView;
                }
            } else {
                model.addAttribute("pageName" , "Login");
                model.addAttribute("loginError", "Login inexistant!");
                ModelAndView modelAndView = new ModelAndView("login");
                return modelAndView;
            }
        } catch (Exception e){
            if(exceptionService.isInternalServerError(e)){
                model.addAttribute("pageName" , "Internal server error");
                ModelAndView modelAndView = new ModelAndView("internal_server_error");
                return modelAndView;
            }
        }
        return null;
    }

    @GetMapping("valider-annonce")
    public ModelAndView validationAnnonce(Model model , HttpServletRequest request , HttpSession session , @RequestParam int idAnnonce) {
        try {
            if(session.getAttribute("user") != null){
                Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
                annonceutilisateurRepository.updateStatusAnnonce(idAnnonce);
                model.addAttribute("pageName" , "Validation");
                List<V_AnnonceUtilisateur> listAnnonce = v_annonceUtilisateurService.getAnnonceAValide();
                for (V_AnnonceUtilisateur annonce : listAnnonce) {
                    List<Photo> listPhoto = photoRepository.findPhotosById_Annonceutilisateur(annonce.getId_Annonceutilisateur());
                    System.out.println("annonce: "+ annonce.getId_Annonceutilisateur()+ " statut: "+ annonce.getStatus());
                    for (Photo photo :listPhoto) {
                        System.out.println("---------------------------Photooooooo");
                    }
                    annonce.setPhotoList(listPhoto);
                }
                model.addAttribute("listAnnonce" , listAnnonce);
                ModelAndView modelAndView = new ModelAndView("validation_annonce");
                return modelAndView;
            } else {
                model.addAttribute("pageName" , "Forbiden");
                ModelAndView modelAndView = new ModelAndView("error_forbiden");
                return modelAndView;
            }
        } catch (Exception e){
            if(exceptionService.isInternalServerError(e)){
                model.addAttribute("pageName" , "Internal server error");
                ModelAndView modelAndView = new ModelAndView("internal_server_error");
                return modelAndView;
            }
        }
        return null;
    }

}
