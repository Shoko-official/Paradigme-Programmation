package tp_java_objet_avance;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de test pour illustrer le polymorphisme et l'héritage avec la
 * hiérarchie Animal.
 */
public class TestAnimal {

    /**
     * Méthode statique pour faire se déplacer les animaux dont le poids est
     * supérieur à un seuil.
     * 
     * @param animaux  La liste des animaux.
     * @param poidsMin Le poids minimum requis pour se déplacer.
     */
    public static void faireBougerLesAnimaux(List<Animal> animaux, double poidsMin) {
        System.out.println("\n--- Animaux de plus de " + poidsMin + " kg qui se déplacent ---");
        for (Animal a : animaux) {
            if (a.getPoids() > poidsMin) {
                System.out.print(a.getNom() + " : ");
                a.seDeplacer();
            }
        }
    }

    /**
     * Point d'entrée pour les tests de la Partie 1.
     * 
     * @param args Arguments ligne de commande.
     */
    public static void main(String[] args) {
        List<Animal> mesAnimaux = new ArrayList<>();

        // Création d'instances variées
        mesAnimaux.add(new Chien("Rex", 5, 25.0, "Berger Allemand"));
        mesAnimaux.add(new Chat("Mistigri", 3, 4.5, "Gris"));
        mesAnimaux.add(new Oiseau("Piou", 1, 0.2, 0.3));

        // Test du polymorphisme dynamique sur la méthode parler()
        System.out.println("--- Test du polymorphisme (parler) ---");
        for (Animal a : mesAnimaux) {
            System.out.print(a.getClass().getSimpleName() + " " + a.getNom() + " dit : ");
            a.parler();
        }

        // Test de l'opérateur instanceof pour les méthodes spécifiques
        System.out.println("\n--- Test spécifique Chien (aboyer) ---");
        for (Animal a : mesAnimaux) {
            if (a instanceof Chien) {
                ((Chien) a).aboyer();
            }
        }

        // Test de l'héritage et de l'encapsulation (manger modifie le poids)
        System.out.println("\n--- Test alimentation ---");
        Animal chat = mesAnimaux.get(1);
        chat.manger(0.5);

        // Test du filtrage polymorphe par poids
        faireBougerLesAnimaux(mesAnimaux, 1.0);
    }
}
