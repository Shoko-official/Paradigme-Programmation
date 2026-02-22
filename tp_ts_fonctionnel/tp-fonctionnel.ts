/**
 * TP - Introduction au fonctionnel
 * 
 * Ce fichier contient les exercices du TP sur la programmation fonctionnelle en TypeScript.
 */

export { };

// =============================================================================
// Partie 1 — Fonctions pures et effets de bord
// =============================================================================

/**
 * Exercice 1 — Fonction pure vs impure
 */

let counter = 0;

/**
 * Fonction PURE : 
 * - Ses sorties dépendent uniquement de ses entrées.
 * - Ne modifie aucun état extérieur (pas d'effets de bord).
 */
function add(a: number, b: number): number {
    return a + b;
}

/**
 * Fonction IMPURE : 
 * - Modifie une variable globale (`counter`).
 * - Son résultat change à chaque appel même avec les mêmes paramètres.
 */
function increment(): number {
    counter++;
    return counter;
}

/*
RÉPONSES AUX QUESTIONS :

- Pourquoi `add` est-elle prévisible ?
  Car pour les mêmes arguments (ex: 2 et 3), elle retournera TOUJOURS le même résultat (5),
  peu importe combien de fois on l'appelle ou l'état du reste de l'application.

- Pourquoi `increment` ne l’est pas ?
  Car son résultat dépend d'un état global mutable. Si on l'appelle 3 fois, on obtient 
  1, puis 2, puis 3. Son comportement est lié à "l'histoire" de l'exécution, ce qui 
  rend le débogage et les tests plus complexes.
*/

// =============================================================================
// Partie 2 — Immutabilité
// =============================================================================

/**
 * Exercice 2 — Mettre à jour sans muter
 */
const student = { name: "Léo", grade: 14 };

function updateGrade(s: typeof student, newGrade: number) {
    // On utilise le spread operator pour créer une COPIE avec la modification
    return { ...s, grade: newGrade };
}

const updatedStudent = updateGrade(student, 18);

console.log("--- Exercice 2 ---");
console.log("Original student:", student); // Doit rester { name: "Léo", grade: 14 }
console.log("Updated student:", updatedStudent);

// =============================================================================
// Partie 3 — Fonctions d’ordre supérieur
// =============================================================================

/**
 * Exercice 3 — Appliquer plusieurs fois
 */
function applyNTimes(f: (x: number) => number, n: number, x: number): number {
    let result = x;
    for (let i = 0; i < n; i++) {
        result = f(result);
    }
    return result;
}

const double = (x: number) => x * 2;
console.log("\n--- Exercice 3 ---");
console.log("Double 1, 3 fois:", applyNTimes(double, 3, 1)); // Attendu: 8

// =============================================================================
// Partie 4 — map, filter, reduce
// =============================================================================

const numbers = [1, 2, 3, 4, 5, 6];

/**
 * Exercice 4.1 — Filtrer et transformer
 */
// 1. Pairs -> 2. * 2 -> 3. Somme
const result41 = numbers
    .filter(n => n % 2 === 0)
    .map(n => n * 2)
    .reduce((acc, curr) => acc + curr, 0);

console.log("\n--- Exercice 4.1 ---");
console.log("Somme des pairs multipliés par 2:", result41); // Attendu: 24

/**
 * Exercice 4.2 — Somme moyenne et produit
 */
const sum = (list: number[]) => list.reduce((acc, n) => acc + n, 0);

const average = (list: number[]) => list.length === 0 ? 0 : sum(list) / list.length;

const product = (list: number[]) => list.reduce((acc, n) => acc * n, 1);

console.log("\n--- Exercice 4.2 ---");
console.log("Sum:", sum(numbers));
console.log("Average:", average(numbers));
console.log("Product:", product(numbers));

// =============================================================================
// Partie 5 — Autres fonctions de liste
// =============================================================================

const users = [
    { name: "Alice", age: 25 },
    { name: "Bob", age: 15 },
    { name: "Charlie", age: 30 },
    { name: "Diana", age: 17 },
];

/**
 * Exercice 5.1 — find
 */
const firstAdult = users.find(u => u.age >= 18);
console.log("\n--- Exercice 5.1 ---");
console.log("Premier majeur:", firstAdult);

/**
 * Exercice 5.2 — some / every
 */
const hasMinor = users.some(u => u.age < 18);
const allOver10 = users.every(u => u.age > 10);
console.log("\n--- Exercice 5.2 ---");
console.log("Au moins un mineur ?", hasMinor);
console.log("Tous > 10 ans ?", allOver10);

/**
 * Exercice 5.3 — includes
 */
const names = users.map(u => u.name);
console.log("\n--- Exercice 5.3 ---");
console.log("Alice présente ?", names.includes("Alice"));
console.log("Eve présente ?", names.includes("Eve"));

/**
 * Exercice 5.4 — Collections imbriquées (flatMap)
 */
const usersWithHobbies = [
    { name: "Alice", hobbies: ["climbing", "yoga"] },
    { name: "Bob", hobbies: ["gaming"] },
    { name: "Charlie", hobbies: ["reading", "hiking"] },
];

const allHobbies = usersWithHobbies.flatMap(u => u.hobbies);
console.log("\n--- Exercice 5.4 ---");
console.log("Tous les hobbies:", allHobbies);

/**
 * Exercice 5.5 — sort et slice
 */
// On crée une copie avec le spread operator car .sort() mute l'original
const twoYoungest = [...users]
    .sort((a, b) => a.age - b.age)
    .slice(0, 2);

console.log("\n--- Exercice 5.5 ---");
console.log("Les 2 plus jeunes (sans mutation):", twoYoungest);
console.log("Liste originale intacte ?", users[0].name === "Alice"); // Vérification

// =============================================================================
// Partie bonus - cas concret
// =============================================================================

type User = { name: string; age: number; country: string };

const data: User[] = [
    { name: "Alice", age: 25, country: "France" },
    { name: "Bob", age: 15, country: "France" },
    { name: "Charlie", age: 30, country: "Spain" },
    { name: "Diana", age: 22, country: "France" },
];

/**
 * Objectifs :
 * 1. Adultes français
 * 2. Leurs noms
 * 3. Tri par âge décroissant
 * 4. Moyenne d’âge
 */

// Pipeline de traitement
const frenchAdultsNames = data
    .filter(u => u.country === "France" && u.age >= 18)
    .sort((a, b) => b.age - a.age) // Décroissant
    .map(u => u.name);

const frenchAdultsAges = data
    .filter(u => u.country === "France" && u.age >= 18)
    .map(u => u.age);

const averageAgeFrenchAdults = frenchAdultsAges.length > 0
    ? sum(frenchAdultsAges) / frenchAdultsAges.length
    : 0;

console.log("\n--- Partie Bonus ---");
console.log("Noms des adultes français (triés par âge):", frenchAdultsNames);
console.log("Moyenne d'âge des adultes français:", averageAgeFrenchAdults);
