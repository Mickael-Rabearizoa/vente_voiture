package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voiture.model.Photo;
import voiture.model.V_AnnonceUtilisateur;

import java.util.List;

import java.util.List;

@Repository
public interface PhotoRepository  extends JpaRepository<Photo,Integer> {
     @Query(value = "select p from Photo as p where p.Id_Annonceutilisateur=?1")
     List<Photo> findPhotosById_Annonceutilisateur(int idAnnonceUtilisateur);
}
