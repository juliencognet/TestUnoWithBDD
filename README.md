# TestUnoWithBDD

Ce projet sert de laboratoire pour tester le Behavior Driven Development.
Et si nous testions le Behavior Driven Development ?
Le behavior driven development est une pratique issue de l’agilité qui vise à plus 
de collaboration entre les développeurs et leurs key users. Le principe est de mettre 
en œuvre un langage naturel pour exprimer le comportement du logiciel. On pourra ainsi 
décrire des spécifications par l’exemple qui servent aussi de description des cas de tests. 

Des outils tels que Fitnesse, JBehave ou Cucumber permettent de faire le lien entre ces 
exemples exprimés en langage naturel et notre code de test pour faire en sorte de transformer 
ces spécifications en tests exécutables. 

Je vous propose de tester ces outils sur un exemple un peu ludique. 
Nous utiliserons le code d’un jeu de Uno développé en Java, dans lequel j’ai volontairement 
introduit des anomalies. 
Nous partirons à la recherche de ces anomalies en implémentant des « spécifications par 
l’exemple » testables et exécutables qui permettront à la fois de documenter l’application 
et de la tester. 

Pour commencer, récupérer les fichiers de mon Github: https://github.com/juliencognet/TestUnoWithBDD

0. Récupération des librairies et compilation du projet
Une fois le projet Maven TestUnoWithBDD-java récupéré, vous devez lancer un maven install sur le
projet pour récupérer les bibliothèques requises et compiler le projet. 
Retenez bien le chemin complet de votre répertoire TestUnoWithBDD-java/target/classes.


1. Utilisation de Fitnesse

Dans FitnesseUno/, lancer runFitness.bat (ou java -jar fitnesse-standalone.jar.
Ouvrir un navigateur, puis taper: http://localhost
Observer les exemples présents dans ExemplesSimplesAvecSlim ou ExemplesSimplesAvecFit.
Pour la suite de nos expériences, nous utilisons le moteur Slim, recommandé par Fitnesse.
Vous pouvez aussi consulter la documentation présente dans User guide / Slim.
Retourner ensuite à la home page de Fitnesse (en cliquant sur le logo FitNesse) puis ouvrir la 
page Uno présente dans Mes pages.

La première chose à faire est de modifier la variable classpath en pointant vers votre dossier 
TestUnoWithBDD-java/target/classes.

Ensuite, vous n'avez plus qu'à suivre les instructions des exercices 1 à 4 pour parvenir à 
décrire vos spécifications par l'exemple et ainsi créer des spécifications exécutables.


2. Utilisation de Cucumber

A venir ...
