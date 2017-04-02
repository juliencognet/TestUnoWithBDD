/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cgi.TestUnoWithBDD.SimpleTestsWithSlim;

import java.util.List;

/**
 *
 * @author cognetj
 */
public class SimpleDecisionFixture {

  private int dollars;
  private int pints;
  private boolean creditCard;

  public void setCashInWallet(int dollars) {
    this.dollars = dollars;
  }

  public void setPintsOfMilkRemaining(int pints) {
    this.pints = pints;
  }

  public void setCreditCard(String valid) {
    creditCard = "yes".equals(valid);
  }

  public String goToStore() {
    return (pints == 0 && (dollars > 2 || creditCard)) ? "yes" : "no";
  }

  // The following functions are optional.  If they aren't declared they'll be ignored.
  public void execute() {
  }

  public void reset() {
  }

  public void table(List<List<String>> table) {
  }

  public void beginTable() {
  }

  public void endTable() {
  }
}
