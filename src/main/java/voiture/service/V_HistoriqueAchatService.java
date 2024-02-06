package voiture.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voiture.model.V_HistoriqueAchat;
import voiture.repository.V_HistoriqueAchatRepository;
import voiture.repository.V_MarqueplusvenduRepository;

import java.util.List;

@Service
public class V_HistoriqueAchatService {

    public final V_HistoriqueAchatRepository v_historiqueAchatRepository;

    @Autowired
    public V_HistoriqueAchatService(V_HistoriqueAchatRepository v_historiqueAchatRepository) {
        this.v_historiqueAchatRepository = v_historiqueAchatRepository;
    }

    public V_HistoriqueAchat getChiffreDAffaire() {
        return v_historiqueAchatRepository.getChiffreDAffaire();
    }

    public List<V_HistoriqueAchat> getBestVendeur() {
        return v_historiqueAchatRepository.getBestVendeur();
    }

}
