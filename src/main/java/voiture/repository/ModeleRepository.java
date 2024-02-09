package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import voiture.model.Modele;

import java.util.List;
import java.util.Optional;

public interface ModeleRepository extends JpaRepository<Modele, Integer>  {
    @Query(value = "select * from modele where id_marque=?1", nativeQuery = true)
    Optional<List<Modele>> getModelByMarque(Integer id_marque);
}
