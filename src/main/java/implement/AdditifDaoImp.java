package implement;

import dao.IAdditifDAO;
import entities.Additif;
import jakarta.persistence.Cache;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utils.ConsoleColors;

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
     * @param additif
     * @throws Exception
     */
    @Override
    public void save(Additif additif) throws Exception {

        Cache cache = emf.getCache();
        if(cache.contains(Additif.class,1L)){
            System.out.println(ConsoleColors.GREEN_BOLD + "contain" + additif.getNom());
        }
/*
        Query query = em.createQuery("SELECT a FROM Additif a WHERE a.nom = ?1");
        query.setParameter(1, additif.getNom());
        query.setMaxResults(0);
        List<Additif> additifDB = query.getResultList();
        if (additifDB == null || additifDB.isEmpty()) {
            em.persist(additif);
        } else {
            additif.setId(additifDB.get(0).getId());
        }*/
    }
}
