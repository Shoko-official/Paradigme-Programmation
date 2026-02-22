package tp_java_objet_avance;

/**
 * Classe représentant un chat, spécialisation d'un Animal.
 */
public class Chat extends Animal {
    /** La couleur du pelage du chat. */
    private String couleur;

    /**
     * Constructeur par défaut.
     */
    public Chat() {
    }

    /**
     * Constructeur complet.
     * 
     * @param nom     Le nom du chat.
     * @param age     Son âge.
     * @param poids   Son poids.
     * @param couleur La couleur de sa robe.
     */
    public Chat(String nom, int age, double poids, String couleur) {
        super(nom, age, poids);
        this.couleur = couleur;
    }

    /** @return La couleur du chat. */
    public String getCouleur() {
        return couleur;
    }

    @Override
    public void parler() {
        System.out.println("Miaou!");
    }
}
