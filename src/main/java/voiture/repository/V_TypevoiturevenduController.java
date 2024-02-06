package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voiture.model.V_Marqueplusvendu;
import voiture.model.V_Typevoiturevendu;

import java.util.List;

@Repository
public interface V_TypevoiturevenduController extends JpaRepository<V_Typevoiturevendu,Integer> {

    @Query(value = "select * from V_Typevoiturevendu;", nativeQuery = true)
    List<V_Typevoiturevendu> getbestTypevoiturevendu();
}
