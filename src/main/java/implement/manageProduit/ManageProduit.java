package implement.manageProduit;

import entities.Category;
import entities.Ingredient;
import entities.Produit;
import implement.AbstractDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Root;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        //TODO  Afficher les noms  d' ingrédients  les plus courant





/*    public List<Ingredient> getMostCommonAttributeValues() {
        String jpql = "SELECT i FROM Ingredient i JOIN i.produits p GROUP BY i.id ORDER BY COUNT(p) DESC";
        TypedQuery<Ingredient> query = em.createQuery(jpql, Ingredient.class);
        List<Ingredient> ingredients = query.getResultList();
        return ingredients;
    }
    */

    public <T> List<T> getMostCommonAttributeValues(Class<T> entityClass) {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e JOIN e.produits a GROUP BY e.id ORDER BY COUNT(a) DESC";
        TypedQuery<T> query = em.createQuery(jpql, entityClass);
        List<T> results = query.getResultList();
        return results;
    }

    /**
     * Utilisation de la reflexion pour obtenir le getter
     * @param entityClass
     * @param n
     * @param <T>
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public <T> void getStringMost(Class<T> entityClass, int n) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<T> produitList = getMostCommonAttributeValues(entityClass);

        List<String> listNom = new ArrayList<>();
        for (T element: produitList) {

            Method getNom = entityClass.getMethod("getNom");
            String produit = (String) getNom.invoke(element);
            listNom.add(produit);
        }
        List<String> nomsIngredientsDistincts = listNom.stream()
                .distinct()
                .limit(10)
                .collect(Collectors.toList());
        for (String str: nomsIngredientsDistincts) System.out.println(str);
    }

}
