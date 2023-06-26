import entities.Category;
import entities.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {


    private static final Logger LOGGER = LoggerFactory.getLogger("monLogger");
    public static void main(String[] args) {
        LOGGER.warn(" Log  _____________________________________________________________________________________________________");


        try(
                // create entity manager factory
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
                //  create entity factory
                EntityManager entityManager = entityManagerFactory.createEntityManager() ) {

            // start transaction
            entityManager.getTransaction().begin();

            //create cate

            Category category = new Category();
            category.setNom("catenew");

            //
            Produit produit = new Produit();
            produit.setNom("maison");
            produit.setCategory(category);

            entityManager.persist(produit);
            entityManager.persist(category);


            entityManager.getTransaction().commit();

        }

    }
}
