package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voiture.model.Utilisateur;
import voiture.model.V_HistoriqueAchat;

import java.util.Optional;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByLoginAndMotdepasse(
            String login,
            String motdepasse
    );

    Optional<Utilisateur> findByLogin(String login);

    @Query(value = "select count(idutilisateur) as nbutilisateur from Utilisateur", nativeQuery = true)
    int getNbUtilisateur();
}



