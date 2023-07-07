import entities.Category;
import entities.Produit;
import implement.AbstractDAO;
import implement.manageProduit.ManageProduit;
import jakarta.persistence.EntityManager;
import utils.ConsoleColors;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        EntityManager em = AbstractDAO.emf.createEntityManager();


        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.BLACK);
        System.out.println(ConsoleColors.YELLOW_BACKGROUND +"<<<<<<<<<< Voulez-vous générer la BDD >>>>>>> \n 1 = Oui \n 2 = Non " + ConsoleColors.RESET);
        int nbResponse = scanner.nextInt();
        if(nbResponse == 1 ){
            Bdd.run();
        }
        ManageProduit manageProduit = new ManageProduit(em);
        scanner.nextLine();

        System.out.println(ConsoleColors.BLUE + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(ConsoleColors.YELLOW + "<<<<<<<<<< Rechercher les N meilleurs produits pour une marque donnée >>>>>>>");
        System.out.print(ConsoleColors.BLUE + "_____ Entrez le nom de la marque ____\n");
        String marque = scanner.nextLine();
        System.out.print(ConsoleColors.BLUE + "_____ Entrez le nombre  ____\n");
        int nb = Integer.parseInt(scanner.nextLine());


        // a changer
        List<Produit> produitList = manageProduit.searchBestProduct(marque,nb);
        for (int i = 0; i < produitList.size(); i++) {
            Produit produit = produitList.get(i);
            System.out.println(ConsoleColors.YELLOW + produit.getNom());
        }
        scanner.nextLine();

        System.out.println(ConsoleColors.BLUE + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(ConsoleColors.YELLOW + "<<<<<<<<<< Rechercher les N meilleurs produits pour une marque donnée >>>>>>>");
        System.out.print(ConsoleColors.BLUE + "_____ Entrez le nom de la categorie ____\n");
        String categorie = scanner.nextLine();
        System.out.print(ConsoleColors.BLUE + "_____ Entrez le nombre  ____\n");
        int nb1 = Integer.parseInt(scanner.nextLine());

        List<Produit> produitsCategory = manageProduit.searchBestCategory(categorie,nb1);
        for (int i =0; i < produitsCategory.size(); i++){

            Produit produit = produitsCategory.get(i);
            System.out.println(ConsoleColors.YELLOW + produit.getNom());
        }



        System.out.println(ConsoleColors.BLUE + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(ConsoleColors.YELLOW + "<<<<<<<<<<  Rechercher les N meilleurs produits par marque et catégorie >>>>>>>");
        System.out.print(ConsoleColors.BLUE + "_____ Entrez le nom de la marque ____\n");
        String marque1 = scanner.nextLine();
        System.out.print(ConsoleColors.BLUE + "_____ Entrez le nom de la categorie ____\n");
        String category = scanner.nextLine();
        System.out.print(ConsoleColors.BLUE + "_____ Entrez le nombre  ____\n");
        int nb2 = Integer.parseInt(scanner.nextLine());

         List<Produit>  produitList1 =  manageProduit.searchBestMarqueCat(category,marque1,nb2);
        for (int i =0; i < produitList1.size(); i++){

            Produit produit = produitList1.get(i);
            System.out.println(ConsoleColors.YELLOW + produit.getNom());
        }






    }
}