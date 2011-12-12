/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commande;

import javax.ejb.Local;

/**
 *
 * @author Treemo
 */
@Local
public interface CommandeManagerBean {
   

    
    public java.util.List<commande.Commande> commandeList(lib.Utilisateur client);

    public commande.Commande getCommandeById(int id);

    public void creationDepuisPannier(pannier.Pannier new_commande);

}
