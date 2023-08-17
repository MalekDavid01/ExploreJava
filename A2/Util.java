import java.io.FileReader;
import java.util.Scanner;

/**
 * Ceci est une classe utilitaire qui contient des fonctionnalites qu'on va utiliser 
 * On ajoutera des methodes au fur et a mesure. 
 */
public class Util {
	 public static final char DEBUTALPHABETMINUSCULE = 'a';
	 public static final char DEBUTALPHABETMAJUSCULE = 'A';
	 public static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	 /**
	  * remplit un String compose du charactere @param character un @param occurence de fois
	  * @param character le caractere donne
	  * @param occurence le nombre de fois
	  * @return
	  */
	 public static String fillString(char character, int occurence) {
        StringBuffer sb = new StringBuffer();
        for (int j=1; j<= occurence; j++) {
            sb.append(character);
        }
        return sb.toString();
	 }
	 
	 /**
	  * montre un exemple comment afficher le contenu d un fichier sur l ecran et compte
	  * un caractere donne
	  * @param filename le nom du fichier
	  * @throws Exception
	  */
	 public static void countChar (String filename) throws Exception{
        FileReader fileReader = new FileReader(filename);
    	char[] cbuf = new char[1];
    	
		int n = 0;

		while(fileReader.read(cbuf)>0) {
			System.out.print(cbuf);
			if(cbuf[0] == '*') {
				n++;
			}
		}
    	fileReader.close();
	}

	/**
	 * retourne la valeur int d un string sinon retourne la valeur par defaut si une erreur arrive pendant la conversion
	 * @param number le int en String
	 * @param defaultVal la valeur par defaut retournee si erreur
	 * @return la valeur int.
	 */
	public static int parseIntWithDefault(String number, int defaultVal) {
		try {
		  return Integer.parseInt(number);
		} catch (NumberFormatException e) {
		  return defaultVal;
		}
	  }

	  /**
	   * * retourne la valeur Double d un string sinon retourne la valeur par defaut si une erreur arrive pendant la conversion
	   * @param number le Double en String
	   * @param defaultVal la valeur par defaut retournee si erreur
	   * @return la valeur Double
	   */
	  public static Double parseDoubleWithDefault(String number, Double defaultVal) {
		try {
		  return Double.parseDouble(number);
		} catch (NumberFormatException e) {
		  return defaultVal;
		}
	  }
}
