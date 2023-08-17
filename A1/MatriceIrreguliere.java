import java.util.*;
import java.text.*;
import java.lang.Math.*;


public class MatriceIrreguliere 
{    
    private Double[] matrice;
    //
    //TODO - Ajouter votre code ici
    private int nombreElements;
    private int tailleColonne;

    public MatriceIrreguliere(double[] tableauParam, int nombreElements,  int tailleColonne)
    {
        //
        //TODO - Ajouter votre code ici
        this.matrice = new Double[nombreElements];
        for (int i = 0; i<nombreElements; i++)
        {
            this.matrice[i]= tableauParam[i];
        }
        this.nombreElements= nombreElements;
        this.tailleColonne=tailleColonne;
    }

    

    //
    //TODO - Vous pouvez aussi ajouter autant de methode de classe ou d'instance, de constructeur,  private ou public, selon votre guise. 

    public String toString() {
        //
        //TODO - Ajouter votre code ici
        int i, j, maxlen, nb_elem;
        int nb_cols= getN(); //cherche nombre de colonnes
        int size = this.matrice.length; // n d'elements dans la matrice
        int nb_rows= getM(); //cherche le nombre de lignes dans la matrice

        double maxEl= getMax();  //plus grand nombre de la matrice
        //String s1 = maxEl +"";
        String s1 = Double.toString(maxEl); //transforme le Double en String
        maxlen = s1.length(); //longueur du String convertit

        StringBuffer affichage = new StringBuffer(""); //StringBuffer vide
        String fmt = "|%" + maxlen + ".1f"; //formatage pour la cellule contenant le Double
        String fmt2 = "|%" + maxlen + "s"; 
        String strb;

        for(i=0; i<(maxlen+1)*nb_cols+1; i++) //ajoute '-' (le plus grand nombre multiplié par le nombre de colonnes de fois)
        {
            affichage.append('-');
        }
        affichage.append("\n");

        for(i=0; i<size; i++)
        {
            //strb = String.format(fmt,this.matrice[i]); //ajoute à la cellule le nombre dans l'index i
            //affichage.append(strb);
            s1 = Double.toString(this.matrice[i]);
            if (s1.contains("e") || s1.contains("E"))
            {
                strb = String.format(fmt2, s1);
            }
            else
            {
                strb = String.format(fmt, this.matrice[i]);
            }

            affichage.append(strb); 
            if ((i+1)% nb_cols == 0)
            {
                affichage.append("|\n");
                for (j=0; j<(maxlen+1)*nb_cols+1; j++)
                    affichage.append("-");
                affichage.append("\n");
            }

            else if (i == size-1)
            {
                affichage.append("|\n");
                nb_elem = size % nb_cols;
                for (j = 0; j<nb_elem*maxlen+nb_elem+1; j++)
                    affichage.append("-");
                affichage.append("\n");
            }
            
        }
        return affichage.toString();
    }

    public Double getMin(int ligne)
    {
        //TODO - Ajouter votre code ici
        //ligne implique le ID du groupement
        Double min= this.matrice[ligne*(this.tailleColonne)];
        int start_index = ligne*(this.tailleColonne);
        int lastLine= this.getM() -1; // add -1
        int nb_inLine; 

        if (ligne <lastLine)
        {
            nb_inLine= tailleColonne;
        }
        else
        {
            nb_inLine = nombreElements - tailleColonne*lastLine;
        }

        if (nb_inLine == 1)
        {
            return min;
        }
        else
        {
            for (int i = start_index; i<nb_inLine+start_index; i++)
            {
                if (min > this.matrice[i])
                {
                    min = this.matrice[i];
                }
            }
            return min;
        }
        
    }


    public Double getMax(int ligne)
    {
        //TODO - Ajouter votre code ici
        //ligne implique le ID du groupement
        Double max= this.matrice[ligne*(this.tailleColonne)];
        int start_index = ligne*(this.tailleColonne);
        int lastLine= this.getM() -1;
        int nb_inLine; 

        if (ligne <lastLine)
        {
            nb_inLine= tailleColonne;
        }
        else
        {
            nb_inLine = nombreElements - tailleColonne*lastLine;
        }

         if (nb_inLine == 1)
        {
            return max;
        }

        else
        {
            for (int i = start_index; i<nb_inLine+start_index; i++)
            {
                if (max < this.matrice[i])
                {
                    max = this.matrice[i];
                }
            }
            return max;
        }
    }

    public int getM()
    { 
        ///////nombre de lignes
        //
        //TODO - Ajouter votre code ici
        int nDeLignes= (int) Math.ceil((double)this.nombreElements/this.tailleColonne);

        return nDeLignes;
    }

    public int getN()
    { 
        //
        //TODO - Ajouter votre code ici
        int nDeColonnes=this.tailleColonne;
        return nDeColonnes;
    }

    public Double getMin () 
    {   
        ///get min for whole matrix
        //
        //TODO - Ajouter votre code ici
        Double min = this.matrice[0];

        for (int i = 0; i<this.matrice.length-1; i++)
        {
            if (min > this.matrice[i+1])
            {
                min = this.matrice[i+1];
            }
        }
        return min;
    }

    public Double getMax () 
    {
        //
        //TODO - Ajouter votre code ici
        Double max= this.matrice[0];

        for (int i = 0; i<this.matrice.length-1; i++)
        {
            if (max < this.matrice[i+1])
            {
                max = this.matrice[i+1];
            }
        } 
        return max;
    }

    public Double getTotal() 
    {
        //
        //TODO - Ajouter votre code ici
        Double sum=0.0;
        for(int i = 0; i<this.matrice.length; i++)
        {
            sum += this.matrice[i];
        } 

        return sum;
    }   
}