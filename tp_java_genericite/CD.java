package tp_java_genericite;

/**
 * Classe représentant un album CD dans la médiathèque.
 * <p>
 * Un CD est un média qui possède un artiste et une durée.
 * Il implémente l'interface {@link Empruntable}.
 * </p>
 */
public class CD extends Media implements Empruntable {
    /** L'artiste ou le groupe. */
    private String artiste;

    /** La durée totale en minutes. */
    private int duree;

    /**
     * Constructeur par défaut.
     */
    public CD() {
    }

    /**
     * Constructeur complet pour un CD.
     * 
     * @param titre            Le titre de l'album.
     * @param anneePublication L'année de sortie.
     * @param artiste          L'artiste producteur.
     * @param duree            La durée en minutes.
     */
    public CD(String titre, int anneePublication, String artiste, int duree) {
        super(titre, anneePublication);
        this.artiste = artiste;
        this.duree = duree;
    }

    @Override
    public String getDescription() {
        return "CD de " + artiste + ", durée : " + duree + " min.";
    }

    @Override
    public void emprunter() {
        System.out.println("Le CD '" + getTitre() + "' a été emprunté.");
    }
}
