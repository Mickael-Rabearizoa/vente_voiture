package voiture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import voiture.model.Marque;
import voiture.model.Modele;
import voiture.model.Transmission;
import voiture.service.TransmissionService;
import voiture.tools.Util;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/transmission")
public class TransmissionController {

    private final TransmissionService transmissionService;

    @Autowired
    public TransmissionController(TransmissionService transmissionService) { this.transmissionService = transmissionService; }

    @PostMapping("/createtransmission")
    @PreAuthorize("hasRole('ADMIN')")
    public Transmission createTransmission(@RequestBody Transmission transmission) {
        return transmissionService.createTransmission(transmission);
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map<String, Object>> getTransmission() {
        Map<String,Object> response = Util.getDefaultResponse();
        response.put("data",transmissionService.getAllTransmission());
        return new ResponseEntity<Map<String, Object>>(
                response,
                HttpStatusCode.valueOf(200)
        );
    }

    @DeleteMapping("/{Id_Transmission}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteTransmission(@PathVariable Integer Id_Transmission) {
        transmissionService.deleteTransmission(Id_Transmission);
        return ResponseEntity.ok("Trajet with ID " + Id_Transmission + " has been deleted");
    }

    @PostMapping("{Id_Transmission}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Transmission> updateTransmission(@PathVariable int Id_Transmission, @RequestBody Transmission updatedTransmission) {
        Optional<Transmission> optionalTransmission = transmissionService.getTransmissionById(Id_Transmission);

        if (optionalTransmission.isPresent()) {
            Transmission existingTransmission = optionalTransmission.get();
            existingTransmission.setId_Transmission(updatedTransmission.getId_Transmission());
            existingTransmission.setTransmission_(updatedTransmission.getTransmission_());

            Transmission updatedEntity = transmissionService.updateTransmission(existingTransmission);
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
