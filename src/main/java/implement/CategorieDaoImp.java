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
    public long save(Category category) throws Exception {
        em.persist(category);

/*
        Cache cache = emf.getCache();
        if(cache.contains(Category.class,1L)){
            System.out.println(ConsoleColors.GREEN_BOLD + "contain" + category.getNom());
        }else {
            em.persist(category);
        }
*/

/*        Query query = em.createQuery("SELECT c FROM Category c WHERE c.nom = ?1");
        query.setParameter(1, category.getNom());
        query.setMaxResults(1);
        List<Category> categorieDB = query.getResultList();
        if (categorieDB == null || categorieDB.isEmpty()) {
            em.persist(category);
        } else {
            category.setId(categorieDB.get(0).getId());
        }*/

        return 0;
    }



}
