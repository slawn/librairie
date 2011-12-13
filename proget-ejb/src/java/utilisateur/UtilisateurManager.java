/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateur;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import log.Log;
import session.SessionUtilisateur;

/**
 *
 * @author Treemo
 */
@Stateful(name="UtilisateurManager")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UtilisateurManager implements UtilisateurManagerBean {


    @PersistenceContext(unitName="bsPU")
    EntityManager client;

    @PersistenceContext(unitName="bsPU")
    EntityManager admin;

    /**
     *
     * log d'un admin valide ?
     *
     * @param login
     * @param pass
     * @return bool
     */
    @Override
    public Admin loginAdmin(String login, String pass) {

        pass = hashMdp(login, pass);

        String q= "SELECT a FROM Admin a WHERE a.loginAdmin = :login AND a.mdpAdmin = :pass";
        Query query = admin.createQuery(q);
        query.setParameter("login", login);
       query.setParameter("pass", pass);
        List<Admin> result = query.getResultList();

        if ( !result.isEmpty() )
            return result.get(0);

        return null;
    }

    /**
     *
     * log du client valide ?
     *
     * @param login
     * @param pass
     * @return bool
     */
    @Override
    public Client loginClient(String login, String pass) {

        pass = hashMdp(login, pass);
        
        String q = "SELECT c FROM Client c WHERE c.loginClient = :login AND c.mdpClient = :pass";
        Query query = client.createQuery(q);
        query.setParameter("login", login);
        query.setParameter("pass", pass);
        List<Client> result = query.getResultList();

        if ( !result.isEmpty() )
            return result.get(0);

        return null;
    }    

    /**
     * cree un nouvel admin
     *
     * @param login
     * @param pass
     */
    @Override
    public void addAdmin(Admin admin) {

        this.admin.persist( admin );
    }

    /**
     * cree un nouveau client
     *
     * @param login
     * @param pass
     */
    @Override
    public void addClient(Client client) {

        this.client.persist( client );
    }

    /**
     *
     * test si le compte peut etre cree et si oui il le cree
     *
     * @param this
     * @param login
     * @param password
     * @param password2
     * @param nom
     * @param prenom
     * @param adresse
     * @param email
     * @return boolean
     */
    @Override
    public Client creationClient(String login, String password, String password2, String nom, String prenom, String adresse, String email) {

        password = hashMdp(login, password);

        Client client = new Client(1, login, password);
        client.setAdressePostaleClient(adresse);
        client.setEmailClient(email);
        client.setNomClient(nom);
        client.setPrenomClient(prenom);

        addClient(client);

        return client;
    }

    /**
     * l'adresse email est valide
     *
     * @param email
     * @return boolean
     */
    @Override
    public boolean isValidEmailAddress(String email) {

	try {
		new javax.mail.internet.InternetAddress(email, true);
	} catch (javax.mail.internet.AddressException e) {
		return false;
	}
	return true;
    }

    /**
     *
     * hash le login + mdp en md5
     *
     * @param login
     * @param pass
     * @return hash
     */
    @Override
    public String hashMdp(String login, String pass) {

        String hashword = "";
        String password = login + ":" + pass;

        try {

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(password.getBytes());
            BigInteger hash = new BigInteger(1, md5.digest());
            hashword = hash.toString(16);

        } catch (NoSuchAlgorithmException nsae) {

        }

        return hashword;
    }
}
