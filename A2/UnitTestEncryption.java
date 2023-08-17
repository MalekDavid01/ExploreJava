import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 * la classe de Unit test qui teste les methodes encrypter et decrypter de
 * la classe EncryptionCesar 
 */
public class UnitTestEncryption {
    private static String aphabet = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NOMBREITERATIONTEST = 10;
    private static final int TAILLEMAXIMUMSTRINGAENCRYPTER = 50;

    /**
     * Genere aleatoirement une chaine de caracteres de taile @param @taille
     * utilise java.lang.Math.random()
     * @param taille
     * @return la chaine de caractere 
     */
     private static String getRandomString(int taille) {
        StringBuilder sb = new StringBuilder(taille);
        int taileAlphabet = aphabet.length();
        
        //generer un chiffre random, considerer ce chiffre comme un position dans le tableu d alphabet 
        for (int i = 0; i < taille; i++) {
            int positionDansAlphabet = (int)(taileAlphabet * Math.random());
            sb.append(aphabet.charAt(positionDansAlphabet));
        }
        return sb.toString();
    }

    /**
     * Genere aleatoirement une nombre entier compris entre @param borneInferieur et @param borneSuperieur
     * utilise java.util.Random
     * @param borneInferieur
     * @param borneSuperieur
     * @return
     */
    private static int getRamdomInt(int borneInferieur, int borneSuperieur){
        Random random = new Random();
        int entier = borneInferieur+random.nextInt(borneSuperieur-borneInferieur);
        return entier;
    }


    /**
     * 
     * Verifie NOMBREITERATIONTEST de fois que des chaines generees de facon aleatoire sont encrypte et decrypte convenablement
     */
     @Test
    public void testEncryption() {
        for (int i = 0; i < NOMBREITERATIONTEST; i++) {
            //choisissons un decalage random entre 1 et taille alphabet. ca aurait pu etre un chiffre fixe aussi
            int decalage = UnitTestEncryption.getRamdomInt (1, UnitTestEncryption.aphabet.length());
            int tailleMessageAEncrypter = UnitTestEncryption.getRamdomInt (1, UnitTestEncryption.TAILLEMAXIMUMSTRINGAENCRYPTER);
            String messageAvantEncryption = UnitTestEncryption.getRandomString(tailleMessageAEncrypter);
            EncryptionCesar encryption = new EncryptionCesar(decalage);

            System.out.println ("Message avant Encryption: " + messageAvantEncryption);  
            String messageEncrypter = encryption.Encrypter(messageAvantEncryption);
            System.out.println ("Message apres Encryption: " + messageEncrypter +  " (decalage="+ decalage + ")");
            String messageApresDecryption= encryption.Decrypter(messageEncrypter);
            System.out.println ("Message apres Decryption: " + messageApresDecryption);
            System.out.println();
            assertEquals(messageAvantEncryption, messageApresDecryption);
        }     
    } 

    //encryption valide
    @Test
    public void testValiditeEncryption1() {
        char[][] tableau = {
            {'a','b','c','z'},
            {'Y','Z','E','b'}
        };
        SubstitutionEncryption se = new SubstitutionEncryption(tableau);
        assertTrue(se.isValid());
    }

    //encryption invalide: test surjerctivite: le caractere Y possede 2 sources d encryption 'a' et 'z'
    @Test
    public void testValiditeEncryption2() {
        char[][] tableau = {
            {'a','b','c','z'},
            {'Y','Z','E','Y'}
        };
        SubstitutionEncryption se = new SubstitutionEncryption(tableau);
        assertFalse(se.isValid());
    }

    //encryption invalide: le caractere 'a' possede 2 valeurs d encryption 'Y' et 'E'
    @Test
    public void testValiditeEncryption3() {
        char[][] tableau = {
            {'a','b','a','z'},
            {'Y','Z','E','b'}
        };
        SubstitutionEncryption se = new SubstitutionEncryption(tableau);
        assertFalse(se.isValid());
    }


    public static void main(String[] args) {
        TestUtils.runClass(UnitTestEncryption.class);        
    }
    
}

// Pour compiler ce fichier
// javac -cp "junit-4.13.jar;hamcrest-core-1.3.jar ;." UnitTestEncryption.java
// Pour executer les tests
// java -cp "junit-4.13.jar;hamcrest-core-1.3.jar ;." UnitTestEncryption