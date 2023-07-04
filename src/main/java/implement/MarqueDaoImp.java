package implement;

import dao.IMarqueDAO;
import entities.Additif;
import entities.Marque;
import jakarta.persistence.Cache;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
    public void save(Marque marque) throws Exception {
        em.persist(marque);
    }


    @Override
    public Marque findByNom(Marque marque, String nom) throws Exception {
        TypedQuery<Marque> query = em.createQuery("FROM Produit WHERE nom=:nom AND marque=:marque ", Marque.class);
        query.setParameter("nom",nom);
        query.setParameter("marque",marque);

        List<Marque> results = query.getResultList();
        if(results != null) return results.get(0);
        return null;

    }


}
