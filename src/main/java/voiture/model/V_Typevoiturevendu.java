package voiture.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "V_Typevoiturevendu")
public class V_Typevoiturevendu {

    @Id
    @Column(name="id_typevoiture")
    public int id_typevoiture;

    @Column(name="typevoiture")
    public String typevoiture;

    @Column(name="quantitevendu")
    public int quantitevendu;

    @Column(name="pourcentage_vente")
    public double pourcentage_vente;

    public int getId_typevoiture() {
        return id_typevoiture;
    }

    public void setId_typevoiture(int id_typevoiture) {
        this.id_typevoiture = id_typevoiture;
    }

    public String getTypevoiture() {
        return typevoiture;
    }

    public void setTypevoiture(String typevoiture) {
        this.typevoiture = typevoiture;
    }

    public int getQuantitevendu() {
        return quantitevendu;
    }

    public void setQuantitevendu(int quantitevendu) {
        this.quantitevendu = quantitevendu;
    }

    public double getPourcentage_vente() {
        return pourcentage_vente;
    }

    public void setPourcentage_vente(double pourcentage_vente) {
        this.pourcentage_vente = pourcentage_vente;
    }
}
