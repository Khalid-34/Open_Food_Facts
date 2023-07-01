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
    public long save(Additif additif) throws Exception {

    em.persist(additif);


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
        return 0;
    }
}
