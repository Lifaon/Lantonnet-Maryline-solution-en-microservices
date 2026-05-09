# Lantonnet-Maryline-solution-en-microservices
Neuvième et dernier projet de la formation Java d'OpenClassrooms.

## Construction et lancement des images docker
`mvn clean install`

`mvn jib:dockerBuild -pl !patient/api,!note/api,!risk/api`

`docker compose up -d`

## Green code
Ce projet a pour l'instant une architecture minimale, mais dans le cas où
sa structure se développerait de façon exponentielle, voici un rappel des
grands principes du green code :

- ### Réduire les traitements inutiles
  N'exécuter que ce qui est nécessaire, éviter les boucles, requêtes ou
  calculs redondants, et privilégier la mise en cache des résultats coûteux.

- ### Optimiser les transferts de données
  Limiter la taille des payloads (pagination, projections), compresser les
  réponses, et éviter de transférer des données qui ne seront pas utilisées.

- ### Choisir des algorithmes efficaces
  La complexité algorithmique a un impact direct sur la consommation CPU.
  Un algorithme O(n²) remplacé par O(n log n) consomme moins d'énergie à
  grande échelle.

- ### Dimensionner au juste nécessaire
  Éviter l'over-engineering et les dépendances inutiles. Chaque librairie
  ajoutée a un coût mémoire et CPU.

- ### Privilégier l'asynchrone et l'événementiel
  Éviter les requêtes actives et les threads bloqués qui consomment des
  ressources sans produire de valeur.

- ### Optimiser les accès aux bases de données
  Indexer correctement, éviter le "problème N+1", et ne sélectionner que les
  colonnes nécessaires.

- ### Éteindre ce qui ne sert pas
  Scaling to zero : mise en veille des services inactifs, et nettoyage des
  ressources inutilisées.