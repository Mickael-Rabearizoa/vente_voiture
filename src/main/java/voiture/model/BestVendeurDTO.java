package voiture.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "bestvendeurdto")
public class BestVendeurDTO {

    @Id
    @Column(name = "Idutilisateur")
    public int idutilisateur;

    @Column(name = "nom_utilisateur")
    private String nom_utilisateur;

    @Column(name = "prenom_utilisateur")
    private String prenom_utilisateur;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "nbvente")
    private int nbvente;

    @Column(name = "chiffre_daffaire")
    private double chiffre_daffaire;

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public String getPrenom_utilisateur() {
        return prenom_utilisateur;
    }

    public void setPrenom_utilisateur(String prenom_utilisateur) {
        this.prenom_utilisateur = prenom_utilisateur;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getNbvente() {
        return nbvente;
    }

    public void setNbvente(int nbvente) {
        this.nbvente = nbvente;
    }

    public double getChiffre_daffaire() {
        return chiffre_daffaire;
    }

    public void setChiffre_daffaire(double chiffre_daffaire) {
        this.chiffre_daffaire = chiffre_daffaire;
    }
}
