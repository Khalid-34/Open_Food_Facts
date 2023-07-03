package implement;

import dao.IAllergieDAO;
import entities.Allergie;
import jakarta.persistence.EntityManager;

import java.util.List;

/**
 * @author kone mamoudou et khalid
 * Class qui implement l'interface allergieDao
 * Role:
 * gestions des requêtes vers la bdd
 */
public class AllergieDaoImp extends AbstractDAO implements IAllergieDAO {
    //-------------{ ATTRIBUT }----------------//
    private EntityManager em;

    //-------------{ CONSTRUCTOR }----------------//

    public AllergieDaoImp(EntityManager em) {
        this.em = em;
    }
    //-------------{ METHODS }----------------//

    @Override
    public List<Allergie> getAll() throws Exception {
        return null;
    }

    /**
     * Insertion bdd et verification du nom avant l'envoi dans la bdd
     *
     * @param allergie
     * @return
     * @throws Exception
     */

    @Override
    public void save(Allergie allergie) throws Exception {

        em.persist(allergie);
    }

}
