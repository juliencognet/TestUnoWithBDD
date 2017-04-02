package MoreAdvancedCucumberTest;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cognetj
 */
public class PersonRepository {

@Given("^L'entrepôt contient N Personnes$")
public void l_entrepôt_contient_N_Personnes() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^Je crée une Personne$")
public void je_crée_une_Personne() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^J'obtiens l'ID de la Personne créée et l'entrepôt contient plus de N Personnes$")
public void j_obtiens_l_ID_de_la_Personne_créée_et_l_entrepôt_contient_plus_de_N_Personnes() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Given("^L'entrepôt contient la Personnes Anakin Skywalker$")
public void l_entrepôt_contient_la_Personnes_Anakin_Skywalker() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^Je supprime la Personne (\\d+)$")
public void je_supprime_la_Personne(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^L'entrepôt contient moins de N Personnes$")
public void l_entrepôt_contient_moins_de_N_Personnes() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^Je recupère la Personne (\\d+)$")
public void je_recupère_la_Personne(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^J'obtiens la Personne d'identifiant (\\d+) contenant les données Anakin, Skywalker, (\\d+)\\.(\\d+) BBY$")
public void j_obtiens_la_Personne_d_identifiant_contenant_les_données_Anakin_Skywalker_BBY(int arg1, int arg2, int arg3) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^J'obtiens la Personne d'identifiant (\\d+) contenant les données Luke, Skywalker, (\\d+) BBY$")
public void j_obtiens_la_Personne_d_identifiant_contenant_les_données_Luke_Skywalker_BBY(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^J'obtiens la Personne d'identifiant (\\d+) contenant les données Leia, Organa Solo, (\\d+) BBY$")
public void j_obtiens_la_Personne_d_identifiant_contenant_les_données_Leia_Organa_Solo_BBY(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Given("^L'entrepôt contient les Personnes suivantes$")
public void l_entrepôt_contient_les_Personnes_suivantes(DataTable arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
    // E,K,V must be a scalar (String, Integer, Date, enum etc)
    throw new PendingException();
}

@When("^Je modifie la Personne (\\d+) avec Organa Solo Skywalker$")
public void je_modifie_la_Personne_avec_Organa_Solo_Skywalker(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^J'obtiens la Personne d'identifiant (\\d+) contenant les données Leia, Organa Solo Skywalker, (\\d+) BBY$")
public void j_obtiens_la_Personne_d_identifiant_contenant_les_données_Leia_Organa_Solo_Skywalker_BBY(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}    
}
