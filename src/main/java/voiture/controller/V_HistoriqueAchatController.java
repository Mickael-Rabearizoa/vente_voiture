package voiture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import voiture.model.V_AnnonceUtilisateur;
import voiture.model.V_HistoriqueAchat;
import voiture.service.V_HistoriqueAchatService;

import java.util.List;

@RestController
@RequestMapping("/getHistoriqueAchat")
public class V_HistoriqueAchatController {

    public final V_HistoriqueAchatService v_historiqueAchatService;

    @Autowired
    public V_HistoriqueAchatController(V_HistoriqueAchatService v_historiqueAchatService) {
        this.v_historiqueAchatService = v_historiqueAchatService;
    }

    @GetMapping("/getChiffreDAffaire")
    @PreAuthorize("hasRole('ADMIN')")
    public V_HistoriqueAchat getChiffreDAffaire(){
        return v_historiqueAchatService.getChiffreDAffaire();
    }

    @GetMapping("/getBestVendeur")
    @PreAuthorize("hasRole('ADMIN')")
    public List<V_HistoriqueAchat> getBestVendeur(){
        return v_historiqueAchatService.getBestVendeur();
    }
}
