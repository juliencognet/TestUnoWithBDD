Feature: Tests de l application Uno
  
  # Repartition des cartes - Le Uno contient 108 cartes réparties d une certaine maniere.
  Scenario: Decompte des cartes avant distribution aleatoire.
    Given un plateau de Uno deballe et complet sans aucune carte perdue
    When Je decompte les cartes du type <typeCarte> et de couleur <couleurCarte>
    Then Je decompte <decompte> cartes.

  Examples:
   | typeCarte   | couleur    | decompte |
   | Numero      | Bleue      | 19       |
   | Joker       | Noire      | 4        |