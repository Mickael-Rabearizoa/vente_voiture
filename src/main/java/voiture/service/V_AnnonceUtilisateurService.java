package voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voiture.model.Annonceutilisateur;
import voiture.model.V_AnnonceUtilisateur;
import voiture.repository.V_AnnonceUtilisateurRepository;

import java.util.List;

@Service
public class V_AnnonceUtilisateurService {
    public final V_AnnonceUtilisateurRepository v_annonceUtilisateurRepository;

    @Autowired
    public V_AnnonceUtilisateurService(V_AnnonceUtilisateurRepository v_annonceUtilisateurRepository) {
        this.v_annonceUtilisateurRepository = v_annonceUtilisateurRepository;
    }
    public List<V_AnnonceUtilisateur> getAnnonceNonValide(Integer Idutilisateur ){
        return v_annonceUtilisateurRepository.getAnnonceNonValide(Idutilisateur);
    }
    public List<V_AnnonceUtilisateur> getAnnonceValide(Integer Idutilisateur ){
        return  v_annonceUtilisateurRepository.getAnnonceValide(Idutilisateur);
    }
    public List<V_AnnonceUtilisateur> getAnnonceValideVendu(Integer Idutilisateur ){
        return v_annonceUtilisateurRepository.getAnnonceValideVendu(Idutilisateur);
    }
    public List<V_AnnonceUtilisateur> getAnnonceAValide(){
        return v_annonceUtilisateurRepository.getAnnonceAValide();
    }

    public List<V_AnnonceUtilisateur> getAnnonceDetail(Integer Id_Annonceutilisateur){
        return v_annonceUtilisateurRepository.getAnnonceDetail(Id_Annonceutilisateur);
    }
    public List<V_AnnonceUtilisateur> rechercheAvance(Integer id_modele,Integer id_couleur,Integer annee, Integer id_typevoiture,Integer id_marque,Double prix1,Double prix2) {
        return v_annonceUtilisateurRepository.rechercheAvance(id_modele, id_couleur, annee, id_typevoiture, id_marque, prix1, prix2);
    }

    public List<V_AnnonceUtilisateur> getListAnnonceValide(){
        return v_annonceUtilisateurRepository.getListAnnonceValide();
    }

    public V_AnnonceUtilisateur getNbAnnonceValide(){
        return v_annonceUtilisateurRepository.getNbAnnonceValide();
    }

    public List<V_AnnonceUtilisateur> getAnnonceUtilisateur(int Idutilisateur){
        return v_annonceUtilisateurRepository.getAnnonceUtilisateur(Idutilisateur);
    }
}
