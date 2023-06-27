package entité;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadCsv {
    public static void main(String[] args) {
        try {
            String path = "src/main/java/csv/open-food-facts.csv";
            Path filePath = Paths.get(path);
            List<String> produitsCsv = Files.readAllLines(filePath);
            String csvSplitBy = ",|%|\\(";



            for (String line : produitsCsv) {
                String[] tabProduits = line.split("\\|");


                String tabMarque = tabProduits[1];
                String tabNom = tabProduits[2];
                String tabNutritionGradeFr = tabProduits[3];


                String tabEnergie100g = tabProduits[5];
                String tabGraisse100g = tabProduits[6];
                String tabSucres100g = tabProduits[7];
                String tabFibres100g = tabProduits[8];
                String tabProteines100g = tabProduits[9];
                String tabSel100g = tabProduits[10];


                String tabIngredient = tabProduits[4];
                String tabAllergent = tabProduits[28];
                String tabAdditifs = tabProduits[29];

                // Traitement des caractères spéciaux
                tabIngredient = tabIngredient.replaceAll("[*_,]", "");
                tabAllergent = tabAllergent.replaceAll("[*_,]", "");
                tabAdditifs = tabAdditifs.replaceAll("[*_,]", "");

                // Traitement des pourcentages
                tabIngredient = tabIngredient.replaceAll("\\s\\d+%\\s?", "");
                tabAllergent = tabAllergent.replaceAll("\\s\\d+%\\s?", "");
                tabAdditifs = tabAdditifs.replaceAll("\\s\\d+%\\s?", "");

                // Traitement des parenthèses
                tabIngredient = tabIngredient.replaceAll("\\(.*?\\)", "");
                tabAllergent = tabAllergent.replaceAll("\\(.*?\\)", "");
                tabAdditifs = tabAdditifs.replaceAll("\\(.*?\\)", "");

                System.out.println("Ingrédients : " + tabIngredient);
                System.out.println("Allergènes : " + tabAllergent);
                System.out.println("Additifs : " + tabAdditifs);
                System.out.println();

//                String tabMarque = tabProduits[1];
//                String tabNom = tabProduits[2];
//                String tabNutritionGradeFr = tabProduits[3];
//                String tabIngredient= tabProduits[4];
//
//
//                String tabEnergie100g = tabProduits[5];
//                String tabGraisse100g = tabProduits[6];
//                String tabSucres100g = tabProduits[7];
//                String tabFibres100g = tabProduits[8];
//                String tabProteines100g = tabProduits[9];
//                String tabSel100g = tabProduits[10];
//                String tabAllergent= tabProduits[28];
//                String tabAdditifs= tabProduits[29];







            }






        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
//    public String traitement_csv(String str) {
//
//        try {
//            Path patheFile = Paths.get(str);
//            List<String> produitsCsv = Files.readAllLines(patheFile);
//
//            for(String line: produitsCsv ){
//                String[] tabProduits = line.split("\\|", -1);
//                System.out.println(tabProduits[1]);
//                return tabProduits
//
//
//            }
//
//        } catch (IOException e) {
//
//            System.out.println(e.getMessage());
//        }
//        return tabProduits;
//
//    }

