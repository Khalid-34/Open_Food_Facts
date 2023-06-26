import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {



    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("food");
            EntityManager em = emf.createEntityManager()) {

            System.out.println(em+ "  je mes suis connecté à la bdd");


        }

    }
}
