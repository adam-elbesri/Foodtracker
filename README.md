# pwa2021-2022
Projet de Programmation Web Avancée 2021-2022

> #### Liste des membres du projet :
>
> - SMADAN Houssan
> - BACHELET Leo
> - EL BESRI Adam
>
>  *Premier rendu back-end effectué le* **11/10/2021**.

# Informations Générale

Notre projet de développement web vise à réaliser la traçabilité de l'alimentation quotidienne d'une personne en fonction de ses propriétés corporelles.
De manière générale, ce projet s'inscrit dans l'objectif d'améliorer la santé publique afin d'adopter de bonnes pratiques alimentaires.
Ps : les données que nous utilisons dans l'application sont générées à partir d'OpenFoodFacts.

## Technologies

A list of technologies used within the project:

- [Spring Boot](https://spring.io/): Version 2.5.5
- [Vue.js](https://012.vuejs.org/): Version 12.16
- Rest API
- Thymeleaf

## Les instructions pour obtenir, compiler, lancer, tester, …, votre projet

<p>La première partie du projet nécessite l'installation de mysql. Dans la seconde partie avec VueJS et Rest API la base de donnée utilisée est celle de H2</p>
<p>Au lancement de l'application on peut soit créer un compte soit se connecter directement, après s'être connecté nous pouvons accèder à l'application depuis le bouton "commencer"</p>
<p>Nous pouvons rechercher un aliment dans la barre de recherche puis l'ajouter grâce au bouton "Add". Chaque aliment ajouté est inclus dans le tableau en bas de la page</p>
<p>Nous pouvons supprimer un aliment ajouté et nous avons le total de calories que l'utilisateur doit consommer par jour selon ses caractéristiques</p>

## Une description de l’architecture (quelle partie interagit avec quelle partie, par ex., database, pages spring, spring REST, Vue, …)

La table "Eaten" correspond à la liaison entre la table "User" et la table "Food"

<p>L'ajout d'un aliment se fait avec la méthode POST en utilisant fetch api (api/eatens/) avec les paramètres (id de l'aliment, date d'ajout, id de l'utilisateur, portion de l'aliment) </p>
<p>La suppression d'un aliment se fait avec la méthode DELETE en utilisant fetch api (api/eatens/id_aliment)</p>

