package implement;

import dao.IProduitDAO;
import entities.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 *
 */
public class ProduitDaoImp extends AbstractDAO implements IProduitDAO {
    //-------------{ ATTRIBUT }----------------//

    private EntityManager em;

    //-------------{ CONSTRUCTOR }----------------//

    public ProduitDaoImp(EntityManager em) {
        this.em = em;
    }
    //-------------{ METHODS }----------------//
    @Override
    public List<Produit> getAll() {
       return null;
    }

    @Override
    public void save(Produit produit) {

        em.persist(produit);
    }
}
