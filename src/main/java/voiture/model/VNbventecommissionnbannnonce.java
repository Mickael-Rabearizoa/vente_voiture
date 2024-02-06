package voiture.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "v_nbventecommissionnbannnonce", schema = "public", catalog = "voiture")
public class VNbventecommissionnbannnonce {
    @Basic
    @Id
    @Column(name = "idmois")
    private Integer idmois;
    @Basic
    @Column(name = "mois")
    private String mois;
    @Basic
    @Column(name = "nbvente")
    private Long nbvente;
    @Basic
    @Column(name = "commission")
    private Double commission;
    @Basic
    @Column(name = "nombre_annonce")
    private Long nombreAnnonce;

    public Integer getIdmois() {
        return idmois;
    }

    public void setIdmois(Integer idmois) {
        this.idmois = idmois;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public Long getNbvente() {
        return nbvente;
    }

    public void setNbvente(Long nbvente) {
        this.nbvente = nbvente;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Long getNombreAnnonce() {
        return nombreAnnonce;
    }

    public void setNombreAnnonce(Long nombreAnnonce) {
        this.nombreAnnonce = nombreAnnonce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VNbventecommissionnbannnonce that = (VNbventecommissionnbannnonce) o;
        return Objects.equals(idmois, that.idmois) && Objects.equals(mois, that.mois) && Objects.equals(nbvente, that.nbvente) && Objects.equals(commission, that.commission) && Objects.equals(nombreAnnonce, that.nombreAnnonce);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmois, mois, nbvente, commission, nombreAnnonce);
    }
}
