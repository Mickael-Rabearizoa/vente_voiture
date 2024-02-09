package voiture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import voiture.repository.PhotoRepository;
import voiture.tools.Util;

import java.util.Map;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoController(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @PostMapping("getphoto")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Map<String, Object>> getPhoto(Integer Id_Annonceutilisateur) {
        Map<String,Object> response = Util.getDefaultResponse();
        response.put("data",photoRepository.getOnePhotoById(Id_Annonceutilisateur));
        response.replace("error","tena misy erreur");
        return new ResponseEntity<Map<String, Object>>(
                response,
                HttpStatusCode.valueOf(200)
        );
    }

}
