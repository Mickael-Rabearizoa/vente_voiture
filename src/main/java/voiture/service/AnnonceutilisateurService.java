package voiture.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
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

//    private final PhotoRepository photoRepository;

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
            System.out.println("hello:"+annonceutilisateur1.getId_Annonceutilisateur());
            int Id_Annonceutilisateur = annonceutilisateur1.getId_Annonceutilisateur();
            /*int maxid=annonceutilisateurRepository.getMaxId();
            photoService.insertPhoto(file,maxid);*/
            // Enregistrement de la commissionAnnonce
            CommisssionAnnonce commissionAnnonce = new CommisssionAnnonce();
            commissionAnnonce.setId_Annonceutilisateur(Id_Annonceutilisateur);
            commissionAnnonce.setCommissionAnnonce(pourcentage);
            commissionAnnonceRepository.save(commissionAnnonce);
            System.out.println("hello222:"+commissionAnnonce.getId_CommissionAnnonce());

//            int idannonce=annonceutilisateur1.getId_Annonceutilisateur();
//            String url = "https://api.imgbb.com/1/upload?key=e916f661d8f223ded411368ccba16723";
//            RestTemplate restTemplate = new RestTemplate();
//
//            for (int i = 0; i <annonceutilisateur1.getImg().size() ; i++) {
//
//                String image = annonceutilisateur1.getImg().get(i);
//
//                if (image.contains(",")) {
//                    // Diviser la chaîne en utilisant la virgule comme séparateur
//                    String[] elements = image.split(",");
//
//                    // Vérifier s'il y a au moins deux éléments après la virgule
//                    if (elements.length >= 2) {
//                        // Remplacer la chaîne par le deuxième élément après la virgule
//                        image = elements[1];
//                    }
//                }
//
//
//                HttpHeaders headers = new HttpHeaders();
//                headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//                MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//                map.add("image", image);
//
//                HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//
//                ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
//
//                // Afficher la réponse
//                System.out.println("Response: " + response.getBody());
//
//                JSONObject jsonObject = new JSONObject(response.getBody());
//
//                // Accédez à l'objet "data"
//                JSONObject dataObject = jsonObject.getJSONObject("data");
//
//                // Accédez à l'objet "image"
//                JSONObject imageObject = dataObject.getJSONObject("image");
//
//                // Obtenez la valeur de "url"
//                String nomurl = imageObject.getString("url");
//
//                photoService.insertPhoto(nomurl, idannonce);
//            }
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
