package voiture.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voiture.model.AnnonceValide;
import voiture.model.V_AnnonceUtilisateur;

import java.util.List;

@Repository
public interface AnnonceValideRepository extends JpaRepository<AnnonceValide, Integer> {

}
