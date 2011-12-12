/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pannier;

import java.util.List;
import livre.Livre;

/**
 *
 * @author edge
 */
public class Pannier {

    private List<Livre>articleList;
    private float prix;


    public List<Livre>getListLivre(){

        return this.articleList;
    }
    public void set_articleList(Livre livre_suivant){
        articleList.add(livre_suivant);
    }
    public float get_prix(){
        return this.prix;
    }
    public void set_prix(float le_prix){
        this.prix=le_prix;
    }

    public void addLivre(){

    }
    
    public void suppressionLivre(){

    }
    public void payement(){

    }

}
