/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package categorie;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Treemo
 */
@Stateful
public class CategorieManager implements CategorieManagerBean {
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    EntityManager em;

    /**
     * recupere un object Categorie depuis sont ID
     *
     * @param id
     * @return Categorie
     */
    public Categorie getCategorieById(int id) {

        return em.find(Categorie.class,id);
    }

    /**
     *  recupere la liste des Categorie
     *
     *  @return List<Categorie>
     */
    public List<Categorie> getCategorieList() {

        Query query = em.createNamedQuery("retrieveAllCategories");
        return query.getResultList();
    }

    /**
     * ajout d'une Categorie
     *
     * @param categorie
     */
    public void addCategory(Categorie categorie) {

        em.persist(categorie);
    }

    /**
     * suppression d'une categorie
     *
     * @param categorie
     */
    public void deleteCategory(Categorie categorie) {


        if(categorie!=null){

            em.remove(categorie);//supression de l'objet dans la base qd transaction executée qd méthode retourne)
        }
    }

    /**
     * met a jour une Categorie
     *
     * @param categorie
     */
    public void updateCategory(Categorie categorie) {

        em.merge(categorie);
    }
}
