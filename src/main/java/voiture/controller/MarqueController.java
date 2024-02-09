package voiture.controller;

import org.apache.catalina.util.ResourceSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import voiture.model.Marque;
import voiture.service.MarqueService;
import voiture.tools.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/marques")
public class MarqueController {

    private final MarqueService marqueService;

    @Autowired
    public MarqueController(MarqueService marqueService) { this.marqueService = marqueService; }

    @PostMapping("/createmarque")
    @PreAuthorize("hasRole('ADMIN')")
    public Marque create(@RequestBody Marque marque) {
        return marqueService.createMarque(marque);
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public ResponseEntity<Map<String, Object>> getMarque() {
        Map<String,Object> response = Util.getDefaultResponse();
        response.put("data",marqueService.getAllMarque());
        response.replace("error","tena misy erreur");
        return new ResponseEntity<Map<String, Object>>(
                response,
                HttpStatusCode.valueOf(200)
        );
    }

    @DeleteMapping("/{Id_Marque}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteMarque(@PathVariable Integer Id_Marque) {
        marqueService.deleteMarque(Id_Marque);
        return ResponseEntity.ok("Trajet with ID " + Id_Marque + " has been deleted");
    }

    @PostMapping("{Id_Marque}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Marque> updateMarque(@PathVariable int Id_Marque, @RequestBody Marque updatedMarque) {
        Optional<Marque> optionalMarque = marqueService.getMarqueById(Id_Marque);

        if (optionalMarque.isPresent()) {
            Marque existingMarque = optionalMarque.get();
            existingMarque.setId_Marque(updatedMarque.getId_Marque());
            existingMarque.setNom(updatedMarque.getNom());

            Marque updatedEntity = marqueService.updateMarque(existingMarque);
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
