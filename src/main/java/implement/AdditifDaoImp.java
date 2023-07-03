package implement;

import dao.IAdditifDAO;
import entities.Additif;
import jakarta.persistence.EntityManager;

import java.util.List;

/**
 * @author kone mamoudou et khalid
 * Class qui implement l'interface additifDao
 * Role :
 * gestions des requêtes vers la bdd
 */

public class AdditifDaoImp extends AbstractDAO implements IAdditifDAO {

    //-------------{ ATTRIBUT }----------------//
    private EntityManager em;

    //-------------{ CONSTRUCTOR }----------------//


    public AdditifDaoImp(EntityManager em) {
        this.em = em;
    }

    //-------------{ METHODS }----------------//
    @Override
    public List<Additif> getAll() throws Exception {
        return null;
    }

    /**
     * Insertion bdd et verification du nom avant l'envoi dans la bdd
     *
     * @param additif
     * @return
     * @throws Exception
     */
    @Override
    public void save(Additif additif) throws Exception {

    em.persist(additif);

    }
}
