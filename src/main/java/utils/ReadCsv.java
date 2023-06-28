package utils;

import dao.ICategoryDAO;
import entities.Allergie;
import entities.Category;
import entities.Marque;
import entities.Produit;
import implement.CategorieDaoImp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Lecture du fichier csv
 * @author kone et khalid
 */

public class ReadCsv {

    public static void main(String[] args) {



            try {
                String path = "C:/Users/km84/OneDrive/Bureau/dossierOpenFood/Open_Food_Facts/src/assets/openfood.csv";
                Path patheFile = Paths.get(path);
                List<String> produitsCsv = Files.readAllLines(patheFile);
                produitsCsv.remove(0);

                for (String line: produitsCsv)
                    linetoProduit(line);

            } catch (IOException e) {

                System.out.println(e.getMessage());
            }

    }

    private static Produit linetoProduit(String line){
        String[] strLine = line.split("\\|", -1);

        String category = strLine[0];
        String marque = strLine[1];
        String produit = strLine[2];
        String grade = strLine[3];
        String ingredient = strLine[4];

        String allergene = strLine[28];
        String additif = strLine[29];


        Double energie100g = ChaineTraitement.convertToDouble(strLine[5]);
        Double graisse100g = ChaineTraitement.convertToDouble(strLine[6]);
        Double sucres100g = ChaineTraitement.convertToDouble(strLine[7]);
        Double fibres100g = ChaineTraitement.convertToDouble(strLine[8]);
        Double proteines100g = ChaineTraitement.convertToDouble(strLine[9]);
        Double sel100g = ChaineTraitement.convertToDouble(strLine[10]);
        Double vitA100g = ChaineTraitement.convertToDouble(strLine[11]);
        Double vitD100g = ChaineTraitement.convertToDouble(strLine[12]);
        Double vitE100g = ChaineTraitement.convertToDouble(strLine[13]);
        Double vitK100g = ChaineTraitement.convertToDouble(strLine[14]);
        Double vitC100g = ChaineTraitement.convertToDouble(strLine[15]);
        Double vitB1100g = ChaineTraitement.convertToDouble(strLine[16]);
        Double vitB2100g = ChaineTraitement.convertToDouble(strLine[17]);
        Double vitPP100g = ChaineTraitement.convertToDouble(strLine[18]);
        Double vitB6100g = ChaineTraitement.convertToDouble(strLine[19]);
        Double vitB9100g = ChaineTraitement.convertToDouble(strLine[20]);
        Double vitB12100g = ChaineTraitement.convertToDouble(strLine[21]);
        Double calcium100g = ChaineTraitement.convertToDouble(strLine[22]);
        Double magnesium100g = ChaineTraitement.convertToDouble(strLine[23]);
        Double iron100g = ChaineTraitement.convertToDouble(strLine[24]);
        Double fer100g = ChaineTraitement.convertToDouble(strLine[25]);
        Double betaCarotene100g = ChaineTraitement.convertToDouble(strLine[26]);

        Category categoryEnt = new Category(category);
        Marque marqueEnt = new Marque(marque);
        Produit produitEnt = new Produit(produit);


        // Extraction des allergenes
        Set<Allergie> listeAllergenes = new HashSet<Allergie>();
        List<String> allergenes= Arrays.asList(ChaineTraitement.removeCarSpe(strLine[28]));
        for (String allergie : allergenes) {

            Allergie allergieEnt = new Allergie(allergie);
            listeAllergenes.add(allergieEnt);
            System.out.println(ConsoleColors.BLUE + );
        }




/*        produitEnt.setGrade(grade);
        produitEnt.setIngredients();
        produitEnt.setAdditif(additif);
        produitEnt.setAllergie();*/

        return produitEnt;
    }

}
