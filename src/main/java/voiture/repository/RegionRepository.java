package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voiture.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
}
