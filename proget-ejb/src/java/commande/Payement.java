/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commande;

import pannier.Pannier;

/**
 *
 * @author edge
 */
public class Payement {

        public String remboursement( Commande la_commande, Pannier le_pannier){
            String message="L'anulation de votre commande n°"+la_commande.getIdCommande()+" a bien été pris en compte. Vous allez donc etre remboursé de totalité de la somme suivante : "+le_pannier.get_prix()+" €.  ALORS ARRETE DE NOUS FAIRE CHIER ENCULé DE FILS DE PUTE";

            return message;
        }

        public boolean payer(String champ_CB){
            boolean paiement_ok,cb_ok;

            cb_ok=cbValider(champ_CB);
            if(cb_ok)
            {
                paiement_ok=true;
            }
            else
            {
                paiement_ok=false;
            }
            return paiement_ok;
        }

        public boolean cbValider(String codeCB){
            boolean valide;
            int taille=codeCB.length();

            if(taille==10)
            {
                valide=true;
            }
            else
            {
                valide=false;
            }
            return valide;
        }

}
