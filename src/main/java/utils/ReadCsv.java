package utils;

import dao.ICategoryDAO;
import entities.*;
import implement.CategorieDaoImp;
import org.apache.commons.io.FileUtils;

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

    /**
     *Role :
     * Obtenir la liste des produits du csv
     * @return
     */
    public List<Produit> listOfProduit(){

        List<String> lines = null;

        try {
            lines = FileUtils.readLines(new File("C:/Users/km84/OneDrive/Bureau/dossierOpenFood/Open_Food_Facts/src/assets/openfood.csv"),"UTF-8");
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
        lines.remove(0);

        System.out.println();

        ArrayList<Produit> produits = new ArrayList<Produit>();
        for (String line: lines){
            produits.add(linetoProduit(line));
        }
        return  produits;

    }


    private Produit linetoProduit(String line){
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

        produitEnt.setCategory(categoryEnt);
        produitEnt.setMarque(marqueEnt);

        produitEnt.setIngredients(cleanIngredient(ingredient));
        produitEnt.setAllergie(cleanAllergie(allergene));
        produitEnt.setAdditif(cleanAdditif(additif));


        produitEnt.setBetaCarotene100g(betaCarotene100g);
        produitEnt.setCalcium100g(calcium100g);
        produitEnt.setEnergie100g(energie100g);
        produitEnt.setFer100g(fer100g);
        produitEnt.setFibres100g(fibres100g);
        produitEnt.setGraisse100g(graisse100g);
        produitEnt.setIron100g(iron100g);
        produitEnt.setMagnesium100g(magnesium100g);
        produitEnt.setProteines100g(proteines100g);
        produitEnt.setSel100g(sel100g);
        produitEnt.setSucres100g(sucres100g);
        produitEnt.setVitA100g(vitA100g);
        produitEnt.setVitB1100g(vitB1100g);
        produitEnt.setVitB12100g(vitB12100g);
        produitEnt.setVitB2100g(vitB2100g);
        produitEnt.setVitB6100g(vitB6100g);
        produitEnt.setVitB9100g(vitB9100g);
        produitEnt.setVitC100g(vitC100g);
        produitEnt.setVitD100g(vitD100g);
        produitEnt.setVitE100g(vitE100g);
        produitEnt.setVitK100g(vitK100g);
        produitEnt.setVitPP100g(vitPP100g);

        return produitEnt;
    }


    private Set<Ingredient> cleanIngredient(String str){

        List<String> lineStr = ChaineTraitement.removeCarSpeListChaine(str);
        Set<Ingredient>  listIngredient = new HashSet<Ingredient>();
        for( String ingredientNom : lineStr){

            if(ingredientNom.length() < 255){
                listIngredient.add(new Ingredient(ingredientNom));
            }
        }
        return listIngredient;
    }
    private Set<Additif> cleanAdditif(String str){

        List<String> lineStr = ChaineTraitement.removeCarSpeListChaine(str);
        Set<Additif>  listAdditif = new HashSet<Additif>();
        for( String additifNom : lineStr){

            listAdditif.add(new Additif(additifNom));
        }
        return listAdditif;
    }

    private Set<Allergie> cleanAllergie(String str){

        List<String> lineStr = ChaineTraitement.removeCarSpeListChaine(str);
        Set<Allergie>  listAllergie = new HashSet<Allergie>();
        for( String additifNom : lineStr){

            listAllergie.add(new Allergie(additifNom));
        }
        return listAllergie;
    }


}
