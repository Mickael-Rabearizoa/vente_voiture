package voiture.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name= "Modele")
public class Modele {

    @Id
    @Column(name = "Id_Modele")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Modele;

    @Column(name = "modele")
    private String modele;

    @Column(name = "Id_Typevoiture")
    private int Id_Typevoiture;

    @Column(name = "Id_Marque")
    private int Id_marque;

    @OneToOne
    @JoinColumn(name = "id_marque", referencedColumnName = "id_marque", insertable = false, updatable = false , nullable = false)
    private Marque marque;

    @OneToOne
    @JoinColumn(name = "id_typevoiture", referencedColumnName = "id_typevoiture", insertable = false, updatable = false , nullable = false)
    private Typevoiture typevoiture;

    public int getId_Modele() {
        return Id_Modele;
    }

    public void setId_Modele(int id_Modele) {
        Id_Modele = id_Modele;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getId_Typevoiture() {
        return Id_Typevoiture;
    }

    /*public void setId_Typevoiture(int id_Typevoiture) {
        Id_Typevoiture = id_Typevoiture;
    }*/

    public void setId_Typevoiture(int id_Typevoiture) throws Exception {
        if(id_Typevoiture < 0) {
            throw new Exception("Id_Typevoiture ne peut pas être négatif");
        }
        Id_Typevoiture = id_Typevoiture;
    }

    public int getId_marque() {
        return Id_marque;
    }

    public void setId_marque(int id_marque) throws Exception {
        if(id_marque < 0) {
            throw new Exception("id_marque ne peut pas être négatif");
        }
        Id_marque = id_marque;
    }
}
