import dao.*;
import entities.*;
import implement.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Int;
import utils.ConsoleColors;
import utils.ReadCsv;
import utils.TimeChrono;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger("monLog");
    public static void main(String[] args) throws Exception {


        EntityManager em = AbstractDAO.emf.createEntityManager();
        ReadCsv read = new ReadCsv();
        List<Produit> produits = read.listOfProduit();

        IProduitDAO produitDAO = new ProduitDaoImp(em);
        ICategoryDAO categoryDAO = new CategorieDaoImp(em);
        IIngredientDAO ingredientDAO = new IngredientDaoImp(em);
        IAllergieDAO  allergieDAO = new AllergieDaoImp(em);
        IMarqueDAO marqueDAO = new MarqueDaoImp(em);
        IAdditifDAO additifDAO = new AdditifDaoImp(em);


        HashSet<Marque> mapMarque = new HashSet<>();
        HashSet<Category> mapCategory = new HashSet<>();
        HashSet<Ingredient> mapIngredient = new HashSet<>();
        HashSet<Allergie> mapAllergie = new HashSet<>();
        HashSet<Additif> mapAdditif = new HashSet<>();
        HashSet<Produit> mapProduit = new HashSet<>();



        int i =0;
        int contIng = 0;
        int contAl = 0;
        int contAd = 0;

        long a = System.currentTimeMillis();




        // Insertion dans la base de donnée Category
        for( Produit produit: produits){
            em.getTransaction().begin();


            Marque marqueObj = produit.getMarque();
            Category categoryObj = produit.getCategory();
            Set<Additif> additifList =  produit.getAdditif();
            Set<Allergie> allergieList = produit.getAllergie();
            Set<Ingredient> ingredientList = produit.getIngredients();




            i++;

            if(mapMarque.size() == 0 ){

                mapMarque.add(marqueObj);
            }
            if(mapMarque.contains(marqueObj) ){

            }else {
                System.out.println(ConsoleColors.CYAN + "insertion ***********************************************" + i);
                mapMarque.add(marqueObj);
                marqueDAO.save(produit.getMarque());

            }

            if(mapCategory.size() == 0 ){

                mapCategory.contains(categoryObj);
            }
            if(mapCategory.contains(categoryObj) ){
                System.out.println(ConsoleColors.GREEN_BOLD + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);

            }else {
                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);
                mapCategory.add(categoryObj);
                categoryDAO.save(produit.getCategory());
                produitDAO.save(produit);

            }




            for (Allergie al: allergieList){
                contAl ++;

                if(mapAllergie.size() == 0 ){

                    mapAllergie.add(al);
                }
                if(mapAllergie.contains(al) ){
                    System.out.println(ConsoleColors.PURPLE + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);

                }else {
                    System.out.println(ConsoleColors.PURPLE_BOLD + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);
                    mapAllergie.add(al);
                    allergieDAO.save(al);
                }

            }

            for (Additif ad: additifList){
                contAd ++;

                if(mapAdditif.size() == 0 ){

                    mapAdditif.add(ad);
                }
                if(mapAdditif.contains(ad) ){
                    System.out.println(ConsoleColors.RED + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);

                }else {
                    System.out.println(ConsoleColors.RED_BOLD + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);
                    mapAdditif.add(ad);
                    additifDAO.save(ad);
                }

            }


            for (Ingredient ing: ingredientList){
                contIng ++;

                if(mapIngredient.size() == 0 ){

                    mapIngredient.add(ing);
                }
                if(mapIngredient.contains(ing) ){
                    System.out.println(ConsoleColors.YELLOW + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);

                }else {
                    System.out.println(ConsoleColors.YELLOW_BOLD + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);
                    mapIngredient.add(ing);
                    ingredientDAO.save(ing);
                }

            }
            em.getTransaction().commit();
        }
        em.close();



        long b = System.currentTimeMillis();
        long r = (a - b ) /1000;

        System.out.println("temps " + r);
        System.out.println(contIng + " cont ingredient \n " + "allergie =" + ConsoleColors.RED_BOLD + contAl +"\n"+ ConsoleColors.YELLOW_BOLD_BRIGHT + contAd);
        System.out.println(ConsoleColors.GREEN_BOLD + "nb produit = " + produits.size() + "temps de traitement = " + TimeChrono.millisecondsToTime(r));


    }
}