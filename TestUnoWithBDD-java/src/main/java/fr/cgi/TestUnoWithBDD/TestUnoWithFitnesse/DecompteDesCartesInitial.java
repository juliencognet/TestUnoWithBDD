/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cgi.TestUnoWithBDD.TestUnoWithFitnesse;

import fr.cgi.TestUnoWithBDD.TestUnoFacade.FacadeUno;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author cognetj
 */
public class DecompteDesCartesInitial {
    private String couleurDeCarte;
    private String typeDeCarte;

    public void setTypeDeCarte(String typeDeCarte) {
        this.typeDeCarte = typeDeCarte;
    }
    FacadeUno facadeUno;
    HashMap<String,Integer> nombreDeCartesParType;

    public DecompteDesCartesInitial() {
    }

    public void setCouleurDeCarte(String couleurDeCarte) {
        this.couleurDeCarte = couleurDeCarte;
    }
    
    public int nombreDeCartes(){
        //To implement
        return -1;
    }
    
    // The following functions are optional.  If they aren't declared they'll be ignored.
    
    // Function table is called just after the constructor and before the first row is processed. 
    // It is passed a list of lists that contain all the cells of the table except for the very first row. 
    // The argument contains a list of rows, each row is a list of cells. 
    // This is the same format that is passed to the doTable method of the Table table. 
    public void table(List<List<String>> table) {
    }

    // Function beginTable is called once, just after the table method, and just before the rows are processed. This is for setup and initialization stuff.
    public void beginTable() {
        //On initialise la facade Uno
        facadeUno = new FacadeUno();
        
        //Ensuite, il faut initialiser le plateau de jeu avec 4 joueurs
        // >> A implémenter
        
        //Puis trier les cartes de la pioche
        // >> A implémenter
        
        //Mais aussi rajouter aussi la première carte
        // >> A implémenter
    }

    // Function reset is called once for each row before any set or output functions are called.
    public void reset() {
    }

    // Function execute is called once for each row just after all the set functions have been called, and just before the first output function (if any) are called.
    public void execute() {
    }
    
    // Function endTable is called once, just after the last row has been processed. It's the last function to be called by the table. Use it for cleanup and closedowns
    public void endTable() {
    }    
}
