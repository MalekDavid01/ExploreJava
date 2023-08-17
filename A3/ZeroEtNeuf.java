import java.util.Scanner;
import java.util.Stack;

/**
 * la classe utilitaire ZeroEtNeuf 
 */
public class ZeroEtNeuf {
    
    /**
     * resoud le probleme qui cherche le plus petit nombre positif multiple de n et qui contient juste des zeros et des neufs
     * @param n
     * @return le chiffre compose juste de zeros et de neufs.
     */
    public int resoudre(int n) {
        int resultat;
        Queue<String> q;
        q = new LinkedQueue<String>();
        // TODO: Insert votre code ici
        //we can assume n>0 according to prof
        resultat = -1;
        //q.enqueue("0");
        q.enqueue("9");
        boolean found = false;
        
        /*if (n<=0){
            throw new IllegalArgumentException("n must be > 0");
        }*/
        while(!found){
            String s;
            s = q.dequeue();
            int num = Integer.parseInt(s);
            
            if (num %n==0 && num!=0){
                resultat = num;
                found = true;
            }
            /*else if(num==0){
                resultat = 0;
            }*/
            else{
                q.enqueue(s+ "0");
                q.enqueue(s+ "9");
            }
        }
            
        return resultat;
    }

    public static void main(String[] args) {
        if (args.length !=1) {
            System.out.print("Utilisation: java ZeroEtNeuf <n:int>");
            return;
          } 

        int n = Integer.parseInt(args[0]);
        ZeroEtNeuf zeroEtNeuf = new ZeroEtNeuf();
        System.out.println("Le plus petit nombre multiple de " + n + " compose juste de [0,9] est:  " + zeroEtNeuf.resoudre(n));
    }
}