# RégimeIndé

## Language Policy

> While this repository is maintained in English, RégimeIndé is a tax simulator specifically designed for the French legal and fiscal framework.
> The mission of this open-source project is to demystify complex French regulations and make them accessible to every entrepreneur. Because the tool's logic and its target audience are strictly tied to French law, all functional documentation and user guides will be entirely written in French.

## Genèse du projet

Dans le but de développer ma stack technique en tant que concepteur développeur d'applications, j'ai entrepris l'[apprentissage documenté de Java et Spring Boot](https://github.com/sebaseg-dev/learn_java/tree/main).

Afin de mettre en œuvre mes apprentissages dans un cas concret, étant issu d'un background dans la filière de l'expertise comptable et récemment reconverti dans le développement, j'ai eu l'idée de créer un calculateur d'impôts et de cotisations, pour pallier d'une part la complexité des ressources disponibles sur le sujet, et aider d'autre part tous les nouveaux créateurs d'entreprises à se positionner sur le sujet d'un choix initial et qui porte beaucoup de conséquences des régimes et des structures juridiques.

> Ce projet a une vocation pédagogique à double-sens:
> - Aider les nouveaux créateurs d'entreprise dans les méandres des possibilités et options offertes par le cadre juridique, fiscal et social en donnant des informations précises et pédagogiques sur les conséquences des choix tout en sourçant les données et les calculs ;
> - Construire un projet avec Java Spring Boot, open-source et en production.

## Architecture de l'application

### Inventaire des technologies

- Java Spring Boot
- React
- SQLite
- SonarQube

### Choix de technologie : SQLite pour la donnée

Dans mon projet d'apprentissage, qui a donné lieu au développement d'un petit POC qui permet de faire les calculs pour un régime micro, j'ai utilisé un simple modèle de données basé sur un fichier JSON. L'idée étant qu'aucune donnée concernant les utilisateurs ou les saisies ne sera stockée, le format JSON permet de stocker les taux de l'administration tout en permettant une lecture et une mise à jour à la main. Cependant, la manipulation d'un JSON à la main est particulièrement risquée : avec le grossissement du fichier, le format perd de sa lisibilité pour un être humain, la syntaxe, bien que simple, nécessite d'être utilisée avec précision, faute de quoi, le projet tombe.

D'un autre côté, l'utilisation d'une base SQL paraissait plus robuste. Néanmoins, la base de données ne contiendra que les taux, historiques, des administrations fiscales et sociales. Ces données sont davantage des constantes, elles varient peu (une fois par an maximum), et il n'y a aucune gestion relationnelle entre les différents taux (ils sont publiés, n'ont aucune incidence entre eux). Mettre en place un serveur PostgreSQL pour gérer une poignée de constantes, c'est d'abord un gaspillage de ressources, et ensuite un outillage sous-utilisé.

Dans ma réflexion, il apparaît alors que l'entre-deux parfait (comme souvent) c'est d'utiliser une base SQLite :
- Base de données sous forme de fichier (pas de service dédié, simple d'accès, de duplication, de remplacement, de sauvegarde...) ;
- Structure de la donnée en tables (évite des problèmes de manipulation telles que l'édition d'un JSON d'une centaine de lignes à la main).
Nous n'utiliserons pas ou peu les relations entre les tables, mais c'est une technologie mieux dimensionnée qu'un serveur SQL (type PostgreSQL) et plus robuste qu'un fichier JSON édité à la main.

