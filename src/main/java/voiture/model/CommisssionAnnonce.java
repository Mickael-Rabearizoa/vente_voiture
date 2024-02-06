package voiture.model;


import jakarta.persistence.*;

@Entity
@Table(name= "commissionannonce")
public class CommisssionAnnonce {

    @Id
    @Column(name = "Id_CommissionAnnonce")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id_CommissionAnnonce;

    @Column(name = "Id_Annonceutilisateur")
    public int Id_Annonceutilisateur;

    @Column(name = "commissionannonce")
    public double commissionAnnonce;

    public int getId_CommissionAnnonce() {
        return Id_CommissionAnnonce;
    }

    public void setId_CommissionAnnonce(int id_CommissionAnnonce) {
        Id_CommissionAnnonce = id_CommissionAnnonce;
    }

    public int getId_Annonceutilisateur() {
        return Id_Annonceutilisateur;
    }

    public void setId_Annonceutilisateur(int id_Annonceutilisateur) {
        Id_Annonceutilisateur = id_Annonceutilisateur;
    }

    public double getCommissionAnnonce() {
        return commissionAnnonce;
    }

    public void setCommissionAnnonce(double commissionAnnonce) {
        this.commissionAnnonce = commissionAnnonce;
    }
}
