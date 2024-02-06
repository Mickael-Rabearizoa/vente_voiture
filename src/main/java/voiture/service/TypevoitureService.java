package voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voiture.model.Marque;
import voiture.model.Typevoiture;
import voiture.repository.TypevoitureRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TypevoitureService {

    private final TypevoitureRepository typevoitureRepository;

    @Autowired
    public TypevoitureService(TypevoitureRepository typevoitureRepository) {
        this.typevoitureRepository = typevoitureRepository;
    }

    public Typevoiture addTypevoiture(Typevoiture typevoiture) {
        return typevoitureRepository.save(typevoiture);
    }

    public List<Typevoiture> getAllTypevoiture() { return typevoitureRepository.findAll(); }

    public Optional<Typevoiture> getTypevoitureById(Integer idTypevoiture) { return typevoitureRepository.findById(idTypevoiture); }

    public Typevoiture updateTypevoiture(Typevoiture typevoiture) {
        return typevoitureRepository.save(typevoiture);
    }

    public void deleteTypevoiture(Integer idTypevoiture) {
        typevoitureRepository.deleteById(idTypevoiture);
    }
}
