import dao.*;
import entities.Additif;
import entities.Allergie;
import entities.Ingredient;
import entities.Produit;
import implement.*;
import jakarta.persistence.Cache;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConsoleColors;
import utils.ReadCsv;
import utils.TimeChrono;
import utils.TraitementInsert;

import java.util.HashSet;
import java.util.List;

public class App {


    private static final Logger LOGGER = LoggerFactory.getLogger("monLog");
    public static void main(String[] args) throws Exception {


        EntityManager em = AbstractDAO.emf.createEntityManager();
        Cache cache = AbstractDAO.emf.getCache();

        ReadCsv read = new ReadCsv();
        List<Produit> produits = read.listOfProduit();

        IProduitDAO produitDAO = new ProduitDaoImp(em);
        ICategoryDAO categoryDAO = new CategorieDaoImp(em);
        IIngredientDAO ingredientDAO = new IngredientDaoImp(em);
        IAllergieDAO  allergieDAO = new AllergieDaoImp(em);
        IMarqueDAO marqueDAO = new MarqueDaoImp(em);
        IAdditifDAO additifDAO = new AdditifDaoImp(em);


        HashSet<String> mapMarque = new HashSet<>();
        HashSet<String> mapCategory = new HashSet<>();
        HashSet<String> mapIngredient = new HashSet<>();
        HashSet<String> mapAllergie = new HashSet<>();
        HashSet<String> mapAdditif = new HashSet<>();



        int i =0;
        int contIng = 0;
        int contAl = 0;
        int contAd = 0;

        em.getTransaction().begin();
        long a = System.currentTimeMillis();

        // Insertion dans la base de donnée Category
        for( Produit produit: produits){
/*            i++;


            if(mapMarque.size() == 0 ){

                mapMarque.contains(produit.getMarque().getNom());

            }
            if(mapMarque.contains(produit.getMarque().getNom()) ){
                System.out.println(ConsoleColors.BLUE + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);

            }else {
                System.out.println(ConsoleColors.CYAN + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);
                mapMarque.add(produit.getMarque().getNom());
                long id = marqueDAO.save(produit.getMarque());
                System.out.println(ConsoleColors.GREEN_BOLD + "indentité ==== "+ id) ;


            }*/
            TraitementInsert.verifyBeforeSend(produit.getMarque(),marqueDAO,"getNom",mapMarque);


            TraitementInsert.verifyBeforeSend(produit.getCategory(),categoryDAO,"getNom",mapCategory);
/*
            if(mapCategory.size() == 0 ){

                mapCategory.contains(produit.getCategory().getNom());
            }
            if(mapCategory.contains(produit.getCategory().getNom()) ){
                System.out.println(ConsoleColors.GREEN_BOLD + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);

            }else {
                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);
                mapCategory.add(produit.getCategory().getNom());
                categoryDAO.save(produit.getCategory());
            }





            for (Allergie al: produit.getAllergie()){
                contAl ++;

                if(mapAllergie.size() == 0 ){

                    mapAllergie.contains(al.getNom());
                }
                if(mapAllergie.contains(al.getNom()) ){
                    System.out.println(ConsoleColors.PURPLE + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);

                }else {
                    System.out.println(ConsoleColors.PURPLE_BOLD + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);
                    mapAllergie.add(al.getNom());
                    allergieDAO.save(al);
                }

            }

            for (Additif ad: produit.getAdditif()){
                contAd ++;

                if(mapAdditif.size() == 0 ){

                    mapAdditif.contains(ad.getNom());
                }
                if(cache.contains(Additif.class,1L)){
                    System.out.println(ConsoleColors.RED + "il es en cache ___________________________________________________________" + i);

                }else {

                    System.out.println(ConsoleColors.RED_BOLD + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);
                    mapAdditif.add(ad.getNom());
                    additifDAO.save(ad);
                }

            }*/
/*            for (Ingredient ing: produit.getIngredients()){
                contIng ++;

                if(mapIngredient.size() == 0 ){

                    mapIngredient.add(ing.getNom());
                }
                if(mapIngredient.contains(ing.getNom()) ){
                    System.out.println(ConsoleColors.YELLOW + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);

                }else {
                    System.out.println(ConsoleColors.YELLOW_BOLD + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);
                    mapIngredient.add(ing.getNom());
                    ingredientDAO.save(ing);
                }

            }*/


/*            categoryDAO.save(produit.getCategory());
            marqueDAO.save(produit.getMarque());


            for (Allergie al: produit.getAllergie()){
                allergieDAO.save(al);
            }
            for (Additif ad: produit.getAdditif()){
                additifDAO.save(ad);
            }*/

  /*      produitDAO.save(produit);
*/
        }
        em.getTransaction().commit();
        em.close();

        long b = System.currentTimeMillis();
        long r = (a - b ) /1000;

        System.out.println("temps " + r);
        System.out.println(contIng + " cont ingredient \n " + "allergie =" + ConsoleColors.RED_BOLD + contAl +"\n"+ ConsoleColors.YELLOW_BOLD_BRIGHT + contAd);
        System.out.println(ConsoleColors.GREEN_BOLD + "nb produit = " + produits.size() + "temps de traitement = " + TimeChrono.millisecondsToTime(r));


    }


}
