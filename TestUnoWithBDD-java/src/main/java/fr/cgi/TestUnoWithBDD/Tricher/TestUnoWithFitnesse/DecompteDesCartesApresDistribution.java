/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cgi.TestUnoWithBDD.Tricher.TestUnoWithFitnesse;

import fr.cgi.TestUnoWithBDD.TestUnoFacade.FacadeUno;
import fr.utt.lo02.uno.jeu.exception.JeuException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cognetj
 */
public class DecompteDesCartesApresDistribution {

    public List<List<List<String>>> query(){
        FacadeUno facade = new FacadeUno();
        facade.initialiserPlateauDeJeu(4);
        facade.ajouterJoueur("Marc");
        facade.ajouterJoueur("Rémi");
        facade.ajouterJoueur("Julien");
        facade.ajouterJoueur("Damien");
        facade.lancerPartieViaDistributionAleatoire();
        return facade.recupererNombreDeCartesEnMainParJoueur();
    }
    
 
}
