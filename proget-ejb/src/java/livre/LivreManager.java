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
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @PersistenceContext(unitName="bsPU")
    EntityManager em;

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

    @Override
    public List<Livre> recherche(String pattern) {

        pattern="%"+pattern+"%";//pour retrouver les livres qui contiennent le motif dans leur titre
        String q= "SELECT b From Livre b where b.titreLivre LIKE :pattern";
        Query query = em.createQuery(q);
        query.setParameter("pattern", pattern);
        return query.getResultList();
    }

    @Override
    public Livre getLivreById(int id) {

        return em.find(Livre.class,id);
    }

    @Override
    public List<Livre> getLivreByMostVente(int nombre) {

        String q = "SELECT l FROM Livre l ORDER BY l.nombreVenteLivre DESC";
        Query query = em.createQuery(q);
        query.setMaxResults(nombre);
        return query.getResultList();
    }

    @Override
    public List<Livre> getLivreByEnRupture() {

        String q = "SELECT l FROM Livre l WHERE l.nombreStockLivre < 1";
        Query query = em.createQuery(q);
        return query.getResultList();
    }

    @Override
    public void addLivre(Livre livre) {

         em.persist(livre);
    }

    @Override
    public void updateLivre(Livre livre) {

        em.merge(livre);
    }

    @Override
    public void delLivre(Livre livre) {

         em.remove(livre);
    }
    
}
