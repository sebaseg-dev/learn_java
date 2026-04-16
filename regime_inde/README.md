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

## Conception de l'interface

### Postulat de base

La logique de l'application repose sur un triptyque classique de système :
1. L'utilisateur saisit ses données (remplissage du profil entrepreneur – données d'entrée) ;
2. Le simulateur calcule les impôts et cotisations sociales en fonction des régimes et options possibles (traitement) ;
3. L'application renvoie vers les sources officielles d'une part et des explications complémentaires d'autre part (restitution).

L'interface de l'application suit cette approche dans une interface simple, intuitive, accessible : tout doit se passer en une seule page, les liens entre les données des différentes étapes sont clairement visibles.

Décrire un arbre logique dans un seul cas de figure est assez simple : au sein d'un seul régime, certains choix sont possibles ou non, il est ainsi facile de représenter un cheminement linéaire. Cependant, le choix parmi plusieurs régimes est complexe : les différentes dispositions et traitements dépendent beaucoup de chaque régime et nécessitent des données ou des typologies de données distinctes, ne donnant pas forcément de résultats simples à comparer. L'enjeu d'une restitution unique des résultats ne doit ni conduire à des raccourcis pouvant induire en erreur ou être confusant pour l'utilisateur, ni devenir trop lourde visuellement avec une interface trop chargée pour prendre en compte les spécificités de chaque cas.

> L'utilisateur est indépendant dans sa recherche, il doit arriver à un niveau de maîtrise suffisant pour effectuer un choix libre et éclairé sur sa structure et ses options.
> Cependant, il doit être considéré comme novice : cette application est un des points d'entrée de sa recherche ou de confirmation de ses recherches antérieures, il doit quitter l'application en ayant progressé sur sa compréhension du sujet.

### Hypothèses de base dans la conception

- L'Utilisateur connait sa catégorie d'activité. Pour effectuer les calculs des impôts et taxes, nous avons besoin de connaitre la catégorie de l'activité (BIC, BNC, libéral – réglementé ou non, location de meublé classé...). Si l'on fonctionne avec l'ensemble des impôts et taxes, la catgorisation devient un sujet complexe. Nous pourrions ici aider à la détermination de la catégorie, au moins principale, de l'activité ; mais ce sont des réflexions supplémentaires qui ne font pas partie de la problématique à laquelle répond cette application et ne sera pas proposé dans une première version.
- L'activité de l'Utilisateur ne se déroule que dans une seule catégorie. Un entrepreneur peut proposer plusieurs types d'activités, imposés différemment (notamment pour le cas de l'Entreprise). Par exemple, un développeur free-lance peut réaliser des prestations de service free-lance (par exemple un audit d'accessibilité), mais aussi avoir une partie accessoire considérée comme commerciale (il développe un SaaS dont il vend des licences d'utilisation). L'ensemble de son activité correspond à deux catégories dans ce cas, avec l'application de plafonds (plafond de CA pour le régime micro), de taux (d'abattement, d'imposition, de cotisation) différents en fonction de ses activités. Pour la première version, une approche simplifiée sera adoptée : une seule catégorie d'activité sera prise en compte, la catégorie principale.
- Les revenus de l'Utilisateur liés à son activité indépendante sont traités comme ses revenus principaux dans un foyer fiscal d'une seule part. Les impôts sur le revenu sont des impôts personnels : il n'existe pas un taux unique pour taxer tous les revenus (notion de foyer fiscal, impact de la priorisation des revenus pour affecter l'impôt à chaque activité, particularités de niches ou crédits/réductions d'impôts...). Les revenus tirés de la simulation ne prendront pas en compte les caractéristiques personnelles de l'assujetti ; le premier euro imposable au titre de l'activité d'indépendant sera le premier euro imposé sur la première tranche du barème, sans prise en compte d'éléments extérieurs (par exemple la déductibilité des dons à des organisations d'utilité publique). Dans une version ultérieure, il devrait être possible de déterminer une autre activité principale, de manière à ajuster la tranche utilisée pour l'imposition du premier euro (exemple de l'auto-entreprise en complément d'activité : l'utilisateur à un travail salarié qui sera imposé sur les premières tranches, l'activité indépendante est complémentaire et commencera sur des tranches suivantes).
- L'Utilisateur utilise le simulateur en vue de créer son activité. Dans une première version, le simulateur ne permettra le calcul que dans le cadre de l'exercice suivant la date de démarrage de l'activité, nécessaire pour certains calculs (taux acquis dès la naissance de la structure telle que le dispositif ARCE). Il ne sera pas pris en compte les exercices éventuels extérieurs (qui créent des complications pour la gestion des plafonds d'admissibilité à certains régimes – micro notamment). Bien utilisé, cela devrait permettre normalement d'approcher des simulations en cours de vie néanmoins (charge à l'Utilisateur de s'assurer du respect des contraintes fiscales portant sur l'antériorité).

- La TVA ne sera pas prise en compte dans la simulation. La TVA est surtout un mécanisme lié à la trésorerie : cela crée des décalages temporels entre décaissements et encaissements (fait générateur, date d'exigibilité, distinction entre facturation/livraison/encaissement/décaissement pour l'Utilisateur). Ce simulateur est orienté résultats et non pas trésorerie. Il faudra juste apporter les informations nécessaires à l'Utilisateur pour qu'il inscrive les bonnes données (cohérence entre CA et charges). Il est alors admis que le CA soit exprimé TTC (utilisateur en franchise de base de TVA).
- L'historique des taux utilisés démarrera à partir du 1er janvier 2025. La loi de finances 2026 étant récente, il peut être utile d'avoir accès aux taux 2025 pour d'éventuelles comparaisons avec des outils existants ou des données réelles de l'Utilisateur. Cette application n'a pas vocation à comparer les années entre-elles, il ne parait pas utile aujourd'hui de remonter plus loin dans l'historique des taux.

### Interface et données

#### Régimes prévus

Régimes prévus :
- Micro entreprise
  - Imposition au réel des revenus (régime micro-fiscal)
  - Option pour le Prélèvement Forfaitaire Libératoire (PFL)
- Entreprise individuelle (EI)
- Entreprise Unipersonnelle à Responsabilité Limitée (EURL)
- Société par Actions Simplifiée Unipersonnelle (SASU)
- Société d'Exercice Libéral Unipersonnelle à Responsabilité Limitée (SELURL)
- Société d'Exercice Libéral par Actions Simplifiée Unipersonnelle (SELASU)

Options :
- Aide à la Création ou à la Reprise d'une Entreprise (ACRE) : pour éviter la multiplication des colonnes dans le tableau de résultats, vu que l'ACRE est une option disponible dans beaucoup de cas différents, elle sera traitée comme une réduction de charges (et c'est bien la nature de cette aide), donc viendra dans une ligne du tableau (et non pas dans une colonne dédiée) en déduction des cotisations sociales calculées.

#### Tableau d'utilisation des données d'entrée

| Données d'entrée     | Micro entreprise | EI | EURL | SASU | SELURL | SELASU | 
|:---------------------|:----------------:|:--:|:----:|:----:|:------:|:------:|
| Catégorie d'activité |        ✔         |    |      |      |        |        |
| Chiffre d'affaires   |        ✔         |    |      |      |        |        |

_Pour le moment, les autres régimes (EI, EURL, SASU, SELURL et SELASU) n'ont pas été étudiés._

#### Tableau d'organisation des données de sortie

| Poste                                       | Micro entreprise (PFL) | Micro entreprise (IR) |
|:--------------------------------------------|:----------------------:|:---------------------:|
| Chiffre d'affaires                          |           ✔            |           ✔           |
| Impôt sur le revenu                         |           ✔            |           ✔           |
| Cotisations sociales                        |           ✔            |           ✔           |
| Contribution à la Formation Professionnelle |           ✔            |           ✔           |
| Revenus nets                                |           ✔            |           ✔           |

_Pour le moment, toutes les lignes sont applicables à tous les régimes. Les régimes supplémentaires (notamment des sociétés) n'ayant pas encore été étudiées, ce sont eux qui viendront modifier la représentation des résultats et introduire des lignes supplémentaires : cela créera des problèmes de comparaison des résultats, donc un besoin de représenter un tableau unique ici pour prendre en compte les difficultés de restitution._

