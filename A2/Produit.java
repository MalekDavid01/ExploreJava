/**
 * La classe abstraite Produit qui definit un name, sku et unitPrice.
 * chaque sous classe doit concretement definir
 */

 //TODO: Corriger la declaration de la classe
public abstract class Produit extends ProduitsEtServices implements Identifiable {//public abstract class Produit extends ProduitsEtServices implements Identifiable 
    /**
     * un enumeration des types de produits possible
     */
    public enum ProductType {
        CARTE,
        POSTER,
        JERSEY
    }

    private String name;
    private String sku;
    private Double unitPrice;

    //la seule methode qui doit etre concretement redefinie par les sous classes
    abstract ProductType getProductType();

    /**
     * constructeur
     * @param name le nom du produit 
     * @param sku le product-id du produit
     * @param unitPrice le prix unitaire du produit
     */
    public Produit (String name, String sku, Double unitPrice) {
        super();
        this.name = name;
        this.sku = sku;
        this.unitPrice = unitPrice;
    }

    /**
     * constructeur
     * @param name le nom du produit 
     * @param sku le product-id du produit
     * @param unitPrice le prix unitaire du produit
     * @param taxRate le tax rate du produit
     */
    public Produit (String name, String sku, Double unitPrice, Double taxRate) {
         this(name, sku, unitPrice);
        super.taxRate = taxRate;
    }

    /**
     * @return le Id de l'Objet de la classe pour qu elle soit "Identifiable"
     */ 
    // Il manque une methode ici et cette classe ne compilera pas tant que cette methode ne sera pas 
    // implementee!
    //TODO: Mettez votre code ici
    public String getId() { //s'agit du sku (pour les produits)
        return this.sku;
    }

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    protected String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected Double getPrice(){
        return this.unitPrice;
    }

    protected void setPrice(Double price) {
        this.unitPrice = price;
    }

    /**
     * la version toString du Produit. 
     */
    public String toString() {
        //TODO
        //Mettez votre code ici
        //toString de format Type de Produit, son Sku, Total de la quantité vendu (par Sku)
        ProductType productType = getProductType();
        String id = getSku();
        return productType.toString() + "/sku("+ id + ")";
    }
}