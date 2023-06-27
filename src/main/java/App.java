import entité.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {



    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("food");
            EntityManager em = emf.createEntityManager()) {

            System.out.println(em+ "  je mes suis connecté à la bdd");

            String csvFile = "src/main/java/csv/open-food-facts.csv";

            BufferedReader br = new BufferedReader(new FileReader(csvFile));

            String csvSplitBy = ",|%|\\(";
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                System.out.println(line);


                Category category = new Category();
                category.setNom(data[0]);


                em.getTransaction().begin();
                em.persist(category);
                em.getTransaction().commit();
            }




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
