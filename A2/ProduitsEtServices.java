/**
 * La classe abstraite ProduitsEtServices qui definit uniquement un taxRate par defaut des champs abstraites que
 * chaque sous classe doit concretement definir
 */
public abstract class ProduitsEtServices {
    protected Double taxRate = 0.13;

    abstract String getName();
    abstract void setName(String name);
    abstract Double getPrice();
    abstract void setPrice(Double price);
 
    /**
     * constructeur par defaut
     */
    protected ProduitsEtServices () {
        ;
    }

    /**
     * Constructeur qui permet de faire un overwrite du tax rate
     * @param taxRate
     */
    protected ProduitsEtServices (Double taxRate) {
        this.taxRate = taxRate;
    }
}