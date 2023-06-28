package implement;

import dao.IMarqueDAO;
import entities.Marque;
import jakarta.persistence.EntityManager;

import java.util.List;
/**
 * @author kone mamoudou et khalid
 * classe fille de AbstractDao
 * qui implement l'interface marqueDao
 * Role:
 * gestions des requêtes vers la bdd
 */

public class MarqueDaoImp extends AbstractDAO implements IMarqueDAO {
    //-------------{ ATTRIBUT }----------------//
    private EntityManager em;
    //-------------{ CONSTRUCTOR }----------------//

    public MarqueDaoImp(EntityManager em) {
        this.em = em;
    }
    //-------------{ METHODS }----------------//

    @Override
    public List<Marque> getAll() throws Exception {
        return null;
    }

    @Override
    public void save(Marque marque) throws Exception {
        em.persist(marque);
    }
}
