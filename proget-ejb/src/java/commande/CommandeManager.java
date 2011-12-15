/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commande;

import java.util.Date;
import panier.Panier;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import livre.Livre;
import panier.PanierStruct;
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

    @Override
    public void creationDepuisPannier(Client client, Panier new_commande){

        Commande commande = new Commande();
        commande.setPrixCommande( new_commande.getPrix() );
        commande.setAdressePostaleCommande( client.getAdressePostaleClient() );
        commande.setDateCommande( new Date() );
        commande.setIdClient( client.getIdClient() );
        commande.setEtatCommande( CommandeEnum.EN_COUR.getValue() );

        em.persist(commande);
        
/*        for ( PanierStruct panierStruct : new_commande.getListLivre() ) {
         
            ContenuCommande contenu = new ContenuCommande(panierStruct.livre.getIdLivre(), commande.getIdCommande() );
            contenu.setNombre( panierStruct.ajoutNbPanier );
            em.persist(contenu);
        }
*/
    }    
}
