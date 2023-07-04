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
        scanner.nextLine(); // vider

        System.out.println(ConsoleColors.YELLOW + "<<<<<<<<<< Rechercher les N meilleurs produits pour une marque donnée >>>>>>>");
        System.out.print(ConsoleColors.BLUE + "_____ Entrez le nom de la marque ____\n");
        String marque = scanner.nextLine();
        System.out.print(ConsoleColors.BLUE + "_____ Entrez le nombre  ____\n");
        int nb = Integer.parseInt(scanner.nextLine());

        ManageProduit manageProduit = new ManageProduit(em);
        List<Produit> produitList = manageProduit.searchBestProduct(marque,nb);
        for (int i = 0; i < produitList.size(); i++) {
            Produit produit = produitList.get(i);
            System.out.println(ConsoleColors.YELLOW + produit.getNom());
        }
        scanner.nextLine();

    }
}