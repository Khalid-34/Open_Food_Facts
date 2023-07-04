package implement.manageProduit;

import entities.Produit;
import implement.AbstractDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 * Role :
 * requete et gestions des produits
 */

public class ManageProduit extends AbstractDAO {
    EntityManager em = AbstractDAO.emf.createEntityManager();
    public ManageProduit(EntityManager em) {this.em = em;}

    //TODO Rechercher les N meilleurs produits pour une marque donnée
    public List<Produit> searchBestProduct(String marque, int n) {

        String jpql = "SELECT p FROM Produit p JOIN p.marque m WHERE m.nom = :marque AND p.grade = 'a'";
        TypedQuery<Produit> query = em.createQuery(jpql, Produit.class);
        query.setParameter("marque", marque);
        query.setMaxResults(n);
        List<Produit> listP = query.getResultList();

        return listP;
    }

    //TODO Rechercher les N meilleurs produits pour une catégorie donnée


    //TODO Rechercher les N meilleurs produits par marque et catégorie


    //TODO  Afficher les N ingrédients les plus courants


    //TODO Afficher les N allergènes les plus courants


    //TODO Afficher les N additifs les plus courants
}
