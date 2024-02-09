package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voiture.model.Photo;

import java.util.List;

@Repository
public interface PhotoRepository  extends JpaRepository<Photo,Integer> {
     @Query(value = "select p from photo as p where p.Id_Annonceutilisateur=?1")
     List<Photo> findPhotosById_Annonceutilisateur(int idAnnonceUtilisateur);
}
