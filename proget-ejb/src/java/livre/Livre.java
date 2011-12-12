/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package livre;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author edge
 */
@Entity
@Table(name = "t_livre")
@NamedQueries({
    @NamedQuery(name = "Livre.findAll", query = "SELECT l FROM Livre l"),
    @NamedQuery(name = "Livre.findByIdLivre", query = "SELECT l FROM Livre l WHERE l.idLivre = :idLivre"),
    @NamedQuery(name = "Livre.findByIdCategorie", query = "SELECT l FROM Livre l WHERE l.idCategorie = :idCategorie"),
    @NamedQuery(name = "Livre.findByTitreLivre", query = "SELECT l FROM Livre l WHERE l.titreLivre = :titreLivre"),
    @NamedQuery(name = "Livre.findByDateParutionLivre", query = "SELECT l FROM Livre l WHERE l.dateParutionLivre = :dateParutionLivre"),
    @NamedQuery(name = "Livre.findBySommaireLivre", query = "SELECT l FROM Livre l WHERE l.sommaireLivre = :sommaireLivre"),
    @NamedQuery(name = "Livre.findByDateAjoutLivre", query = "SELECT l FROM Livre l WHERE l.dateAjoutLivre = :dateAjoutLivre"),
    @NamedQuery(name = "Livre.findByEtatLivre", query = "SELECT l FROM Livre l WHERE l.etatLivre = :etatLivre"),
    @NamedQuery(name = "Livre.findByAuteurLivre", query = "SELECT l FROM Livre l WHERE l.auteurLivre = :auteurLivre"),
    @NamedQuery(name = "Livre.findByNombreVenteLivre", query = "SELECT l FROM Livre l WHERE l.nombreVenteLivre = :nombreVenteLivre"),
    @NamedQuery(name = "Livre.findByNombreStockLivre", query = "SELECT l FROM Livre l WHERE l.nombreStockLivre = :nombreStockLivre"),
    @NamedQuery(name = "Livre.findByQuantiteReaprovisionnementLivre", query = "SELECT l FROM Livre l WHERE l.quantiteReaprovisionnementLivre = :quantiteReaprovisionnementLivre"),
    @NamedQuery(name = "Livre.findBySeuilReaprovisionnementLivre", query = "SELECT l FROM Livre l WHERE l.seuilReaprovisionnementLivre = :seuilReaprovisionnementLivre"),
    @NamedQuery(name = "Livre.findByPrixLivre", query = "SELECT l FROM Livre l WHERE l.prixLivre = :prixLivre")})
public class Livre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_livre")
    private Integer idLivre;
    @Column(name = "id_categorie")
    private Integer idCategorie;
    @Basic(optional = false)
    @Column(name = "titre_livre")
    private String titreLivre;
    @Column(name = "date_parution_livre")
    private String dateParutionLivre;
    @Column(name = "sommaire_livre")
    private String sommaireLivre;
    @Column(name = "date_ajout_livre")
    @Temporal(TemporalType.DATE)
    private Date dateAjoutLivre;
    @Column(name = "etat_livre")
    private Boolean etatLivre;
    @Column(name = "auteur_livre")
    private String auteurLivre;
    @Column(name = "nombre_vente_livre")
    private Integer nombreVenteLivre;
    @Column(name = "nombre_stock_livre")
    private Integer nombreStockLivre;
    @Column(name = "quantite_reaprovisionnement_livre")
    private Integer quantiteReaprovisionnementLivre;
    @Column(name = "seuil_reaprovisionnement_livre")
    private Integer seuilReaprovisionnementLivre;
    @Basic(optional = false)
    @Column(name = "prix_livre")
    private float prixLivre;

    public Livre() {
    }

    public Livre(Integer idLivre) {
        this.idLivre = idLivre;
    }

    public Livre(Integer idLivre, String titreLivre, float prixLivre) {
        this.idLivre = idLivre;
        this.titreLivre = titreLivre;
        this.prixLivre = prixLivre;
    }

    public Integer getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Integer idLivre) {
        this.idLivre = idLivre;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getTitreLivre() {
        return titreLivre;
    }

    public void setTitreLivre(String titreLivre) {
        this.titreLivre = titreLivre;
    }

    public String getDateParutionLivre() {
        return dateParutionLivre;
    }

    public void setDateParutionLivre(String dateParutionLivre) {
        this.dateParutionLivre = dateParutionLivre;
    }

    public String getSommaireLivre() {
        return sommaireLivre;
    }

    public void setSommaireLivre(String sommaireLivre) {
        this.sommaireLivre = sommaireLivre;
    }

    public Date getDateAjoutLivre() {
        return dateAjoutLivre;
    }

    public void setDateAjoutLivre(Date dateAjoutLivre) {
        this.dateAjoutLivre = dateAjoutLivre;
    }

    public Boolean getEtatLivre() {
        return etatLivre;
    }

    public void setEtatLivre(Boolean etatLivre) {
        this.etatLivre = etatLivre;
    }

    public String getAuteurLivre() {
        return auteurLivre;
    }

    public void setAuteurLivre(String auteurLivre) {
        this.auteurLivre = auteurLivre;
    }

    public Integer getNombreVenteLivre() {
        return nombreVenteLivre;
    }

    public void setNombreVenteLivre(Integer nombreVenteLivre) {
        this.nombreVenteLivre = nombreVenteLivre;
    }

    public Integer getNombreStockLivre() {
        return nombreStockLivre;
    }

    public void setNombreStockLivre(Integer nombreStockLivre) {
        this.nombreStockLivre = nombreStockLivre;
    }

    public Integer getQuantiteReaprovisionnementLivre() {
        return quantiteReaprovisionnementLivre;
    }

    public void setQuantiteReaprovisionnementLivre(Integer quantiteReaprovisionnementLivre) {
        this.quantiteReaprovisionnementLivre = quantiteReaprovisionnementLivre;
    }

    public Integer getSeuilReaprovisionnementLivre() {
        return seuilReaprovisionnementLivre;
    }

    public void setSeuilReaprovisionnementLivre(Integer seuilReaprovisionnementLivre) {
        this.seuilReaprovisionnementLivre = seuilReaprovisionnementLivre;
    }

    public float getPrixLivre() {
        return prixLivre;
    }

    public void setPrixLivre(float prixLivre) {
        this.prixLivre = prixLivre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLivre != null ? idLivre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livre)) {
            return false;
        }
        Livre other = (Livre) object;
        if ((this.idLivre == null && other.idLivre != null) || (this.idLivre != null && !this.idLivre.equals(other.idLivre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "livre.Livre[idLivre=" + idLivre + "]";
    }

}
