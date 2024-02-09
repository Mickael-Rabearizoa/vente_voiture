package voiture.model;


import jakarta.persistence.*;

@Entity
@Table(name= "Annoncefavoris")
public class Annoncefavoris {

    @Id
    @Column(name = "Id_Annoncefavoris")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id_Annoncefavoris;

    @Column(name = "Id_Annonceutilisateur")
    public int Id_Annonceutilisateur;

    @Column(name = "Idutilisateur")
    public int Idutilisateur;

    public int getId_Annoncefavoris() {
        return Id_Annoncefavoris;
    }

    public void setId_Annoncefavoris(int id_Annoncefavoris) {
        Id_Annoncefavoris = id_Annoncefavoris;
    }

    public int getId_Annonceutilisateur() {
        return Id_Annonceutilisateur;
    }

    public void setId_Annonceutilisateur(int id_Annonceutilisateur) {
        Id_Annonceutilisateur = id_Annonceutilisateur;
    }

    public int getIdutilisateur() {
        return Idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        Idutilisateur = idutilisateur;
    }
}
