/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commande;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Treemo
 */
@Entity
@Table(name = "a_contenir")
@NamedQueries({
    @NamedQuery(name = "ContenuCommande.findAll", query = "SELECT c FROM ContenuCommande c"),
    @NamedQuery(name = "ContenuCommande.findByIdLivre", query = "SELECT c FROM ContenuCommande c WHERE c.contenuCommandePK.idLivre = :idLivre"),
    @NamedQuery(name = "ContenuCommande.findByNombre", query = "SELECT c FROM ContenuCommande c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "ContenuCommande.findByIdCommande", query = "SELECT c FROM ContenuCommande c WHERE c.contenuCommandePK.idCommande = :idCommande")})
public class ContenuCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContenuCommandePK contenuCommandePK;
    @Basic(optional = false)
    @Column(name = "nombre")
    private int nombre;

    public ContenuCommande() {
    }

    public ContenuCommande(ContenuCommandePK contenuCommandePK) {
        this.contenuCommandePK = contenuCommandePK;
    }

    public ContenuCommande(ContenuCommandePK contenuCommandePK, int nombre) {
        this.contenuCommandePK = contenuCommandePK;
        this.nombre = nombre;
    }

    public ContenuCommande(int idLivre, int idCommande) {
        this.contenuCommandePK = new ContenuCommandePK(idLivre, idCommande);
    }

    public ContenuCommandePK getContenuCommandePK() {
        return contenuCommandePK;
    }

    public void setContenuCommandePK(ContenuCommandePK contenuCommandePK) {
        this.contenuCommandePK = contenuCommandePK;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contenuCommandePK != null ? contenuCommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContenuCommande)) {
            return false;
        }
        ContenuCommande other = (ContenuCommande) object;
        if ((this.contenuCommandePK == null && other.contenuCommandePK != null) || (this.contenuCommandePK != null && !this.contenuCommandePK.equals(other.contenuCommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "commande.ContenuCommande[contenuCommandePK=" + contenuCommandePK + "]";
    }

}
