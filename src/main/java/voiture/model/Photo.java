package voiture.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "photo")
public class Photo {

    @Id
    @Column(name = "Id_Photo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id_Photo;

    @Column(name = "nomphoto")
    public String photo;

    @Column(name = "Id_Annonceutilisateur")
    public Integer Id_Annonceutilisateur;

    @ManyToOne
    @JoinColumn(name = "id_annonceutilisateur", referencedColumnName = "id_annonceutilisateur" , insertable = false, updatable = false , nullable = false)
    private V_AnnonceUtilisateur V_AnnonceUtilisateur;

    public Integer getId_Annonceutilisateur() {
        return Id_Annonceutilisateur;
    }

    public void setId_Annonceutilisateur(Integer id_Annonceutilisateur) {
        Id_Annonceutilisateur = id_Annonceutilisateur;
    }

    public int getId_Photo() {
        return Id_Photo;
    }

    public void setId_Photo(int id_Photo) {
        Id_Photo = id_Photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
