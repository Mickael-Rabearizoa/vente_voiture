package voiture.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voiture.model.Annoncefavoris;
import voiture.model.V_AnnonceUtilisateur;

import java.util.List;

@Repository
public interface AnnoncefavorisRepository extends JpaRepository<Annoncefavoris,Integer>  {

    @Modifying
    @Transactional // Add this annotation
    @Query(value = "INSERT INTO Annoncefavoris (Id_Annonceutilisateur, Idutilisateur) VALUES (?1, ?2)", nativeQuery = true)
    void insertAnnoncefavoris(Integer Id_Annonceutilisateur, Integer Idutilisateur);
}
