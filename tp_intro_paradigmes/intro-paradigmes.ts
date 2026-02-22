/**
 * TP - Introduction aux paradigmes
 * Implémentation en TypeScript (Paradigmes Impératif et Fonctionnel)
 */

export { };

// --- Partie 1 : Hello World ---
console.log("--- Partie 1 : Hello World ---");
console.log("Bonjour depuis le monde TypeScript !");

// --- Partie 2 : Somme des entiers ---
console.log("\n--- Partie 2 : Somme des entiers (1 à 5) ---");
const nSomme = 5;
const numbers = Array.from({ length: nSomme }, (_, i) => i + 1);

// Impératif (Boucle for)
let sumImperative = 0;
for (let i = 1; i <= nSomme; i++) {
    sumImperative += i;
}
console.log(`Impératif (for) : ${sumImperative}`);

// Fonctionnel (Reduce)
const sumFunctional = numbers.reduce((acc, curr) => acc + curr, 0);
console.log(`Fonctionnel (reduce) : ${sumFunctional}`);


// --- Partie 3 : Factorielle ---
console.log("\n--- Partie 3 : Factorielle (5) ---");
const nFact = 5;

// Impératif (Boucle for)
function factorialImperative(n: number): number {
    let result = 1;
    for (let i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}
console.log(`Impératif (for) : ${factorialImperative(nFact)}`);

// Fonctionnel (Récursion)
const factorialFunctional = (n: number): number =>
    n <= 1 ? 1 : n * factorialFunctional(n - 1);

console.log(`Fonctionnel (récursif) : ${factorialFunctional(nFact)}`);
