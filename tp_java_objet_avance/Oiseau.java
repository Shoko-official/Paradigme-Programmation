package tp_java_objet_avance;

/**
 * Classe représentant un oiseau, spécialisation d'un Animal.
 */
public class Oiseau extends Animal {
    /** L'envergure des ailes de l'oiseau. */
    private double envergure;

    /**
     * Constructeur par défaut.
     */
    public Oiseau() {
    }

    /**
     * Constructeur complet.
     * 
     * @param nom       Le nom de l'oiseau.
     * @param age       Son âge.
     * @param poids     Son poids.
     * @param envergure L'envergure de ses ailes.
     */
    public Oiseau(String nom, int age, double poids, double envergure) {
        super(nom, age, poids);
        this.envergure = envergure;
    }

    /** @return L'envergure. */
    public double getEnvergure() {
        return envergure;
    }

    @Override
    public void seDeplacer() {
        System.out.println("L’oiseau vole.");
    }
}
