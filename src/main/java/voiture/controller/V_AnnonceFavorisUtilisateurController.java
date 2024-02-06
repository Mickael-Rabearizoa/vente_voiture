package voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import voiture.model.V_AnnonceFavorisUtilisateur;
import voiture.service.V_AnnonceFavorisUtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/V_AnnonceFavorisUtilisateur")
public class V_AnnonceFavorisUtilisateurController {

    public final V_AnnonceFavorisUtilisateurService v_annonceFavorisUtilisateurService;

    @Autowired
    public V_AnnonceFavorisUtilisateurController(V_AnnonceFavorisUtilisateurService v_annonceFavorisUtilisateurService) {
        this.v_annonceFavorisUtilisateurService = v_annonceFavorisUtilisateurService;
    }

    @GetMapping("/getAnnonceFavorisUtilisateur")
    @PreAuthorize("hasRole('USER')")
    public List<V_AnnonceFavorisUtilisateur> getAnnonceFavorisUtilisateur(@RequestParam Integer Idutilisateur) {
        return v_annonceFavorisUtilisateurService.getAnnonceFavorisUtilisateur(Idutilisateur);
    }
}
