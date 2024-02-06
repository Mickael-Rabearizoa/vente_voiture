package voiture.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voiture.model.V_AnnonceFavorisUtilisateur;
import voiture.model.V_AnnonceUtilisateur;
import java.util.List;

@Repository
public interface V_AnnonceFavorisUtilisateurRepository extends JpaRepository<V_AnnonceFavorisUtilisateur,Integer> {

    @Query(value = "select * from V_AnnonceFavorisUtilisateur where idutilisateur=?1", nativeQuery = true)
    List<V_AnnonceFavorisUtilisateur> getAnnonceFavorisUtilisateur(Integer IdUtilisateur);
}
