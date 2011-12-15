/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commande;

import panier.Panier;
import session.SessionUtilisateur;

/**
 *
 * @author edge
 */
public class Payement {

        public String remboursement( Commande la_commande, Panier le_pannier){
            String message="L'anulation de votre commande n°"+la_commande.getIdCommande()+" a bien été pris en compte. Vous allez donc etre remboursé de totalité de la somme suivante : "+le_pannier.getPrix()+" €";

            return message;
        }

    public boolean payer(SessionUtilisateur session, float prix, String typeCarte, String numCarte, String moisExpiration, String anneeExpiration, String cvv) {

        
        if ( numCarte == null || numCarte.isEmpty() ) {

            session.addErreur("Numéro de carte vide");
            return false;
        }
        
        if ( cvv == null || cvv.isEmpty() ) {

            session.addErreur("Code CVV2 vide");
            return false;
        }

        if ( !cbValide(typeCarte, numCarte, moisExpiration, anneeExpiration, cvv) ) {

            session.addErreur("Carte bancaire invalide");
            return false;
        }

        // payement validé par la banque ?
        if ( true ) {


            return true;
        }

        return false;
    }

    private boolean cbValide(String typeCarte, String numCarte, String moisExpiration, String anneeExpiration, String cvv) {

        try {

             double i = Double.parseDouble( numCarte );

             if ( i >= 1000000000000L && i < 10000000000000L )
                 return true;
             
        } catch ( NumberFormatException e ) {

             return false;
        }

        return false;
    }

}
