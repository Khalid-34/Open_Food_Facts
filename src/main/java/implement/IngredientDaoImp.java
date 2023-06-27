package implement;

import dao.IIngredientDAO;
import entities.Ingredient;
import jakarta.persistence.EntityManager;

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

    @Override
    public void save(Ingredient ingredient) throws Exception {
        em.persist(ingredient);
    }
}
