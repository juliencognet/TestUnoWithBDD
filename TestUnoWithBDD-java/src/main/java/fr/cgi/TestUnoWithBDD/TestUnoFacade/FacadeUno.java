/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cgi.TestUnoWithBDD.TestUnoFacade;

import fr.utt.lo02.uno.jeu.Jeu;
import fr.utt.lo02.uno.jeu.Partie;
import fr.utt.lo02.uno.jeu.action.Action;
import fr.utt.lo02.uno.jeu.action.ActionJoueur;
import fr.utt.lo02.uno.jeu.action.ActionPoseCarte;
import fr.utt.lo02.uno.jeu.action.AutomateActions;
import fr.utt.lo02.uno.jeu.carte.Carte;
import fr.utt.lo02.uno.jeu.carte.CarteInversion;
import fr.utt.lo02.uno.jeu.carte.CarteJoker;
import fr.utt.lo02.uno.jeu.carte.CarteNumero;
import fr.utt.lo02.uno.jeu.carte.CartePasseTour;
import fr.utt.lo02.uno.jeu.carte.CartePlusDeux;
import fr.utt.lo02.uno.jeu.carte.CartePlusQuatre;
import fr.utt.lo02.uno.jeu.carte.Couleur;
import fr.utt.lo02.uno.jeu.carte.TypeCarte;
import fr.utt.lo02.uno.jeu.carte.ensemble.PlateauJeu;
import fr.utt.lo02.uno.jeu.exception.ActionInvalideException;
import fr.utt.lo02.uno.jeu.exception.JeuException;
import fr.utt.lo02.uno.jeu.joueur.Joueur;
import fr.utt.lo02.uno.jeu.joueur.ListeJoueurs;
import fr.utt.lo02.uno.jeu.joueur.TourJoueur;
import fr.utt.lo02.uno.jeu.joueur.TypeJoueur;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cognetj
 */
public class FacadeUno {
    
    private PlateauJeu plateau;
    private ListeJoueurs joueurs;
    private Jeu jeu;
    private Partie partie;    
    
    /**
     * Fonction de conversion permettant de retrouver une Couleur par son nom
     * @param colorName parmi Rouge, Verte, Jaune, Bleu
     * @return 
     */
    private static Couleur getColorByName(String colorName){
        switch (colorName){
            case "Rouge": return Couleur.ROUGE;
            case "Verte": return Couleur.VERT;
            case "Vert":  return Couleur.VERT;
            case "Bleue": return Couleur.BLEU;
            case "Bleu":  return Couleur.BLEU;
            case "Jaune": return Couleur.JAUNE;
        }
        return null;
    }
    
    /**
     * Fonction permettant de retrouver une carte Uno par sa couleur (ou son type)
     * et son numéro
     * @param typeCarte parmi Rouge, Verte, Jaune, Bleu, +2, Passer, Joker, SuperJoker, Inversion
     * @param numero de 0 à 9 pour les cartes de couleurs
     * @return Carte
     */
    public static Carte getCardByColorAndNumber(String typeCarte,String couleur,int numero){
        switch (typeCarte){
            case "Numero": return new CarteNumero(getColorByName(couleur),numero);
            case "+2": return new CartePlusDeux(getColorByName(couleur));
            case "Passer": return new CartePasseTour(getColorByName(couleur));
            case "Joker": return new CarteJoker();
            case "Super Joker": return new CartePlusQuatre();
            case"Inversion": return new CarteInversion(getColorByName(couleur));
        }
        return null;
    }    

    /**
     * Fonction interne permettant d'incrémenter le nombre de carte par type pour une couleur de carte
     * @param typeCarte parmi Rouge, Verte, Jaune, Bleu, +2, Passer, Joker, SuperJoker, Inversion
     * @param nombreDeCartesParType HashMap de décompte des cartes par type
     */
    private void ajouteNombreCarteParType(String typeCarte,HashMap<String,Integer> nombreDeCartesParType){
        int nbCartes=0;
        if (nombreDeCartesParType.containsKey(typeCarte)){
         nbCartes = nombreDeCartesParType.get(typeCarte);
        }
        nbCartes++;
        nombreDeCartesParType.put(typeCarte, nbCartes);
    }    
    
    /**
     * Fonction permettant de trier une carte par type
     * @param carte CarteUno qu'on peut récupérer par exemple avec la fonction getCardByColorAndNumber
     * @param nombreDeCartesParType HashMap de décompte des cartes par type à laquelle on ajoutera +1 pour le type de carte
     */
    public void trierCarte(Carte carte, HashMap<String,Integer> nombreDeCartesParType){
            switch (carte.getType()) {
                case INVERSION: ajouteNombreCarteParType("Inversion",nombreDeCartesParType);break;
		case JOKER:     ajouteNombreCarteParType("Joker",nombreDeCartesParType);break;
		case NUMERO:    {
                    switch (carte.getCouleur()){
                        case ROUGE:   ajouteNombreCarteParType("Rouge",nombreDeCartesParType);break;
                        case VERT:    ajouteNombreCarteParType("Verte",nombreDeCartesParType);break;
                        case BLEU:    ajouteNombreCarteParType("Bleue",nombreDeCartesParType);break;
                        case JAUNE:   ajouteNombreCarteParType("Jaune",nombreDeCartesParType);break;
                    }
                };break;
		case PASSE_TOUR: ajouteNombreCarteParType("Passer",nombreDeCartesParType);break;
		case PLUS_DEUX: ajouteNombreCarteParType("+2",nombreDeCartesParType);break;
		case PLUS_QUATRE: ajouteNombreCarteParType("Super Joker",nombreDeCartesParType);break;
            }        
    }    
    
    /**
     * Fonction de tri de toutes les cartes de la pioche
     * @return une HashMap de décompte des cartes par type de toute la pioche
     */
    public HashMap<String,Integer> trierCartesDeLaPioche(){
        HashMap<String,Integer> nombreDeCartesParType = new HashMap<>();
        
        //Je propose le principe suivant qui est de piocher toutes les cartes les
        //unes après les autres pour inventorier les cartes
        while (plateau.getPioche().getNombre()>0){
            Carte carte = plateau.getPioche().piocher();
            trierCarte(carte,nombreDeCartesParType);
        }
        return nombreDeCartesParType;
    }
    
    /**
     * Initialisation du plateau de jeu, après initialisation, une pioche complète est présente avec toutes les cartes du Uno,
     * Une carte de la pioche est retournée et présente sur le talon
     * Les cartes ne sont pas encore distribuées
     * @param nbJoueurs Nombre de joueurs participant à la partie
     */
    public void initialiserPlateauDeJeu(int nbJoueurs){
        this.plateau = new PlateauJeu();
        this.joueurs = new ListeJoueurs(nbJoueurs);
    }
    
    /**
     * Fonction à appeler après initialisation pour ajouter un joueur à la partie
     * @param nomJoueur nom du joueur
     */
    public void ajouterJoueur(String nomJoueur){
        try {
            joueurs.ajoutJoueur(new Joueur(TypeJoueur.HUMAIN,nomJoueur));
        } catch (JeuException ex) {
            Logger.getLogger(FacadeUno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Lancement de la partie après initialisation
     * Les cartes sont distribuées à chaque joueur
     */
    public void lancerPartieViaDistributionAleatoire(){
           this.partie = new Partie(joueurs,plateau);
           this.jeu = new Jeu(joueurs.getNombre());
           this.jeu.debutPartie(partie);
           this.partie.lancer();
    }
    
    public void lancerPartieSansDistribution(){
        this.partie = new Partie(joueurs,plateau);
    }

    public Joueur retrouveJoueurParNom(String nomJoueur) throws Exception{
        Joueur joueurCherche = null;

        for (Joueur joueur: this.partie.getJoueurs().getListeJoueurs()){
            if (joueur.getNom().equals(nomJoueur)){
                joueurCherche = joueur;
                break;
            }
        }
        if (joueurCherche == null){
            throw new Exception("Impossible de retrouver le joueur "+nomJoueur);
        }
        return joueurCherche;
    }
    
    private boolean carteIdentique(Carte carte1, Carte carte2){
        if (carte1.getType().name().equals(carte2.getType().name())){
            if (carte1.getValeurPoints()==carte2.getValeurPoints()){
                if ((carte1.getType().equals(TypeCarte.JOKER)||(carte1.getType().equals(TypeCarte.PLUS_QUATRE)))){
                    return true; 
                } else if (carte1.getCouleur().getNom().equals(carte2.getCouleur().getNom())){
                    return true;
                }}}
        return false;
    }
    
    
    private Carte chercheDansLaPioche(String typeCarte, String couleur,int numeroCarte) throws Exception{
        Carte carteCherchee = FacadeUno.getCardByColorAndNumber(typeCarte, couleur,numeroCarte);        
        Carte carteTrouvee = null;
        int nombreDeCartesDansLaPioche = this.plateau.getPioche().getNombre();
        boolean isCarteRetrouvee=false;
        for (int i=0; i<nombreDeCartesDansLaPioche;i++){
            Carte carteDeLaPioche = this.plateau.getPioche().piocher();
            if ( carteIdentique(carteDeLaPioche, carteCherchee)
                    &&!isCarteRetrouvee )
            {
                carteTrouvee = carteDeLaPioche;
                isCarteRetrouvee= true;
            } else {
                this.plateau.getTalon().poser(carteDeLaPioche);
            }
        }
        //Reconstituer la pioche
        this.plateau.reconstruirePioche(this.plateau.getTalon().piocher());
        
        if (!isCarteRetrouvee){
            throw new Exception("Carte "+typeCarte+" "+numeroCarte+" non trouvée");
        } else {
            return carteTrouvee;
        }
    }
    
    private Carte chercheDansMainJoueur(String nomJoueur, String typeCarte, String couleur,int numeroCarte) throws Exception{
        Joueur joueurCherche = this.retrouveJoueurParNom(nomJoueur);
        Carte carteCherchee = FacadeUno.getCardByColorAndNumber(typeCarte, couleur,numeroCarte);        
        Carte carteTrouvee = null;
        
        for (Carte carteMainJoueur : joueurCherche.getMain().getCartes()){
            if ( carteIdentique(carteMainJoueur, carteCherchee)){
               return carteMainJoueur;  
            } 
        } 
        throw new Exception("Carte "+typeCarte+" "+numeroCarte+" non trouvée dans la main du joueur "+nomJoueur);
    }    
    
    /**
     * Fonction permettant de "tricher" et de donner une carte spécifique de la pioche à un joueur
     * @param nomJoueur
     * @param typeCarte
     * @param numeroCarte 
     */
    public void donnerCarteAJoueur(String nomJoueur, String typeCarte,String couleur, int numeroCarte) throws Exception{
        Joueur joueurCherche = retrouveJoueurParNom(nomJoueur);
        //Mettre à la pioche la première carte du talon
        if (this.plateau.getTalon().getNombre()>0){
            this.plateau.getPioche().poser(this.plateau.getTalon().piocher());        
        }
        Carte carteRecherchee = chercheDansLaPioche(typeCarte, couleur,numeroCarte);
        joueurCherche.getMain().ajoutCarte(carteRecherchee);
    }

    private void deplacerPremiereCarteDuTalonVersPioche(){
        if (this.plateau.getTalon().getNombre()>0){
            this.plateau.getPioche().poser(this.plateau.getTalon().piocher());
        }
    }
    
    public boolean definirPremiereCarteDuTalon(String typeCarte, String couleur,int numeroCarte) throws Exception{
        deplacerPremiereCarteDuTalonVersPioche();
        Carte carteRecherchee= chercheDansLaPioche(typeCarte, couleur, numeroCarte);
        deplacerPremiereCarteDuTalonVersPioche();
        this.plateau.getTalon().poser(carteRecherchee);
        return true;
    }
    
    public boolean jouerCarte(String nomJoueur,String typeCarte, String couleur, int numeroCarte) throws Exception{
        Joueur joueur = this.retrouveJoueurParNom(nomJoueur);
        partie.commenceTour();
        TourJoueur tour = null;
        
        if (!(partie.getJoueurs().getJoueur().getNom().equals(joueur.getNom()))){
            throw new Exception("Ce n'est pas le tour de "+nomJoueur+"");
        }
        
        try{
            tour = joueur.getTour();
        } catch (Exception e){
            throw new Exception("Ce n'est pas le tour de "+nomJoueur+" : "+e.getMessage()+"");
        }
        if (tour == null){
            throw new Exception("Ce n'est pas le tour de "+nomJoueur+"");
        }
        
        AutomateActions automAct = tour.getActions();
        List<ActionJoueur> actions = automAct.getActionsPossibles();
        int i=0;
        int actionALancer=-1;
        for (ActionJoueur action:actions){
            if (action.getType().equals(Action.POSE)){
                ActionPoseCarte actionPose=(ActionPoseCarte)action;
                if (carteIdentique(getCardByColorAndNumber(typeCarte, couleur,numeroCarte),actionPose.getCarte())){
                    actionALancer = i;
                }
            }
            i++;
        }
        if (i==-1){
            throw new Exception ("Le joueur "+nomJoueur+" ne peut pas poser la carte "+typeCarte+" de numero "+numeroCarte+"");
        }
        
        if (actionALancer==-1){
            throw new Exception ("Action de poser carte "+typeCarte+" / "+couleur+" / "+numeroCarte+" impossible.");
        }
        try{
            joueur.getTour().faireAction(actionALancer);
        } catch (ActionInvalideException e){
            throw new Exception ("Erreur lors de l'action de poser carte "+typeCarte+" / "+numeroCarte+" : "+e.getMessage()+"");
        }
        partie.finTour();
        partie.nouveauTour();
        plateau.getTalon().getCarte().faireEffet(partie, true);
        return true;
    }
    

    
    /**
     * 
     * @param nomJoueur
     * @return
     * @throws Exception 
     */
    public int retourneNombreDeCartesDuJoueur(String nomJoueur) throws Exception{
        Joueur joueur = retrouveJoueurParNom(nomJoueur);
        return joueur.getMain().getCartes().size();
    }
    /**
     * 
     * @return 
     */
    public int retourneNombreDeCartesDeLaPioche(){
        return this.plateau.getPioche().getNombre();
    }
    
    public int retourneNombreDeCartesDuTalon(){
        return this.plateau.getTalon().getNombre();
    }
    
    /**
     * Fonction retournant un tableau listant pour chaque joueur le nombre de cartes qu'il a en main
     * @return tableau de tableaux de tableaux de la forme suivante:
     * [
     *   [
     *     [ "Joueur", "Nom joueur 1"],
     *     [ "nombre de cartes en main", "3"]
     *   ],
     *   [
     *     [ "Joueur", "Nom joueur 2"],
     *     [ "nombre de cartes en main", "4"]
     *   ], ...
     * ]
     */
    public List<List<List<String>>> recupererNombreDeCartesEnMainParJoueur(){
        List<List<List<String>>> resultat = new ArrayList();
            
        for (Joueur joueur : ((ListeJoueurs)partie.getJoueurs()).getJoueurs() ){
            String nomJoueur = joueur.getNom();
            int nbCartesEnMain = joueur.getMain().getCartes().size();

            ArrayList oneResult = new ArrayList();
            oneResult.add(asList("Joueur",nomJoueur));
            oneResult.add(asList("nombre de cartes en main",nbCartesEnMain));
            resultat.add(oneResult);
        }
        return resultat;
    }
    
    /**
     * Retourne la première carte retournée de la pioche présente sur le talon
     * @return Carte Uno
     */
    public Carte recupererPremiereCarteRetourneeDuTalon(){
        return plateau.getTalon().getCarte();
    }
    
    public String decrireCarteSuperieureDuTalon(){
        return plateau.getTalon().getCarte().toString();
    }
}
