package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voiture.model.BestVendeurDTO;

import java.util.List;

@Repository
public interface BestVendeurRepository extends JpaRepository<BestVendeurDTO,Integer> {
}
