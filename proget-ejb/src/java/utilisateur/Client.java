/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateur;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Treemo
 */
@Entity
@Table(name = "t_client")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient"),
    @NamedQuery(name = "Client.findByLoginClient", query = "SELECT c FROM Client c WHERE c.loginClient = :loginClient"),
    @NamedQuery(name = "Client.findByMdpClient", query = "SELECT c FROM Client c WHERE c.mdpClient = :mdpClient"),
    @NamedQuery(name = "Client.findByNomClient", query = "SELECT c FROM Client c WHERE c.nomClient = :nomClient"),
    @NamedQuery(name = "Client.findByPrenomClient", query = "SELECT c FROM Client c WHERE c.prenomClient = :prenomClient"),
    @NamedQuery(name = "Client.findByAdressePostaleClient", query = "SELECT c FROM Client c WHERE c.adressePostaleClient = :adressePostaleClient"),
    @NamedQuery(name = "Client.findByEmailClient", query = "SELECT c FROM Client c WHERE c.emailClient = :emailClient")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_client")
    private Integer idClient;
    @Basic(optional = false)
    @Column(name = "login_client")
    private String loginClient;
    @Basic(optional = false)
    @Column(name = "mdp_client")
    private String mdpClient;
    @Column(name = "nom_client")
    private String nomClient;
    @Column(name = "prenom_client")
    private String prenomClient;
    @Column(name = "adresse_postale_client")
    private String adressePostaleClient;
    @Column(name = "email_client")
    private String emailClient;

    public Client() {
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Client(Integer idClient, String loginClient, String mdpClient) {
        this.idClient = idClient;
        this.loginClient = loginClient;
        this.mdpClient = mdpClient;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getLoginClient() {
        return loginClient;
    }

    public void setLoginClient(String loginClient) {
        this.loginClient = loginClient;
    }

    public String getMdpClient() {
        return mdpClient;
    }

    public void setMdpClient(String mdpClient) {
        this.mdpClient = mdpClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getAdressePostaleClient() {
        return adressePostaleClient;
    }

    public void setAdressePostaleClient(String adressePostaleClient) {
        this.adressePostaleClient = adressePostaleClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "client.Client[idClient=" + idClient + "]";
    }

}
