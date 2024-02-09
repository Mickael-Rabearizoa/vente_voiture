package voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import voiture.model.Photo;
import voiture.repository.PhotoRepository;

import java.io.IOException;

@Service
public class PhotoService {
    public final PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }
    public void insertPhoto(String file, Integer maxid) {
        Photo photo= new Photo();
        photo.setPhoto(file);
        photo.setId_Annonceutilisateur(maxid);
        photoRepository.save(photo);
    }}