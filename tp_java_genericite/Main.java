package tp_java_genericite;

import java.util.*;
import java.util.function.Predicate;

/**
 * Classe principale de démonstration pour le TP Généricité.
 * <p>
 * Ce programme illustre l'usage des collections génériques (List, Set, Map),
 * des méthodes génériques et des comparateurs personnalisés.
 * </p>
 */
public class Main {

    /**
     * Affiche tous les éléments d'une liste quelconque.
     * 
     * @param <T>   Le type des éléments.
     * @param liste La liste à parcourir.
     */
    public static <T> void afficherListe(List<T> liste) {
        for (T element : liste) {
            System.out.println(element.toString());
        }
    }

    /**
     * Filtre une liste selon un prédicat donné.
     * 
     * @param <T>     Le type des éléments.
     * @param liste   La liste source.
     * @param critere Le prédicat définissant la condition de filtrage.
     * @return Une nouvelle liste contenant les éléments validés par le critère.
     */
    public static <T> List<T> filtrer(List<T> liste, Predicate<T> critere) {
        List<T> resultat = new ArrayList<>();
        for (T element : liste) {
            if (critere.test(element)) {
                resultat.add(element);
            }
        }
        return resultat;
    }

    /**
     * Copie tous les éléments d'une collection source vers une collection
     * destination.
     * 
     * @param <T>         Le type des éléments.
     * @param source      La collection d'origine.
     * @param destination La collection cible.
     */
    public static <T> void copierCollection(Collection<T> source, Collection<T> destination) {
        destination.addAll(source);
    }

    /**
     * Point d'entrée de l'application de test.
     * 
     * @param args Arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        // --- Initialisation des collections ---
        List<Media> mediatheque = new ArrayList<>();
        Set<Membre> membres = new HashSet<>();
        Map<Membre, List<Media>> empruntsMap = new HashMap<>();

        // Création des médias
        Livre l1 = new Livre("Le Petit Prince", 1943, "Antoine de Saint-Exupéry", 96);
        Livre l2 = new Livre("1984", 1949, "George Orwell", 328);
        Livre l3 = new Livre("Le Problème à trois corps", 2008, "Liu Cixin", 400);
        CD c1 = new CD("Discovery", 2001, "Daft Punk", 61);
        CD c2 = new CD("Thriller", 1982, "Michael Jackson", 42);

        mediatheque.add(l1);
        mediatheque.add(l2);
        mediatheque.add(l3);
        mediatheque.add(c1);
        mediatheque.add(c2);

        // Création des membres
        Membre m1 = new Membre("Alice", 1);
        Membre m2 = new Membre("Bob", 2);
        membres.add(m1);
        membres.add(m2);

        // Gestion des emprunts
        m1.emprunterMedia(l1);
        m1.emprunterMedia(c1);
        m2.emprunterMedia(l2);

        empruntsMap.put(m1, m1.getMediasEmpruntes());
        empruntsMap.put(m2, m2.getMediasEmpruntes());

        // --- Tests des méthodes génériques ---
        System.out.println("\n--- Liste complète des médias ---");
        afficherListe(mediatheque);

        System.out.println("\n--- Médias publiés après 2000 ---");
        List<Media> recents = filtrer(mediatheque, m -> m.getAnneePublication() > 2000);
        afficherListe(recents);

        System.out.println("\n--- Membres dont le nom commence par 'A' ---");
        List<Membre> membresA = filtrer(new ArrayList<>(membres), m -> m.getNom().startsWith("A"));
        afficherListe(membresA);

        // --- Tris et comparateurs ---
        System.out.println("\n--- Tri par année (décroissant) puis titre ---");
        mediatheque.sort((a, b) -> {
            if (b.getAnneePublication() != a.getAnneePublication()) {
                return Integer.compare(b.getAnneePublication(), a.getAnneePublication());
            }
            return a.getTitre().compareTo(b.getTitre());
        });
        afficherListe(mediatheque);

        // Tri spécifique pour les livres (auteur puis titre)
        List<Livre> livres = new ArrayList<>();
        livres.add(l1);
        livres.add(l2);
        livres.add(l3);

        System.out.println("\n--- Tri des livres (auteur puis titre) ---");
        livres.sort(Comparator.comparing(Livre::getAuteur).thenComparing(Livre::getTitre));
        afficherListe(livres);

        // --- Défis avancés ---

        // 1. Copie de collection
        List<Media> copieMediatheque = new ArrayList<>();
        copierCollection(mediatheque, copieMediatheque);

        // 2. Médias empruntés sans doublons (Set via Map)
        Set<Media> tousEmprunts = new HashSet<>();
        for (List<Media> listeEmprunts : empruntsMap.values()) {
            tousEmprunts.addAll(listeEmprunts);
        }
        System.out.println("\n--- Tous les médias empruntés (sans doublons) ---");
        afficherListe(new ArrayList<>(tousEmprunts));

        // 3. Filtrage polymorphe (Livre uniquement)
        System.out.println("\n--- Filtrage polymorphe : uniquement les Livres ---");
        List<Media> uniquementLivres = filtrer(mediatheque, m -> m instanceof Livre);
        afficherListe(uniquementLivres);

        // --- Polymorphisme avec afficherDetails ---
        System.out.println("\n--- Détails de tous les médias (Polymorphisme via afficherDetails) ---");
        for (Media m : mediatheque) {
            m.afficherDetails();
        }
    }
}
