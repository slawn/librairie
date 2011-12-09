/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package categorie;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Treemo
 */
@Remote
public interface CategorieManagerBean {

    /**
     * recupere un object Categorie depuis sont ID
     *
     * @param id
     * @return Categorie
     */
    public Categorie getCategorieById(int id);

    /**
     *  recupere la liste des Categorie
     *
     *  @return List<Categorie>
     */
    public List<Categorie> getCategorieList();

    /**
     * ajout d'une Categorie
     *
     * @param categorie
     */
    public void addCategory(Categorie categorie);

    /**
     * suppression d'une categorie
     *
     * @param categorie
     */
    public void deleteCategory(Categorie categorie);

    /**
     * met a jour une Categorie
     *
     * @param categorie
     */
    public void updateCategory(Categorie categorie);
}
