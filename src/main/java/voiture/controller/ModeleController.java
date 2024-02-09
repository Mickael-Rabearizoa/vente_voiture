package voiture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import voiture.model.Marque;
import voiture.model.Modele;
import voiture.service.ModeleService;
import voiture.tools.Util;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/modele")
public class ModeleController {

    private final ModeleService modeleService;

    @Autowired
    public ModeleController(ModeleService modeleService) {
        this.modeleService = modeleService;
    }

    @PostMapping("/createmodele")
    @PreAuthorize("hasRole('ADMIN')")
    public Modele createModele(@RequestBody Modele modele) {
        return modeleService.addModele(modele);
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public Iterable<Modele> getModele() { return modeleService.getAllModele(); }

    @DeleteMapping("/{idmodele}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteModele(@PathVariable Integer idmodele) {
        modeleService.deleteModele(idmodele);
        return ResponseEntity.ok("Trajet with ID " + idmodele + " has been deleted");
    }

    @PostMapping("{idmodele}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Modele> updateMarque(@PathVariable int idmodele, @RequestBody Modele updateModele) throws Exception {
        Optional<Modele> optionalModele = modeleService.getModeleById(idmodele);

        if(optionalModele.isPresent()) {
            Modele modele = optionalModele.get();
            modele.setId_Modele(updateModele.getId_Modele());
            modele.setId_marque(updateModele.getId_marque());
            modele.setId_Typevoiture(updateModele.getId_Typevoiture());
            modele.setModele(updateModele.getModele());

            Modele updateEntity = modeleService.updateModele(modele);
            return new ResponseEntity<>(updateEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("getModelByMarque")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map<String , Object>> getModelByMarque(@RequestParam int id_marque) {
        Optional<List< Modele>> optionalModeles = modeleService.getModelByMarque(id_marque);
        List<Modele> modeleList = optionalModeles.get();
        Map<String , Object> response = Util.getDefaultResponse();
        if(modeleList.isEmpty() == false) {
            response.put("data" , optionalModeles.get());
            return new ResponseEntity<Map<String , Object>>(
                    response,
                    HttpStatusCode.valueOf(200)
            );
        } else {
            response.put("error" , "Aucun resultat");
            return new ResponseEntity<Map<String , Object>>(
                    response,
                    HttpStatusCode.valueOf(500)
            );
        }
    }
}
