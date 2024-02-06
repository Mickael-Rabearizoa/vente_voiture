package voiture.model;


import jakarta.persistence.*;

@Entity
@Table(name= "V_Marqueplusvendu")
public class V_Marqueplusvendu {

    @Id
    @Column(name = "id_marque")
    private int idMarque;

    @Column(name = "quantitevendu")
    public int quantitevendu;

    @Column(name = "nom_marque")
    public String nom_marque;

    @Column(name = "totalpirx")
    public double totalpirx;

    @Column(name = "commission")
    public double commission;

    @Column(name = "mois")
    public int mois;

    @Column(name = "annee_extraction")
    public int annee_extraction;

    public String getNom_marque() {
        return nom_marque;
    }

    public void setNom_marque(String nom_marque) {
        this.nom_marque = nom_marque;
    }

    public int getQuantitevendu() {
        return quantitevendu;
    }

    public void setQuantitevendu(int quantitevendu) {
        this.quantitevendu = quantitevendu;
    }

    public double getTotalpirx() {
        return totalpirx;
    }

    public void setTotalpirx(double totalpirx) {
        this.totalpirx = totalpirx;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

}
