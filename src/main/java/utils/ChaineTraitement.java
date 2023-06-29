package utils;

import entities.Ingredient;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ChaineTraitement {
    //-------------{ ATTRIBUT }----------------//


    //-------------{ METHODS }----------------//



    /**
     * Role :
     * convertir en Double un String
     * test = ok
     * @param str
     * @return
     */
    public static Double convertToDouble(String str){
        if (NumberUtils.isCreatable(str)) {
            return  Double.parseDouble(str);
        }
        return null;

    }

    /**
     * Role:
     * convertir en integer un String
     * test = ok
     * @param str
     * @return
     */
    public static Integer convertToInt(String str){
        if (NumberUtils.isDigits(str)) {
            return Integer.parseInt(str);
        }
        return null;
    }

    /**
     * Role :
     * Suppression des accents sur les strings
     * test = ok
     * @param str
     * @return
     */
    public static String unaccent(String str ){
        return Normalizer
                .normalize(str, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

    /**
     * Role :
     * Suppression des caractères spéciaux des strings
     * test = ok
     * @param str
     * @return
     */
    public static List<String> removeCarSpeListChaine(String str){
        String cleanStr =  str.replaceAll("[_\\*'/\\?\\+=]*", "")
                                .replaceAll("\\(.*?\\)", "")
                                .replaceAll("[\\(\\)\\[\\]]", "")
                                .replaceAll("[0-9]*\\s*%", "")
                                .replaceAll("[0-9]*\\.*", "")
                                .replace("fr:", " ")
                                .replace("en:", " ").trim();

        cleanStr = unaccent(cleanStr);


        if (cleanStr.equals("")) {
            cleanStr = null;
        }
        return splitStr(cleanStr);
    }

    private static List<String> splitStr(String str) {

        if (str == null || str.isEmpty()) {
            return new ArrayList<String>();
        }

        List<String> liste = new ArrayList<String>();
        String[] morceaux = str.split("[,;:]");
        for (String m : morceaux) {
            String morceauTraite = m.trim();
            if (!morceauTraite.isEmpty()) {

                liste.add(morceauTraite);
            }
        }
        return liste;
    }





}
