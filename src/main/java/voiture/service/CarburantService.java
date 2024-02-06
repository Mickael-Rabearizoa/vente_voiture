package voiture.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voiture.model.Carburant;
import voiture.model.Marque;
import voiture.repository.CarburantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarburantService {

    private final CarburantRepository carburantRepository;

    @Autowired
    public CarburantService(CarburantRepository carburantRepository) { this.carburantRepository = carburantRepository; }

    public Carburant createCarburant(Carburant carburant) { return carburantRepository.save(carburant); }

    public List<Carburant> getAllCarburants() { return carburantRepository.findAll(); }

    public Optional<Carburant> getCarburantById(Integer idCarburant) { return carburantRepository.findById(idCarburant); }

    public Carburant updateCarburant(Carburant carburant) {
        return carburantRepository.save(carburant);
    }

    public void deleteCarburant(Integer idCarburant) {
        carburantRepository.deleteById(idCarburant);
    }
}
