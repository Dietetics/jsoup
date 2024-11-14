# Tâche #3: test sur divers environnements
- Sujet prise: Jsoup 

# Auteurs:
- Yongkang He 20220607
- Wanting teng 20179470

---
## Table des matières
- [Flags](#Differents-flags)
- [Structure](#Structure)
- [Changement apportés à la Github action](#Changement-apportes-a-la-Github-action)
- [Justification des Flags](#Justification-des-Flags)
- [Qualité](#Qualité)
- [humour](#humour)
- [Bonus](#Bonus)
- [Bibliographie](#Bibliographie)
---

## Differents flags
- Gestion du garbage collector:
  - "-XX:+UseG1GC"                                    
- Diagnostic:
  - "-XX:+PrintGCDetails"               
- Gestion de la memoire:
  - "-XX:MaxHeapSize=512m"              
- Activation de fonctionnalités avancées:
  - "-XX:+UnlockExperimentalVMOptions"  
- Compilation JIT:
  - "-XX:+OptimizeStringConcat"
---



## Structure
-         name: "Test Flag: ${{ matrix.jvm_flag }}, JDK: ${{ matrix.java }}, OS: ${{ matrix.os }}"
-       - name: Log JVM Flag ${{ matrix.jvm_flag }}"
          run: |
          echo "Running with JVM flag: ${{ matrix.jvm_flag }}"
Effet 1： ![Logs Clairs](assets/logsClairs.png)
Effet 2： ![Logs Clairs](assets/logsClairs2.png)
---




## Changement apportes a la Github action 
Au lieu de modifier les workflows existant, on a creer une nouvelle workflows au nom de jvm-flags-test.yml afin deviter 
les conflits visuels avec les workflows du tache2. On a garder la structure du build.yml, mais avec certain modification 
et amelioration.

1. `Configuration de la matrice de strategie

On a ajouter la matrix jvm_flag（`matrice de strategie`) qui permet dexecuter un job plusieurs 
fois avec des configurations differentes. Voici les  5 flags dans la matrix:

- "-XX:+UseG1GC", lors dexecution, permettre dactiver le garbage collector G1
- "-XX:+PrintGCDetails", lors dexecution, permettre dafficher les details des evenements de GC
- "-XX:MaxHeapSize=512m", lors dexecution, limite la taille maximale du tas a 512Mo
- "-XX:+UnlockExperimentalVMOptions", lors dexecution, deverrouille les options experimentales de la JVM
- "-XX:+OptimizeStringConcat", lors dexecution, optimise les operations de concatenation de chaines

Si necessaire, on peut aussi definir l'environnement ou la version de java (dans notre cas, ce nest pas necessaire)

2. Execution des étapes du workflow

Voici une petite résumé de la série d'étapes qui vont être exécutées pour chaque combinaison de la matrice
- Checkout du code: récupère le code source du repo pour l'utiliser
- Configuration du JDK: configure la version du java
- Application du flag JVM: le flag JVM sélectionné est passé à la variable d'env MAVEN_OPTS, permet ainsi d'être utiliser pendant l'exécution des tâches Maven
- Compilation et Tests: mvn compile test, puis la couverture est générée via JaCoCo
- Analyse de la couverture des tests: vérifier si ya augmentation, si ce n'est pas le cas, ca échoue
- Sauvegarde et affichage des résultats: les résultats sont sauvegardés dans un fichier texte et est affiché dans les logs

3. Utilisation des Flags JVM

   - Comme mentionner si haut concernant la variable d'environnement MAVEN_OPTS. Cela permet à Maven de les utiliser pour personnaliser la facon dont la JVM sexecute pendant les etapes de compilation, de test et d'execution

Bref, avec ces changements, on peut collectionner les donnees sur la couverture de code, de mieux comprendre comment differents
parametres JVM affectent les tests et les performances.
---


## Justification des Flags
1. -XX:+UseG1GC
- **Performance** : Il permet activer le garbage collector G1, qui est super pour gérer la mémoire dans des applications avec beaucoup de données. Il essaie de limiter les pauses dues à la gestion de la mémoire, ce qui peut améliorer les performances.
- **Observabilité** : Il fournit beaucoup d'infos sur la gestion de la mémoire, donc on peut facilement voir si quelque chose ne va pas (comme des fuites de mémoire).
- **Pourquoi c'est choisi** : Il aide à tester la gestion de la mémoire et la performance. C'est utile pour voir comment un application réagit à des demandes de mémoire importantes.

2. -XX:+PrintGCDetails
- **Performance** : Il fait en sorte que la JVM affiche des détails sur le garbage collection dans les logs. On saura exactement combien de temps chaque étape du garbage collection prend, quelle est la taille de la mémoire avant et après chaque collecte, etc.
- **Observabilité** : Ca peut légèrement ralentir l'application, car il y a plus de log à traiter, mais les infos sont super utiles pour comprendre ce qui se passe en arrière-plan.
- **Pourquoi c'est choisi** : C'est vraiment utile pour avoir une vue détaillée de la gestion de la mémoire et de l'impact du garbage collection, surtout pendant les tests.

3. -XX:MaxHeapSize=512m
- **Performance** : Il fixe la taille maximale du tas mémoire à 512 Mo. Si le tas est trop petit, la JVM va devoir faire plus de garbage collection, ce qui peut ralentir l'application. Si le tas est trop grand, ça consomme plus de mémoire, ce qui peut aussi poser problème.
- **Observabilité** : En limitant la taille de la mémoire, on peut tester comment un application gère les ressources sous pression. C’est un bon moyen de détecter des fuites ou des problèmes de mémoire.
- **Pourquoi c'est choisi** : Il permet de tester l'application avec une taille de mémoire plus petite pour voir comment elle réagit sous contraintes.

4. -XX:+UnlockExperimentalVMOptions
- **Performance** :  Il permet d'activer des options expérimentales dans la JVM. C'est un peu risqué, car ces options ne sont pas toujours stables, mais elles peuvent offrir des optimisations intéressantes.
- **Observabilité** :  Ces options peuvent être moins fiables, donc ce flag n'est pas toujours conseillé en production, mais c'est un moyen d'explorer des améliorations avant qu'elles soient officiellement intégrées
- **Pourquoi c'est choisi** : Il permet de tester de nouvelles fonctionnalités qui pourraient améliorer les performances, même si elles ne sont pas encore entièrement prêtes.
 
5. -XX:+OptimizeStringConcat
- **Performance** : Il optimise la concaténation des chaînes de caractères. Par défaut, la JVM crée des objets temporaires pour chaque concaténation, ce qui peut être lent si on fait beaucoup de manipulations de chaînes. Ce flag permet de rendre cette opération plus rapide.
- **Observabilité** : L'optimisation rend les choses plus rapides, mais parfois elle cache ce qui se passe sous le capot. Cependant, ça n'affecte généralement pas la qualité du code.
- **Pourquoi c'est choisi** : Si un application travaille beaucoup avec des chaînes de caractères, ce flag peut vraiment améliorer les performances.
 
---

## Qualité
- Voir github action
---


## humour
- voir github action
---


## Bonus
- ![Screenshot de tous les images de lolcommits](lolcommits/global.png)
- Path pour les images de lolcommits: `src/test/java/org/jsoup/IFT3913D2/lolcommits/`
---

## Bibliographie
- [Oracle](https://www.oracle.com/java/technologies/javase/vmoptions-jsp.html)
- [bellsoft](https://bell-sw.com/blog/guide-to-jvm-memory-configuration-options/)
---