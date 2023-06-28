package implement;

import dao.IAllergieDAO;
import entities.Allergie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

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
     * @param allergie
     * @throws Exception
     */

    @Override
    public void save(Allergie allergie) throws Exception {
        Query query = em.createQuery("SELECT a FROM Additif a WHERE a.nom = ?1");
        query.setParameter(1, allergie.getNom());
        query.setMaxResults(1);
        List<Allergie> additifDB = query.getResultList();
        if (additifDB == null || additifDB.isEmpty()) {
            em.persist(allergie);
        } else {
            allergie.setId(additifDB.get(0).getId());
        }
    }

}
