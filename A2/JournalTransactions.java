import java.io.*;
import java.util.*;

/**
 * la classe JournalTransactions qui est la classe principale produisant les sorties voulues
 */
public class JournalTransactions {
    public static final String COMMA_DELIMITER = ",";

    /**
     * 
     * @param args les arguments de la ligne de commande
     * args[0] prendra le nom du fichier input contenant la liste des transactions de notre site e-commerce
     * args[1] prendra le nom du fichier output contenant le rapport des ventes accomplies et des services recues
     * @throws Exception
     */
    public static void main (String[] args) throws Exception {
        if (args.length !=2) {
          System.out.print("Utilisation: java JournalTransactions <fichierInput:string> <fichierOutput:string>");
          return;
        } 

        String fichierinput = args[0];
        String fichierOutput = args[1];

        FileReader fileReader = new FileReader(fichierinput);               
        OccurenceCollection collectionOccurencesServicesRecues = new OccurenceCollection();
        OccurenceCollection collectionOccurencesVentes = new OccurenceCollection();
        
        try (BufferedReader br = new BufferedReader(fileReader)) {
            String ligne;
            while ((ligne = br.readLine()) != null) {

                String[] values = ligne.split(COMMA_DELIMITER);

                String operation = values[0];
                String type = values[1];
                String productType = values[2];
                String name = values[3];
                String prestataire = values[4];
                String description = values[5];
                String skuOrServiceId = values[6];
                Integer quantity = Util.parseIntWithDefault(values[7], 0);
                Double taxRate = Util.parseDoubleWithDefault(values[8], 0.0);
                Double price = Util.parseDoubleWithDefault(values[9], 0.0);

                if (type.equalsIgnoreCase("services")) {                    
                    Service service = new Service (name, prestataire, description, price); 
                    Occurence<Service> o = new Occurence<Service>(service, 1); // Pour un service, le service donne est considere comme une quantite de 1
                    collectionOccurencesServicesRecues.add(o);
                }
                else if (type.equalsIgnoreCase("produit") && operation.equalsIgnoreCase("vente")) {
                    Produit produit = null;                  

                    Boolean venteProduitTrouve = false;
                    switch (productType) {
                        case "Carte":
                            produit = new Carte(name, skuOrServiceId, price, taxRate);
                            venteProduitTrouve = true;
                        break;

                        case "Poster":
                            produit = new Poster(name, skuOrServiceId, price, taxRate,false);
                            venteProduitTrouve = true;
                        break;

                        case "Poster-s":
                            produit = new Poster(name, skuOrServiceId, price, taxRate, true);  
                            venteProduitTrouve = true;                          
                        break;

                        case "Jersey":
                        case "Jersey-s":
                        case "Jersey-c":
                        case "Jersey-sc":
                            produit = new Jersey(name, skuOrServiceId, price, taxRate);    
                            if (type.endsWith("-c")) {
                                Jersey jersey = (Jersey) produit;
                                jersey.setIsCustomized(true);   
                            }  
                            venteProduitTrouve = true;                   
                        break;
 
                    } //end switch 
                    if (venteProduitTrouve) {
                        Occurence<Produit> o = new Occurence<Produit>(produit, quantity);
                        collectionOccurencesVentes.add(o);   
                    }                        
                }  //end if   
                
                               
            }  //end while  
   
            FileWriter output = new FileWriter(fichierOutput);
            output.write("****SOMMAIRE DES VENTES****");
            output.write(System.lineSeparator());
            output.write(collectionOccurencesVentes.toString());
            output.write("****SOMMAIRE DES SERVICES RECUES****");
            output.write(System.lineSeparator());
            output.write(collectionOccurencesServicesRecues.toString());
            output.close();

            //vous pouvez enlever les commentaires ci-bas pour voir l execution sur l ecran
            System.out.println();
            System.out.println("****SOMMAIRE DES VENTES****");
            System.out.println(collectionOccurencesVentes);  
            System.out.println("****SOMMAIRE DES SERVICES RECUES****");           
            System.out.println(collectionOccurencesServicesRecues);  
        }//end try
        catch (Exception e) {
            System.out.println("Probleme dans l execution.");
            System.out.println(e.toString());
        }//end catch
    }//end main                
}