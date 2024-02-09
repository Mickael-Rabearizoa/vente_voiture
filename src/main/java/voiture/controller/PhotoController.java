package voiture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import voiture.model.Photo;
import voiture.repository.PhotoRepository;
import voiture.tools.Util;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    PhotoRepository photoRepository;

    @GetMapping("/getPhoto")
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public List<Photo> findPhotosById_Annonceutilisateur(@RequestParam int idAnnonceUtilisateur){
        List<Photo> list = photoRepository.findPhotosById_Annonceutilisateur(idAnnonceUtilisateur);
        return list;
    }
}
