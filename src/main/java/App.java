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



        int i =0;
        int contIng = 0;
        int contAl = 0;
        int contAd = 0;

        long a = System.currentTimeMillis();


        for( Produit produit: produits){

            em.getTransaction().begin();


            Marque marqueObj = produit.getMarque();
            Category categoryObj = produit.getCategory();
            Set<Additif> additifList =  produit.getAdditif();
            Set<Allergie> allergieList = produit.getAllergie();
            Set<Ingredient> ingredientList = produit.getIngredients();


            i++;


            if(mapMarque.contains(marqueObj) ){

                Iterator<Marque> marqueIterator = mapMarque.iterator();
                while (marqueIterator.hasNext()){
                    Marque marqueNext = marqueIterator.next();
                    if(marqueNext.getId() == marqueObj.getId()){
                        marqueObj.setId(marqueNext.getId());
                    }
                }

            }else {
                System.out.println(ConsoleColors.CYAN + "insertion ***********************************************" + i);
                mapMarque.add(marqueObj);
                marqueDAO.save(marqueObj);

            }

            // Category


            if(mapCategory.contains(categoryObj) ){

                Iterator<Category> categorieIterator = mapCategory.iterator();
                while (categorieIterator.hasNext()){
                    Category categoryNext = categorieIterator.next();
                    if(categoryNext.getId() == categoryObj.getId()){
                        categoryObj.setId(categoryNext.getId());
                    }
                }

                System.out.println(ConsoleColors.GREEN_BOLD + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);

            }else {
                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + i);
                mapCategory.add(categoryObj);
                categoryDAO.save(produit.getCategory());

            }

/*
            produitDAO.save(produit);
*/


            // allergie

            for (Allergie al: allergieList){
                contAl ++;

                if(mapAllergie.contains(al) ){

                    Iterator<Allergie> allergieIterator = mapAllergie.iterator();
                    while (allergieIterator.hasNext()){
                        Allergie allergieNext = allergieIterator.next();
                        if(allergieNext.getId() == al.getId()){
                            al.setId(allergieNext.getId());
                        }
                    }
                    System.out.println(ConsoleColors.PURPLE + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                }else {
                    System.out.println(ConsoleColors.PURPLE_BOLD + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    mapAllergie.add(al);
                    allergieDAO.save(al);
                }

            }

            for (Additif ad: additifList){
                contAd ++;


                if(mapAdditif.contains(ad) ){

                    Iterator<Additif> additifIterator = mapAdditif.iterator();
                    while (additifIterator.hasNext()){
                        Additif adNext = additifIterator.next();
                        if(adNext.getId() == ad.getId()){
                            ad.setId(adNext.getId());
                        }
                    }
                    System.out.println(ConsoleColors.RED + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );

                }else {
                    System.out.println(ConsoleColors.RED_BOLD + "presnt!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    mapAdditif.add(ad);
                    additifDAO.save(ad);
                }

            }


            for (Ingredient ing: ingredientList){
                contIng ++;

                if(mapIngredient.contains(ing) ){
                    Iterator<Ingredient> ingIterator = mapIngredient.iterator();
                    while (ingIterator.hasNext()){
                        Ingredient ingNext = ingIterator.next();
                        if(ingNext.getId() == ing.getId()){
                            ing.setId(ingNext.getId());
                        }
                    }

                    System.out.println(ConsoleColors.YELLOW + "INGREDIENT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                }else {
                    System.out.println(ConsoleColors.YELLOW_BOLD + " INGREDIENT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    mapIngredient.add(ing);
                    ingredientDAO.save(ing);
                }

            }


/*            if(mapProduit.size() == 0 ){

                mapProduit.add(produit);
            }
            if(mapProduit.contains(produit) ){

                Iterator<Produit> prodIterator = mapProduit.iterator();
                while (prodIterator.hasNext()){
                    Produit produitNext = prodIterator.next();
                    if(produitNext.getId() == produit.getId()){
                        produit.setId(produitNext.getId());
                    }
                }

            }else {
                System.out.println(ConsoleColors.CYAN + "insertion ***********************************************" + i);
                mapProduit.add(produit);
                produitDAO.save(produit);
            }*/
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