package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voiture.model.V_AnnonceUtilisateur;

import java.util.List;

@Repository
public interface V_AnnonceUtilisateurRepository extends JpaRepository<V_AnnonceUtilisateur,Integer> {
    @Query(value = "select * from V_AnnonceUtilisateur where idutilisateur=?1 and status=0", nativeQuery = true)
    List<voiture.model.V_AnnonceUtilisateur> getAnnonceNonValide(Integer idutilisateur);
    @Query(value = "select * from V_AnnonceUtilisateur where idutilisateur=?1 and status=1", nativeQuery = true)
    List<voiture.model.V_AnnonceUtilisateur> getAnnonceValide(Integer idutilisateur);
    @Query(value = "select * from V_AnnonceUtilisateur where idutilisateur=?1 and status=2", nativeQuery = true)
    List<voiture.model.V_AnnonceUtilisateur> getAnnonceValideVendu(Integer idutilisateur);

    @Query(value = "select * from V_AnnonceUtilisateur where status=0", nativeQuery = true)
    List<V_AnnonceUtilisateur> getAnnonceAValide();

    @Query(value = "select * from V_AnnonceUtilisateur where Id_Annonceutilisateur=?1", nativeQuery = true)
    List<V_AnnonceUtilisateur> getAnnonceDetail(Integer Id_Annonceutilisateur);

    @Query(value = "SELECT * FROM V_AnnonceUtilisateur\n" +
            "WHERE\n" +
            "    status = 1\n" +
            "    AND (id_modele IS NOT NULL OR id_modele = ?1)\n" +
            "    AND (Id_couleur IS NOT NULL OR Id_couleur = ?2)\n" +
            "    AND (annee IS NOT NULL OR annee = ?3)\n" +
            "    AND (id_typevoiture IS NOT NULL OR id_typevoiture = ?4)\n" +
            "    AND (id_marque IS NOT NULL OR id_marque = ?5)\n" +
            "    AND ((prix IS NOT NULL AND prix < ?6) OR (prix > ?7 AND prix IS NOT NULL));\n", nativeQuery = true)
    List<V_AnnonceUtilisateur> rechercheAvance(Integer id_modele,Integer id_couleur,Integer annee, Integer id_typevoiture,Integer id_marque,Double prix1,Double prix2 );

    @Query(value = "select * from V_AnnonceUtilisateur where status=1", nativeQuery = true)
    List<voiture.model.V_AnnonceUtilisateur> getListAnnonceValide();

    @Query(value = "select count(id_annonceutilisateur) as nbannonce from V_AnnonceUtilisateur where status=1", nativeQuery = true)
    V_AnnonceUtilisateur getNbAnnonceValide();

    @Query(value = "select * from V_AnnonceUtilisateur where idutilisateur=?1", nativeQuery = true)
    List<voiture.model.V_AnnonceUtilisateur> getAnnonceUtilisateur(int idutilisateur);

}
