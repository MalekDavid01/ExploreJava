import java.util.Stack;

/**
 * la classe ConvertisseurBase qui convertit un nombre en base 10 vers un autre nombre de base quelconque
 */
public class ConvertisseurBase {
    
    /**
     * 
     * @param n le nombre
     * @param b la base (Hypothese:  b>1)
     * @return la version du nombre @param n en base @param b
     */
    public int convert(int n, int b) {
        LinkedStack<Integer> s;
        s = new LinkedStack<Integer>();

        // TODO: Insert votre code ici
        int dividende = n;
        int diviseur = b;
        int quotient, reste;
        int base10= 1;
        while (dividende != 0){
            reste = dividende%diviseur;
            s.push(reste*base10);
            base10= base10*10;
            quotient = dividende / diviseur;
            dividende = quotient;
        }

        int sum = 0;
        while(!s.isEmpty()){
            sum = sum + s.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        
        if (args.length !=2) {
            System.out.print("Utilisation: java ConvertisseurBase <n:int> <base:int>");
            return;
        } 

        int n = Integer.parseInt(args[0]);
        int base = Integer.parseInt(args[1]); 

        ConvertisseurBase baseConverter = new ConvertisseurBase();
        System.out.println(n + " s'ecrit " + baseConverter.convert(n,base) + " en base " + base);
    }
}