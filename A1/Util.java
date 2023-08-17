/**
 * Ceci est une classe utilitaire qui contient des fonctionnalites qu'on va utiliser 
 * On ajoutera des methodes au fur et a mesure. 
 * 
 *
 */
import java.io.FileReader;
import java.util.Scanner;

public class Util {
	/**
	 * Produces a string filled of given characters
	 * 
	 * @param character the character to repeated
	 * @param occurence the number of repetition
	 * @return the string representation
	 */

	 public static int TAILLEALPHABET = 26;
	 public static final char DEBUTALPHABETMINUSCULE = 'a';
	 public static final char DEBUTALPHABETMAJUSCULE = 'A';

	 public static String fillString(char character, int occurence) {
        StringBuffer sb = new StringBuffer();
        for (int j=1; j<= occurence; j++) {
            sb.append(character);
        }
        return sb.toString();
    }

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
}
