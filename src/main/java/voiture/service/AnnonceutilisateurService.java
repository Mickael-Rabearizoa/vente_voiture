package voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import voiture.model.Annonceutilisateur;
import voiture.model.CommisssionAnnonce;
import voiture.repository.AnnonceutilisateurRepository;
import voiture.repository.CommissionAnnonceRepository;
import voiture.repository.CommissionRepository;
import voiture.repository.PhotoRepository;


@Service
public class AnnonceutilisateurService {
    private final AnnonceutilisateurRepository annonceutilisateurRepository;
    private final CommissionAnnonceRepository commissionAnnonceRepository;
    private  final CommissionRepository commissionRepository;

    private  final PhotoService photoService;

    @Autowired
    public AnnonceutilisateurService(AnnonceutilisateurRepository annonceutilisateurRepository, CommissionAnnonceRepository commissionAnnonceRepository, CommissionRepository commissionRepository, PhotoService photoService) {
        this.annonceutilisateurRepository = annonceutilisateurRepository;
        this.commissionAnnonceRepository = commissionAnnonceRepository;
        this.commissionRepository = commissionRepository;
        this.photoService = photoService;
    }
    
    @Transactional
    public Annonceutilisateur AddAnnonceutilisateur(Annonceutilisateur annonceutilisateur) {
        try {
            // Logique métier ici
            CommissionService commissionService = new CommissionService(commissionRepository);
            double pourcentage = commissionService.getLastCommission().getPourcentage_();

            // Enregistrement de l'annonceutilisateur
            Annonceutilisateur annonceutilisateur1 = annonceutilisateurRepository.save(annonceutilisateur);
            int Id_Annonceutilisateur = annonceutilisateur1.getId_Annonceutilisateur();
            /*int maxid=annonceutilisateurRepository.getMaxId();
            photoService.insertPhoto(file,maxid);*/
            // Enregistrement de la commissionAnnonce
            CommisssionAnnonce commissionAnnonce = new CommisssionAnnonce();
            commissionAnnonce.setId_Annonceutilisateur(Id_Annonceutilisateur);
            commissionAnnonce.setCommissionAnnonce(pourcentage);
            commissionAnnonceRepository.save(commissionAnnonce);

            return annonceutilisateur1; // Retourner l'annonceutilisateur enregistré si nécessaire
        } catch (Exception e) {
            // Gérer les exceptions appropriées
            e.printStackTrace(); // ou loguer l'erreur
            throw new RuntimeException("Erreur lors de l'ajout de l'annonceutilisateur", e);
        }
    }

    public void updateStatusAnnonce(Integer Id_Annonceutilisateur){
        annonceutilisateurRepository.updateStatusAnnonce(Id_Annonceutilisateur);
    }

    public void updateStatusAnnonceVendu(Integer Id_Annonceutilisateur){
        annonceutilisateurRepository.updateStatusAnnonceVendu(Id_Annonceutilisateur);
    }

    public Integer getMaxId(){
        return annonceutilisateurRepository.getMaxId();
    }
}
