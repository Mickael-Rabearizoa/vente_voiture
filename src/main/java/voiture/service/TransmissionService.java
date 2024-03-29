package voiture.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voiture.model.Marque;
import voiture.model.Transmission;
import voiture.repository.TransmissionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransmissionService {

    private final TransmissionRepository transmissionRepository;

    @Autowired
    public TransmissionService(TransmissionRepository transmissionRepository) { this.transmissionRepository = transmissionRepository; }

    public Transmission createTransmission(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }

    public List<Transmission> getAllTransmission() { return transmissionRepository.findAll(); }

    public Optional<Transmission> getTransmissionById(Integer idTransmission) { return transmissionRepository.findById(idTransmission); }

    public Transmission updateTransmission(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }

    public void deleteTransmission(Integer idTransmission) {
        transmissionRepository.deleteById(idTransmission);
    }
}
