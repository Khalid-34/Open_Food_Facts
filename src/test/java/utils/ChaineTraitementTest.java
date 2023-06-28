package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChaineTraitementTest {
    private static final String accents 	= "È,É,Ê,Ë,Û,Ù,Ï,Î,À,Â,Ô,è,é,ê,ë,û,ù,ï,î,à,â,ô,Ç,ç,Ã,ã,Õ,õ";
    private static final String expected	= "E,E,E,E,U,U,I,I,A,A,O,e,e,e,e,u,u,i,i,a,a,o,C,c,A,a,O,o";

    private static final String accents2	= "çÇáéíóúýÁÉÍÓÚÝàèìòùÀÈÌÒÙãõñäëïöüÿÄËÏÖÜÃÕÑâêîôûÂÊÎÔÛ";
    private static final String expected2	= "cCaeiouyAEIOUYaeiouAEIOUaonaeiouyAEIOUAONaeiouAEIOU";


    private static final String accents3 = "-_a";
    private static final String expected3 = "  a";
    @Test
    public void convertToDouble() {
        String str = "12.54";
        double expected = 12.54;

        double actual = ChaineTraitement.convertToDouble(str);

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void convertToInt() {
        String str = "123";
        Integer expected = 123;

        Integer actual = ChaineTraitement.convertToInt(str);

        assertEquals(expected, actual);

    }

    @Test
    public void unaccent() {

        assertEquals(expected, ChaineTraitement.unaccent(accents));
        assertEquals(expected2, ChaineTraitement.unaccent(accents2));
    }

}