package voiture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import voiture.model.Carburant;
import voiture.model.Marque;
import voiture.service.CarburantService;

import java.util.Optional;

@RestController
@RequestMapping("/carburant")
public class CarburantController {

    private final CarburantService carburantService;

    @Autowired
    public CarburantController(CarburantService carburantService) { this.carburantService = carburantService; }

    @PostMapping("/createcarburant")
    @PreAuthorize("hasRole('ADMIN')")
    public Carburant createCarburant(@RequestBody Carburant carburant) {
        return carburantService.createCarburant(carburant);
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public Iterable<Carburant> getCarburant() { return carburantService.getAllCarburants(); }

    @DeleteMapping("/{idcarburant}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteCarburant(@PathVariable Integer idcarburant) {
        carburantService.deleteCarburant(idcarburant);
        return ResponseEntity.ok("Trajet with ID " + idcarburant + " has been deleted");
    }

    @PostMapping("{idtrajet}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Carburant> updateCarburant(@PathVariable int idcarburant, @RequestBody Carburant updateCarburant) {
        Optional<Carburant> optionalCarburant = carburantService.getCarburantById(idcarburant);

        if(optionalCarburant.isPresent()) {
            Carburant carburant = optionalCarburant.get();
            carburant.setId_Carburant(updateCarburant.getId_Carburant());
            carburant.setCarburant(updateCarburant.getCarburant());

            Carburant updateEntity = carburantService.updateCarburant(carburant);
            return new ResponseEntity<>(updateEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
