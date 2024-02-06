package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voiture.model.Couleur;

@Repository
public interface CouleurRepository extends JpaRepository<Couleur, Integer> {
}
