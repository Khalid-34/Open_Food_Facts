package implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
/**
 * @author kone mamoudou et khalid
 * Class abstrait
 * Role:
 * Creation de Entity manager
 */
public class AbstractDAO {

    //-------------{ ATTRIBUT }----------------//
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("openfood");;

}
