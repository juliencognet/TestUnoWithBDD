/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cgi.TestUnoWithBDD.SimpleTestsWithFit;
import fit.RowFixture;

/**
 *
 * @author cognetj
 */
public class PrimeNumbersFixture extends RowFixture{
    
  @Override
  public Object[] query() throws Exception {
    PrimeData[] array = new PrimeData[5];
    array[0] = new PrimeData(11);
    array[1] = new PrimeData(5);
    array[2] = new PrimeData(3);
    array[3] = new PrimeData(7);
    array[4] = new PrimeData(2);
    return array;
  }

    @Override
  public Class getTargetClass() {
    return PrimeData.class;
  }
}     
