package tp_java_genericite;

/**
 * Classe abstraite de base représentant un média (Livre, CD, etc.) dans le
 * système de gestion.
 * <p>
 * Cette classe définit les attributs communs à tous les médias et impose
 * l'implémentation
 * d'une méthode de description détaillée.
 * </p>
 * 
 * @author Georgio
 * @version 1.0
 */
public abstract class Media {
    /** Le titre du média. */
    private String titre;

    /** L'année de publication du média. */
    private int anneePublication;

    /**
     * Constructeur par défaut.
     */
    public Media() {
    }

    /**
     * Constructeur complet pour initialiser un média.
     * 
     * @param titre            Le titre du média.
     * @param anneePublication L'année de sortie.
     */
    public Media(String titre, int anneePublication) {
        this.titre = titre;
        this.anneePublication = anneePublication;
    }

    /**
     * Récupère le titre du média.
     * 
     * @return Le titre.
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Récupère l'année de publication.
     * 
     * @return L'année.
     */
    public int getAnneePublication() {
        return anneePublication;
    }

    /**
     * Fournit une description textuelle complète du média.
     * Cette méthode doit être implémentée par les classes dérivées.
     * 
     * @return Une chaîne décrivant le média.
     */
    public abstract String getDescription();

    /**
     * Affiche les détails du média dans la console.
     * Utilise le polymorphisme pour appeler la méthode {@link #getDescription()}.
     */
    public void afficherDetails() {
        System.out.println(getDescription());
    }

    @Override
    public String toString() {
        return getTitre() + " (" + getAnneePublication() + ")";
    }
}
