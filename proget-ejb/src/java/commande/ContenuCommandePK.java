/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commande;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Treemo
 */
@Embeddable
public class ContenuCommandePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_livre")
    private int idLivre;
    @Basic(optional = false)
    @Column(name = "id_commande")
    private int idCommande;

    public ContenuCommandePK() {
    }

    public ContenuCommandePK(int idLivre, int idCommande) {
        this.idLivre = idLivre;
        this.idCommande = idCommande;
    }

    public int getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLivre;
        hash += (int) idCommande;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContenuCommandePK)) {
            return false;
        }
        ContenuCommandePK other = (ContenuCommandePK) object;
        if (this.idLivre != other.idLivre) {
            return false;
        }
        if (this.idCommande != other.idCommande) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "commande.ContenuCommandePK[idLivre=" + idLivre + ", idCommande=" + idCommande + "]";
    }

}
