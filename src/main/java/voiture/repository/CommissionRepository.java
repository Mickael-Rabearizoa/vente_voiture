package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voiture.model.Commission;
import voiture.model.CommisssionAnnonce;
import voiture.model.V_AnnonceFavorisUtilisateur;

import java.util.List;

@Repository
public interface CommissionRepository extends JpaRepository<Commission, Integer>  {

    @Query(value = "select * from Commission where id_commission = (select max(id_commission) from Commission)", nativeQuery = true)
    Commission getCommisssionAnnonce();
}
