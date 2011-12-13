/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package livre;

import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Treemo
 */
@Stateful
public class LivreManager implements LivreManagerBean {

    @PersistenceContext(unitName="bsPU")
    EntityManager em;

    /**
     *
     * recupere les livre de la categorie
     *
     * @param categorieId
     * @param page
     * @param nombre
     * @return
     */
    @Override
    public List<Livre> getLivreByCategorie(int categorieId, int page, int nombre) {

        page--;

        String q= "SELECT l FROM Livre l WHERE l.idCategorie = :categorieId ";
        Query query = em.createQuery(q);
        query.setParameter("categorieId", categorieId);
        query.setFirstResult(page * nombre);
        query.setMaxResults(nombre);
        return query.getResultList();
    }

    /**
     * recherche un livre
     *
     * @param pattern
     * @return Livre
     */
    @Override
    public List<Livre> recherche(String pattern) {

        pattern="%"+pattern+"%";//pour retrouver les livres qui contiennent le motif dans leur titre
        String q= "SELECT b From Livre b where b.titreLivre LIKE :pattern";
        Query query = em.createQuery(q);
        query.setParameter("pattern", pattern);
        return query.getResultList();
    }

    /**
     * recupere un livre via son id
     *
     * @param id
     * @return Livre
     */
    @Override
    public Livre getLivreById(int id) {

        return em.find(Livre.class,id);
    }

    /**
     * recuprer le "top vente"
     *
     * @param nombre
     * @return
     */
    @Override
    public List<Livre> getLivreByMostVente(int nombre) {

        String q = "SELECT l FROM Livre l ORDER BY l.nombreVenteLivre DESC";
        Query query = em.createQuery(q);
        query.setMaxResults(nombre);
        return query.getResultList();
    }

    /**
     * retour les livre en rupture de stock
     *
     * @return
     */
    @Override
    public List<Livre> getLivreByEnRupture() {

        String q = "SELECT l FROM Livre l WHERE l.nombreStockLivre < 1";
        Query query = em.createQuery(q);
        return query.getResultList();
    }

    /**
     * ajoute un livre
     *
     * @param livre
     */
    @Override
    public void addLivre(Livre livre) {

         em.persist(livre);
    }

    /*
     * sauvegarde un livre
     *
     * @param livre
     */
    @Override
    public void updateLivre(Livre livre) {

        em.merge(livre);
    }

    /**
     * suprime un livre
     *
     * @param livre
     */
    @Override
    public void delLivre(Livre livre) {

         em.remove(livre);
    }
}
