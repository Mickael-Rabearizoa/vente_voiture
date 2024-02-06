package voiture.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;


@Entity
@Table(name = "V_HistoriqueAchat")
public class V_HistoriqueAchat {

    @Id
    @Column(name="Id_Annonceutilisateur")
    public int Id_Annonceutilisateur;

    @Column(name="matricule")
    public String matricule;

    @Column(name="dateannonce")
    public Date dateannonce;

    @Column(name="kilometrage")
    public double kilometrage;

    @Column(name="annee")
    public int annee;

    @Column(name="moteur")
    public String moteur;

    @Column(name="description")
    public String description;

    @Column(name="prix")
    public double prix;

    @Column(name="status")
    public int status;

    @Column(name="nom_modele")
    public String nom_modele;

    @Column(name="id_marque")
    public int id_marque;

    @Column(name="nom_marque")
    public String nom_marque;

    @Column(name="Idutilisateur")
    public int Idutilisateur;

    @Column(name="prenom_utilisateur")
    public String prenom_utilisateur;

    @Column(name="nom_utilisateur")
    public String nom_utilisateur;

    @Column(name="telephone")
    public String telephone;

    @Column(name="dateachat")
    public Date dateachat;

    @Column(name="prixachat")
    public double prixachat;

    @Column(name="Idacheteur")
    public int Idacheteur;

    @Column(name="pourcentage_commission")
    public double pourcentage_commission;

    @Column(name="commission")
    public double commission;

    @Column(name="nbvente")
    public int nbvente;

    @Column(name="chiffre_daffaire")
    public double chiffre_daffaire;

    public int getId_Annonceutilisateur() {
        return Id_Annonceutilisateur;
    }

    public void setId_Annonceutilisateur(int id_Annonceutilisateur) {
        Id_Annonceutilisateur = id_Annonceutilisateur;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Date getDateannonce() {
        return dateannonce;
    }

    public void setDateannonce(Date dateannonce) {
        this.dateannonce = dateannonce;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getMoteur() {
        return moteur;
    }

    public void setMoteur(String moteur) {
        this.moteur = moteur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNom_modele() {
        return nom_modele;
    }

    public void setNom_modele(String nom_modele) {
        this.nom_modele = nom_modele;
    }

    public int getId_marque() {
        return id_marque;
    }

    public void setId_marque(int id_marque) {
        this.id_marque = id_marque;
    }

    public String getNom_marque() {
        return nom_marque;
    }

    public void setNom_marque(String nom_marque) {
        this.nom_marque = nom_marque;
    }

    public int getIdutilisateur() {
        return Idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        Idutilisateur = idutilisateur;
    }

    public String getPrenom_utilisateur() {
        return prenom_utilisateur;
    }

    public void setPrenom_utilisateur(String prenom_utilisateur) {
        this.prenom_utilisateur = prenom_utilisateur;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public Date getDateachat() {
        return dateachat;
    }

    public void setDateachat(Date dateachat) {
        this.dateachat = dateachat;
    }

    public double getPrixachat() {
        return prixachat;
    }

    public void setPrixachat(double prixachat) {
        this.prixachat = prixachat;
    }

    public int getIdacheteur() {
        return Idacheteur;
    }

    public void setIdacheteur(int idacheteur) {
        Idacheteur = idacheteur;
    }

    public double getPourcentage_commission() {
        return pourcentage_commission;
    }

    public void setPourcentage_commission(double pourcentage_commission) {
        this.pourcentage_commission = pourcentage_commission;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
