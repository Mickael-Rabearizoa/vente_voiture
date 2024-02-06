package voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import voiture.model.Marque;
import voiture.model.Modele;
import voiture.model.Typevoiture;
import voiture.service.TypevoitureService;

import java.util.Optional;

@RestController
@RequestMapping("/typevoitures")
public class TypevoitureController {

    private final TypevoitureService typevoitureService;

    @Autowired
    public TypevoitureController(TypevoitureService typevoitureService) {
        this.typevoitureService = typevoitureService;
    }

    @PostMapping("/createtypevoiture")
    @PreAuthorize("hasRole('ADMIN')")
    public Typevoiture createTypevoiture(@RequestBody Typevoiture typevoiture) {
        return typevoitureService.addTypevoiture(typevoiture);
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public Iterable<Typevoiture> getTypevoiture() { return typevoitureService.getAllTypevoiture(); }


    @DeleteMapping("/{idtypevoiture}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteTypevoiture(@PathVariable Integer idtypevoiture) {
        typevoitureService.deleteTypevoiture(idtypevoiture);
        return ResponseEntity.ok("Trajet with ID " + idtypevoiture + " has been deleted");
    }

    @PostMapping("{idtrajet}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Typevoiture> updateTypevoiture(@PathVariable int idtypevoiture, @RequestBody Typevoiture updateTypevoiture) {
        Optional<Typevoiture> optionalTypevoiture = typevoitureService.getTypevoitureById(idtypevoiture);

        if(optionalTypevoiture.isPresent()) {
            Typevoiture typevoiture = optionalTypevoiture.get();
            typevoiture.setId_Typevoiture(updateTypevoiture.getId_Typevoiture());
            typevoiture.setTypevoiture(updateTypevoiture.getTypevoiture());

            Typevoiture updateEntity = typevoitureService.updateTypevoiture(typevoiture);
            return new ResponseEntity<>(updateEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
