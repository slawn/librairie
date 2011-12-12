/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commande;

import pannier.Pannier;
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
@Table(name = "t_commande")
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
    @NamedQuery(name = "Commande.findByIdCommande", query = "SELECT c FROM Commande c WHERE c.idCommande = :idCommande"),
    @NamedQuery(name = "Commande.findByIdClient", query = "SELECT c FROM Commande c WHERE c.idClient = :idClient"),
    @NamedQuery(name = "Commande.findByDateCommande", query = "SELECT c FROM Commande c WHERE c.dateCommande = :dateCommande"),
    @NamedQuery(name = "Commande.findByEtatCommande", query = "SELECT c FROM Commande c WHERE c.etatCommande = :etatCommande"),
    @NamedQuery(name = "Commande.findByAdressePostaleCommande", query = "SELECT c FROM Commande c WHERE c.adressePostaleCommande = :adressePostaleCommande")})
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_commande")
    private Integer idCommande;
    @Basic(optional = false)
    @Column(name = "id_client")
    private int idClient;
    @Column(name = "date_commande")
    @Temporal(TemporalType.DATE)
    private Date dateCommande;
    @Column(name = "etat_commande")
    private Integer etatCommande;
    @Column(name = "adresse_postale_commande")
    private String adressePostaleCommande;

    public Commande() {
    }

    public Commande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Commande(Integer idCommande, int idClient) {
        this.idCommande = idCommande;
        this.idClient = idClient;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Integer getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(Integer etatCommande) {
        this.etatCommande = etatCommande;
    }

    public String getAdressePostaleCommande() {
        return adressePostaleCommande;
    }

    public void setAdressePostaleCommande(String adressePostaleCommande) {
        this.adressePostaleCommande = adressePostaleCommande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommande != null ? idCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idCommande == null && other.idCommande != null) || (this.idCommande != null && !this.idCommande.equals(other.idCommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "commande.Commande[idCommande=" + idCommande + "]";
    }

}
