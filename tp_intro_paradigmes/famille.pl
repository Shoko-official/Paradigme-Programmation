/**
 * TP - Introduction aux paradigmes
 * Partie 4 : Mini base familiale Prolog
 */

% --- Faits (Facts) ---
parent(jean, paul).
parent(paul, luc).
parent(marie, luc).
parent(sophie, paul).
parent(sophie, claire).

% --- Règles de base ---

% Grand-parent : X est grand-parent de Y si X est parent d’un Z qui est parent de Y
grandparent(X, Y) :- parent(X, Z), parent(Z, Y).

% Frère/soeur : X est frère/soeur de Y s'ils partagent un parent
% On ajoute X \= Y pour éviter que quelqu'un soit son propre frère/soeur
sibling(X, Y) :- 
    parent(Z, X), 
    parent(Z, Y), 
    X \= Y.

% --- Règles complexes ---

% Ancêtre (définition récursive)
% Cas de base : X est parent direct de Y
ancestor(X, Y) :- parent(X, Y).

% Récursion : X est ancêtre de Y si X est parent de Z et Z est l'ancêtre de Y
ancestor(X, Y) :- 
    parent(X, Z), 
    ancestor(Z, Y).

% Oncle/tante : X est l'oncle ou la tante de Y si X est le frère/soeur d'un parent Z de Y
uncle_or_aunt(X, Y) :- 
    sibling(X, Z), 
    parent(Z, Y).

% Cousin : X et Y sont cousins si leurs parents respectifs (PX et PY) sont frères/soeurs
cousin(X, Y) :-
    parent(PX, X),
    parent(PY, Y),
    sibling(PX, PY).

/**
 * RÉPONSES AUX QUESTIONS :
 * 
 * 1. Quelle est la différence entre grandparent et ancestor ?
 *    - grandparent(X, Y) : Définit une relation fixe de second degré (X est le parent du parent de Y).
 *    - ancestor(X, Y)    : Est une relation récursive. Elle inclut les parents, les grands-parents, 
 *                          les arrière-grands-parents, etc. (X est à n'importe quel échelon au-dessus de Y).
 * 
 * 2. Que se passe-t-il si on interroge : ?- ancestor(X, luc). ?
 *    Prolog va chercher toutes les solutions satisfaisant la règle :
 *    - D'abord les parents directs (paul, marie).
 *    - Puis récursivement les parents de paul (jean, sophie), qui sont les grands-parents de luc.
 *    L'utilisateur peut appuyer sur ';' pour faire défiler tous les ancêtres trouvés.
 */

/**
 * EXEMPLES DE REQUÊTES :
 * 
 * 1. Qui sont les grands-parents de luc ?
 *    ?- grandparent(X, luc).
 * 
 * 2. Paul a-t-il des frères ou soeurs ?
 *    ?- sibling(paul, X).
 * 
 * 3. Jean est-il un ancêtre de luc ?
 *    ?- ancestor(jean, luc).
 * 
 * 4. Qui est l'oncle/tante de luc ?
 *    ?- uncle_or_aunt(X, luc).
 * 
 * 5. Claire et Luc sont-ils cousins ?
 *    ?- cousin(claire, luc).
 */
