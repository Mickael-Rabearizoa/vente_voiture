package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import voiture.model.CommisssionAnnonce;

public interface CommissionAnnonceRepository extends JpaRepository<CommisssionAnnonce, Long> {
}
