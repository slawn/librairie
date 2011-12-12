/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package log;

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
@Table(name = "t_log")
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByIdLog", query = "SELECT l FROM Log l WHERE l.idLog = :idLog"),
    @NamedQuery(name = "Log.findByIdAdmin", query = "SELECT l FROM Log l WHERE l.idAdmin = :idAdmin"),
    @NamedQuery(name = "Log.findByIdClient", query = "SELECT l FROM Log l WHERE l.idClient = :idClient"),
    @NamedQuery(name = "Log.findByIdLivre", query = "SELECT l FROM Log l WHERE l.idLivre = :idLivre"),
    @NamedQuery(name = "Log.findByIdCommande", query = "SELECT l FROM Log l WHERE l.idCommande = :idCommande"),
    @NamedQuery(name = "Log.findByDateHeureLog", query = "SELECT l FROM Log l WHERE l.dateHeureLog = :dateHeureLog"),
    @NamedQuery(name = "Log.findByActionLog", query = "SELECT l FROM Log l WHERE l.actionLog = :actionLog"),
    @NamedQuery(name = "Log.findByArgumentLog", query = "SELECT l FROM Log l WHERE l.argumentLog = :argumentLog")})
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_log")
    private Integer idLog;
    @Column(name = "id_admin")
    private Integer idAdmin;
    @Column(name = "id_client")
    private Integer idClient;
    @Column(name = "id_livre")
    private Integer idLivre;
    @Column(name = "id_commande")
    private Integer idCommande;
    @Basic(optional = false)
    @Column(name = "date_heure_log")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeureLog;
    @Basic(optional = false)
    @Column(name = "action_log")
    private String actionLog;
    @Column(name = "argument_log")
    private String argumentLog;

    public Log() {
    }

    public Log(Integer idLog) {
        this.idLog = idLog;
    }

    public Log(Integer idLog, Date dateHeureLog, String actionLog) {
        this.idLog = idLog;
        this.dateHeureLog = dateHeureLog;
        this.actionLog = actionLog;
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Integer idLivre) {
        this.idLivre = idLivre;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateHeureLog() {
        return dateHeureLog;
    }

    public void setDateHeureLog(Date dateHeureLog) {
        this.dateHeureLog = dateHeureLog;
    }

    public String getActionLog() {
        return actionLog;
    }

    public void setActionLog(String actionLog) {
        this.actionLog = actionLog;
    }

    public String getArgumentLog() {
        return argumentLog;
    }

    public void setArgumentLog(String argumentLog) {
        this.argumentLog = argumentLog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "log.Log[idLog=" + idLog + "]";
    }

}
