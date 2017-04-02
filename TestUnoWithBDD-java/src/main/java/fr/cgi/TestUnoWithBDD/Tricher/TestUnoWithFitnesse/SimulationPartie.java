/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cgi.TestUnoWithBDD.Tricher.TestUnoWithFitnesse;

import fr.cgi.TestUnoWithBDD.TestUnoFacade.FacadeUno;

/**
 *
 * @author cognetj
 */
public class SimulationPartie {
     
    FacadeUno facade;
    
    public boolean initialiserPartie(int nbJoueurs){
        //Initialisation du plateau de jeu
        facade = new FacadeUno();
        facade.initialiserPlateauDeJeu(nbJoueurs);
        return true;
    }
    
    public boolean ajouterJoueur(String nomJoueur){
        facade.ajouterJoueur(nomJoueur);
        return true;
    }
    
    public boolean lancerPartieSansDistribution(){
        facade.lancerPartieSansDistribution();
        return true;
    }
    
    public boolean donnerCarteAJoueur(String nomJoueur, String typeCarte, String couleur,int numeroCarte) throws Exception{
        facade.donnerCarteAJoueur(nomJoueur, typeCarte, couleur,numeroCarte);
        return true;
    }
    
    public int retourneNombreDeCartesDeLaPioche(){
        return facade.retourneNombreDeCartesDeLaPioche();
    }
    public int retourneNombreDeCartesDuJoueur(String joueur) throws Exception{
        return facade.retourneNombreDeCartesDuJoueur(joueur);
    }
    
    public int retourneNombreDeCartesDuTalon(){
        return facade.retourneNombreDeCartesDuTalon();
    }
    
    public boolean definirPremiereCarteDuTalon(String typeDeCarte, String couleur,int numeroCarte) throws Exception{
        facade.definirPremiereCarteDuTalon(typeDeCarte, couleur, numeroCarte);
        return true;
    }
    
    public String jouerCarte(String nomJoueur,String typeDeCarte, String couleur,int numeroCarte) throws Exception {
        try {
            facade.jouerCarte(nomJoueur, typeDeCarte, couleur, numeroCarte);
            return "OK";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
            
    public String decrireCarteSuperieureDuTalon(){
        return facade.decrireCarteSuperieureDuTalon();
    }    
    
    
    
}
