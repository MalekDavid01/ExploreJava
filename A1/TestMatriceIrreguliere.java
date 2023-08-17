import java.util.*;
import java.text.*;
import java.lang.Math.*;

public class TestMatriceIrreguliere {
    public static void main (String[] args) {
        if (args.length !=2) {
            System.out.print("Utilisation: <java> <MatriceIrreguliere>  <MaxM:int> <n:int>");
            return;
        }
        
        System.out.println("Entrez des nombres 1 par 1. Entrez 0 pour terminer.");
        //
        //TODO - Ajouter votre code ici pour ramasser les entrees de l utilisateur
        //       et mettre les donnees dans un tableau temporaire
        
        int ligne = Integer.parseInt(args[0]); // lines
        int col = Integer.parseInt(args[1]); //columns
        
        double[] tmpList= new double[ligne*col]; // list of size i*j 
        Scanner userInput= new Scanner(System.in);
        double numbers;


        int index = 0;
        boolean add = true;
        do{
            numbers = userInput.nextDouble();
            if (numbers == 0){
                add = false;
            }
            else if (index == ligne*col -1){
                numbers = (Math.round(numbers*10.0))/10.0;
                tmpList[index] = numbers;
                index++;
                add = false;
            }
            else{
                
                numbers = (Math.round(numbers*10.0))/10.0;
                tmpList[index] = numbers;
                index++;
            }
        }while (add == true);
        int count = index;


        MatriceIrreguliere matrice = new MatriceIrreguliere(tmpList, count, col);

        System.out.println();
        System.out.println("Matrice/Affichage");
        System.out.println(); 
        System.out.println(matrice.toString());
        //System.out.println();

        int nombreLignes =matrice.getM();
        System.out.println("Nombre de lignes=" + nombreLignes);
        for (int i=0; i<nombreLignes ; i++) {
            System.out.println("Ligne #" + i + "/ Min=" + matrice.getMin(i) + ", Max="+ matrice.getMax(i));
        }
        System.out.println("Matrice/ Min=" + matrice.getMin() + ",Max="+matrice.getMax());
        System.out.println("Matrice/ Total=" + matrice.getTotal());
    }
}