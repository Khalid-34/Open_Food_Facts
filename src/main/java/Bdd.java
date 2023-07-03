import dao.*;
import entities.*;
import implement.*;
import jakarta.persistence.EntityManager;
import utils.ConsoleColors;
import utils.ReadCsv;
import utils.TimeChrono;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Bdd {

    public static void run() throws Exception {


        EntityManager em = AbstractDAO.emf.createEntityManager();
        ReadCsv read = new ReadCsv();
        List<Produit> produits = read.listOfProduit();

        IProduitDAO produitDAO = new ProduitDaoImp(em);
        ICategoryDAO categoryDAO = new CategorieDaoImp(em);
        IIngredientDAO ingredientDAO = new IngredientDaoImp(em);
        IAllergieDAO allergieDAO = new AllergieDaoImp(em);
        IMarqueDAO marqueDAO = new MarqueDaoImp(em);
        IAdditifDAO additifDAO = new AdditifDaoImp(em);


        HashMap<String, Marque> mapMarque = new HashMap<>();
        HashMap<String, Category> mapCategory = new HashMap<>();
        HashMap<String, Ingredient> mapIngredient = new HashMap<>();
        HashMap<String, Allergie> mapAllergie = new HashMap<>();
        HashMap<String, Additif> mapAdditif = new HashMap<>();
        HashMap<String, Produit> mapProduit = new HashMap<>();

        long debut = System.currentTimeMillis();
        em.getTransaction().begin();
        for (Produit produit : produits) {


            Marque marqueObj = produit.getMarque();
            Category categoryObj = produit.getCategory();
            Set<Additif> additifList = produit.getAdditif();
            Set<Allergie> allergieList = produit.getAllergie();
            Set<Ingredient> ingredientList = produit.getIngredients();


            /** MARQUES
             */

            if (mapMarque.containsKey(marqueObj.getNom())) {
                Marque entMarque = mapMarque.get(marqueObj.getNom());
                marqueObj.setId(entMarque.getId());
                System.out.println(ConsoleColors.RED + "insertion ************* " + marqueObj.getNom());

            } else {
                System.out.println(ConsoleColors.CYAN + "insertion ************* " + marqueObj.getNom());
                mapMarque.put(marqueObj.getNom(), marqueObj);
                marqueDAO.save(marqueObj);
            }

            /**
             * Category
             */

            if (mapCategory.containsKey(categoryObj.getNom())) {
                Category entCat = mapCategory.get(categoryObj.getNom());
                categoryObj.setId(entCat.getId());
                System.out.println(ConsoleColors.GREEN_BOLD + " SETTTTTERS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + categoryObj.getNom());

            } else {
                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + " INSERTION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + categoryObj.getNom());
                mapCategory.put(categoryObj.getNom(), categoryObj);
                categoryDAO.save(produit.getCategory());

            }

            /**
             * ALLERGIE
             */
            for (Allergie allergieObj: allergieList){

                if (mapAllergie.containsKey(allergieObj.getNom())){
                    Allergie entAdditif = mapAllergie.get(allergieObj.getNom());
                    allergieObj.setId(entAdditif.getId());
                    System.out.println(ConsoleColors.GREEN_BOLD + " SETTTTTERS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + allergieObj.getNom());
                }else {
                    mapAllergie.put(allergieObj.getNom(),allergieObj);
                    allergieDAO.save(allergieObj);
                    System.out.println(ConsoleColors.YELLOW + " INSERTION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + allergieObj.getNom());

                }
            }

            /**
             * INGREDIENTS
             */

            for (Ingredient ingredientObj: ingredientList){
                if(mapIngredient.containsKey(ingredientObj.getNom())){
                    Ingredient ingredientEnt = mapIngredient.get(ingredientObj.getNom());
                    ingredientObj.setId(ingredientEnt.getId());
                }else {
                    mapIngredient.put(ingredientObj.getNom(),ingredientObj);
                    ingredientDAO.save(ingredientObj);
                    System.out.println(ConsoleColors.BLUE_BOLD + " INSERTION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + ingredientObj.getNom());

                }

            }

            /**
             * PRODUITS
             */
            if (mapProduit.containsKey(produit.getNom())){
                Produit entPro = mapProduit.get(produit.getNom());
                produit.setId(entPro.getId());
                System.out.println(ConsoleColors.GREEN_BOLD + " SETTTTTERS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + produit.getNom());

            }else {
                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + " INSERTION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + categoryObj.getNom());
                mapProduit.put(produit.getNom(), produit);
                produitDAO.save(produit);
            }

            /**
             * ADDITIF
             */

            for (Additif additifObj: additifList){

                if (mapAdditif.containsKey(additifObj.getNom())){
                    Additif entAdditif = mapAdditif.get(additifObj.getNom());
                    additifObj.setId(entAdditif.getId());
                    System.out.println(ConsoleColors.GREEN_BOLD + " SETTTTTERS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + additifObj.getNom());
                }else {
                    mapAdditif.put(additifObj.getNom(),additifObj);
                    additifDAO.save(additifObj);
                    System.out.println(ConsoleColors.BLUE_BOLD + " INSERTION !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + additifObj.getNom());

                }
            }



        }


        em.getTransaction().commit();

        em.close();


        long fin = System.currentTimeMillis();
        long resultat = (debut - fin) ;

        System.out.println("temps ======> " + resultat /1000);
        System.out.println(ConsoleColors.GREEN_BOLD + "nb produit = " + produits.size() + "temps de traitement = " + TimeChrono.millisecondsToTime(resultat));

    }
}
