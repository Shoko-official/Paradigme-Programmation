% ==============================================================================
% TP - Introduction à Prolog
% ==============================================================================

% ------------------------------------------------------------------------------
% Partie 1 - Les faits et les requêtes
% ------------------------------------------------------------------------------

% Faits
couleur(pomme, rouge).
couleur(ballon, bleu).
couleur(citron, jaune).

mange(romain, pomme).
mange(lea, citron).
mange(sarah, pomme).

/*
=== Exercice 1 - Requêtes ===

1. Qui est rouge ?
   ?- couleur(X, rouge).

2. Qu’est-ce que mange Léa ?
   ?- mange(lea, X).

3. Qui mange une pomme ?
   ?- mange(X, pomme).

4. Quel objet est de couleur jaune ?
   ?- couleur(X, jaune).
*/

% ------------------------------------------------------------------------------
% Partie 2 - Règles
% ------------------------------------------------------------------------------

% X aime Y si X mange Y
aime(X, Y) :- mange(X, Y).

couleur(carotte, orange).
mange(bob, carotte).
mange(claire, banane).

% Faits additionnels pour les types
type(pomme, fruit).
type(citron, fruit).
type(banane, fruit).
type(carotte, legume).

% 1. aime_fruit(Personne)
aime_fruit(Personne) :- mange(Personne, X), type(X, fruit).

% 2. meme_couleur(X, Y)
meme_couleur(X, Y) :- couleur(X, C), couleur(Y, C), X \= Y.

% 3. aiment_la_meme_chose(A, B)
aiment_la_meme_chose(A, B) :- mange(A, X), mange(B, X), A \= B.

/*
=== Requêtes de test (Partie 2) ===
?- aime_fruit(lea).
?- meme_couleur(X, Y).
?- aiment_la_meme_chose(romain, sarah).
*/

% ------------------------------------------------------------------------------
% Partie 3 - Manipulation des listes
% ------------------------------------------------------------------------------

% Pattern [H|T] : H est la tête (head), T est le reste (tail)

% Exercice 3 - Longueur d'une liste
longueur([], 0).
longueur([_|T], N) :-
    longueur(T, N1),
    N is N1 + 1.

/*
=== Questions (Exercice 3) ===

1. Expliquer en 2 phrases le fonctionnement de cette règle.
   La règle utilise la récursion : le cas de base définit qu'une liste vide a une longueur de 0.
   Le cas récursif ignore l'élément de tête, calcule la longueur du reste de la liste, puis ajoute 1 au résultat.

2. Tests :
   ?- longueur([a,b,c], N).
   ?- longueur([], N).
   ?- longueur([1,2,3,4,5], N).

3. Pourquoi "_" dans la tête de la règle ?
   Le symbole "_" (underscore) désigne une variable anonyme. On l'utilise ici car la valeur 
   de l'élément de tête n'importe pas pour le calcul de la longueur ; on a seulement besoin 
   de savoir que la liste n'est pas vide.
*/

% Exercice 4 - Somme d'une liste
somme([], 0).
somme([H|T], Resultat) :-
    somme(T, R1),
    Resultat is H + R1.

/*
=== Tests (Exercice 4) ===
?- somme([1,2,3], S).
?- somme([], S).
*/

% ------------------------------------------------------------------------------
% Partie 4 - Relations familiales
% ------------------------------------------------------------------------------

homme(pierre).
homme(luc).
homme(andre).

femme(marie).
femme(sara).

parent(pierre, luc).
parent(marie, luc).
parent(andre, pierre).
parent(sara, marie).

% Exercice 5 - Règles
pere(P, E) :- homme(P), parent(P, E).
mere(M, E) :- femme(M), parent(M, E).

grand_parent(GP, E) :- parent(GP, Z), parent(Z, E).

ancetre(A, E) :- parent(A, E).
ancetre(A, E) :- parent(A, Z), ancetre(Z, E).

frere_ou_soeur(A, B) :- parent(P, A), parent(P, B), A \= B.

/*
=== Exercice 6 - Vérifications ===
?- grand_parent(sara, luc).
?- ancetre(andre, luc).
?- frere_ou_soeur(luc, X).
*/

% ------------------------------------------------------------------------------
% Partie 5 - Petits problèmes logiques
% ------------------------------------------------------------------------------

% Exercice 7 - Membre d’une liste
membre(X, [X|_]).
membre(X, [_|T]) :- membre(X, T).

/*
=== Test Exercice 7 ===
?- membre(3, [1,2,3]).
?- membre(X, [1,2,3]).
*/

% Exercice 8 - Maximum d’une liste
max_liste([X], X).
max_liste([H|T], Max) :-
    max_liste(T, MaxT),
    (H > MaxT -> Max = H ; Max = MaxT).

/*
=== Test Exercice 8 ===
?- max_liste([1, 5, 3, 9, 2], M).
*/
