package voiture.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import voiture.model.*;
import voiture.repository.*;
import voiture.service.ExceptionService;
import voiture.service.V_AnnonceUtilisateurService;

import java.util.List;

@Controller
public class ElementsBackOfficeController {

    @Autowired
    TypevoitureRepository typevoitureRepository;

    @Autowired
    MarqueRepository marqueRepository;

    @Autowired
    ModeleRepository modeleRepository;

    @Autowired
    TransmissionRepository transmissionRepository;

    @Autowired
    CarburantRepository carburantRepository;

    @Autowired
    V_AnnonceUtilisateurService v_annonceUtilisateurService;

    @Autowired
    V_MarqueplusvenduRepository v_marqueplusvenduRepository;

    @Autowired
    CommissionRepository commissionRepository;

    @Autowired
    ExceptionService exceptionService;

    @Autowired
    CouleurRepository couleurRepository;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    PhotoRepository photoRepository;


    @GetMapping("/ajout-model")
    public ModelAndView pageAjoutModel(Model model , HttpSession session){
        try{
            if(session.getAttribute("user") != null){
                Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
                model.addAttribute("pageName" , "Ajout");
                model.addAttribute("listType" , typevoitureRepository.findAll());
                model.addAttribute("listMarque" , marqueRepository.findAll());
                ModelAndView modelAndView = new ModelAndView("ajout_model");
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

    @PostMapping("ajout-marque")
    public ModelAndView ajoutMarque(Model model , HttpSession session , HttpServletRequest request){
        try{
            if(session.getAttribute("user") != null){
                Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
                Marque marque = new Marque();
                marque.setNom(request.getParameter("marque"));
                marqueRepository.save(marque);

                model.addAttribute("pageName" , "Ajout");
                model.addAttribute("listType" , typevoitureRepository.findAll());
                model.addAttribute("listMarque" , marqueRepository.findAll());

                ModelAndView modelAndView = new ModelAndView("ajout_model");
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

    @PostMapping("ajout-type")
    public ModelAndView ajoutType(Model model , HttpSession session , HttpServletRequest request){
        try {
            if(session.getAttribute("user") != null){
                Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
                Typevoiture typeVoiture = new Typevoiture();
                typeVoiture.setTypevoiture(request.getParameter("type"));
                typevoitureRepository.save(typeVoiture);

                model.addAttribute("pageName" , "Ajout");
                model.addAttribute("listType" , typevoitureRepository.findAll());
                model.addAttribute("listMarque" , marqueRepository.findAll());

                ModelAndView modelAndView = new ModelAndView("ajout_model");
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

    @PostMapping("ajout-model")
    public ModelAndView ajoutModel(Model model , HttpSession session , HttpServletRequest request){
        try{
            if(session.getAttribute("user") != null){
                Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
                Modele modele = new Modele();
                modele.setModele(request.getParameter("model"));
                try{
                    modele.setId_marque(Integer.parseInt(request.getParameter("marque")));
                    modele.setId_Typevoiture(Integer.parseInt(request.getParameter("type")));
                    modeleRepository.save(modele);
                }catch (Exception e){
                    model.addAttribute("error", e.getMessage());
                }
                model.addAttribute("pageName" , "Ajout");
                model.addAttribute("listType" , typevoitureRepository.findAll());
                model.addAttribute("listMarque" , marqueRepository.findAll());

                ModelAndView modelAndView = new ModelAndView("ajout_model");
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

    @GetMapping("/ajout-element")
    public ModelAndView pageAjoutAutreElement(Model model , HttpSession session){
        try{
            if(session.getAttribute("user") != null){
                Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
                model.addAttribute("pageName" , "Ajout");
                ModelAndView modelAndView = new ModelAndView("ajout_autre_element");
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

    @PostMapping("/ajout-transmission")
    public ModelAndView ajoutTransmission(Model model , HttpSession session , HttpServletRequest request){
        try{
            if(session.getAttribute("user") != null){
                Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
                Transmission transmission = new Transmission();
                transmission.setTransmission_(request.getParameter("transmission"));
                transmissionRepository.save(transmission);

                model.addAttribute("pageName" , "Ajout");

                ModelAndView modelAndView = new ModelAndView("ajout_autre_element");
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

    @PostMapping("/ajout-carburant")
    public ModelAndView ajoutCarburant(Model model , HttpSession session , HttpServletRequest request){
        try{
            if(session.getAttribute("user") != null){
                Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
                Carburant carburant = new Carburant();
                carburant.setCarburant(request.getParameter("carburant"));
                carburantRepository.save(carburant);

                model.addAttribute("pageName" , "Ajout");

                ModelAndView modelAndView = new ModelAndView("ajout_autre_element");
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

    @PostMapping("/ajout-region")
    public ModelAndView ajoutRegion(Model model , HttpSession session , HttpServletRequest request){
        try{
            if(session.getAttribute("user") != null){
                Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
                Region region = new Region();
                region.setRegion(request.getParameter("region"));
                regionRepository.save(region);

                model.addAttribute("pageName" , "Ajout");

                ModelAndView modelAndView = new ModelAndView("ajout_autre_element");
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

    @PostMapping("/ajout-couleur")
    public ModelAndView ajoutCouleur(Model model , HttpSession session , HttpServletRequest request){
        try{
            if(session.getAttribute("user") != null){
                Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
                Couleur couleur = new Couleur();
                couleur.setNom(request.getParameter("couleur"));
                couleurRepository.save(couleur);

                model.addAttribute("pageName" , "Ajout");

                ModelAndView modelAndView = new ModelAndView("ajout_autre_element");
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

    @GetMapping("/list-model")
    public ModelAndView pageListModel(Model model , HttpSession session){
        try{
            if(session.getAttribute("user") != null){
                Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
                model.addAttribute("pageName" , "List");
                model.addAttribute("listType" , typevoitureRepository.findAll());
                model.addAttribute("listMarque" , marqueRepository.findAll());
                model.addAttribute("listModel", modeleRepository.findAll());

                ModelAndView modelAndView = new ModelAndView("list_model");
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

    @ResponseBody
    @GetMapping("/getMarques")
    public List<Marque> getMarques() {
        List<Marque> marques = marqueRepository.findAll();
        return marques;
    }

    @ResponseBody
    @GetMapping("/getTypes")
    public List<Typevoiture> getTypes() {
        List<Typevoiture> typevoitures = typevoitureRepository.findAll();
        return typevoitures;
    }

    @GetMapping("/list-element")
    public ModelAndView pageListElement(Model model , HttpSession session){
        try {
            if(session.getAttribute("user") != null){
                Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
                model.addAttribute("pageName" , "List");
                model.addAttribute("listTransmission" , transmissionRepository.findAll());
                model.addAttribute("listCarburant" , carburantRepository.findAll());
                model.addAttribute("listCouleur" , couleurRepository.findAll());
                model.addAttribute("listRegion" , regionRepository.findAll());

                ModelAndView modelAndView = new ModelAndView("list_autre_element");
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

    @GetMapping("/validation-annonce")
    public ModelAndView pageValidationAnnonce(Model model , HttpSession session){
        try{
            if(session.getAttribute("user") != null){
                Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
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

    @GetMapping(path="/delete/marque")
    public RedirectView deleteMarquebyid(@RequestParam("id") int id){
        Marque marque = new Marque();
        marque.setId_Marque(id);
        marqueRepository.delete(marque);
        return new RedirectView("/list-model");
    }

    @GetMapping(path="/delete/type")
    public RedirectView deleteTypebyid(@RequestParam("id") int id){
        Typevoiture typevoiture = new Typevoiture();
        typevoiture.setId_Typevoiture(id);
        typevoitureRepository.delete(typevoiture);
        return new RedirectView("/list-model");
    }

    @GetMapping(path="/delete/modele")
    public RedirectView deleteModelebyid(@RequestParam("id") int id){
        Modele modele = new Modele();
        modele.setId_Modele(id);
        modeleRepository.delete(modele);
        return new RedirectView("/list-model");
    }
    @GetMapping(path="/delete/transmission")
    public RedirectView deleteTransmissionbyid(@RequestParam("id") int id){
        Transmission transmission = new Transmission();
        transmission.setId_Transmission(id);
        transmissionRepository.delete(transmission);
        return new RedirectView("/list-element");
    }
    @GetMapping(path="/delete/carburant")
    public RedirectView deleteCarburantbyid(@RequestParam("id") int id){
        Carburant carburant = new Carburant();
        carburant.setId_Carburant(id);
        carburantRepository.delete(carburant);
        return new RedirectView("/list-element");
    }

    @GetMapping(path="/delete/couleur")
    public RedirectView deleteCouleurbyid(@RequestParam("id") int id){
        Couleur couleur = new Couleur();
        couleur.setId_Couleur(id);
        couleurRepository.delete(couleur);
        return new RedirectView("/list-element");
    }

    @GetMapping(path="/delete/region")
    public RedirectView deleteRegionbyid(@RequestParam("id") int id){
        Region region = new Region();
        region.setId_Region(id);
        regionRepository.delete(region);
        return new RedirectView("/list-element");
    }

    @PostMapping("/modifier/marque")
    public RedirectView updateMarquebyid(HttpServletRequest request){
        Marque marque = new Marque();
        marque.setId_Marque(Integer.parseInt(request.getParameter("id")));
        marque.setNom(request.getParameter("nom"));
        marqueRepository.save(marque);
        return new RedirectView("/list-model");
    }

    @PostMapping("/modifier/type")
    public RedirectView updateTypebyid(HttpServletRequest request){
        Typevoiture typevoiture = new Typevoiture();
        typevoiture.setId_Typevoiture(Integer.parseInt(request.getParameter("id")));
        typevoiture.setTypevoiture(request.getParameter("nom"));
        typevoitureRepository.save(typevoiture);
        return new RedirectView("/list-model");
    }

    @PostMapping("/modifier/transmission")
    public RedirectView updateTransmissionbyid(HttpServletRequest request){
        Transmission transmission = new Transmission();
        transmission.setId_Transmission(Integer.parseInt(request.getParameter("id")));
        transmission.setTransmission_(request.getParameter("nom"));
        transmissionRepository.save(transmission);
        return new RedirectView("/list-element");
    }

    @PostMapping("/modifier/carburant")
    public RedirectView updateCarburantbyid(HttpServletRequest request){
        Carburant carburant = new Carburant();
        carburant.setId_Carburant(Integer.parseInt(request.getParameter("id")));
        carburant.setCarburant(request.getParameter("nom"));
        carburantRepository.save(carburant);
        return new RedirectView("/list-element");
    }

    @PostMapping("/modifier/couleur")
    public RedirectView updateCouleurbyid(HttpServletRequest request){
        Couleur couleur = new Couleur();
        couleur.setNom(request.getParameter("nom"));
        couleur.setId_Couleur(Integer.parseInt(request.getParameter("id")));
        couleurRepository.save(couleur);
        return new RedirectView("/list-element");
    }

    @PostMapping("/modifier/region")
    public RedirectView updateRegionbyid(HttpServletRequest request){
        Region region = new Region();
        region.setRegion(request.getParameter("nom"));
        region.setId_Region(Integer.parseInt(request.getParameter("id")));
        regionRepository.save(region);
        return new RedirectView("/list-element");
    }

    @PostMapping("/modifier-model")
    public ModelAndView updateModelbyid(HttpServletRequest request , Model model , HttpSession session){
        try{
            Modele modele = new Modele();
            modele.setId_marque(Integer.parseInt(request.getParameter("idMarque")));
            modele.setId_Typevoiture(Integer.parseInt(request.getParameter("idType")));
            modele.setModele(request.getParameter("model"));
            modele.setId_Modele(Integer.parseInt(request.getParameter("id")));
            modeleRepository.save(modele);
        } catch (Exception e){
            System.out.println("--------------------------------------"+ e.getMessage());
            model.addAttribute("erreur" , e.getMessage());
        }
        if(session.getAttribute("user") != null){
            Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
            model.addAttribute("pageName" , "List");
            model.addAttribute("listType" , typevoitureRepository.findAll());
            model.addAttribute("listMarque" , marqueRepository.findAll());
            model.addAttribute("listModel", modeleRepository.findAll());

            ModelAndView modelAndView = new ModelAndView("list_model");
            return modelAndView;
        } else {
            model.addAttribute("pageName" , "Forbiden");
            ModelAndView modelAndView = new ModelAndView("error_forbiden");
            return modelAndView;
        }
    }

    @PostMapping("/modifier/commission")
    public RedirectView updateCommissionbyid(HttpServletRequest request){
        Commission commission = new Commission();
        commission.setDateActuel();
        commission.setPourcentage_(Double.parseDouble(request.getParameter("commission")));
        commissionRepository.save(commission);
        return new RedirectView("/validation-annonce");
    }
}
