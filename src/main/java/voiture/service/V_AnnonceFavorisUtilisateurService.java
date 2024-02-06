package voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voiture.model.V_AnnonceFavorisUtilisateur;
import voiture.repository.V_AnnonceFavorisUtilisateurRepository;
import voiture.repository.V_AnnonceUtilisateurRepository;

import java.util.List;

@Service
public class V_AnnonceFavorisUtilisateurService {

    public final V_AnnonceFavorisUtilisateurRepository v_annonceFavorisUtilisateurRepository;

    @Autowired
    public V_AnnonceFavorisUtilisateurService(V_AnnonceFavorisUtilisateurRepository v_annonceFavorisUtilisateurRepository) {
        this.v_annonceFavorisUtilisateurRepository = v_annonceFavorisUtilisateurRepository;
    }

    public List<V_AnnonceFavorisUtilisateur> getAnnonceFavorisUtilisateur(Integer Idutilisateur) {
        return v_annonceFavorisUtilisateurRepository.getAnnonceFavorisUtilisateur(Idutilisateur);
    }
}
