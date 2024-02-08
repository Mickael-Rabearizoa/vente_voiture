package voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voiture.model.Couleur;
import voiture.model.Region;
import voiture.repository.CouleurRepository;

import java.util.List;
@Service
public class CouleurService {
    private final CouleurRepository couleurRepository;

        @Autowired
        public CouleurService(CouleurRepository couleurRepository) {
            this.couleurRepository = couleurRepository;
        }

        public List<Couleur> getAllCouleur() { return couleurRepository.findAll();}
}
