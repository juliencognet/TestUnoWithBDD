/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cgi.TestUnoWithBDD.Tricher.TestUnoWithFitnesse;

import fr.cgi.TestUnoWithBDD.TestUnoFacade.FacadeUno;
import fr.utt.lo02.uno.jeu.carte.Carte;

/**
 *
 * @author cognetj
 */
public class ValeurDesCartes {
    String typeCarte;

    public void setTypeDeCarte(String typeCarte) {
        this.typeCarte = typeCarte;
    }
    String couleur;
    int numéro;

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setNuméro(int numéro) {
        this.numéro = numéro;
    }
    
    public int valeur(){
        Carte carte = FacadeUno.getCardByColorAndNumber(this.typeCarte,this.couleur, this.numéro);
        return carte.getValeurPoints();
    }
}
