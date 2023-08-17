/**
 * La classe Service   qui definit un name, prestataire,  le serviceId, la description et le prix du prestation.
 */
//TODO: Corriger la declaration de la classe
public class Service extends ProduitsEtServices implements Identifiable { //...extends ProduitsEtServices implements Identifiable 
    private String name;
    private String prestataire;    
    private String description;
    private Double prixPrestation;

    /**
     * constructeur 
     * @param serviceName le nom du service
     * @param prestataire le nom de l entreprise prestataire
     * @param description la description du service     
     * @param prixPrestation le prix/valeur de la prestation totale
     */    
    public Service(String serviceName, String prestataire, String description, Double prixPrestation) {
        this.name = serviceName;
        this.prestataire = prestataire;
        this.description= description;        
        this.prixPrestation = prixPrestation;
    }

    /**
     * @return le Id de l'Objet de la classe pour qu elle soit "Identifiable"
     */ 
    // Il manque une methode ici et cette classe ne compilera pas tant que cette methode ne sera pas 
    // implementee!
    //TODO: Mettez votre code ici
    //

    public String getId() {
        return this.prestataire+ "\\"+ this.name;
    }

    protected String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected Double getPrice(){
        return this.prixPrestation;
    }

    protected void setPrice(Double price) {
        this.prixPrestation = price;
    }

    protected double getTaxRate() {
        return this.taxRate;
    }

    protected void setTaxRate(Double rate) {
        this.taxRate = rate;
    }

    protected String getDescription() {
        return this.description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

     /**
     * @return la version toString du Produit. 
     */
    public String toString() {
        //TODO
        //Mettez votre code ici
        return this.prestataire + "("+ this.name + ")";
        
    }
}