package implement.manageProduit;

import entities.Category;
import entities.Produit;
import implement.AbstractDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Root;

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

    //TODO Rechercher les N meilleurs produits pour une catégorie donné
    public List<Produit> searchBestCategory(String category, int n) {

        String jpql = "SELECT p FROM Produit p JOIN p.category c WHERE c.nom = :category AND p.grade = 'a'";
        TypedQuery<Produit> query = em.createQuery(jpql, Produit.class);
        query.setParameter("category", category);
        query.setMaxResults(n);
        List<Produit> listC = query.getResultList();

        return listC;
    }



    //TODO Rechercher les N meilleurs produits par marque et catégorie

    public List<Produit> searchBestMarqueCat(String categorie,String marque, int nb){

        String jpql ="SELECT p FROM Produit p WHERE p.marque.nom = :marque AND p.category.nom = :categorie ORDER BY p.grade DESC";
        TypedQuery<Produit> query = em.createQuery(jpql, Produit.class);
        query.setParameter("marque", marque);
        query.setParameter("categorie", categorie);
        query.setMaxResults(nb);
        List<Produit> produits = query.getResultList();
        return  produits ;
    }


    //TODO  Afficher les N ingrédients les plus courants

    public <T,R> List<T> searchNCourant(Class<T> element, String elementNom){

        CriteriaBuilder criteriaBuild = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuild.createQuery(element);
        Root<T> root = criteriaQuery.from(element);
        criteriaQuery.select(root).groupBy(root.get(elementNom)).orderBy(criteriaBuild.desc( criteriaBuild.count(root.get(elementNom))));
        TypedQuery<T> query = em.createQuery(criteriaQuery);

        return query.getResultList();

    }




    //TODO Afficher les N allergènes les plus courants


    //TODO Afficher les N additifs les plus courants
}
