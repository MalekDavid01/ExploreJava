import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 * la classe de Unit test qui teste les questions du devoir 3
 */
public class TestD3 {
    /**
     * 
     * Verifie que l exception est bien executee quand on appelle Peek sur une Pile vide;
     */
    @Test
    public void testPeekThrowsEmptyLinkedStackException(){
        Stack<String> stack = new LinkedStack<String>();
        try{
            stack.peek();
            fail("Peek - EmptyLinkedStackException n a pas ete lancee");
        } catch (EmptyLinkedStackException e){
           ;
        }
    }

    /**
     * 
     * Verifie que l exception est bien executee quand on appelle Pop sur une Pile vide;
     */
    @Test
    public void testPopThrowsEmptyLinkedStackException(){
        Stack<String> stack = new LinkedStack<String>();
        try {
            String element = stack.pop();
            fail("Pop -  EmptyLinkedStackException n a pas ete lancee");
        }catch (EmptyLinkedStackException e){
            ;
        }
    }

    /**
     * 
     * Verifie que l exception ne devrait pas s executer quand on appelle Peek sur une Pile qui n est pas vide;
     */
    @Test
    public void testPeekShouldNotThrowEmptyLinkedStackException(){
        Stack<String> stack = new LinkedStack<String>();
        try{
            stack.push("A");
            stack.peek();
            
        } catch (EmptyLinkedStackException e){
            fail("Peek - EmptyLinkedStackException a ete lancee alors que ca n aurait pas du");
        }
    }

    /**
     * 
     * Verifie que l exception ne devrait pas s executer quand on appelle Pop sur une Pile qui n est pas vide;
     */
    @Test
    public void testPopThrowsShouldnotThrowEmptyLinkedStackException(){
        Stack<String> stack = new LinkedStack<String>();
        try {
            stack.push("A");
            String element = stack.pop();
            
        }catch (EmptyStackException e){
            fail("Pop -  EmptyLinkedStackException a ete lancee alors que ca n aurait pas du");
        }
    }

    /**
     * 
     * Verifie que l algorithme fonctionne bien avec differents exemples
     */

     
    @Test
    public void testD2Q2(){
        int tab [][] = 
           { 
            {2072,5, 31242}, // 2027 en base 5 s ecrit 31242
            {12, 5, 22},   
            {23, 10, 23},
            {1023, 2, 1111111111}
           };

           for (int i=0; i<tab.length; i++) {
            ConvertisseurBase baseConverter = new ConvertisseurBase();
            int resultat = baseConverter.convert(tab[i][0], tab[i][1]);            
            assertTrue( "votre algorithme n etait pas capable de convertir le chiffre " + tab[i][0] + "en base "+ tab[i][1], resultat== tab[i][2]);
            }
    }

    /**
     * 
     * Verifie que l algorithme fonctionne bien avec differents exemples
     */

     
    @Test
    public void testD2Q3(){
        int tab [][] = 
           { 
            {1,9},
           {2,90},
           {3,9},
           {5,90},
           {7,9009},
           {9,9},
           {133,99909999}
           };

           for (int i=0; i<tab.length; i++) {
            ZeroEtNeuf z = new ZeroEtNeuf();
            int resultat = z.resoudre(tab[i][0]);
            assertTrue( "votre algorithme n etait pas capable de calculer pour " + tab[i][0], resultat== tab[i][1]);
           }
    }


    public static void main(String[] args) {
        TestUtils.runClass(TestD3.class);        
    }
    
}

// Pour compiler ce fichier
// javac -cp "junit-4.13.jar;hamcrest-core-1.3.jar ;." TestD3.java
// Pour executer les tests
// java -cp "junit-4.13.jar;hamcrest-core-1.3.jar ;." TestD3