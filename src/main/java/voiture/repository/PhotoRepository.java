package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voiture.model.Photo;

@Repository
public interface PhotoRepository  extends JpaRepository<Photo,Integer> {
}
