/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commande;

import java.util.List;
import javax.ejb.Local;
import utilisateur.Client;

/**
 *
 * @author Treemo
 */
@Local
public interface CommandeManagerBean {
   

    
    public List<Commande> commandeList(Client client);

    public commande.Commande getCommandeById(int id);

    public void creationDepuisPannier(pannier.Pannier new_commande);

}
