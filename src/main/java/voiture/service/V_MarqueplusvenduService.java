package voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import voiture.model.V_AnnonceUtilisateur;
import voiture.model.V_Marqueplusvendu;
import voiture.repository.V_MarqueplusvenduRepository;

import java.util.List;

@Service
public class V_MarqueplusvenduService {

    public final V_MarqueplusvenduRepository v_marqueplusvenduRepository;

    @Autowired
    public V_MarqueplusvenduService(V_MarqueplusvenduRepository v_marqueplusvenduRepository) {
        this.v_marqueplusvenduRepository = v_marqueplusvenduRepository;
    }

    public List<V_Marqueplusvendu> getMarqueplusvendu() {
        return v_marqueplusvenduRepository.getMarqueplusvendu();
    }

    public double getCommissionannuel() { return v_marqueplusvenduRepository.getCommissionannuel(); }

    public double getVenteannuel() { return v_marqueplusvenduRepository.getVenteannuel(); }

    public double getChiffreaffairemois() { return v_marqueplusvenduRepository.getChiffreaffairemois(); }


}
