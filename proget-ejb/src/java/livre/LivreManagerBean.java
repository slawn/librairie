/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package livre;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Treemo
 */
@Local
public interface LivreManagerBean {

    /**
     *
     * recupere les livre de la categorie
     *
     * @param categorieId
     * @param page
     * @param nombre
     * @return
     */
    public List<Livre> getLivreByCategorie(int categorieId, int page, int nombre);

    /**
     * recherche un livre
     *
     * @param pattern
     * @return Livre
     */
    public List<Livre> recherche(String pattern);

    /**
     * recupere un livre via son id
     *
     * @param id
     * @return Livre
     */
    public Livre getLivreById(int id);

    /**
     * recuprer le "top vente"
     *
     * @param nombre
     * @return
     */
    public List<Livre> getLivreByMostVente(int nombre);

    /**
     * retour les livre en rupture de stock
     *
     * @return
     */
    public List<Livre> getLivreByEnRupture();

    /**
     * ajoute un livre
     *
     * @param livre
     */
    public void addLivre(Livre livre);

    /*
     * sauvegarde un livre
     *
     * @param livre
     */
    public void updateLivre(Livre livre);

    /**
     * suprime un livre
     *
     * @param livre
     */
    public void delLivre(Livre livre);
}
