package voiture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import voiture.service.RegionService;
import voiture.tools.Util;

import java.util.Map;

@RestController
@RequestMapping("/region")
public class RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public ResponseEntity<Map<String, Object>> getAllRegion() {
        Map<String,Object> response = Util.getDefaultResponse();
        response.put("data",regionService.getAllRegion());
        response.replace("error","tena misy erreur");
        return new ResponseEntity<Map<String, Object>>(
                response,
                HttpStatusCode.valueOf(200)
        );
    }
}
