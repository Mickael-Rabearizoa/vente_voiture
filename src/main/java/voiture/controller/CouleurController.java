package voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import voiture.service.CouleurService;
import voiture.tools.Util;

import java.util.Map;

@RestController
@RequestMapping("/couleur")
public class CouleurController {
    private final CouleurService couleurService;

    @Autowired
    public CouleurController(CouleurService couleurService) {
        this.couleurService = couleurService;
    }

    @GetMapping("/getAllCouleur")
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public ResponseEntity<Map<String, Object>> getAllCouleur() {
        Map<String,Object> response = Util.getDefaultResponse();
        response.put("data",couleurService.getAllCouleur());
        response.replace("error","tena misy erreur");
        return new ResponseEntity<Map<String, Object>>(
                response,
                HttpStatusCode.valueOf(200)
        );
    }
}
