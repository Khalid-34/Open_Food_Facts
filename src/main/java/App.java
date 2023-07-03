import utils.ConsoleColors;

import java.util.Scanner;

public class App {


    public static void main(String[] args) throws Exception {

        Bdd.run();
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.YELLOW + "<<<<<<<<<< Rechercher les N meilleurs produits pour une marque donnée >>>>>>>");
        System.out.print(ConsoleColors.BLUE + "_____ Entrez le nom de la marque ____");
        String marqueStr = scanner.nextLine();
        System.out.print(ConsoleColors.BLUE + "_____ Entrez le nombre  ____");
        int nb = Integer.parseInt(scanner.nextLine());
        scanner.nextLine();
        





    }
}