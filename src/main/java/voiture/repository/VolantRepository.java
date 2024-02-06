package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import voiture.model.Volant;

public interface VolantRepository extends JpaRepository<Volant,Integer> {
}
