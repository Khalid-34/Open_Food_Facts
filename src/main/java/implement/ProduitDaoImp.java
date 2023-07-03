package implement;

import dao.IProduitDAO;
import entities.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.ConsoleColors;

import java.util.List;
/**
 * @author kone mamoudou et khalid
 * Class fille AsbractDao
 * Class qui implement l'interface ProduitDao
 * Role:
 * gestions des requêtes vers la bdd
 */
public class ProduitDaoImp extends AbstractDAO implements IProduitDAO {
    //-------------{ ATTRIBUT }----------------//

    private EntityManager em;

    //-------------{ CONSTRUCTOR }----------------//

    public ProduitDaoImp(EntityManager em) {
        this.em = em;
    }
    //-------------{ METHODS }----------------//
    @Override
    public List<Produit> getAll() {
       return null;
    }

    @Override
    public void save(Produit produit) {

        Query query = em.createQuery("SELECT p FROM Produit p WHERE p.nom = ?1");
        query.setParameter(1, produit.getNom());
        query.setMaxResults(1);
        List<Produit> produitDb = query.getResultList();
        if (produitDb == null || produitDb.isEmpty()) {
            System.out.println(ConsoleColors.YELLOW + "ELESE");

            em.persist(produit);

        } else {
            System.out.println(ConsoleColors.PURPLE + "ELESE");
            produit.setId(produitDb.get(0).getId());
        }
    }
}
