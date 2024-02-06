package voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import voiture.model.Annonceutilisateur;
import voiture.model.V_AnnonceUtilisateur;
import voiture.service.V_AnnonceUtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/V_AnnonceUtilisateur")
public class V_AnnonceUtilisateurController {
   public final V_AnnonceUtilisateurService v_annonceUtilisateurService;

   @Autowired
    public V_AnnonceUtilisateurController(V_AnnonceUtilisateurService v_annonceUtilisateurService) {
        this.v_annonceUtilisateurService = v_annonceUtilisateurService;
    }

    @GetMapping("/getAnnonceNonValide")
    @PreAuthorize("hasRole('USER')")
    public List<V_AnnonceUtilisateur> getAnnonceNonValide(@RequestParam Integer Idutilisateur){
        return v_annonceUtilisateurService.getAnnonceNonValide(Idutilisateur);
    }
    @GetMapping("/getAnnonceValide")
    @PreAuthorize("hasRole('USER')")
    public List<V_AnnonceUtilisateur> getAnnonceValide(@RequestParam Integer Idutilisateur){
        return v_annonceUtilisateurService.getAnnonceValide(Idutilisateur);
    }
    @GetMapping("/getAnnonceValideVendu")
    @PreAuthorize("hasRole('USER')")
    public List<V_AnnonceUtilisateur> getAnnonceValideVendu(@RequestParam Integer Idutilisateur){
        return v_annonceUtilisateurService.getAnnonceValideVendu(Idutilisateur);
    }

    @GetMapping("/getAnnonceAValide")
    @PreAuthorize("hasRole('ADMIN')")
    public List<V_AnnonceUtilisateur> getAnnonceAvalide(){
        return v_annonceUtilisateurService.getAnnonceAValide();
    }

    @GetMapping("/getAnnonceDetail")
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public List<V_AnnonceUtilisateur> getAnnonceDetail(Integer Id_Annonceutilisateur) {
       return v_annonceUtilisateurService.getAnnonceDetail(Id_Annonceutilisateur);
    }

    @GetMapping("/rechercheAvance")
    @PreAuthorize("hasRole('USER')")
    public List<V_AnnonceUtilisateur> rechercheAvance(@RequestParam  Integer id_modele,@RequestParam Integer id_couleur, @RequestParam Integer annee, @RequestParam Integer id_typevoiture,@RequestParam Integer id_marque,@RequestParam Double prix1,@RequestParam Double prix2) {
        return v_annonceUtilisateurService.rechercheAvance(id_modele, id_couleur, annee, id_typevoiture, id_marque, prix1, prix2);
    }

    @GetMapping("/getListAnnonceValide")
    @PreAuthorize("hasRole('USER')")
    public List<V_AnnonceUtilisateur> getListAnnonceValide(){
        return v_annonceUtilisateurService.getListAnnonceValide();
    }

    @GetMapping("/getNbAnnonceValide")
    @PreAuthorize("hasRole('ADMIN')")
    public V_AnnonceUtilisateur getNbAnnonceValide(){
        return v_annonceUtilisateurService.getNbAnnonceValide();
    }


    @GetMapping("/getListAnnonceUtilisateur")
    @PreAuthorize("hasRole('USER')")
    public List<V_AnnonceUtilisateur> getAnnonceUtilisateur(@RequestParam int Idutilisateur){
        return v_annonceUtilisateurService.getAnnonceUtilisateur(Idutilisateur);
    }
}
