package implement;

import dao.IIngredientDAO;
import entities.Ingredient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class IngredientDaoImp extends AbstractDAO implements IIngredientDAO {
    //-------------{ ATTRIBUT }----------------//
    private EntityManager em;
    //-------------{ CONSTRUCTOR }----------------//

    public IngredientDaoImp(EntityManager em) {
        this.em = em;
    }
    //-------------{ METHODS }----------------//

    @Override
    public List<Ingredient> getAll() throws Exception {
        return null;
    }

    /**
     * Insertion bdd et verification du nom avant l'envoi dans la bdd
     * @param ingredient
     * @throws Exception
     */
    @Override
    public void save(Ingredient ingredient) throws Exception {
        em.persist(ingredient);
    }
/*        Query query = em.createQuery("SELECT i FROM Ingredient i WHERE i.nom = ?1");
        query.setParameter(1, ingredient.getNom());
        query.setMaxResults(1);
        List<Ingredient> ingredientDB = query.getResultList();
        if (ingredientDB == null || ingredientDB.isEmpty()) {
            em.persist(ingredient);
        } else {
            ingredient.setId(ingredientDB.get(0).getId());
        }
    }*/
}
