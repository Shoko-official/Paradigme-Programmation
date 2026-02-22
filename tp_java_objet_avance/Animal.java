package tp_java_objet_avance;

/**
 * Classe représentant un animal générique.
 * <p>
 * Cette classe illustre les concepts de portée (private vs protected)
 * et de comportement de base.
 * </p>
 */
public class Animal {
    /** Nom de l'animal. */
    private String nom;

    /** Age de l'animal. Accessible aux classes dérivées. */
    protected int age;

    /** Poids de l'animal. */
    private double poids;

    /**
     * Constructeur par défaut.
     */
    public Animal() {
    }

    /**
     * Constructeur avec paramètres.
     * 
     * @param nom   Le nom de l'animal.
     * @param age   L'âge de l'animal.
     * @param poids Le poids de l'animal.
     */
    public Animal(String nom, int age, double poids) {
        this.nom = nom;
        this.age = age;
        this.poids = poids;
    }

    // --- Getters and Setters ---

    /** @return Le nom. */
    public String getNom() {
        return nom;
    }

    /** @param nom Le nouveau nom. */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /** @return L'âge. */
    public int getAge() {
        return age;
    }

    /** @param age Le nouvel âge. */
    public void setAge(int age) {
        this.age = age;
    }

    /** @return Le poids. */
    public double getPoids() {
        return poids;
    }

    /** @param poids Le nouveau poids. */
    public void setPoids(double poids) {
        this.poids = poids;
    }

    // --- Méthodes de comportement ---

    /**
     * Définit le mode de déplacement par défaut de l'animal.
     */
    public void seDeplacer() {
        System.out.println("L’animal se déplace.");
    }

    /**
     * Définit le cri par défaut de l'animal.
     */
    public void parler() {
        System.out.println("...");
    }

    /**
     * Permet à l'animal de s'alimenter, ce qui augmente son poids.
     * 
     * @param quantite La quantité de nourriture consommée.
     */
    public void manger(double quantite) {
        this.poids += quantite;
        System.out.println(nom + " a mangé. Nouveau poids : " + poids);
    }
}
