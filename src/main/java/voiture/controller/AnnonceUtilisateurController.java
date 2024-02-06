package voiture.controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import voiture.model.AnnonceValide;
import voiture.model.Utilisateur;
import voiture.repository.UtilisateurRepository;
import voiture.service.AnnonceValideService;
import voiture.service.AnnonceutilisateurService;
import voiture.model.Annonceutilisateur;
import voiture.service.PhotoService;
import voiture.tools.JwtUtil;


import java.io.IOException;
import java.sql.Date;
import java.util.Optional;

@RestController
@RequestMapping("/AnnonceUtilisateur")
public class AnnonceUtilisateurController {

    private final AnnonceutilisateurService annonceutilisateurService;
    private final AnnonceValideService annonceValideService;
    private final PhotoService photoService;

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    public AnnonceUtilisateurController(AnnonceutilisateurService annonceutilisateurService, AnnonceValideService annonceValideService, PhotoService photoService, JwtUtil jwtUtil) {
        this.annonceutilisateurService = annonceutilisateurService;
        this.annonceValideService = annonceValideService;
        this.photoService = photoService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/rechercheAvance")
    @PreAuthorize("hasRole('USER')")
    public Integer getMaxId(){
        return annonceutilisateurService.getMaxId();
    }

    @PostMapping("/AddAnnonceutilisateur")
    @PreAuthorize("hasRole('USER')")
    @Transactional
    public ResponseEntity<Annonceutilisateur> AddAnnonceutilisateur(@RequestBody Annonceutilisateur annonceutilisateur) throws IOException {
        Annonceutilisateur  createdAnnonceUtilisateur = annonceutilisateurService.AddAnnonceutilisateur(annonceutilisateur);
        int idannonce=createdAnnonceUtilisateur.getId_Annonceutilisateur();
        System.out.println(""+createdAnnonceUtilisateur.getImg().get(0));
        String url = "https://api.imgbb.com/1/upload?key=e916f661d8f223ded411368ccba16723";
        RestTemplate restTemplate = new RestTemplate();

        for (int i = 0; i <createdAnnonceUtilisateur.getImg().size() ; i++) {

            //mbola asina split ,
            String image=createdAnnonceUtilisateur.getImg().get(i);

            if (image.contains(",")) {
                // Diviser la chaîne en utilisant la virgule comme séparateur
                String[] elements = image.split(",");

                // Vérifier s'il y a au moins deux éléments après la virgule
                if (elements.length >= 2) {
                    // Remplacer la chaîne par le deuxième élément après la virgule
                    image = elements[1];
                }
            }


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("image", image);

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

            // Afficher la réponse
            System.out.println("Response: " + response.getBody());

            JSONObject jsonObject = new JSONObject(response.getBody());

            // Accédez à l'objet "data"
            JSONObject dataObject = jsonObject.getJSONObject("data");

            // Accédez à l'objet "image"
            JSONObject imageObject = dataObject.getJSONObject("image");

            // Obtenez la valeur de "url"
            String nomurl = imageObject.getString("url");

            photoService.insertPhoto(nomurl,idannonce);
        }
        return new ResponseEntity<>(createdAnnonceUtilisateur, HttpStatus.CREATED);
    }

    @GetMapping("/updateStatusAnnonce")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateStatusAnnonce( @RequestParam Integer Id_Annonceutilisateur, HttpServletRequest request) {

        String authorization = request.getHeader("Authorization");
        String token = authorization.substring(7);
        System.out.println("Token: " + token);
        String login = jwtUtil.extractLogin(token);

        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByLogin(login);
        Utilisateur utilisateur = new Utilisateur();

        long currentTimeMillis = System.currentTimeMillis();
        java.util.Date currentDate = new java.util.Date(currentTimeMillis);
        Date currentSqlDate = new Date(currentDate.getTime());

        if (utilisateurOptional.isPresent()) {

            utilisateur = utilisateurOptional.get();
            AnnonceValide annonceValide = new AnnonceValide();

            annonceValide.setId_Annonceutilisateur(Id_Annonceutilisateur);
            annonceValide.setDatevalidation(currentSqlDate);
            annonceValide.setId_Utilisateur(utilisateur.getIdutilisateur());

            annonceValideService.addAnnonceValide(annonceValide);
        }
        annonceutilisateurService.updateStatusAnnonce(Id_Annonceutilisateur);

    }


    @GetMapping("/updateStatusAnnonceVendu")
    @PreAuthorize("hasRole('USER')")
    public void updateStatusAnnonceVendu( @RequestParam Integer Id_Annonceutilisateur, HttpServletRequest request) {

        String authorization = request.getHeader("Authorization");
        String token = authorization.substring(7);
        System.out.println("Token: " + token);
        String login = jwtUtil.extractLogin(token);

        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByLogin(login);
        Utilisateur utilisateur = new Utilisateur();

        long currentTimeMillis = System.currentTimeMillis();
        java.util.Date currentDate = new java.util.Date(currentTimeMillis);
        Date currentSqlDate = new Date(currentDate.getTime());

        if (utilisateurOptional.isPresent()) {

            utilisateur = utilisateurOptional.get();
            AnnonceValide annonceValide = new AnnonceValide();

            annonceValide.setId_Annonceutilisateur(Id_Annonceutilisateur);
            annonceValide.setDatevalidation(currentSqlDate);
            annonceValide.setId_Utilisateur(utilisateur.getIdutilisateur());

            //annonceValideService.addAnnonceValide(annonceValide);
        }
        annonceutilisateurService.updateStatusAnnonce(Id_Annonceutilisateur);

    }



}


