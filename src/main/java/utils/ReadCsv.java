package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

                for(String line: produitsCsv ){
                    String[] tabProduits = line.split("\\|", -1);
                    System.out.println(tabProduits[1]);

                }

            } catch (IOException e) {

                System.out.println(e.getMessage());
            }

    }

}
