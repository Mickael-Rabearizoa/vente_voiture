package voiture.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voiture.model.Modele;
import voiture.repository.ModeleRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ModeleService {

    private final ModeleRepository modeleRepository;

    @Autowired
    public ModeleService(ModeleRepository modeleRepository) {
        this.modeleRepository = modeleRepository;
    }

    public Modele addModele(Modele modele) {
        return modeleRepository.save(modele);
    }

    public List<Modele> getAllModele() {
        return modeleRepository.findAll();
    }

    public Optional<Modele> getModeleById(Integer idModele) { return modeleRepository.findById(idModele); }

    public Modele updateModele(Modele modele) {
        return modeleRepository.save(modele);
    }

    public void deleteModele(Integer IdModele) {
        modeleRepository.deleteById(IdModele);
    }

    public Optional<List<Modele>> getModelByMarque(int id_marque) {
        return modeleRepository.getModelByMarque(id_marque);
    }
}
