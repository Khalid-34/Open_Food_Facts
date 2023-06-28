import dao.*;
import entities.Additif;
import entities.Allergie;
import entities.Ingredient;
import entities.Produit;
import implement.*;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConsoleColors;
import utils.ReadCsv;
import utils.TimeChrono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class App {


    private static final Logger LOGGER = LoggerFactory.getLogger("monLog");
    public static void main(String[] args) throws Exception {
        System.out.println(ConsoleColors.BLUE + "RED COLORED" + " Log  ________________________________________________________");
        System.out.println("coucou");
        System.out.println(ConsoleColors.BLUE+"RED COLORED" + " Log  ________________________________________________________");


        EntityManager em = AbstractDAO.emf.createEntityManager();
        ReadCsv read = new ReadCsv();
        List<Produit> produits = read.listOfProduit();

        IProduitDAO produitDAO = new ProduitDaoImp(em);
        ICategoryDAO categoryDAO = new CategorieDaoImp(em);
        IIngredientDAO ingredientDAO = new IngredientDaoImp(em);
        IAllergieDAO  allergieDAO = new AllergieDaoImp(em);
        IMarqueDAO marqueDAO = new MarqueDaoImp(em);
        IAdditifDAO additifDAO = new AdditifDaoImp(em);

        em.getTransaction().begin();
        long a = System.currentTimeMillis();

        // Insertion dans la base de donnée Category
        for( Produit produit: produits){
            categoryDAO.save(produit.getCategory());
            marqueDAO.save(produit.getMarque());

            for (Ingredient ing: produit.getIngredients()){
                int length = ing.getNom().length();
                if(length > 1 && length <= 200) ingredientDAO.save(ing);
            }
            for (Allergie al: produit.getAllergie()){
                allergieDAO.save(al);
            }
            for (Additif ad: produit.getAdditif()){
                additifDAO.save(ad);
            }

            produitDAO.save(produit);
        }
        long b = System.currentTimeMillis();
        long r = (a - b );
        System.out.println(ConsoleColors.GREEN_BOLD + "nb produit = " + produits.size() + "temps de traitement = " + TimeChrono.millisecondsToTime(r));


        em.getTransaction().commit();
        em.close();



    }
}
