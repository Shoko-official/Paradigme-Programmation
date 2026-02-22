package tp_java_genericite;

/**
 * Classe représentant un livre dans la médiathèque.
 * <p>
 * Un livre est un média qui possède un auteur et un nombre de pages.
 * Il implémente l'interface {@link Empruntable}.
 * </p>
 */
public class Livre extends Media implements Empruntable {
    /** L'auteur du livre. */
    private String auteur;

    /** Le nombre de pages. */
    private int nbPages;

    /**
     * Constructeur par défaut.
     */
    public Livre() {
    }

    /**
     * Constructeur complet pour un livre.
     * 
     * @param titre            Le titre du livre.
     * @param anneePublication L'année de parution.
     * @param auteur           L'auteur de l'ouvrage.
     * @param nbPages          Le nombre de pages.
     */
    public Livre(String titre, int anneePublication, String auteur, int nbPages) {
        super(titre, anneePublication);
        this.auteur = auteur;
        this.nbPages = nbPages;
    }

    @Override
    public String getDescription() {
        return "Livre de " + auteur + ", " + nbPages + " pages.";
    }

    @Override
    public void emprunter() {
        System.out.println("Le livre '" + getTitre() + "' a été emprunté.");
    }

    /**
     * Récupère l'auteur.
     * 
     * @return L'auteur.
     */
    public String getAuteur() {
        return auteur;
    }
}
