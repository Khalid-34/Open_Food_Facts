package utils;

import entities.Ingredient;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.Normalizer;
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
    public static String removeCarSpe(String str){
        String cleanStr =  str.replaceAll("[^\\w]\\s", " ")
                .replaceAll("[\\+\\.\\^,%]", " ")
                .replaceAll("[\\_\\-]", " ")
                .replace("fr:", " ")
                .replace("en:", " ").trim();
        cleanStr = unaccent(cleanStr);


        if (cleanStr.equals("")) {
            cleanStr = null;
        }
        return cleanStr;
    }




}
