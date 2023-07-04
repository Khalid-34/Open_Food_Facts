package implement;

import dao.ICategoryDAO;
import entities.Category;
import jakarta.persistence.EntityManager;

import java.util.List;
/**
 * @author kone mamoudou et khalid
 *classe fille de AbstractDao
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

    /**
     * Insertion bdd et verification du nom avant l'envoi dans la bdd
     *
     * @param category
     * @return
     * @throws Exception
     */
    @Override
    public void save(Category category) throws Exception {
        em.persist(category);

    }

    @Override
    public Category findByNom(Category category, String n) throws Exception {
        return null;
    }

}
