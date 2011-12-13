/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilisateur;

import javax.ejb.Remote;
import session.SessionUtilisateur;

/**
 *
 * @author Treemo
 */
@Remote
public interface UtilisateurManagerBean {
    
   /**
     *
     * log d'un admin valide ?
     *
     * @param login
     * @param pass
     * @return bool
     */
    public Admin loginAdmin(String login, String pass);

    /**
     *
     * log du client valide ?
     *
     * @param login
     * @param pass
     * @return bool
     */
    public Client loginClient(String login, String pass);

    /**
     * cree un nouvel admin
     *
     * @param login
     * @param pass
     */
    public void addAdmin(Admin admin);

    /**
     * cree un nouveau client
     *
     * @param login
     * @param pass
     */
    public void addClient(Client client);

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
    public Client creationClient(String login, String password, String password2, String nom, String prenom, String adresse, String email);

    /**
     * l'adresse email est valide
     *
     * @param email
     * @return boolean
     */
    public boolean isValidEmailAddress(String email);

    /**
     *
     * hash le login + mdp en md5
     *
     * @param login
     * @param pass
     * @return hash
     */
    public String hashMdp(String login, String pass);
}
