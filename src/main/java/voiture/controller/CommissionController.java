package voiture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import voiture.model.Commission;
import voiture.model.Marque;
import voiture.model.V_AnnonceUtilisateur;
import voiture.service.CommissionService;
import voiture.tools.Util;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/commission")
public class CommissionController {

    private final CommissionService commissionService;

    @Autowired
    public CommissionController(CommissionService commissionService) { this.commissionService = commissionService; }

    @GetMapping("/getLastCommission")
    @PreAuthorize("hasRole('ADMIN')")
    public Commission getLastCommission() {
        return commissionService.getLastCommission();
    }

    @PostMapping("/createmarque")
    @PreAuthorize("hasRole('ADMIN')")
    public Commission createCommission(@RequestBody Commission commission) {
        return commissionService.createCommission(commission);
    }

    @DeleteMapping("/{idcommission}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteCommission(@PathVariable Integer idcommission) {
        commissionService.deleteCommission(idcommission);
        return ResponseEntity.ok("Trajet with ID " + idcommission + " has been deleted");
    }

    @PostMapping("{idtrajet}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Commission> updateCommission(@PathVariable int idcommission, @RequestBody Commission updateCommission) {
        Optional<Commission> optionalCommission = commissionService.getCommissionById(idcommission);

        if(optionalCommission.isPresent()) {
            Commission commission = optionalCommission.get();
            commission.setId_Commission(updateCommission.getId_Commission());
            commission.setDatecommision(updateCommission.getDatecommision());
            commission.setPourcentage_(updateCommission.getPourcentage_());

            Commission updateEntity = commissionService.updateCommission(commission);
            return new ResponseEntity<>(updateEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
