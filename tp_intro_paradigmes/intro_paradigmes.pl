/**
 * TP - Introduction aux paradigmes
 * Implémentation en Prolog (Paradigme Logique)
 */

% --- Partie 1 : Hello World ---
% Pour tester : ?- hello.
hello :- write('Bonjour depuis le monde Prolog !'), nl.

% --- Partie 2 : Somme des entiers ---
% Somme de 1 à N.
% Pour tester : ?- somme(5, X).
somme(0, 0).
somme(N, Resultat) :-
    N > 0,
    N1 is N - 1,
    somme(N1, R1),
    Resultat is N + R1.

% --- Partie 3 : Factorielle ---
% Factorielle de N.
% Pour tester : ?- factorielle(5, X).
factorielle(0, 1).
factorielle(N, Resultat) :-
    N > 0,
    N1 is N - 1,
    factorielle(N1, R1),
    Resultat is N * R1.
