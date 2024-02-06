package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import voiture.model.Annonceutilisateur;

import org.springframework.stereotype.Repository;
@Repository
public interface AnnonceutilisateurRepository extends JpaRepository<Annonceutilisateur, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update Annonceutilisateur set status=1  where Id_Annonceutilisateur=?1", nativeQuery = true)
    void updateStatusAnnonce(Integer Id_Annonceutilisateur);

    @Modifying
    @Transactional
    @Query(value = "update Annonceutilisateur set status=2  where Id_Annonceutilisateur=?1", nativeQuery = true)
    void updateStatusAnnonceVendu(Integer Id_Annonceutilisateur);

    @Query(value = "select max(Annonceutilisateur) from V_AnnonceUtilisateur ", nativeQuery = true)
    Integer getMaxId();

    @Query(value = "select * from Annonceutilisateur where id_annonceutilisateur = (select max(id_annonceutilisateur) from Annonceutilisateur)", nativeQuery = true)
    Annonceutilisateur getLastAnnonceutilisateur();

}
