package tp_java_genericite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Représente un membre de la bibliothèque pouvant emprunter des médias.
 */
public class Membre {
    /** Le nom complet du membre. */
    private String nom;

    /** L'identifiant numérique unique. */
    private int id;

    /** La liste des médias actuellement empruntés par ce membre. */
    private List<Media> mediasEmpruntes;

    /**
     * Crée un nouveau membre.
     * 
     * @param nom Le nom du membre.
     * @param id  L'identifiant unique.
     */
    public Membre(String nom, int id) {
        this.nom = nom;
        this.id = id;
        this.mediasEmpruntes = new ArrayList<>();
    }

    /** @return Le nom du membre. */
    public String getNom() {
        return nom;
    }

    /** @return L'ID du membre. */
    public int getId() {
        return id;
    }

    /** @return La liste des médias empruntés. */
    public List<Media> getMediasEmpruntes() {
        return mediasEmpruntes;
    }

    /**
     * Enregistre l'emprunt d'un média pour ce membre.
     * Si le média est empruntable, l'action d'emprunt est déclenchée.
     * 
     * @param media Le média à emprunter.
     */
    public void emprunterMedia(Media media) {
        mediasEmpruntes.add(media);
        if (media instanceof Empruntable) {
            ((Empruntable) media).emprunter();
        }
    }

    @Override
    public String toString() {
        return "Membre {" + nom + ", " + id + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Membre membre = (Membre) o;
        return id == membre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
