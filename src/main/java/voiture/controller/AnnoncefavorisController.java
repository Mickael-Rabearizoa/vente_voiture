package voiture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import voiture.repository.AnnoncefavorisRepository;

@RestController
@RequestMapping("/annoncefavoris")
public class AnnoncefavorisController {

    private final AnnoncefavorisRepository annoncefavorisRepository;

    @Autowired
    public AnnoncefavorisController(AnnoncefavorisRepository annoncefavorisRepository) {
        this.annoncefavorisRepository = annoncefavorisRepository;
    }

    @GetMapping("/insertAnnoncefavoris")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> insertAnnoncefavoris(@RequestParam Integer Id_Annonceutilisateur, @RequestParam Integer Idutilisateur) {
        annoncefavorisRepository.insertAnnoncefavoris(Id_Annonceutilisateur, Idutilisateur);
        return ResponseEntity.ok().build();
    }


}
