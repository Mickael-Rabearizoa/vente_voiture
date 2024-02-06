package voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voiture.model.Region;
import voiture.model.Volant;
import voiture.repository.RegionRepository;
import voiture.repository.VolantRepository;

import java.util.List;

@Service
public class VolantService {

    private final VolantRepository volantRepository;

    @Autowired
    public VolantService(VolantRepository volantRepository) {
        this.volantRepository = volantRepository;
    }

    public List<Volant> getAllVolant() { return volantRepository.findAll();}
}
