# Tâche #3: test sur divers environnements
- Sujet prise: Jsoup 

# Auteurs:
- Yongkang He 20220607
- Wanting teng 20179470

---
## Table des matières
- [Flags](#Differents-flags)
- [Structure](#Structure)
- [Changement apportés à la Github action ](#Changement-apportés-à-la-Github-action)
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
avant notre test ![couverture sur close avant test](assets/methodeCloseAvant.png)


---
## Changement apportés à la Github action 
s
---

## Justification des Flags
          - "-XX:+UseG1GC" gestion du garbage collector
          - "-XX:+PrintGCDetails" diagnostic 
          - "-XX:MaxHeapSize=512m" gestion de la mémoire
          - "-XX:+UnlockExperimentalVMOptions" activation de fonctionnalités avancées
          - "-XX:TieredStopAtLevel=1" Compilation JIT

---

## Qualité

---


## humour
- voir github action
---


## Bonus
- voir lien pour les images
- ---

## Bibliographie

---