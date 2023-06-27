package implement;

import dao.ICategoryDAO;
import entities.Category;
import jakarta.persistence.EntityManager;

import java.util.List;
/**
 * @author kone mamoudou et khalid
 * Class qui implement l'interface CategorieDao
 * Role:
 * gestions des requêtes vers la bdd
 */
public class CategorieDaoImp extends AbstractDAO implements ICategoryDAO {
    //-------------{ ATTRIBUT }----------------//
    private EntityManager em;

    //-------------{ CONSTRUCTOR }----------------//

    public CategorieDaoImp(EntityManager em) {
        this.em = em;
    }

    //-------------{ METHODS }----------------//
    @Override
    public List<Category> getAll() throws Exception {
        return null;
    }

    @Override
    public void save(Category category) throws Exception {
        em.persist(category);
    }



}
