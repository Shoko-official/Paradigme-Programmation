![GitHub stars](https://img.shields.io/github/stars/Shoko-official/TP1-Genericite?style=social)
![Dernier commit](https://img.shields.io/github/last-commit/Shoko-official/TP1-Genericite)

# TP Georgio - ravaux Pratiques

Ce dépôt contient l'ensemble des TPs réalisés, organisés par dossier et documentés avec **Javadoc**.

## Structure du projet

Les fichiers sont organisés en packages Java pour une meilleure gestion dans les IDE (VS Code, IntelliJ, Eclipse).

### [tp_prolog](file:///C:/Users/Shoko/Downloads/TP%20Georgio/tp_prolog/)
*   `tp.pl` : Introduction à Prolog (Faits, règles, récursivité, listes).

### [tp_ts_fonctionnel](file:///C:/Users/Shoko/Downloads/TP%20Georgio/tp_ts_fonctionnel/)
*   `tp-fonctionnel.ts` : Programmation fonctionnelle (Fonctions pures, immutabilité).

### [tp_java_genericite](file:///C:/Users/Shoko/Downloads/TP%20Georgio/tp_java_genericite/)
*   Gestion de médiathèque avec **Generics**, **Collections** et **Comparateurs**.
*   Fichier principal : `Main.java`.

### [tp_java_objet_avance](file:///C:/Users/Shoko/Downloads/TP%20Georgio/tp_java_objet_avance/)
*   Hiérarchie `Animal` illustrant l'**Héritage**, le **Polymorphisme** et l'**Encapsulation** (portée `protected`).
*   Fichier principal : `TestAnimal.java`.

### [tp_intro_paradigmes](file:///C:/Users/Shoko/Downloads/TP%20Georgio/tp_intro_paradigmes/)
*   Comparaison des paradigmes **Objet**, **Impératif**, **Fonctionnel** et **Logique**.
*   Fichiers : `IntroParadigmes.java`, `intro-paradigmes.ts`, `intro_paradigmes.pl`, `famille.pl`.

---

## Instructions d'exécution

### Java (avec packages)
Depuis la racine du projet (`TP Georgio`) :

**Généricité :**
```bash
javac -d . tp_java_genericite/*.java
java tp_java_genericite.Main
```

**Objet Avancé :**
```bash
javac -d . tp_java_objet_avance/*.java
java tp_java_objet_avance.TestAnimal
```

**Introduction aux Paradigmes :**
```bash
javac -d . tp_intro_paradigmes/*.java
java tp_intro_paradigmes.IntroParadigmes
```

### TypeScript
Depuis le dossier correspondant :
```bash
npx ts-node <nom-du-fichier>.ts
```

### Prolog
Ouvrir les fichiers `.pl` sur [SWISH](https://swish.swi-prolog.org/).
