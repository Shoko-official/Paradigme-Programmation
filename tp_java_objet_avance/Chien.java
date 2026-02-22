package tp_java_objet_avance;

/**
 * Classe représentant un chien, spécialisation d'un Animal.
 */
public class Chien extends Animal {
    /** La race du chien. */
    private String race;

    /**
     * Constructeur par défaut.
     */
    public Chien() {
    }

    /**
     * Constructeur complet.
     * 
     * @param nom   Le nom du chien.
     * @param age   Son âge.
     * @param poids Son poids.
     * @param race  Sa race.
     */
    public Chien(String nom, int age, double poids, String race) {
        super(nom, age, poids);
        this.race = race;
    }

    /** @return La race du chien. */
    public String getRace() {
        return race;
    }

    @Override
    public void parler() {
        System.out.println("Wouf!");
    }

    /**
     * Comportement spécifique au chien.
     */
    public void aboyer() {
        System.out.println("Wouaf Wouaf!");
    }
}
