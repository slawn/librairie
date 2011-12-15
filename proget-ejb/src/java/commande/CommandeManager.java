/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commande;

import panier.Panier;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import utilisateur.Client;

/**
 *
 * @author Treemo
 */
@Stateful
public class CommandeManager implements CommandeManagerBean {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
@PersistenceContext(unitName="bsPU")
    EntityManager em;


    public List<Commande> commandeList(Client client){

        Query query = em.createNamedQuery("retrieveAllCategories");
        return query.getResultList();
    }
    public Commande getCommandeById(int id){
        
        return em.find(Commande.class,id);
    }

    public void creationDepuisPannier(Panier new_commande){
        
    }
    
}
