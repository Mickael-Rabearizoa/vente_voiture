package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voiture.model.V_AnnonceFavorisUtilisateur;
import voiture.model.V_Marqueplusvendu;
import java.util.List;

@Repository
public interface V_MarqueplusvenduRepository extends JpaRepository<V_Marqueplusvendu,Integer>  {

    @Query(value = "select * from V_Marqueplusvendu order by quantitevendu desc,totalpirx desc,commission desc limit 3;", nativeQuery = true)
    List<V_Marqueplusvendu> getMarqueplusvendu();

    @Query(value = "select sum(commission) as commissionannuel,annee_extraction from V_Marqueplusvendu where annee_extraction = (extract(YEAR FROM current_date)) group by annee_extraction;", nativeQuery = true)
    double getCommissionannuel();

    @Query(value = "select sum(quantitevendu) as venteannuel,annee_extraction from V_Marqueplusvendu where annee_extraction = (extract(YEAR FROM current_date)) group by annee_extraction;", nativeQuery = true)
    double getVenteannuel();

    @Query(value = " select sum(commission) as chiffreaffairemois,mois,annee_extraction from V_Marqueplusvendu group by mois,annee_extraction;", nativeQuery = true)
    double getChiffreaffairemois();
}
