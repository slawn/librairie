/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package panier;

import java.util.ArrayList;
import livre.Livre;
import livre.LivreManagerBean;
import session.SessionUtilisateur;

/**
 *
 * @author edge
 */
public class Panier {

    private ArrayList<PanierStruct> articleList = new ArrayList<PanierStruct>();
    private float prix;


    public ArrayList<PanierStruct>getListLivre(){

        return articleList;
    }

    public float getPrix(){

        return prix;
    }

    public void calculPrix(){

        prix = 0;

        for(PanierStruct article : articleList)
            prix += article.ajoutNbPanier * article.livre.getPrixLivre();
    }

    /**
     * ajoute un livre au pannier
     * 
     * @param livre
     * @param ajoutNbPanier
     * @return nombre ajout
     */
    public int addLivre(SessionUtilisateur session, Livre livre, int ajoutNbPanier) {

        PanierStruct article = null;

        if ( livre.getNombreStockLivre() < ajoutNbPanier) {

            int vieuAjoutNbPanier = ajoutNbPanier;
            ajoutNbPanier = livre.getNombreStockLivre();

            session.addErreur("Nombre de livre insuffisant ("+ajoutNbPanier+" ajouté au lieu de "+vieuAjoutNbPanier+")");
        }

        livre.setNombreStockLivre( livre.getNombreStockLivre() - ajoutNbPanier );
        livre.setNombreVenteLivre( livre.getNombreVenteLivre() + ajoutNbPanier );

        for( PanierStruct articleItr : articleList) {

            if ( articleItr.livre.equals(livre) ) {

                article = articleItr;
                article.ajoutNbPanier += ajoutNbPanier;

                calculPrix();
                return ajoutNbPanier;
            }
        }

        article = new PanierStruct();
        article.ajoutNbPanier = ajoutNbPanier;
        article.livre = livre;
        articleList.add(article);
        calculPrix();

        return ajoutNbPanier;
    }
    
    public int suppressionLivre(Livre livre, int ajoutNbPanier) {

        return 0;
    }

    public void payement(){

    }

    /**
     * pannier vide ?
     * @return boolean
     */
    public boolean isEmpty() {

        return articleList.isEmpty();
    }
}
