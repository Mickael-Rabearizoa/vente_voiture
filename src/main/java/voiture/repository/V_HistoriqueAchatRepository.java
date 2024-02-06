package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voiture.model.V_HistoriqueAchat;

import java.util.List;

@Repository
public interface V_HistoriqueAchatRepository extends JpaRepository<V_HistoriqueAchat,Integer>  {

    @Query(value = "select count(id_annonceutilisateur) as nbvente,sum(commission) as chiffre_daffaire from V_HistoriqueAchat", nativeQuery = true)
    V_HistoriqueAchat getChiffreDAffaire();

    @Query(value = "select nom_utilisateur,prenom_utilisateur,telephone,count(id_annonceutilisateur) as nbvente,sum(commission) as chiffre_daffaire from V_HistoriqueAchat group by nom_utilisateur,prenom_utilisateur,telephone order by count(id_annonceutilisateur) desc limit 3", nativeQuery = true)
    List<V_HistoriqueAchat> getBestVendeur();

    @Query(value = "select count(id_annonceutilisateur) as nbvente,sum(commission),mois,annee_extraction as chiffre_daffaire from V_HistoriqueAchat group by mois,annee_extraction order by mois;", nativeQuery = true)
    List<Integer> getNbVente();
}
