package tp_intro_paradigmes;

/**
 * Classe de démonstration des différents paradigmes en Java.
 * <p>
 * Ce TP illustre l'approche Objet (via une classe dédiée) et
 * l'approche Impérative (via des méthodes statiques et des boucles).
 * </p>
 */
class Calculatrice {
    /**
     * Calcule la somme des entiers de 1 à n (Approche Objet).
     * 
     * @param n L'entier limite.
     * @return La somme calculée.
     */
    public int somme(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        return total;
    }
}

/**
 * Point d'entrée pour la comparaison des paradigmes.
 */
public class IntroParadigmes {

    /**
     * Calcule la factorielle de n (Approche Impérative).
     * 
     * @param n Le nombre à calculer.
     * @return La factorielle de n.
     */
    public static long factorielle(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Exécute les démonstrations de Hello World, Somme et Factorielle.
     * 
     * @param args Arguments de ligne de commande.
     */
    public static void main(String[] args) {
        // --- Partie 1 : Hello World (Objet) ---
        System.out.println("--- Partie 1 : Hello World ---");
        System.out.println("Bonjour depuis le monde Java !");

        // --- Partie 2 : Somme des entiers (Objet via Calculatrice) ---
        System.out.println("\n--- Partie 2 : Somme des entiers ---");
        Calculatrice calc = new Calculatrice();
        int nSomme = 5;
        System.out.println("Somme de 1 à " + nSomme + " (Objet) : " + calc.somme(nSomme));

        // --- Partie 3 : Factorielle (Impératif) ---
        System.out.println("\n--- Partie 3 : Factorielle ---");
        int nFact = 5;
        System.out.println("Factorielle de " + nFact + " (Impératif) : " + factorielle(nFact));
    }
}
