package voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voiture.model.Photo;
import voiture.repository.PhotoRepository;

import java.io.IOException;
import java.util.List;

@Service
public class PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    public void insertPhoto(String file, Integer maxid) throws IOException {
        Photo photo= new Photo();
        photo.setPhoto(file);
        photo.setId_Annonceutilisateur(maxid);
        photoRepository.save(photo);
    }

    public List<Photo> findPhotosByIdAnnonceUtilisateur(int idAnnonceUtilisateur){
        return photoRepository.findPhotosById_Annonceutilisateur(idAnnonceUtilisateur);
    }
}