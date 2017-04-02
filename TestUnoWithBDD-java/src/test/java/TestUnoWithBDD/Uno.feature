Feature: Tests de l application Uno
  
  # Repartition des cartes - Le Uno contient 108 cartes réparties d une certaine maniere.
  Scenario Outline: Decompte des cartes avant distribution aleatoire.
    Given un plateau de Uno deballe et complet sans aucune carte perdue
    When je decompte les cartes du type <typeCarte> et de couleur <couleur>
    Then je decompte <decompte> cartes.

  Examples:
    | typeCarte   | couleur    | decompte |
    | Passer      | Bleue      | 8        |
    | Joker       | Noire      | 4        |