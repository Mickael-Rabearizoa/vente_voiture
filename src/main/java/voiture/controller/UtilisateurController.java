package voiture.controller;

import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import voiture.auth.AuthenticationRequest;
import voiture.auth.RegisterRequest;
import voiture.model.Transmission;
import voiture.model.Utilisateur;
import voiture.service.AuthenticationService;
import voiture.service.UtilisateurService;
import voiture.tools.Util;

@RestController
@RequestMapping("/login")
public class UtilisateurController {

    @Autowired
    private AuthenticationService service;
    @Autowired
    private  final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/hello")
    public String register() {
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(
            @RequestBody RegisterRequest request
    ) {
        Map<String, Object> response = Util.getDefaultResponse();
        response.put("response", service.register(request));
        return new ResponseEntity<Map<String, Object>>(
                response,
                HttpStatusCode.valueOf(200)
        );
    }

    @PostMapping("/auth")
    public ResponseEntity<Map<String, Object>> auth(
            @RequestBody AuthenticationRequest request
    ) {
        Map<String, Object> response = Util.getDefaultResponse();
        response.put("response", service.authenticate(request));
        return new ResponseEntity<Map<String, Object>>(
                response,
                HttpStatusCode.valueOf(200)
        );
    }

    @GetMapping("/getUtilisateurBYid")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<Utilisateur> getUtilisateurBYid(@RequestParam  Integer idutilisateur){
        return utilisateurService.getUtilisateurBYid(idutilisateur);
    }

    @GetMapping("/getnbutilisateur")
    @PreAuthorize("hasRole('ADMIN')")
    public int getnbutilisateur() {
        return utilisateurService.getnbutilisateur();
    }
}

