package implement;

import dao.IMarqueDAO;
import entities.Additif;
import entities.Marque;
import jakarta.persistence.Cache;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.ConsoleColors;

import java.util.List;
import java.util.Objects;

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

    /**
     * Insertion bdd et verification avant l'envois dans la bdd
     * @param marque
     * @throws Exception
     */
    @Override
    public long save(Marque marque) throws Exception {
        em.persist(marque);
        return  marque.getId();

/*        Cache cache = emf.getCache();
        if(cache.contains(Marque.class,1L)){
            System.out.println(ConsoleColors.GREEN_BOLD + "contain" + marque.getNom());
        }else {
            em.persist(marque);
        }*/
/*        Query query = em.createQuery("SELECT m FROM Marque m WHERE m.nom = ?1");
        query.setParameter(1, marque.getNom());
        query.setMaxResults(1);
        List<Marque> marqueDB = query.getResultList();
        if (marqueDB == null || marqueDB.isEmpty()) {
            em.persist(marque);
        } else {
            marque.setId(marqueDB.get(0).getId());
        }*/

    }




}
