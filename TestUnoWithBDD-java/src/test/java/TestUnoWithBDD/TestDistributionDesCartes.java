package TestUnoWithBDD;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import fr.cgi.TestUnoWithBDD.TestUnoFacade.FacadeUno;
import org.junit.Assert; 

import java.util.HashMap;

import org.junit.runner.RunWith;

public class TestDistributionDesCartes {

    FacadeUno facadeUno;
    HashMap<String,Integer> nombreDeCartesParType;
    private String couleurDeCarte;
    private String typeDeCarte;    
	
	@Given("^un plateau de Uno deballe et complet sans aucune carte perdue$")
	public void un_plateau_de_Uno_deballe_et_complet_sans_aucune_carte_perdue() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
        //On initialise la facade Uno
        facadeUno = new FacadeUno();
        
        //Ensuite, il faut initialiser le plateau de jeu avec 4 joueurs
        facadeUno.initialiserPlateauDeJeu(4);
        
        //Puis trier les cartes de la pioche
        this.nombreDeCartesParType = facadeUno.trierCartesDeLaPioche();
        
        //Mais aussi rajouter aussi la première carte
        facadeUno.trierCarte(facadeUno.recupererPremiereCarteRetourneeDuTalon(),this.nombreDeCartesParType);
		
	}	
	
    @When("^je decompte les cartes du type (.+) et de couleur (.+)$")
    public void je_decompte_les_cartes_du_type_et_de_couleur(String typecarte, String couleur) throws Throwable {
        this.typeDeCarte=typecarte;
        this.couleurDeCarte=couleur;
    }

	@Then("^je decompte (\\d+) cartes\\.$")
	public void je_decompte_cartes(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(arg1, nombreDeCartesParType.get((this.typeDeCarte.equals("Numero"))?couleurDeCarte:this.typeDeCarte).intValue());
	}




}
